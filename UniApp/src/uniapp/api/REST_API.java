package uniapp.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.io.IOException;
import java.util.Locale;

public class REST_API {

    private static String url;

    public JsonArray customURL(String name, String country, int option) throws IOException {

        // Αναλόγως τις επιλογές φτιάχνουμε το url string
        url = "http://universities.hipolabs.com/search?";

        if (option == 1) {
            url += "name=" + name;
        } else if (option == 2) {
            Locale locale = new Locale("", country);
            url += "country=" + locale.getDisplayCountry();
        } else {
            url += "name=" + name + "&";
            Locale locale = new Locale("", country);
            url += "country=" + locale.getDisplayCountry();
        }
        // Και συνεχίζουμε στο τελικό στάδιο κάτω
        return apiSearch();
    }

    public static JsonArray apiSearch() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).get().build();
        // Πιάνουμε τα διάφορα λάθη για να βοηθήσουμε τον χρήστη
        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException("HTTP Request failed with status code: " + response.code());
            } else if (response.body() == null) {
                throw new IOException("Response body is null.");
            } else {
                String jsonResponse = response.body().string();
                // Parse JSON using Gson βιβλιοθήκη
                Gson gson = new Gson();
                return gson.fromJson(jsonResponse, JsonArray.class);
            }
        } catch (java.net.UnknownHostException e) {
            // Δεν υπάρχει σύνδεση στο διαδίκτυο
            throw new IOException("No internet connection..", e);
        } catch (java.net.SocketTimeoutException e) {
            // Διαδικασία παίρνει παραπάνω χρόνο από τον καθιερωμένο αυτού του λειτουργικού
            throw new IOException("Request timed out..", e);
        } catch (IOException e) {
            // Άλλα IO λάθη
            throw e;
        } catch (Exception e) {
            // Γενικά οτιδήποτε άλλο
            throw e;
        }
    }

}
