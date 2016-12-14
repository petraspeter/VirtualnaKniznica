package sk.upjs.ics.paz1c.modely;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.dao.AutorDao;
import sk.upjs.ics.paz1c.dao.KnihaDao;
import sk.upjs.ics.paz1c.dao.PouzivatelDao;
import sk.upjs.ics.paz1c.entity.Autor;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.entity.Pouzivatel;
import sk.upjs.ics.paz1c.pomocneTriedy.CitacVstupu;
import sk.upjs.ics.paz1c.tovaren.MagicFactory;

/**
 *
 * @author raven
 */
public class KnihaTableModel extends AbstractTableModel {
    
    
    private static final AutorDao autorDao = MagicFactory.INSTANCE.autorDao();
    
    private static final KnihaDao knihaDao = MagicFactory.INSTANCE.knihaDao();
    
    private static final int pocetStlpcov = 5;
    
    private static final String[] nazvyStlpocv = {"Názov", "Žáner", "Jazyk", "Formát", "ID"};
    
    private static final Class[] typyStlpcov = {String.class, String.class, String.class, String.class, Long.class};
    
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
                    if(kniha.getJazyk2() != null && !kniha.getJazyk2().equals("")) {
                        return kniha.getJazyk1() + "/" + kniha.getJazyk2();
                    } else {
                        return kniha.getJazyk1();
                    }
                } else {
                    if(columnIndex == 3) {
                        return kniha.getFormatKniha();
                    } else {
                        return kniha.getIdKniha();
                    }
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
    
    public List<Kniha> naciatajPodlaAutora(String autor) {
        CitacVstupu citacVstupu = new CitacVstupu();
        String[] vstup = citacVstupu.vratPodretazceZoVstupu(autor);
        knihy.clear();
        if(vstup.length > 2) {
            knihy = autorDao.najdiKnihuPodlaAutora(vstup[0], vstup[1], vstup[2]);
        } else {
            if(vstup.length == 2) {
                knihy = autorDao.najdiKnihuPodlaAutora(vstup[0], null, null);
            } else {
                knihy = autorDao.najdiKnihuPodlaAutora(vstup[0], null, vstup[1]);
            }
        }
        fireTableDataChanged();
        return knihy;
    }
    
    public List<Kniha> nacitajPodlaOblubenosti() {
        knihy.clear();
        knihy = knihaDao.najdiPodlaOblubenosti();
        fireTableDataChanged();
        return knihy;
    }
    
    public List<Kniha> nacitajOblubene(Pouzivatel pouzivatel) {
        knihy.clear();
        PouzivatelDao pouzivatelDao = MagicFactory.INSTANCE.pouzivatelDao();
        knihy = pouzivatelDao.oblubeneKnihy(pouzivatel);
        fireTableDataChanged();
        return knihy;
    }
    
    public List<Kniha> nacitajRozcitane(Pouzivatel pouzivatel) {
        knihy.clear();
        PouzivatelDao pouzivatelDao = MagicFactory.INSTANCE.pouzivatelDao();
        knihy = pouzivatelDao.rozcitaneKnihy(pouzivatel);
        fireTableDataChanged();
        return knihy;
    }
    
}
