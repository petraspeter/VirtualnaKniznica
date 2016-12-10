package sk.upjs.ics.paz1c.vynimky;

/**
 *
 * @author raven
 */
public class NeuspesneZiskanieNastaveniException  extends RuntimeException {
    
    private final String exception = "Nepodarilo sa získať údaje z konfiguračného súboru!";
    
    public String getSprava() {
        return exception;
    }
}