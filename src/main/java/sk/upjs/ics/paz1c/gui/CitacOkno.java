package sk.upjs.ics.paz1c.gui;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JViewport;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import sk.upjs.ics.paz1c.dao.PouzivatelDao;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.entity.Pouzivatel;
import sk.upjs.ics.paz1c.tovaren.MagicFactory;

/**
 *
 * @author raven
 */
public class CitacOkno extends javax.swing.JFrame {
    
    private int aktualnaStrana = 0;
    private int pocetStran = 0;
    private String urlAdresa;
    private int nacitajStranu;
    private Long idPouzivatela;
    private ImageIcon strana;
    private JLabel jlabel;
    private JViewport view;
    private Pouzivatel pouzivatel;
    private PouzivatelDao pouzivatelDao;
    private Kniha kniha;
    private double zoom = 1;
    
    public CitacOkno(int nacitajStranu, Long idPouzivatela, Kniha kniha) {
        this.urlAdresa = kniha.getUrlKniha();
        this.nacitajStranu = nacitajStranu;
        this.idPouzivatela = idPouzivatela;
        this.kniha = kniha;
        if(idPouzivatela >= 0) {
            pouzivatelDao = MagicFactory.INSTANCE.pouzivatelDao();
            pouzivatel = pouzivatelDao.nacitajPouzivatela(idPouzivatela);
        }
        initComponents();
    }
    
    private void initComponents() {
        try {
            FileUtils.cleanDirectory(new File("temp"));
            nacitajStranyAkoObrazky(urlAdresa);
        } catch (IOException ex) {
            Logger.getLogger(CitacOkno.class.getName()).log(Level.SEVERE, null, ex);
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
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        
        setTitle(kniha.getNazovKniha());
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(950, 600));
        
        naZaciatokButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/arrowsL.png")); // NOI18N
        naZaciatokButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naZaciatokButton(evt);
            }
            
            private void naZaciatokButton(MouseEvent evt) {
                zoom = 1;
                nacitajStranu = 0;
                refresh();
            }
        });
        
        predchadzajucaButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/arrowL.png")); // NOI18N
        predchadzajucaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                predchadzajucaButton(evt);
            }
            
            private void predchadzajucaButton(MouseEvent evt) {
                if(nacitajStranu != 0) {
                    zoom = 1;
                    nacitajStranu--;
                    refresh();
                }
            }
        });
        
        oddialButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/minus.png")); // NOI18N
        oddialButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oddialButton(evt);
            }
            
            private void oddialButton(MouseEvent evt) {
                if(zoom >= 0.4) {
                    zoom = zoom - 0.2;
                    zoom();
                }
            }
        });
        
        ulozButton.setText("Uložiť");
        ulozButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ulozButton(evt);
            }
            
            private void ulozButton(MouseEvent evt) {
                if(idPouzivatela >= 0) {
                    pouzivatelDao.pridajRozcitanu(pouzivatel, kniha, nacitajStranu);
                }
            }
        });
        
        zavriButton.setText("Zavrieť");
        zavriButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    FileUtils.cleanDirectory(new File("temp"));
                } catch (IOException ex) {
                    Logger.getLogger(CitacOkno.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }
            
        });
        
        priblizButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/plus.png")); // NOI18N
        priblizButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                priblizButton(evt);
            }
            
            private void priblizButton(MouseEvent evt) {
                if(zoom <= 1.8) {
                    zoom = zoom + 0.2;
                    zoom();
                }
            }
        });
        
        nachadzajucaButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/arrowR.png")); // NOI18N
        nachadzajucaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nachadzajucaButton(evt);
            }
            
            private void nachadzajucaButton(MouseEvent evt) {
                if (nacitajStranu != pocetStran-1) {
                    zoom = 1;
                    nacitajStranu++;
                    refresh();
                }
            }
        });
        
        naKoniecButton.setIcon(new javax.swing.ImageIcon("/home/raven/NetBeansProjects/VLib/arrowsR.png")); // NOI18N
        naKoniecButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naKoniecButton(evt);
            }
            
            private void naKoniecButton(MouseEvent evt) {
                zoom = 1;
                nacitajStranu = pocetStran-1;
                refresh();
            }
        });
        
        
        /*
        netbeans rozhadzovanie komponentov
        */
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
        zobrazime defaultnu stranu pdf
        */
        
        strana = new ImageIcon("temp/img"+nacitajStranu+".jpg");
        jlabel = new JLabel(strana);
        view = new JViewport();
        view.setView(jlabel);
        zobrazovacScrollPane.setViewportView(view);
        
        pack();
    }
    
    /*
    nacitame pdf
    */
    private void nacitajStranyAkoObrazky (String urlAdresa) throws MalformedURLException, IOException  {
        /*
        vymazeme aktualne subory z temp
        */
        // FileUtils.cleanDirectory(new File("temp"));
        long s = System.currentTimeMillis();
        InputStream input = new URL(urlAdresa).openStream();
        PDDocument pdfDokument = PDDocument.load(input);
        /*
        synchronized blok
        */
        pdfDokument.getClass();
        if (!pdfDokument.isEncrypted()) {
            
            pocetStran = pdfDokument.getNumberOfPages();
            PDFRenderer pdfRender = new PDFRenderer(pdfDokument);
            for (int i = 0; i < pocetStran; i++) {
                /*
                ukladame vsetky strany do priecinku s docasnymi subormi
                */
                File outputFile = new File("temp/img"+i+".jpg");
                ImageIO.write(pdfRender.renderImageWithDPI(i, 150), "jpg", outputFile);
            }
        } else {
            System.err.println("Subor je zaheslovany!");
        }
        pdfDokument.close();
        System.out.println((System.currentTimeMillis() - s)/1000.0 + "s");
    }
    
    /*
    refreshovanie pane-u, stran
    */
    private void refresh() {
        jlabel.setIcon(new ImageIcon("temp/img"+nacitajStranu+".jpg"));
        jlabel.repaint();
    }
    
    private void zoom() {
        Image obrazok = new ImageIcon("temp/img"+nacitajStranu+".jpg").getImage();
        jlabel.setIcon(new ImageIcon(obrazok.getScaledInstance((int) (obrazok.getWidth(rootPane)*zoom),
                (int) (obrazok.getHeight(rootPane)*zoom), java.awt.Image.SCALE_SMOOTH)));
        jlabel.repaint();
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
    
    
    
    
}
