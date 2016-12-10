package sk.upjs.ics.paz1c.dao;

import java.util.List;
import sk.upjs.ics.paz1c.entity.Kniha;

/**
 *
 * @author raven
 */
public interface KnihaDao {

    List<Kniha> najdiPodlaNazvu(String nazov);
    
    List<Kniha> najdiPodlaFormatu(String format);
    
    List<Kniha> najdiPodlaZanru(String zaner);
    
    List<Kniha> najdiPodlaJazyka(String jazyk);
        
    List<Kniha> najdiPodlaOblubenosti();

    public void vymazKnihu(Long id);

    public void vymazKnihu(Kniha kniha);

    public void upravKnihu(Kniha kniha);

    public void pridajKnihu(Kniha Kniha);

}