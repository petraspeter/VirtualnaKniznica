package sk.upjs.ics.paz1c.dao;



import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.entity.Autor;
import java.util.List;

/**
 *
 * @author raven
 */
public interface AutorDao {
    
    List<Kniha> najdiKnihuPodlaAutora(String meno, String priezvisko, String stredne);
    
    List<Kniha> najdiKnihuPodlaAutora(Long id);
    
    List<String> nacitajAutorov();
    
    Autor najdiAutora(String meno, String priezvisko, String stredne);
        
    Autor najdiAutora(Long id);
    
    public void pridajAutora(Autor autor);
    
    public void upravAutora(Autor autor);
    
    public void vymazAutora(Autor autor);
    
}
