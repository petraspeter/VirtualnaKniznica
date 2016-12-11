
package sk.upjs.ics.paz1c.pomocneTriedy.kombacik;

import java.util.Collection;

/**
 *
 * @author raven
 */
public interface Vyhladavatelny<E, V>{
    
    public Collection<E> vyhladaj(V value);
    
    
}