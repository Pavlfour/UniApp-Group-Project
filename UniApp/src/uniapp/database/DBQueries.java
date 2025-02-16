package uniapp.database;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import uniapp.utils.University;
import uniapp.utils.Country;

public class DBQueries {

    // Διαχείριση entity manager και entity manager factory
    public static EntityManager em;
    public static EntityManagerFactory emf;

    // Επιστροφή Χωρών
    public static List<String> getAllCountryCodes() {
        List<String> countryNames = new ArrayList<>();

        Query query = em.createQuery("SELECT c FROM Country c");
        List<Country> countries = query.getResultList();

        for (Country country : countries) {
            countryNames.add(country.getName());
        }
        // Επιστρέφει [] σε περίπτωση άδειας βάσης
        return countryNames;
    }

    // Διέγραψε όλες τις χώρες και αυτόματα τα πανεπιστήμια (Cascade delete)
    public static void deleteCountries() {

        em.getTransaction().begin();

        // Native SQL Query
        Query query = em.createNativeQuery("DELETE FROM COUNTRY");
        query.executeUpdate();
        // Αποθήκευση αλλαγών
        em.getTransaction().commit();
    }

    // Νέα εγγραφή στην βάση
    public static boolean insertNewRecord(String stateProvince, String alphaTwoCode, String country,
            String webPage, String name, String domain) {

        // Start transaction
        em.getTransaction().begin();

        // Check if university already exists with the name
        University existingUniversity = em.createQuery("SELECT u FROM University u WHERE u.name = :uniName", University.class)
                .setParameter("uniName", name)
                .getResultStream()
                .findFirst()
                .orElse(null);

        if (existingUniversity != null) {
            // Undo των αλλαγών
            em.getTransaction().rollback();
            return false;
        }

        // Check if country already exists
        Country tempCountry = em.createQuery("SELECT c FROM Country c WHERE c.name = :countryName", Country.class)
                .setParameter("countryName", country)
                .getResultStream()
                .findFirst()
                .orElse(null);

        // Insert country only if it doesn't exist
        if (tempCountry == null) {
            tempCountry = new Country();
            tempCountry.setName(country);
            tempCountry.setCountryCode(alphaTwoCode);
            em.persist(tempCountry);
        }

        // Insert new university
        University tempUniversity = new University();
        tempUniversity.setName(name);
        // Αρχικά το ίδιο όνομα και στα δύο πεδία
        tempUniversity.setCurrentName(name);
        tempUniversity.setDomain(domain);
        tempUniversity.setUrl(webPage);
        tempUniversity.setStateProvince(stateProvince);
        tempUniversity.setCountryName(tempCountry);
        tempUniversity.setContact("N/A");
        tempUniversity.setSchools("N/A");
        // Default αριθμό αναζητήσεων σε 1
        tempUniversity.setSearches(1);
        em.persist(tempUniversity);

        em.getTransaction().commit();
        return true;
    }

    // Αύξηση του searches σε περίπτωση εύρεσης πανεπιστημίου από το api result
    public static List<String> checkIfUniversityExists(String name) {

        University existingUniversity = em.createQuery("SELECT u FROM University u WHERE u.name = :uniName", University.class)
                .setParameter("uniName", name)
                .getResultStream()
                .findFirst()
                .orElse(null);

        if (existingUniversity != null) {
            em.getTransaction().begin();
            // Υπάρχει το πανεπιστήμιο στην βάση
            existingUniversity.incrementSearches();
            // Update the university in the database
            em.merge(existingUniversity);
            em.getTransaction().commit();
            // Και το επιστρέφουμε για να μπεί στα searches
            return new ArrayList<>(List.of(existingUniversity.getName(), existingUniversity.getCurrentName()));
        }
        // Άδεια λίστα
        return Collections.emptyList();
    }

    // Συνάρτηση για τα στατιστικά
    public static List<University> displayMostSearchedUniversities() {

        String sql = "SELECT * FROM UNIVERSITY ORDER BY SEARCHES DESC";
        Query query = em.createNativeQuery(sql, University.class);
        // List<University> και [] για άδεια
        return query.getResultList();
    }

    // Διαγραφή πανεπιστημίου
    public static boolean deleteUniversity(String universityName) {
        em.getTransaction().begin();
        University university = em.find(University.class, universityName);
        if (university != null) {

            // Παίρνουμε την χώρα που είναι το πανεπιστήμιο
            Country country = university.getCountryName();

            // Διαγραφή του πανεπιστημίου
            em.remove(university);

            // Έλεγχος αν η χώρα στην βάση είναι χωρίς εγγραφές να αφαιρείται
            long count = (long) em.createQuery("SELECT COUNT(u) FROM University u WHERE u.countryName = :country").setParameter("country", country).getSingleResult();
            if (count == 0) {
                em.remove(country);
            }

            em.getTransaction().commit();
            return true;
        } else {
            em.getTransaction().rollback();
            return false;
        }
    }

    // Κλείσιμο βάσης
    public static void closeDB() {
        em.close();
        emf.close();
    }

    // Άνοιγμα βάσης
    public static void initializeDB() {
        emf = Persistence.createEntityManagerFactory("UniAppPU");
        em = emf.createEntityManager();
    }

    // Update που έρχεται απτό παράθυρο ShowDatabase
    public static boolean updateUniversity(String name, String currentName, String domain, String url, String stateProvince, String contact, String schools) {

        try {
            em.getTransaction().begin();

            // Find the existing university by primary key
            University university = em.find(University.class, name);

            if (university == null) {
                em.getTransaction().rollback();
                return false;
            }
            // Update fields
            university.setCurrentName(currentName);
            university.setDomain(domain);
            university.setUrl(url);
            university.setStateProvince(stateProvince);
            university.setContact(contact);
            university.setSchools(schools);

            // Merge updated entity
            em.merge(university);

            em.getTransaction().commit();
            // Σε περίπτωση επιτυχίας
            return true;
        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                // Αναίρεση
                em.getTransaction().rollback();
            }
            // Σε περίπτωση λάθους
            return false;
        }

    }

    // Όλα τα πανεπιστήμια με βάση την χώρα και αύξηση του searches
    public static List<University> getUniversitiesByCountry(String countryName) {

        List<University> universities = new ArrayList<>();

        // Native SQL Query
        Query query = em.createNativeQuery(
                "SELECT * FROM UNIVERSITY WHERE COUNTRY_NAME = ?", University.class);

        // Ρύθμιση παραμέτρου στο ?
        query.setParameter(1, countryName);

        universities = query.getResultList();

        em.getTransaction().begin();
        // Increment search count for each university found
        for (University university : universities) {

            university.incrementSearches();
            // Update the university in the database
            em.merge(university);
        }
        em.getTransaction().commit();

        return universities;
    }

    // Αναζήτηση και αύξηση searches σε match
    public static List<University> getUniversitiesByFilters(String selectedCountry, String keyword) {

        // Φτιάχνουμε το sql query ανάλογα με τα φίλτρα
        // 1=1 είναι true για να βάλουμε μετά με AND έξτρα
        String sql = "SELECT * FROM UNIVERSITY WHERE 1=1";
        int index = 1;

        // Περιπτώσεις
        // Αν έχουμε λέξη-κλειδί
        if (!keyword.trim().isEmpty()) {
            // Τα κάνουμε όλα lower case για να κάνουμε match
            sql += " AND LOWER(\"CURRENT_NAME\") LIKE LOWER (?)";
        }
        // Αν διαλέχθηκε κάποια χώρα
        if (!selectedCountry.isEmpty()) {
            sql += " AND COUNTRY_NAME = (?)";
        }

        Query query = em.createNativeQuery(sql, University.class);

        // Παράμετροι
        if (!keyword.trim().isEmpty()) {
            query.setParameter(index++, "%" + keyword.toLowerCase().trim() + "%");
        }
        if (!selectedCountry.isEmpty()) {
            query.setParameter(index, selectedCountry);
        }

        // Εκτέλεση του query
        List<University> universities = query.getResultList();

        // Αύξηση του searches
        em.getTransaction().begin();
        for (University university : universities) {

            university.incrementSearches();
            // Update the university in the database
            em.merge(university);
        }
        em.getTransaction().commit();
        return universities;
    }

    // Παίρνουμε τα τοπ searched πανεπιστήμια
    public static List<University> topSearches(int numOfTopSearches) {

        // Query for most searched
        String topSearchesQuery
                = "SELECT * FROM UNIVERSITY "
                + "ORDER BY SEARCHES DESC, \"NAME\" ASC "
                + // Order by name for consistency
                "FETCH FIRST " + numOfTopSearches + " ROWS ONLY";

        Query query = em.createNativeQuery(topSearchesQuery, University.class);
        List<University> universities = query.getResultList();
        return universities;
    }

}
