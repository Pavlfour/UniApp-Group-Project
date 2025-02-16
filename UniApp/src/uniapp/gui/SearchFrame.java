package uniapp.gui;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import uniapp.api.REST_API;
import javax.swing.ButtonGroup;
import uniapp.database.DBQueries;
import uniapp.utils.CustomColors;

public class SearchFrame extends javax.swing.JFrame {

    // To store the selected university from jlist1
    private JsonObject selectedUniversity = null;
    // Instantiate εδώ της api μεταβλητής
    private REST_API api = new REST_API();

    // Πάνω πεδίο τιμή
    private String name = "";
    // Κάτω πεδίο τιμή
    private String country = "";
    private int option;

    public SearchFrame() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/uniapp/media/cap.png")));
        // Disable editing from user the jTextField2 from the beginning
        jTextField2.setEnabled(true);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField2.setEditable(false);

        // Group together the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(jRadioButton1);
        group.add(jRadioButton2);
        group.add(jRadioButton3);

        // Προεπιλογή το πρώτο κουμπί
        jRadioButton1.setSelected(true);
        // Disable the text field αρχικά!
        jTextField3.setEnabled(false);
        // Γκρί χρώμα
        jTextField3.setBackground(new java.awt.Color(200, 200, 200));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/searchButton.png"))); // NOI18N
        jButton1.setText("Ψάξε");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jRadioButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton1.setText("Όνομα Πανεπιστημίου (ή φράση)");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton2.setText("Χώρα (ή κωδικός χώρας)");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton3.setText("Και τα δύο (πάνω όνομα και κάτω χώρα)");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/databaseLogo.png"))); // NOI18N
        jButton2.setText("Αποθήκευση στη βάση");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Πανεπιστήμια");

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Χώρα");

        jTextField2.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(51, 51, 51));
        jTextField2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jList1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jList1.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jList1.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(jList1);

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/backButton.png"))); // NOI18N
        jButton3.setText("Πίσω");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(51, 51, 51));
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/countrySearch.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/universityIcon.png"))); // NOI18N
        jLabel4.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1))
                                .addGap(91, 91, 91)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(jButton1)
                        .addGap(0, 158, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(21, 21, 21))
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2))
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // Το πρώτο κουμπί
        // Απενεργοποίηση του 2ου πεδίου
        jTextField3.setEnabled(false);
        jTextField3.setBackground(new java.awt.Color(200, 200, 200));
        // Σβήσιμο αλφαριθμητικών
        jTextField3.setText("");
        jTextField2.setText("");
        jTextField1.setText("");
        // Καθαρισμός λίστας
        jList1.setListData(new String[0]);
        selectedUniversity = null;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Ξενικάει η διαδικασία της αναζήτησης
        name = "";
        country = "";
        // Μία τιμή για να ξέρουμε ποιό radio button επιλέχθηκε
        option = 1;
        // Καθαρισμός λίστας
        jList1.setListData(new String[0]);

        // Ότι επιστρέψει το rest api
        JsonArray apiResponse;
        // Για τα δεδομένα της jlist1
        ArrayList<String> universitiesList = new ArrayList<>();

        // Για το πρώτο κουμπί
        if (jRadioButton1.isSelected()) {
            name = jTextField1.getText();
            option = 1;

            // Για το δεύτερο κουμπί
        } else if (jRadioButton2.isSelected()) {
            country = jTextField1.getText();
            option = 2;

            // Για το τρίτο κουμπί
        } else if (jRadioButton3.isSelected()) {
            name = jTextField1.getText();
            country = jTextField3.getText();
            option = 3;

        }

        // Χρησιμοποιούμε μία List για να ξέρουμε που κάνει match με τα δεδομένα της βάσης για χρώμα
        List<Integer> coloredRows = new ArrayList<>();

        // Ψάξιμο με χρήση του api και έλεγχο για λάθη
        try {
            // Επιστροφή του JsonArray της REST_API κλάσης ή σφάλμα
            apiResponse = api.customURL(name, country, option);
            if (!apiResponse.isEmpty()) {

                DBQueries.initializeDB();
                for (int i = 0; i < apiResponse.size(); i++) {

                    // Παίρνουμε από το JsonArray κάθε JsonObject
                    JsonObject universityObject = apiResponse.get(i).getAsJsonObject();
                    // Και παίρνουμε το όνομα του πανεπιστημίου απτό επιστρεφόμενο του api
                    String universityName = universityObject.get("name").getAsString();
                    // Προσωρινή αποθήκευση σε μεταβλητή
                    // Εδώ αν βρεθεί στην βάση επιστρέφεται μία λίστα (Όνομα,Τρέχων όνομα)
                    // Και αν υπάρχει αυξάνουμε το Searches +1 στην βάση
                    List<String> universityData = DBQueries.checkIfUniversityExists(universityName);

                    if (!universityData.isEmpty()) {
                        // Θα βάλουμε το τρέχων όνομα και μετά το παλιό
                        universitiesList.add((i + 1) + ". " + universityData.get(1) + "  " + "(Original name : " + universityData.get(0) + ")");
                        // Προσθήκη στην λίστα μας για χρωματισμό
                        coloredRows.add(i);
                    } else {
                        // Διαφορετικά βάζουμε του api
                        universitiesList.add((i + 1) + ". " + universityName);
                    }

                }

                // Update the JList with the universities list
                // Convert ArrayList to Array and set data
                jList1.setListData(universitiesList.toArray(new String[0]));

                // Now set the renderer και κάνει και reset ταυτόχρονα
                jList1.setCellRenderer(new CustomColors(coloredRows));

                DBQueries.closeDB();

                // Remove all existing listeners to prevent duplicate (Επειδή κράσαρε αλλιώς)
                for (javax.swing.event.ListSelectionListener listener : jList1.getListSelectionListeners()) {
                    jList1.removeListSelectionListener(listener);
                }

                // Βάζουμε selection listener για να ξέρουμε τι επίλεξε ο χρήστης
                // Όλο το json object και να βάλουμε και το όνομα της χώρας στο κάτω πεδίο
                jList1.addListSelectionListener(e -> {
                    if (!e.getValueIsAdjusting()) {
                        // Το ίδιο index με αυτό που είναι match με την βάση
                        int selectedIndex = jList1.getSelectedIndex();
                        if (selectedIndex != -1) {
                            // Το αποθηκεύουμε στην μεταβλητή κλάσης
                            selectedUniversity = apiResponse.get(selectedIndex).getAsJsonObject();
                            jTextField2.setText(apiResponse.get(selectedIndex).getAsJsonObject().get("country").getAsString());
                        }
                    }
                });

            } else {
                // Show a message if no university is found
                javax.swing.JOptionPane.showMessageDialog(this, "Δεν βρέθηκαν πανεπιστήμια!!",
                        "No Results", javax.swing.JOptionPane.WARNING_MESSAGE);
            }

        } catch (IOException e) {
            // Βγάζουμε το μήνυμα λάθους που ήρθε από την REST_API apiSearch()
            javax.swing.JOptionPane.showMessageDialog(this,
                    // Θέλουμε να εμφανίζουμε το είδος του error
                    (e.getMessage() != null) ? e.getMessage() : "An unknown error occurred.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // Αποθήκευση στην βάση κουμπί
        // Εδώ παρατηρήσαμε ότι web_pages ή για domains μπορεί να έχουν πχ 2 τιμές (json array)
        // και κάναμε παραδοχή να παίρνουμε την 1η τιμή πάντα
        // Βάζουμε όλα τα κενά με string N/A
        // Check if a university is selected
        if (selectedUniversity != null) {

            String stateProvince = selectedUniversity.has("state-province") && !selectedUniversity.get("state-province").isJsonNull()
                    ? selectedUniversity.get("state-province").getAsString()
                    : "N/A";

            String alphaTwoCode = selectedUniversity.has("alpha_two_code") && !selectedUniversity.get("alpha_two_code").isJsonNull()
                    ? selectedUniversity.get("alpha_two_code").getAsString()
                    : "N/A";

            String country = selectedUniversity.has("country") && !selectedUniversity.get("country").isJsonNull()
                    ? selectedUniversity.get("country").getAsString()
                    : "N/A";

            String webPage;
            if (selectedUniversity.has("web_pages") && !selectedUniversity.get("web_pages").isJsonNull()) {

                JsonElement element = selectedUniversity.get("web_pages");

                if (element.isJsonPrimitive()) {
                    // Single string value
                    webPage = element.getAsString();
                } else {
                    JsonArray array = element.getAsJsonArray();
                    webPage = array.size() > 0 ? array.get(0).getAsString() : "N/A";
                }
            } else {
                webPage = "N/A";
            }

            String domain;
            if (selectedUniversity.has("domains") && !selectedUniversity.get("domains").isJsonNull()) {

                JsonElement element = selectedUniversity.get("domains");

                if (element.isJsonPrimitive()) {
                    // Single string value
                    domain = element.getAsString();
                } else {
                    JsonArray array = element.getAsJsonArray();
                    domain = array.size() > 0 ? array.get(0).getAsString() : "N/A";
                }
            } else {
                domain = "N/A";
            }

            String name = selectedUniversity.has("name") && !selectedUniversity.get("name").isJsonNull()
                    ? selectedUniversity.get("name").getAsString()
                    : "N/A";

            DBQueries.initializeDB();
            // Check if successful insert to database
            boolean checkRecord = DBQueries.insertNewRecord(stateProvince, alphaTwoCode, country, webPage, name, domain);
            DBQueries.closeDB();

            if (!checkRecord) {

                javax.swing.JOptionPane.showMessageDialog(this, "Το πανεπιστήμιο υπάρχει ήδη στην βάση.",
                        "Not Saved", javax.swing.JOptionPane.ERROR_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Έγινε η εγγραφή!",
                        "Saved", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            }

        } else {
            // Show a message if no university is selected
            javax.swing.JOptionPane.showMessageDialog(this, "Παρακαλώ διαλέξτε ένα πανεπιστήμιο για αποθήκευση.",
                    "No Selection", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        dispose();
        java.awt.EventQueue.invokeLater(() -> {
            mainFrame.getInstance().setVisible(true);
        });
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // Δεν χρειάστηκε
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // country's name radio button
        jTextField3.setEnabled(false);
        jTextField3.setBackground(new java.awt.Color(200, 200, 200));
        jTextField3.setText("");
        jTextField2.setText("");
        jTextField1.setText("");
        selectedUniversity = null;
        jList1.setListData(new String[0]);

    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // both name (keyword) and country (code) radio button
        jTextField3.setEnabled(true);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setText("");
        jTextField2.setText("");
        jTextField1.setText("");
        selectedUniversity = null;
        jList1.setListData(new String[0]);

    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // Δεν χρειάστηκε
    }//GEN-LAST:event_jTextField2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
