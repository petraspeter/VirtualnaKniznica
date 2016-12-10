package sk.upjs.ics.paz1c.vynimky;

/**
 *
 * @author raven
 */
public class KnihuSaNepodariloNacitatException extends RuntimeException {
    
    private final String exception = "Knihu sa nepodarilo načítať!";
    
    public String getSprava() {
        return exception;
    }
    
}