package sk.upjs.ics.paz1c.vynimky;

/**
 *
 * @author raven
 */
public class NeuspesnePrihlasenieException extends RuntimeException {

    private final String exception = "Nepodarilo sa prihlásiť. Zadali ste nesprávne meno alebo heslo!";

    public String getSprava() {
        return exception;
    }
}
