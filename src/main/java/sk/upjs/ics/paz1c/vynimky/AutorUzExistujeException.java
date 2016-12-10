package sk.upjs.ics.paz1c.vynimky;

/**
 *
 * @author raven
 */
public class AutorUzExistujeException extends RuntimeException {
    
    private final String exception = "Zadaný autor už existuje!";
    
    public String getSprava() {
        return exception;
    }
    
}
