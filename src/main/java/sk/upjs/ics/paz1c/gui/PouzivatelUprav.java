/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.gui;

/**
 *
 * @author raven
 */
public class PouzivatelUprav extends javax.swing.JFrame {

    /**
     * Creates new form UvodneOkno
     */
    public PouzivatelUprav() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        vyhladavajPodlaButtonGroup = new javax.swing.ButtonGroup();
        vyhladajButtonGroup = new javax.swing.ButtonGroup();
        TabulkaKnihScrollPane = new javax.swing.JScrollPane();
        knihyTable = new javax.swing.JTable();
        vyhladajComboBox = new javax.swing.JComboBox<>();
        vyhladajButton = new javax.swing.JButton();
        OdhlasSaButton = new javax.swing.JButton();
        pridajKnihuButton = new javax.swing.JButton();
        oKniheScrollPane = new javax.swing.JScrollPane();
        popisKnihyTextArea = new javax.swing.JTextArea();
        vyhladavaciPanePanel = new javax.swing.JPanel();
        vyhladavajPodlaLabel = new javax.swing.JLabel();
        nazvuRadioButton = new javax.swing.JRadioButton();
        zanruRadioButton = new javax.swing.JRadioButton();
        oblubenostiRadioButton1 = new javax.swing.JRadioButton();
        autoraRadioButton = new javax.swing.JRadioButton();
        jazykaRadioButton = new javax.swing.JRadioButton();
        formatuRadioButton1 = new javax.swing.JRadioButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Virtuálna knižnica");
        setMinimumSize(new java.awt.Dimension(900, 710));

        knihyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabulkaKnihScrollPane.setViewportView(knihyTable);

        vyhladajComboBox.setEditable(true);
        vyhladajComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        vyhladajButton.setText("Hľadaj");
        vyhladajButton.setMaximumSize(new java.awt.Dimension(90, 35));
        vyhladajButton.setMinimumSize(new java.awt.Dimension(90, 35));

        OdhlasSaButton.setText("Odhlás sa");

        pridajKnihuButton.setText("Pridaj knihu");
        pridajKnihuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajKnihuButtonActionPerformed(evt);
            }
        });

        popisKnihyTextArea.setColumns(20);
        popisKnihyTextArea.setLineWrap(true);
        popisKnihyTextArea.setRows(5);
        popisKnihyTextArea.setText("Popis knihy");
        oKniheScrollPane.setViewportView(popisKnihyTextArea);

        vyhladavajPodlaLabel.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        vyhladavajPodlaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vyhladavajPodlaLabel.setText("Vyhľadávať podľa:");

        nazvuRadioButton.setSelected(true);
        nazvuRadioButton.setText("Názvu");
        nazvuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nazvuRadioButtonActionPerformed(evt);
            }
        });

        zanruRadioButton.setText("Žánru");

        oblubenostiRadioButton1.setText("Obľúbenosti");

        autoraRadioButton.setText("Autora");
        autoraRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoraRadioButtonActionPerformed(evt);
            }
        });

        jazykaRadioButton.setText("Jazyka");

        formatuRadioButton1.setText("Formátu");

        javax.swing.GroupLayout vyhladavaciPanePanelLayout = new javax.swing.GroupLayout(vyhladavaciPanePanel);
        vyhladavaciPanePanel.setLayout(vyhladavaciPanePanelLayout);
        vyhladavaciPanePanelLayout.setHorizontalGroup(
            vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vyhladavaciPanePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vyhladavajPodlaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(vyhladavaciPanePanelLayout.createSequentialGroup()
                        .addGroup(vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nazvuRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zanruRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oblubenostiRadioButton1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vyhladavaciPanePanelLayout.createSequentialGroup()
                        .addGap(0, 130, Short.MAX_VALUE)
                        .addGroup(vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(formatuRadioButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(autoraRadioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jazykaRadioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        vyhladavaciPanePanelLayout.setVerticalGroup(
            vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vyhladavaciPanePanelLayout.createSequentialGroup()
                .addComponent(vyhladavajPodlaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nazvuRadioButton)
                    .addComponent(autoraRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zanruRadioButton)
                    .addComponent(jazykaRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oblubenostiRadioButton1)
                    .addComponent(formatuRadioButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vyhladajComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(vyhladajButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TabulkaKnihScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(vyhladavaciPanePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(oKniheScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(OdhlasSaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pridajKnihuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(vyhladavaciPanePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pridajKnihuButton)
                .addGap(18, 18, 18)
                .addComponent(oKniheScrollPane)
                .addGap(18, 18, 18)
                .addComponent(OdhlasSaButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vyhladajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vyhladajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabulkaKnihScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridajKnihuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajKnihuButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pridajKnihuButtonActionPerformed

    private void nazvuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nazvuRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nazvuRadioButtonActionPerformed

    private void autoraRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoraRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autoraRadioButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PouzivatelUprav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PouzivatelUprav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PouzivatelUprav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PouzivatelUprav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PouzivatelUprav().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OdhlasSaButton;
    private javax.swing.JScrollPane TabulkaKnihScrollPane;
    private javax.swing.JRadioButton autoraRadioButton;
    private javax.swing.JRadioButton formatuRadioButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JRadioButton jazykaRadioButton;
    private javax.swing.JTable knihyTable;
    private javax.swing.JRadioButton nazvuRadioButton;
    private javax.swing.JScrollPane oKniheScrollPane;
    private javax.swing.JRadioButton oblubenostiRadioButton1;
    private javax.swing.JTextArea popisKnihyTextArea;
    private javax.swing.JButton pridajKnihuButton;
    private javax.swing.JButton vyhladajButton;
    private javax.swing.ButtonGroup vyhladajButtonGroup;
    private javax.swing.JComboBox<String> vyhladajComboBox;
    private javax.swing.JPanel vyhladavaciPanePanel;
    private javax.swing.ButtonGroup vyhladavajPodlaButtonGroup;
    private javax.swing.JLabel vyhladavajPodlaLabel;
    private javax.swing.JRadioButton zanruRadioButton;
    // End of variables declaration//GEN-END:variables
}