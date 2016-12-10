package sk.upjs.ics.paz1c.vynimky;

public class NeplatneRegistracneMenoException extends RuntimeException {

    private final String exception = "Zvolené používateľské meno je už obsadené!";

    public String getSprava() {
        return exception;
    }
}
