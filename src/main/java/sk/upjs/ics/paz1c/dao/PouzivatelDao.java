package sk.upjs.ics.paz1c.dao;

import java.util.List;
import java.util.Map;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.entity.Pouzivatel;

/**
 *
 * @author raven
 */
public interface PouzivatelDao {
    
    Pouzivatel prihlasPouzivatela(String meno, String heslo);
    
    void zaregistrujPouzivatela(String meno, String heslo, String email);
    
    List<Kniha> oblubeneKnihy(Pouzivatel pouzivatel);
    
     Map<Kniha, Integer> rozcitaneKnihy(Pouzivatel pouzivatel);
    
    List<Kniha> pridalPouzivatel(Pouzivatel pouzivatel);
    
}
