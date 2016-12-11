package sk.upjs.ics.paz1c.pomocneTriedy;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.databazovyDao.DatabazovyAutorDao;
import sk.upjs.ics.paz1c.databazovyDao.DatabazovyKnihaDao;
import sk.upjs.ics.paz1c.databazovyDao.DatabazovyPouzivatelDao;
import sk.upjs.ics.paz1c.entity.Autor;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.entity.Pouzivatel;
import sk.upjs.ics.paz1c.tovaren.MagicFactory;

/**
 *
 * @author raven
 */
public class citacVstupu {
    
    /*
    zo vstupneho stringu nam vrati jeho obsah vo forme pola stringov, kde ako oddelovac pouzijeme
    znak, ktory nie je pismenom
    kedze \\W berie ako non-word character aj pismena slovenskej, ceskej atd abecedy, tak je potrebne ich
    najskor prerobit na pismena anglickej abecedy
    */
    public String[] vratPodretazceZoVstupu (String vstup) {
        vstup = StringUtils.stripAccents(vstup).toLowerCase();
        String[] vysledok = vstup.split("\\W|_");
        return vysledok;
    }
    
    
    /*
    testovanie dao-a
    */
    public static void main(String[] args) {
        
        JdbcTemplate jdbcTemplate = MagicFactory.INSTANCE.getJdbcTemplate();
        Kniha kniha = new Kniha();
        DatabazovyKnihaDao dkd = new DatabazovyKnihaDao(jdbcTemplate);
        List<Kniha> knihy = new ArrayList<>();
        knihy = dkd.najdiPodlaNazvu("ran");
        kniha = knihy.get(0);
        System.out.println(dkd.vratZaner(5));
//        kniha.setPopisKniha("Havran je jednou z najznámejších básní americkej literatúry. Medzi jej "
//                + "charakteristické rysy patrí zvuková bohatosť až muzikálnosť (porov. havranom neustále "
//                + "opakované Nevermore), jazyková štylizácia a nadprirodzená atmosféra plná symbolov. "
//                + "Z týchto dôvodov sa báseň považuje za jeden z najväčších prekladateľských orieškov.");
System.out.println(kniha.getAliasKniha());
//   dkd.upravKnihu(kniha);


DatabazovyAutorDao dad = new DatabazovyAutorDao(jdbcTemplate);
knihy = dad.najdiKnihuPodlaAutora("edgar", "", "");
System.out.println(knihy.get(0).getNazovKniha());
//        Autor autor = new Autor("George", "Orwell", "");
//      // dad.pridajAutora(autor);
//      Autor a = new Autor();
//      a.setMenoAutor("John");
//      a.setPriezviskoAutor("Doe");
//      dad.pridajAutora(a);
//  //    a = dad.najdiAutora("george", "orwell");
//      System.out.println(a.getMenoAutor());
//      dad.najdiAutora(a.getMenoAutor(), a.getPriezviskoAutor());
////
//        System.out.println(knihy.get(0).getPopisKniha());
//
//        DatabazovyPouzivatelDao dpd = new DatabazovyPouzivatelDao(jdbcTemplate);
// dpd.zaregistrujPouzivatela("gyula2", "hesloAkeNeuhadnes", "gyula@gyula.hu");
//        Pouzivatel p1 = new Pouzivatel();
//        p1.setIdPouzivatel(2L);
//   knihy=dpd.rozcitaneKnihy(p1);
//        System.out.println(knihy.get(0).getFormatKniha());

    }
    
    
    
    
}
