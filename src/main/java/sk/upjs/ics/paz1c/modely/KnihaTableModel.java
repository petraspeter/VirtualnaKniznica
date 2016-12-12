package sk.upjs.ics.paz1c.modely;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.dao.AutorDao;
import sk.upjs.ics.paz1c.dao.KnihaDao;
import sk.upjs.ics.paz1c.entity.Autor;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.tovaren.MagicFactory;

/**
 *
 * @author raven
 */
public class KnihaTableModel extends AbstractTableModel {
    
    
    private static final AutorDao autorDao = MagicFactory.INSTANCE.autorDao();
    
    private static final KnihaDao knihaDao = MagicFactory.INSTANCE.knihaDao();
    
    private static final int pocetStlpcov = 4;
    
    private static final String[] nazvyStlpocv = {"Názov", "Žáner", "Jazyk", "Formát"};
    
    private static final Class[] typyStlpcov = {String.class, String.class, String.class, String.class};
        
    Autor autor = new Autor();
    
    private List<Kniha> knihy = new ArrayList<>();
        
    @Override
    public int getRowCount() {
        return knihy.size();
    }
    
    @Override
    public int getColumnCount() {
        return pocetStlpcov;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kniha kniha = knihy.get(rowIndex);
        autor = autorDao.najdiAutora(kniha.getAutorKniha());
        if(columnIndex == 0) {
            return kniha.getNazovKniha();
        } else {
            if(columnIndex == 1) {
                return knihaDao.vratZaner(kniha.getZaner());
            } else {
                if(columnIndex == 2) {
                    if(kniha.getJazyk2() != null) {
                        return kniha.getJazyk1() + "/" + kniha.getJazyk2();
                    } else {
                        return kniha.getJazyk1();
                    }
                } else {
                    return kniha.getFormatKniha();
                }
            }
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return nazvyStlpocv[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return typyStlpcov[columnIndex];
    }
    
    /*
    nacitavanie knihy podla vstupu
    */
    public void naciatajPodlaNazvu(String nazov) {
        knihy.clear();
        knihy = knihaDao.najdiPodlaNazvu(nazov);
        fireTableDataChanged();
    }
    
    public void naciatajPodlaZanru(String zaner) {
        knihy.clear();
        knihy = knihaDao.najdiPodlaNazvu(zaner);
        fireTableDataChanged();
    }
    
    public void naciatajPodlaFormatu(String format) {
        knihy.clear();
        knihy = knihaDao.najdiPodlaNazvu(format);
        fireTableDataChanged();
    }
    
    public void naciatajPodlaJazyka(String jazyk) {
        knihy.clear();
        knihy = knihaDao.najdiPodlaNazvu(jazyk);
        fireTableDataChanged();
    }
        
}
