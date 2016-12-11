package sk.upjs.ics.paz1c.pomocneTriedy.kombacik;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author raven
 */
public class VyhladavatelnyRetazec implements Vyhladavatelny<String,String>{
    
    private List<String> kluce = new ArrayList<String>();
    public VyhladavatelnyRetazec(List<String> kluce){
        this.kluce.addAll(kluce);
    }
    
    @Override
    public Collection<String> vyhladaj(String vstup) {
        List<String> najdene = new ArrayList<String>();
        for ( String s : kluce ){
            if ( s.indexOf(vstup) == 0 ){
                najdene.add(s);
            }
        }
        return najdene;
    }
    
}

