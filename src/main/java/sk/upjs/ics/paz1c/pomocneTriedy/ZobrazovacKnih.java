package sk.upjs.ics.paz1c.pomocneTriedy;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
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
import javax.swing.JViewport;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author raven
 */
public class ZobrazovacKnih {
    
    public void nacitajText (String urlAdresa) throws FileNotFoundException, IOException {
        
        long s = System.currentTimeMillis();
        InputStream input = new URL(urlAdresa).openStream();
        PDDocument pdfDokument = PDDocument.load(input);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(pdfDokument);
        
        
        System.out.println((System.currentTimeMillis() - s)/1000.0 + "s");
        
    }
    
    
    public BufferedImage[] nacitajStranyAkoObrazky (String urlAdresa) throws MalformedURLException, IOException  {
        
        long s = System.currentTimeMillis();
        BufferedImage[] strany  = null;
        InputStream input = new URL(urlAdresa).openStream();
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
        frame.setSize(2000 , 1800);
        JScrollPane skrolovaciPanel = new JScrollPane(new JPanel());
        skrolovaciPanel.setSize(2000, 1800);
        JLabel jlabel = new JLabel(new ImageIcon(pdfStrany[0]));
        JViewport view = new JViewport();
        view.setView(jlabel);
        view.setViewSize(new Dimension(2000, 1800));
        
        skrolovaciPanel.setViewportView(view);
        
        
        frame.add(skrolovaciPanel);
        frame.setVisible(true);
        
        System.out.println((System.currentTimeMillis() - s)/1000.0 + "s");
    }
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        ZobrazovacKnih zobrazovacKnih = new ZobrazovacKnih();
        zobrazovacKnih.vykresli(zobrazovacKnih.nacitajStranyAkoObrazky("http://s.ics.upjs.sk/~ppetras/paz1c/Antoine%20de%20Saint-Exup%c3%a9ry%20-%20Mal%c3%bd%20Princ.pdf"));
        // zobrazovacKnih.nacitajText("http://s.ics.upjs.sk/~ppetras/paz1c/Antoine%20de%20Saint-Exup%c3%a9ry%20-%20Mal%c3%bd%20Princ.pdf");
    }
    
    
    
}
