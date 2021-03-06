/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sk.upjs.ics.paz1c.gui; 

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableColumnModel;
import sk.upjs.ics.paz1c.dao.AutorDao;
import sk.upjs.ics.paz1c.dao.KnihaDao;
import sk.upjs.ics.paz1c.dao.PouzivatelDao;
import sk.upjs.ics.paz1c.entity.Autor;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.entity.Pouzivatel;
import sk.upjs.ics.paz1c.modely.KnihaTableModel;
import sk.upjs.ics.paz1c.pomocneTriedy.VytvaracAliasov;
import sk.upjs.ics.paz1c.pomocneTriedy.kombacik.KombacNasepkavac;
import sk.upjs.ics.paz1c.pomocneTriedy.kombacik.VyhladavatelnyRetazec;
import sk.upjs.ics.paz1c.tovaren.MagicFactory;

/**
 *
 * @author raven
 */
public class UvodneOkno extends javax.swing.JFrame {
    
    /*
    slovniky na vyhladavanie
    */
    
    private AutorDao autorDao = MagicFactory.INSTANCE.autorDao();
    
    private KnihaDao knihaDao = MagicFactory.INSTANCE.knihaDao();
        
    private List<String> nazvy = knihaDao.nacitajKnihy();
    
    private List<String> autori;
    
    private List<String> zanre;
    
    private List<String> jazyky;
    
    private List<String> formaty;
    
    int vyhladaj = 0;
    
    private static final KnihaTableModel knihaTableModel = new KnihaTableModel();
    
    private TableColumnModel tcm;
    
    private Kniha kniha;
    
    private Autor autor;
    
    private List<Kniha> knihy;
    
    
    /**
     * Creates new form UvodneOkno
     */
    public UvodneOkno() {
        formaty = new ArrayList<>(); formaty.add("pdf"); formaty.add("epub"); formaty.add("mobi");
        jazyky = new ArrayList<>(); jazyky.add("cz"); jazyky.add("sk"); jazyky.add("en");
        jazyky.add("de"); jazyky.add("re"); jazyky.add("pl");
        
        initComponents();
        /*
        nastavime sirku ID stlpca na 0
        http://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
        */
        TableColumnModel tcm = tabulkaTable.getColumnModel();
        tcm.getColumn(4).setWidth(0);
        tcm.getColumn(4).setMaxWidth(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        
        vyhladavajPodlaButtonGroup = new javax.swing.ButtonGroup();
        vyhladavaciPanePanel = new javax.swing.JPanel();
        vyhladavajPodlaLabel = new javax.swing.JLabel();
        nazvuRadioButton = new javax.swing.JRadioButton();
        zanruRadioButton = new javax.swing.JRadioButton();
        oblubenostiRadioButton = new javax.swing.JRadioButton();
        autoraRadioButton = new javax.swing.JRadioButton();
        jazykaRadioButton = new javax.swing.JRadioButton();
        formatuRadioButton = new javax.swing.JRadioButton();
        TabulkaScrollPane = new javax.swing.JScrollPane();
        tabulkaTable = new javax.swing.JTable();
        vyhladajComboBox = new KombacNasepkavac(new VyhladavatelnyRetazec(nazvy));
        vyhladajButton = new javax.swing.JButton();
        prihlasovaciPanel = new javax.swing.JPanel();
        prihlasovacieMenoTextField = new javax.swing.JTextField();
        hesloPasswordField = new javax.swing.JPasswordField();
        prihlasButton = new javax.swing.JButton();
        registrujButton = new javax.swing.JButton();
        oKnihePanel = new javax.swing.JPanel();
        oKniheScrollPane = new javax.swing.JScrollPane();
        popisKnihyTextArea = new javax.swing.JTextArea();
        menoAutoraLabel = new javax.swing.JLabel();
        oAutoroviScrollPane = new javax.swing.JScrollPane();
        popisAutoraTextArea = new javax.swing.JTextArea();
        pocetStranLabel = new javax.swing.JLabel();
        citajButton = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Virtuálna knižnica");
        setMinimumSize(new java.awt.Dimension(900, 710));
        
        vyhladavajPodlaLabel.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        vyhladavajPodlaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vyhladavajPodlaLabel.setText("Vyhľadávať podľa:");
        
        vyhladavajPodlaButtonGroup.add(nazvuRadioButton);
        nazvuRadioButton.setSelected(true);
        nazvuRadioButton.setText("Názvu");
        nazvuRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nazvuRadioButtonMouseClicked(evt);
            }
        });
        nazvuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nazvuRadioButtonActionPerformed(evt);
            }
        });
        
        vyhladavajPodlaButtonGroup.add(zanruRadioButton);
        zanruRadioButton.setText("Žánru");
        zanruRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zanruRadioButtonMouseClicked(evt);
            }
        });
        
        vyhladavajPodlaButtonGroup.add(oblubenostiRadioButton);
        oblubenostiRadioButton.setText("Obľúbenosti");
        oblubenostiRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oblubenostiRadioButtonMouseClicked(evt);
            }
        });
        
        vyhladavajPodlaButtonGroup.add(autoraRadioButton);
        autoraRadioButton.setText("Autora");
        autoraRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                autoraRadioButtonMouseClicked(evt);
            }
        });
        autoraRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoraRadioButtonActionPerformed(evt);
            }
        });
        
        vyhladavajPodlaButtonGroup.add(jazykaRadioButton);
        jazykaRadioButton.setText("Jazyka");
        jazykaRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jazykaRadioButtonMouseClicked(evt);
            }
        });
        
        vyhladavajPodlaButtonGroup.add(formatuRadioButton);
        formatuRadioButton.setText("Formátu");
        formatuRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formatuRadioButtonMouseClicked(evt);
            }
        });
        
        javax.swing.GroupLayout vyhladavaciPanePanelLayout = new javax.swing.GroupLayout(vyhladavaciPanePanel);
        vyhladavaciPanePanel.setLayout(vyhladavaciPanePanelLayout);
        vyhladavaciPanePanelLayout.setHorizontalGroup(
                vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(vyhladavaciPanePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(vyhladavajPodlaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                        .addGroup(vyhladavaciPanePanelLayout.createSequentialGroup()
                                                .addGroup(vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nazvuRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(zanruRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(oblubenostiRadioButton))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vyhladavaciPanePanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(vyhladavaciPanePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(formatuRadioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(oblubenostiRadioButton)
                                        .addComponent(formatuRadioButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        tabulkaTable.setModel(knihaTableModel);
        tabulkaTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabulkaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabulkaTableMouseClicked(evt);
            }
        });
        TabulkaScrollPane.setViewportView(tabulkaTable);
        
        vyhladajComboBox.setEditable(true);
        vyhladajComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vyhladajComboBoxActionPerformed(evt);
            }
        });
        vyhladajComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vyhladajComboBoxKeyPressed(evt);
            }
        });
        
        vyhladajButton.setText("Hľadaj");
        vyhladajButton.setMaximumSize(new java.awt.Dimension(90, 35));
        vyhladajButton.setMinimumSize(new java.awt.Dimension(90, 35));
        vyhladajButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vyhladajButtonMouseClicked(evt);
            }
        });
        
        prihlasovacieMenoTextField.setText("Meno");
        prihlasovacieMenoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prihlasovacieMenoTextFieldActionPerformed(evt);
            }
        });
        
        hesloPasswordField.setText("jPasswordField1");
        
        prihlasButton.setText("Prihlás sa");
        prihlasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prihlasButtonMouseClicked(evt);
            }
        });
        
        registrujButton.setText("Registruj sa");
        registrujButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrujButtonMouseClicked(evt);
            }
        });
        registrujButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrujButtonActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout prihlasovaciPanelLayout = new javax.swing.GroupLayout(prihlasovaciPanel);
        prihlasovaciPanel.setLayout(prihlasovaciPanelLayout);
        prihlasovaciPanelLayout.setHorizontalGroup(
                prihlasovaciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(prihlasovaciPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(prihlasovaciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hesloPasswordField)
                                        .addComponent(prihlasovacieMenoTextField)
                                        .addGroup(prihlasovaciPanelLayout.createSequentialGroup()
                                                .addComponent(prihlasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(registrujButton, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        prihlasovaciPanelLayout.setVerticalGroup(
                prihlasovaciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(prihlasovaciPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(prihlasovacieMenoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hesloPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(prihlasovaciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(prihlasButton)
                                        .addComponent(registrujButton)))
        );
        
        popisKnihyTextArea.setEditable(false);
        popisKnihyTextArea.setLineWrap(true);
        popisKnihyTextArea.setColumns(20);
        popisKnihyTextArea.setRows(5);
        popisKnihyTextArea.setText("Popis knihy");
        oKniheScrollPane.setViewportView(popisKnihyTextArea);
        
        menoAutoraLabel.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        menoAutoraLabel.setText("Meno autora");
        
        oAutoroviScrollPane.setMaximumSize(new java.awt.Dimension(130, 130));
        
        popisAutoraTextArea.setEditable(false);        
        popisAutoraTextArea.setLineWrap(true);
        popisAutoraTextArea.setColumns(20);
        popisAutoraTextArea.setRows(5);
        popisAutoraTextArea.setText("O autorovi");
        popisAutoraTextArea.setToolTipText("");
        popisAutoraTextArea.setMaximumSize(new java.awt.Dimension(130, 75));
        popisAutoraTextArea.setPreferredSize(new java.awt.Dimension(150, 75));
        oAutoroviScrollPane.setViewportView(popisAutoraTextArea);
        
        pocetStranLabel.setText("Počet strán");
        
        javax.swing.GroupLayout oKnihePanelLayout = new javax.swing.GroupLayout(oKnihePanel);
        oKnihePanel.setLayout(oKnihePanelLayout);
        oKnihePanelLayout.setHorizontalGroup(
                oKnihePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(oKnihePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(oKnihePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(oKniheScrollPane)
                                        .addGroup(oKnihePanelLayout.createSequentialGroup()
                                                .addGroup(oKnihePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(oAutoroviScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                                        .addGroup(oKnihePanelLayout.createSequentialGroup()
                                                                .addComponent(pocetStranLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(122, 122, 122))
                                                        .addComponent(menoAutoraLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(3, 3, 3)))
                                .addContainerGap())
        );
        oKnihePanelLayout.setVerticalGroup(
                oKnihePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oKnihePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(menoAutoraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(oAutoroviScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(oKniheScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pocetStranLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        
        citajButton.setText("Čítaj knihu");
        citajButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                citajButtonMouseClicked(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(vyhladajComboBox, 0, 495, Short.MAX_VALUE)
                                                .addGap(26, 26, 26)
                                                .addComponent(vyhladajButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(TabulkaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(prihlasovaciPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(oKnihePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(vyhladavaciPanePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(citajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(vyhladajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(vyhladajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(TabulkaScrollPane))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(vyhladavaciPanePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prihlasovaciPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(citajButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(oKnihePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        
        pack();
    }// </editor-fold>
    
    private void autoraRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void registrujButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void nazvuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void prihlasovacieMenoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void registrujButtonMouseClicked(java.awt.event.MouseEvent evt) {
        new RegistracnyFormular(this, false).setVisible(true);
    }
    
    private void autoraRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {
        autori = autorDao.nacitajAutorov();
        vyhladajComboBox.setVyhladavatelny(new VyhladavatelnyRetazec(autori));
        vyhladaj = 1;
    }
    
    private void vyhladajButtonMouseClicked(java.awt.event.MouseEvent evt) {
        vyhladajAkcia();
    }
    
    private void nazvuRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {
        nazvy = knihaDao.nacitajKnihy();
        vyhladajComboBox.setVyhladavatelny(new VyhladavatelnyRetazec(nazvy));
        vyhladaj = 0;
    }
    
    
    private void zanruRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {
        zanre = knihaDao.nacitajZanre();
        vyhladajComboBox.setVyhladavatelny(new VyhladavatelnyRetazec(zanre));
        vyhladaj = 2;
    }
    
    private void oblubenostiRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {
        vyhladaj = 4;
    }
    
    private void jazykaRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {
        vyhladajComboBox.setVyhladavatelny(new VyhladavatelnyRetazec(jazyky));
        vyhladaj = 3;
    }
    
    private void formatuRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {
        vyhladajComboBox.setVyhladavatelny(new VyhladavatelnyRetazec(formaty));
        vyhladaj = 5;
    }
    
    private void tabulkaTableMouseClicked(java.awt.event.MouseEvent evt) {
        tabulkaTable.getSelectedRow();
        Long id = (Long) tabulkaTable.getValueAt(tabulkaTable.getSelectedRow(), 4);
        kniha = knihaDao.najdiKnihu(id);
        popisKnihyTextArea.setText(kniha.getPopisKniha());
        autor = autorDao.najdiAutora(kniha.getAutorKniha());
        if (autor.getStredneAutor() != null && autor.getStredneAutor().length() > 2) {
            menoAutoraLabel.setText("Autor: " + autor.getMenoAutor() + " "  +
                    autor.getStredneAutor() + " "+autor.getPriezviskoAutor());
        } else {
            menoAutoraLabel.setText("Autor: " + autor.getMenoAutor() + " " +autor.getPriezviskoAutor());
        }
        popisAutoraTextArea.setText(autor.getPopisAutor());
        pocetStranLabel.setText("Počet strán: " + kniha.getPocetStran());
    }
    
    private void prihlasButtonMouseClicked(java.awt.event.MouseEvent evt) {
        PouzivatelDao pouzivatelDao = MagicFactory.INSTANCE.pouzivatelDao();
        try {
            Pouzivatel pouzivatel = pouzivatelDao.prihlasPouzivatela(prihlasovacieMenoTextField.getText(),
                    hesloPasswordField.getText());
            if (pouzivatel.isJeAdmin()) {
                new AdminOkno(pouzivatel).setVisible(true);
                dispose();
            } else {
                new PouzivatelOkno(pouzivatel).setVisible(true);
                dispose();
            }
        } catch (Exception e) {
        }
    }
    
    private void citajButtonMouseClicked(java.awt.event.MouseEvent evt) {
        if (kniha.getUrlKniha().length() > 4) {
            if(kniha.getFormatKniha().equals("pdf") || 
                    kniha.getFormatKniha().equals("PDF")) {
                new CitacOkno(0, -1L, kniha).setVisible(true);
            }
        }
    }
    
    private void vyhladajComboBoxKeyPressed(java.awt.event.KeyEvent evt) {
        //TODO vyhladat po stalceny enter-u
    }
    
    private void vyhladajComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void vyhladajAkcia() {
        VytvaracAliasov vytvaracAlias = new VytvaracAliasov();
        String naVyhladanie = vytvaracAlias.vytvorAlias(vyhladajComboBox.getEditor().getItem().toString());
        if(vyhladaj == 0) {
            knihy = knihaTableModel.naciatajPodlaNazvu(naVyhladanie);
        }
        if(vyhladaj == 1) {
            knihy = knihaTableModel.naciatajPodlaAutora(naVyhladanie);
        }
        if(vyhladaj == 2) {
            knihy = knihaTableModel.naciatajPodlaZanru(naVyhladanie);
        }
        if(vyhladaj == 3) {
            knihy = knihaTableModel.naciatajPodlaJazyka(naVyhladanie);
        }
        if(vyhladaj == 4) {
            knihy = knihaTableModel.nacitajPodlaOblubenosti();
        }
        if(vyhladaj == 5) {
            knihy = knihaTableModel.naciatajPodlaFormatu(naVyhladanie);
        }
    }
    
    
    
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
            java.util.logging.Logger.getLogger(UvodneOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UvodneOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UvodneOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UvodneOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UvodneOkno().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify
    private javax.swing.JScrollPane TabulkaScrollPane;
    private javax.swing.JRadioButton autoraRadioButton;
    private javax.swing.JButton citajButton;
    private javax.swing.JRadioButton formatuRadioButton;
    private javax.swing.JPasswordField hesloPasswordField;
    private javax.swing.JRadioButton jazykaRadioButton;
    private javax.swing.JLabel menoAutoraLabel;
    private javax.swing.JRadioButton nazvuRadioButton;
    private javax.swing.JScrollPane oAutoroviScrollPane;
    private javax.swing.JPanel oKnihePanel;
    private javax.swing.JScrollPane oKniheScrollPane;
    private javax.swing.JRadioButton oblubenostiRadioButton;
    private javax.swing.JLabel pocetStranLabel;
    private javax.swing.JTextArea popisAutoraTextArea;
    private javax.swing.JTextArea popisKnihyTextArea;
    private javax.swing.JButton prihlasButton;
    private javax.swing.JPanel prihlasovaciPanel;
    private javax.swing.JTextField prihlasovacieMenoTextField;
    private javax.swing.JButton registrujButton;
    private javax.swing.JTable tabulkaTable;
    private javax.swing.JButton vyhladajButton;
    private KombacNasepkavac vyhladajComboBox;
    private javax.swing.JPanel vyhladavaciPanePanel;
    private javax.swing.ButtonGroup vyhladavajPodlaButtonGroup;
    private javax.swing.JLabel vyhladavajPodlaLabel;
    private javax.swing.JRadioButton zanruRadioButton;
    // End of variables declaration
}
