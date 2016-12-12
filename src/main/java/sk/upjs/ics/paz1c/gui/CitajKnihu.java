package sk.upjs.ics.paz1c.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JViewport;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 *
 * @author raven
 */
public class CitajKnihu extends javax.swing.JFrame {
    
    private int aktualnaStrana = 0;
    private List<BufferedImage> strany  = new ArrayList<>();
    private String urlAdresa;
    private int nacitajStranu;
    
    public CitajKnihu(String urlAdresa, int nacitajStranu) {
        this.urlAdresa = urlAdresa;
        this.nacitajStranu = nacitajStranu;
        initComponents();
    }
    
    private void initComponents() {
        try {
            nacitajStranyAkoObrazky(urlAdresa);
        } catch (IOException ex) {
            Logger.getLogger(CitajKnihu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        zobrazovacScrollPane = new javax.swing.JScrollPane();
        naZaciatokButton = new javax.swing.JButton();
        predchadzajucaButton = new javax.swing.JButton();
        oddialButton = new javax.swing.JButton();
        ulozButton = new javax.swing.JButton();
        zavriButton = new javax.swing.JButton();
        priblizButton = new javax.swing.JButton();
        nachadzajucaButton = new javax.swing.JButton();
        naKoniecButton = new javax.swing.JButton();
        
       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       
       
        setTitle("Virtuálna knižnica");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(950, 600));
        
        naZaciatokButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/arrowsL.png")); // NOI18N
        
        predchadzajucaButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/arrowL.png")); // NOI18N
        
        oddialButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/minus.png")); // NOI18N
        
        ulozButton.setText("Uložiť");
        
        zavriButton.setText("Zavrieť");
        
        priblizButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/plus.png")); // NOI18N
        priblizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priblizButtonActionPerformed(evt);
            }
        });
        
        nachadzajucaButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/arrowR.png")); // NOI18N
        
        naKoniecButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/arrowsR.png")); // NOI18N
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(zobrazovacScrollPane)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(naZaciatokButton, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(predchadzajucaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(oddialButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ulozButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(zavriButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(priblizButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(nachadzajucaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(naKoniecButton, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(zobrazovacScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ulozButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(priblizButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nachadzajucaButton)
                                                        .addComponent(naKoniecButton)
                                                        .addComponent(naZaciatokButton)
                                                        .addComponent(predchadzajucaButton)
                                                        .addComponent(zavriButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(oddialButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(1, 1, 1)))
                                .addContainerGap())
        );
        
        /*
        zobrazime prvu stranu pdf
        */
        ImageIcon strana = new ImageIcon("temp/img5.jpg");
        JLabel jlabel = new JLabel(strana);
        JViewport view = new JViewport();
        view.setView(jlabel);
//        view.imageUpdate(strany[nacitajStranu], 30, strany[nacitajStranu].getMinX(),
//                strany[nacitajStranu].getMinY(), strany[nacitajStranu].getHeight()*4, strany[nacitajStranu].getWidth()*4);
        zobrazovacScrollPane.setViewportView(view);
        
        pack();
    }
    
    private void priblizButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void naKoniecButtonMouseClicked(java.awt.event.MouseEvent evt) {
        nacitajStranu = strany.size()-1;
        refresh();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CitajKnihu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new CitajKnihu("http://s.ics.upjs.sk/~ppetras/paz1c/lesk_a_bida_kurtizan.pdf", 5).setVisible(true);
                
            }
        });
    }
    
    private javax.swing.JButton naKoniecButton;
    private javax.swing.JButton naZaciatokButton;
    private javax.swing.JButton nachadzajucaButton;
    private javax.swing.JButton oddialButton;
    private javax.swing.JButton predchadzajucaButton;
    private javax.swing.JButton priblizButton;
    private javax.swing.JButton ulozButton;
    private javax.swing.JButton zavriButton;
    private javax.swing.JScrollPane zobrazovacScrollPane;
    
    
    /*
    nacitame pdf
    */
    private void nacitajStranyAkoObrazky (String urlAdresa) throws MalformedURLException, IOException  {
        /*
        vymazeme aktualne subory z temp
        */
        FileUtils.cleanDirectory(new File("temp"));
        long s = System.currentTimeMillis();
        InputStream input = new URL(urlAdresa).openStream();
        PDDocument pdfDokument = PDDocument.load(input);
        
        /*
        synchronized blok
        */
        pdfDokument.getClass();
        if (!pdfDokument.isEncrypted()) {
            
            int pocetStran = pdfDokument.getNumberOfPages();
            PDFRenderer pdfRender = new PDFRenderer(pdfDokument);
            for (int i = 0; i < pocetStran; i++) {
                /*
                ukladame vsetky strany do priecinku s docasnymi subormi
                */
                File outputFile = new File("temp/img"+i+".jpg");
                ImageIO.write(pdfRender.renderImageWithDPI(i, 150), "jpg", outputFile);
              //  strany.add(i, pdfRender.renderImageWithDPI(i, 150));
            }
        } else {
            System.err.println("Subor je zaheslovany!");
        }
        pdfDokument.close();
        
        System.out.println((System.currentTimeMillis() - s)/1000.0 + "s");
    }
    
    /*
    refreshovanie pane-u
    */
    private void refresh() {
        //TODO
    }
    
}
