package uniapp.gui;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uniapp.database.DBQueries;
import uniapp.utils.University;
// PDF
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
// Diagram
import uniapp.utils.Chart;

public class ExportPdf extends javax.swing.JFrame {

    public List<University> universities = new ArrayList<>();

    public ExportPdf() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/uniapp/media/cap.png")));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jTable1.setBackground(new java.awt.Color(220, 220, 220));
        jTable1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "University", "Searches"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/PDF.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/backButton.png"))); // NOI18N
        jButton2.setText("Πίσω");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Προβολή στατιστικών");

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/statisticsIcon.png"))); // NOI18N
        jButton3.setText("Προβολή Αναζητήσεων");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uniapp/media/diagramIcon.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(331, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        dispose();
        java.awt.EventQueue.invokeLater(() -> {
            mainFrame.getInstance().setVisible(true);
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/uniapp/media/cap.png")));
        });
    }//GEN-LAST:event_jButton2ActionPerformed

    // Δικιά μας συνάρτηση για να βάλουμε τις προβολές
    private void updateTable(List<University> universities) {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Clear existing rows
        model.setRowCount(0);

        // Add university data to the table (Όνομα και Αναζητήσεις)
        for (University uni : universities) {
            model.addRow(new Object[]{uni.getCurrentName(), uni.getSearches()});
        }
    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Προβολή πανεπιστημίων
        universities.clear();
        DBQueries.initializeDB();
        universities = DBQueries.displayMostSearchedUniversities();
        DBQueries.closeDB();
        if (!universities.isEmpty()) {

            // Update jTable1
            updateTable(universities);
        } else {
            // Μήνυμα λάθους
            JOptionPane.showMessageDialog(this, "Δεν βρέθηκαν αποτελέσματα.", "No Results", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // Απόπειρα δημιουργίας PDF αρχείου
        if (universities.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Δεν υπάρχουν δεδομένα στο πλαίσιο προς εξαγωγή!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PDFont FONT_NORMAL = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);
        PDFont FONT_BOLD = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD);
        int FONT_SIZE_LARGE = 12;
        int FONT_SIZE_NORMAL = 9;

        // Create a new document
        PDDocument document = new PDDocument();
        // Create a page for the PDF κόλλα Α4
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        try {
            // Set up a content stream to add text and tables to the PDF
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(FONT_NORMAL, 12);

            // Starting position for the first row
            float yStart = 750;
            float margin = 50;
            float yPosition = yStart;
            float rowHeight = 25;
            float tableWidth = 500;

            // Table headers
            String[] headers = {"University", "Searches"};
            // Draw headers
            contentStream.setFont(FONT_BOLD, FONT_SIZE_LARGE);
            contentStream.beginText();
            contentStream.newLineAtOffset(margin, yPosition);
            for (String header : headers) {
                contentStream.showText(header);
                contentStream.newLineAtOffset(tableWidth / 2, 0);
            }
            contentStream.endText();

            // Γραμμές
            contentStream.setLineWidth(1f);
            contentStream.moveTo(margin, yPosition - 5);
            contentStream.lineTo(margin + tableWidth, yPosition - 5);
            contentStream.stroke();
            // Move to the next row
            yPosition -= rowHeight;

            // Draw the rows with normal font
            contentStream.setFont(FONT_NORMAL, FONT_SIZE_NORMAL);

            for (University uni : universities) {
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);

                // Display the university name and its search count
                contentStream.showText(uni.getCurrentName());
                contentStream.newLineAtOffset(tableWidth / 2, 0);
                contentStream.showText(String.valueOf(uni.getSearches()));
                contentStream.endText();

                // Draw a separator line for each row
                contentStream.setLineWidth(0.5f);
                contentStream.moveTo(margin, yPosition - 5);
                contentStream.lineTo(margin + tableWidth, yPosition - 5);
                contentStream.stroke();

                // Move to the next row
                yPosition -= rowHeight;
            }

            // Close the content stream
            contentStream.close();

            // Save the document to a file
            // Get current date and time for name
            Date dateNow = Calendar.getInstance().getTime();
            String nowFormatName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(dateNow);

            document.save("Stats_Taken_At_" + nowFormatName + ".pdf");

            // Inform the user
            JOptionPane.showMessageDialog(this, "Το PDF δημιουργήθηκε με επιτυχία!", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            // Handle exception if something goes wrong (Μάλλον δεν δουλεύει για ελληνικούς χαρακτήρες!)
            JOptionPane.showMessageDialog(this, "Δοκιμάστε μόνο αγγλικούς χαρακτήρες!", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Always close the document
            try {
                document.close();
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // Απόπειρα δημιουργίας διαγράμματος
        if (universities.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Πρέπει να προβάλετε πρώτα τα δεδομένα!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Εμφάνισε διάγραμμα
        Chart.createChart(5);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ExportPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExportPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExportPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExportPdf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExportPdf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
