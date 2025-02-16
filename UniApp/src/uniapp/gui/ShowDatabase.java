package uniapp.gui;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uniapp.database.DBQueries;
import uniapp.utils.University;

public class ShowDatabase extends javax.swing.JFrame {

    // Μεταβλητές κλάσεις για διαχείριση από τις συναρτήσεις
    private List<String> countriesList = new ArrayList<>();
    private List<University> databaseReturnedUniversities = new ArrayList<>();

    public void showCountries() {
        // Open Database
        DBQueries.initializeDB();

        // Φέρνουμε τις χώρες από την Country
        countriesList.clear();
        countriesList = DBQueries.getAllCountryCodes();

        // Βάζουμε τα στοιχεία της countryCodes στο jcombobox1
        jComboBox1.removeAllItems();
        jComboBox1.addItem("No Selection");
        for (String code : countriesList) {
            jComboBox1.addItem(code);
        }

        // Κλείσε την ρημαδοβάση!
        DBQueries.closeDB();
    }

    public ShowDatabase() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/uniapp/media/cap.png")));

        // Εδώ το model για row counter σε 0
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        showCountries();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Επιλογή Χώρας");

        jComboBox1.setBackground(new java.awt.Color(220, 220, 220));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(220, 220, 220));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Initial Name", "Current Name", "Domain", "Url", "State Province", "Contact", "Schools", "Searches"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setGridColor(new java.awt.Color(51, 51, 51));
        jTable1.setInheritsPopupMenu(true);
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/backButton.png"))); // NOI18N
        jButton2.setText("Πίσω");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/toiletLogo.png"))); // NOI18N
        jButton3.setText("Καθαρισμός Βάσης");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/saveIcon.png"))); // NOI18N
        jButton4.setText("Αποθήκευση");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/trashCan.png"))); // NOI18N
        jButton5.setText("Διαγραφή Εγγραφής");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/questionMark.png"))); // NOI18N
        jButton6.setMaximumSize(new java.awt.Dimension(20, 20));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/wordSearch.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Keyword");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 516, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // Δεν χρειάστηκε
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Το Menu παράθυρο
        dispose();
        java.awt.EventQueue.invokeLater(() -> {
            mainFrame.getInstance().setVisible(true);
        });
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // Confirm deletion
        int confirm = JOptionPane.showConfirmDialog(this, "Είστε σίγουροι στο να διαγραφούν όλα απ'την βάση;", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Βάλαμε για πλάκα ήχο
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource("/uniapp/media/toiletFlush.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            // Εδώ να περιμένει να τελειώσει ο ήχος και μετά συνέχιση της εκτέλεσης
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception e) {
            // Ένα dummy catch
        }

        try {
            // Απόπειρα διαγραφής της βάσης με κριτήριο τις χώρες και μετά
            // με cascade delete τα universities με το foreign key
            DBQueries.initializeDB();
            DBQueries.deleteCountries();
            countriesList.clear();
            // Κάνουμε refresh του πλαισίου
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            // Remove existing items
            jComboBox1.removeAllItems();
            jComboBox1.addItem("No Selection");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Σφάλμα : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        DBQueries.closeDB();


    }//GEN-LAST:event_jButton3ActionPerformed


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // Έλεγχος αν υπάρχουν εγγραφές στο πλαίσιο
        if (!databaseReturnedUniversities.isEmpty()) {

            // Table model
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            // Μεταβλητή για έλεγχο
            boolean success;
            DBQueries.initializeDB();
            // Batch update σε όλες τις εγγραφές που είναι στο πλαίσιο
            int i = 0;
            for (University uni : databaseReturnedUniversities) {
                // Το name χρησιμοποιείται για την τελική αποθήκευση
                // Και τριαδικούς τελεστές για συμπλήρωση κενού με N/A
                String currentName = (!model.getValueAt(i, 1).toString().trim().isEmpty()) ? model.getValueAt(i, 1).toString() : "N/A";
                String domain = (!model.getValueAt(i, 2).toString().trim().isEmpty()) ? model.getValueAt(i, 2).toString() : "N/A";
                String url = (!model.getValueAt(i, 3).toString().trim().isEmpty()) ? model.getValueAt(i, 3).toString() : "N/A";
                String stateProvince = (!model.getValueAt(i, 4).toString().trim().isEmpty()) ? model.getValueAt(i, 4).toString() : "N/A";
                String contact = (!model.getValueAt(i, 5).toString().trim().isEmpty()) ? model.getValueAt(i, 5).toString() : "N/A";
                String schools = (!model.getValueAt(i, 6).toString().trim().isEmpty()) ? model.getValueAt(i, 6).toString() : "N/A";

                // Call database update function
                success = DBQueries.updateUniversity(uni.getName(), currentName, domain, url, stateProvince, contact, schools);

                if (!success) {
                    JOptionPane.showMessageDialog(this, "Ουππςςς κάτι πήγε στραβά με την εγγραφή : " + uni.getName(), "Update Failed", JOptionPane.ERROR_MESSAGE);
                    DBQueries.closeDB();
                    return;
                }

                i++;

            }

            JOptionPane.showMessageDialog(this, "Επιτυχία ενημέρωσης βάσης!", "Update Succeeded", JOptionPane.INFORMATION_MESSAGE);
            DBQueries.closeDB();
        } else {
            JOptionPane.showMessageDialog(this, "Δεν υπάρχουν εμφανίσεις εγγραφών στο πλαίσιο.", "No Records", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        // Get selected row index
        int selectedRow = jTable1.getSelectedRow();
        // Έλεγχος αν υπάρχουν εγγραφές και υπάρχει επιλογή εγγραφής
        if (!databaseReturnedUniversities.isEmpty() && selectedRow != -1) {
            // Confirm deletion
            int confirm = JOptionPane.showConfirmDialog(this, "Είστε σίγουροι ότι θέλετε να διαγράψετε αυτήν την εγγραφή;", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            // Delete from database
            DBQueries.initializeDB();
            boolean success = DBQueries.deleteUniversity(databaseReturnedUniversities.get(selectedRow).getName());

            // Refresh jComboBox1
            countriesList.clear();
            countriesList = DBQueries.getAllCountryCodes();

            // Βάζουμε τα στοιχεία της countryCodes στο jcombobox1
            jComboBox1.removeAllItems();
            jComboBox1.addItem("No Selection");
            for (String code : countriesList) {
                jComboBox1.addItem(code);
            }

            DBQueries.closeDB();

            if (success) {
                // Remove from πίνακα και refresh πλαισίου
                model.removeRow(selectedRow);
                // και από την λίστα μας
                databaseReturnedUniversities.remove(selectedRow);
                JOptionPane.showMessageDialog(this, "Η εγγραφή διαγράφηκε επιτυχώς!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Αποτυχία διαγραφής.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Παρακαλώ επιλέξτε μια εγγραφή για διαγραφή.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JOptionPane.showMessageDialog(this, "<html>Μετά την προβολή των εγγραφών στο πλαίσιο χρησιμοποιήστε τον κέρσορα στην στήλη-πεδίο που θέλετε<br>"
                + "να αλλάξετε (εκτός της Initial Name και Searches) και μετά πατήστε Enter και στο τέλος Αποθήκευση για να<br>"
                + "γίνει ομαδική ενημέρωση όλων των τρεχόντων εγγραφών που είναι στο πλαίσιο! (Batch Update)</html>",
                "Πληροφορίες Διαχείρισης Παραθύρου", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        DBQueries.initializeDB();
        databaseReturnedUniversities.clear();
        // Table model
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // Clear existing rows
        model.setRowCount(0);
        // Φτιάχνουμε τα φίλτρα που έβαλε ο χρήστης
        // Εδώ την χώρα ή ""
        String selectedCountry = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());

        // Παίρνουμε την φράση από το jTextField1 ή ""
        String keyword = jTextField1.getText();

        // Ξεκινάει το database fetch
        databaseReturnedUniversities = DBQueries.getUniversitiesByFilters(selectedCountry.equals("No Selection") ? "" : selectedCountry, keyword);

        // Βάζουμε τα στοιχεία στο πλαίσιο αν υπάρχουν
        if (!databaseReturnedUniversities.isEmpty()) {

            for (University uni : databaseReturnedUniversities) {
                model.addRow(new Object[]{
                    uni.getName(),
                    uni.getCurrentName(),
                    uni.getDomain(),
                    uni.getUrl(),
                    uni.getStateProvince(),
                    uni.getContact(),
                    uni.getSchools(),
                    uni.getSearches()
                });
            }
        }
        // Κλείνουμε την βάση
        DBQueries.closeDB();


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // Δεν χρειάστηκε
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(ShowDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowDatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
