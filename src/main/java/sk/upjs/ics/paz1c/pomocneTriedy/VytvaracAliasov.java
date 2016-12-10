package sk.upjs.ics.paz1c.pomocneTriedy;

import org.apache.commons.lang3.StringUtils;


/**
 *
 * @author raven
 */
public class VytvaracAliasov {
    
    /*
    vrati vstup s diakritikou ci inymi specialnymi znakmi(napriklad polske Ł, ł) ako vstup bez diakritiky
    odstranuje viacnasobne medzery, pomlcky a podtrzniky
    odstranuje medzery na zaciatku a konci slova
    */
    public String vytvorAlias(String vstup) {
        if(vstup.length() > 0) {
            String vystup = StringUtils.stripAccents(vstup).toLowerCase();
            StringBuilder sb = new StringBuilder();
            int j = vystup.length()-1;
            while(vystup.charAt(j) == ' ') {
                j--;
            }
            vystup = vystup.substring(0, j + 1);
            for(int i = 1; i < vystup.length(); i++) {
                if(vystup.charAt(i) == ' ') {
                    if(!(vystup.charAt(i - 1) == ' ')) {
                        sb.append(vystup.charAt(i));
                    }
                } else {
                    if(vystup.charAt(i) == '_') {
                        if(!(vystup.charAt(i - 1) == '_')) {
                            sb.append(vystup.charAt(i));
                        }
                    } else {
                        if(vystup.charAt(i) == '-') {
                            if(!(vystup.charAt(i - 1) == '-')) {
                                sb.append(vystup.charAt(i));
                            }
                        } else {
                            sb.append(vystup.charAt(i));
                        }
                    }
                }
            }
            if(vystup.charAt(0) != ' ') {
                return vystup.charAt(0) + sb.toString().toLowerCase();
            } else {
                return sb.toString().toLowerCase();
            }
        } else {
            return null;
        }
    }
    
}
