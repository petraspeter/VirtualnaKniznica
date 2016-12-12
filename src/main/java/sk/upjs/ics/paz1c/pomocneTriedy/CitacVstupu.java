package sk.upjs.ics.paz1c.pomocneTriedy;

import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author raven
 */
public class CitacVstupu {
    
    /*
    zo vstupneho stringu nam vrati jeho obsah vo forme pola stringov, kde ako oddelovac pouzijeme
    znak, ktory nie je pismenom
    kedze \\W berie ako non-word character aj pismena slovenskej, ceskej atd abecedy, tak je potrebne ich
    najskor prerobit na pismena anglickej abecedy
    */
    public String[] vratPodretazceZoVstupu (String vstup) {
        vstup = StringUtils.stripAccents(vstup).toLowerCase();
        String[] vysledok = vstup.split("\\W|_");
        return vysledok;
    }
    
}
