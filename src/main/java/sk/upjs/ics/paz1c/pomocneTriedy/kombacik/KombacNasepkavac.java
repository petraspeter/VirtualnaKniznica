package sk.upjs.ics.paz1c.pomocneTriedy.kombacik;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author raven
 */
public class KombacNasepkavac extends JComboBox{
    
    /*
    pouzity zdroj: http://www.algosome.com/articles/java-jcombobox-autocomplete.html
    */
    
    private final Vyhladavatelny<String,String> vyhladavatelny;
    
    public KombacNasepkavac(Vyhladavatelny<String,String> vstup){
        super();
        this.vyhladavatelny = vstup;
        setEditable(true);
        Component komponent = getEditor().getEditorComponent();
        if ( komponent instanceof JTextComponent ){
            final JTextComponent textovyKomponent = (JTextComponent)komponent;
            textovyKomponent.getDocument().addDocumentListener(new DocumentListener(){
                
                @Override
                public void changedUpdate(DocumentEvent e) {
                    
                }
                
                @Override
                public void insertUpdate(DocumentEvent e) {
                    update();
                }
                
                @Override
                public void removeUpdate(DocumentEvent e) {
                    update();
                }
                
                public void update(){
                    SwingUtilities.invokeLater(new Runnable(){
                        
                        @Override
                        public void run() {
                            
                            List<String> najdene = new ArrayList<String>(vyhladavatelny.vyhladaj(textovyKomponent.getText()));
                            Set<String> najdenaMnozina = new HashSet<String>();
                            for ( String string : najdene ){
                                najdenaMnozina.add(string.toLowerCase());
                            }
                            
                            Collections.sort(najdene);
                            setEditable(false);
                            removeAllItems();
                            if ( !najdenaMnozina.contains( textovyKomponent.getText().toLowerCase()) ){
                                addItem( textovyKomponent.getText() );
                            }
                            
                            for (String string : najdene) {
                                addItem(string);
                            }
                            
                            setEditable(true);
                            setPopupVisible(true);
                            textovyKomponent.requestFocus(); 
                        }
                    });
                }
            });
            
            textovyKomponent.addFocusListener(new FocusListener(){
                
                @Override
                public void focusGained(FocusEvent e) {
                    if ( textovyKomponent.getText().length() >= 0 ){
                        setPopupVisible(true);
                    }
                }
                
                @Override
                public void focusLost(FocusEvent e) {
                    
                }
            });
        }
        
    }
    public static void main(String[] args) throws Exception{
        SwingUtilities.invokeAndWait(new Runnable(){
            
            @Override
            public void run() {
                
                List<String> slovnik = new ArrayList<String>();
                slovnik.add("skortenie čertice");
                slovnik.add("diabol v zvonici");
                slovnik.add("Ako sa máš");
                slovnik.add("ľaľia");
                slovnik.add("canadian");
                slovnik.add("caprecious");
                slovnik.add("catepult");
                
                VyhladavatelnyRetazec vyhladavatelniu = new VyhladavatelnyRetazec(slovnik);
                KombacNasepkavac kombacik = new KombacNasepkavac(vyhladavatelniu);
                JFrame frame = new JFrame("Kombáčik");
                frame.add(kombacik);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                
            }
        });
    }
    
}

