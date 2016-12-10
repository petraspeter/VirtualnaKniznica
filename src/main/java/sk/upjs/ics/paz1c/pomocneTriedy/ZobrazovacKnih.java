package sk.upjs.ics.paz1c.pomocneTriedy;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 *
 * @author raven
 */
public class ZobrazovacKnih {
    
    
    public BufferedImage[] nacitajStranyAkoObrazky (String urlAdresa) throws MalformedURLException, IOException  {
        
        long s = System.currentTimeMillis();
        BufferedImage[] strany  = null;
        InputStream input = new FileInputStream("idiot.pdf");
        PDDocument pdfDokument = PDDocument.load(input);
        
        /*
        synchronized blok
        */
        pdfDokument.getClass();
        if (!pdfDokument.isEncrypted()) {
            
            int pocetStran = pdfDokument.getNumberOfPages();
            strany = new BufferedImage[pocetStran];
            PDFRenderer pdfRender = new PDFRenderer(pdfDokument);
            for (int i = 0; i < pocetStran; i++) {
                strany[i] = pdfRender.renderImage(i);
            }
        } else {
            System.err.println("Subor je zaheslovany!");
        }
        
        pdfDokument.close();
        
        System.out.println((System.currentTimeMillis() - s)/1000.0 + "s");
        return strany;
    }
    
    public void vykresli(BufferedImage[] pdfStrany) {
        long s = System.currentTimeMillis();
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        JScrollPane skrolovaciPanel = new JScrollPane(new JPanel());
        skrolovaciPanel.setSize(495, 495);
        skrolovaciPanel.setViewportView(new JLabel(new ImageIcon(pdfStrany[5])));
        
        
        
        
        System.out.println((System.currentTimeMillis() - s)/1000.0 + "s");
    }
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        ZobrazovacKnih zobrazovacKnih = new ZobrazovacKnih();
        zobrazovacKnih.vykresli(zobrazovacKnih.nacitajStranyAkoObrazky("http://s.ics.upjs.sk/~ppetras/tri_musketyri_II-dumas.pdf"));
    }
    
    
    
}
