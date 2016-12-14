package sk.upjs.ics.paz1c.modely;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.dao.AutorDao;
import sk.upjs.ics.paz1c.dao.KnihaDao;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.pomocneTriedy.CitacVstupu;
import sk.upjs.ics.paz1c.tovaren.MagicFactory;

/**
 *
 * @author raven
 */
public class AdminKnihaTableModel  extends AbstractTableModel{
    
    private static final AutorDao autorDao = MagicFactory.INSTANCE.autorDao();
    
    private static final KnihaDao knihaDao = MagicFactory.INSTANCE.knihaDao();
    
    private static final int pocetStlpcov = 12;
    
    private static final String[] nazvyStlpocv = {"ID", "Názov", "Alias", "Autor", "URL", "Pridal", "Formát",
        "Žáner", "Jazyk", "Jazyk2", "Počet strán", "Popis"};
    
    private static final Class[] typyStlpcov = {Long.class, String.class, String.class, Long.class, String.class,
        Long.class, String.class, Long.class, String.class, String.class, Integer.class, String.class};
    
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
        /*    "ID", "Názov", "Alias", "Autor", "URL", "Pridal", "Formát",
        "Žáner", "Jazyk", "Počet strán", "Popis"};*/
        if(columnIndex == 0) {
            return kniha.getIdKniha();
        }
        if(columnIndex == 1) {
            return kniha.getNazovKniha();
        }
        if(columnIndex == 2) {
            return kniha.getAliasKniha();
        }
        if(columnIndex == 3) {
            return kniha.getAutorKniha();
        }
        if(columnIndex == 4) {
            return kniha.getUrlKniha();
        }
        if(columnIndex == 5) {
            return kniha.getPridalKniha();
        }
        if(columnIndex == 6) {
            return kniha.getFormatKniha();
        }
        if(columnIndex == 7) {
            return kniha.getZaner();
        }
        if(columnIndex == 8) {
            return kniha.getJazyk1();
        }
        if(columnIndex == 9) {
            return kniha.getJazyk2();
        }
        if(columnIndex == 10) {
            return kniha.getPocetStran();
        }
        if(columnIndex == 11) {
            return kniha.getPopisKniha();
        }
        return null;
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
    public List<Kniha> naciatajPodlaNazvu(String nazov) {
        knihy.clear();
        knihy = knihaDao.najdiPodlaNazvu(nazov);
        fireTableDataChanged();
        return knihy;
    }
    
    public List<Kniha> naciatajPodlaZanru(String zaner) {
        knihy.clear();
        knihy = knihaDao.najdiPodlaZanru(zaner);
        fireTableDataChanged();
        return knihy;
    }
    
    public List<Kniha> naciatajPodlaFormatu(String format) {
        knihy.clear();
        knihy = knihaDao.najdiPodlaFormatu(format);
        fireTableDataChanged();
        return knihy;
    }
    
    public List<Kniha> naciatajPodlaJazyka(String jazyk) {
        knihy.clear();
        knihy = knihaDao.najdiPodlaJazyka(jazyk);
        fireTableDataChanged();
        return knihy;
    }
    
    public List<Kniha> nacitajPodlaOblubenosti() {
        knihy.clear();
        knihy = knihaDao.najdiPodlaOblubenosti();
        fireTableDataChanged();
        return knihy;
    }
    
    public List<Kniha> naciatajPodlaAutora(String autor) {
        CitacVstupu citacVstupu = new CitacVstupu();
        String[] vstup = citacVstupu.vratPodretazceZoVstupu(autor);
        knihy.clear();
        if(vstup.length > 2) {
            knihy = autorDao.najdiKnihuPodlaAutora(vstup[0], vstup[1], vstup[2]);
        } else {
            if(vstup.length == 1) {
                knihy = autorDao.najdiKnihuPodlaAutora(vstup[0], null, null);
            } else {
                knihy = autorDao.najdiKnihuPodlaAutora(vstup[0], null, vstup[1]);
            }
        }
        fireTableDataChanged();
        return knihy;
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }
    
}
