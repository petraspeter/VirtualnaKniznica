package sk.upjs.ics.paz1c.entity;

import sk.upjs.ics.paz1c.pomocneTriedy.VytvaracAliasov;
import sk.upjs.ics.paz1c.pomocneTriedy.CitacVstupu;

/**
 *
 * @author raven
 */
public class Autor {
    
    /*
    instancne premenne
    */
    private Long idAutor;
    
    private String menoAutor;
    
    private String aliasMeno;
    
    private String priezviskoAutor;
    
    private String aliasPriezvisko;
    
    private String stredneAutor;
    
    private String aliasStredne;
    
    private String popisAutor;
    
    private VytvaracAliasov vytvaracAliasov = new VytvaracAliasov();
    
    public Autor() {
    }
    
    public Autor(Long idAutor, String menoAutor,  String priezviskoAutor, String stredneAutor, String popisAutor) {
        this.idAutor = idAutor;
        this.menoAutor = menoAutor;
        this.aliasMeno = vytvaracAliasov.vytvorAlias(menoAutor);
        this.priezviskoAutor = priezviskoAutor;
        this.aliasPriezvisko = vytvaracAliasov.vytvorAlias(priezviskoAutor);
        this.stredneAutor = stredneAutor;
        this.aliasStredne = vytvaracAliasov.vytvorAlias(stredneAutor);
        this.popisAutor = popisAutor;
    }
    
    public Autor(Long idAutor, String menoAutor, String priezviskoAutor, String stredneAutor) {
        this.idAutor = idAutor;
        this.menoAutor = menoAutor;
        this.aliasMeno = vytvaracAliasov.vytvorAlias(menoAutor);
        this.priezviskoAutor = priezviskoAutor;
        this.aliasPriezvisko = vytvaracAliasov.vytvorAlias(priezviskoAutor);
        this.stredneAutor = stredneAutor;
        this.aliasStredne = vytvaracAliasov.vytvorAlias(stredneAutor);
    }
    
    public Autor(String menoAutor, String priezviskoAutor, String stredneAutor) {
        this.menoAutor = menoAutor;
        this.aliasMeno = vytvaracAliasov.vytvorAlias(menoAutor);
        this.priezviskoAutor = priezviskoAutor;
        this.aliasPriezvisko = vytvaracAliasov.vytvorAlias(priezviskoAutor);
        this.stredneAutor = stredneAutor;
        this.aliasStredne = vytvaracAliasov.vytvorAlias(stredneAutor);
    }
    
    public Autor(String menoAutor, String priezviskoAutor, String stredneAutor, String popisAutor) {
        this.menoAutor = menoAutor;
        this.aliasMeno = vytvaracAliasov.vytvorAlias(menoAutor);
        this.priezviskoAutor = priezviskoAutor;
        this.aliasPriezvisko = vytvaracAliasov.vytvorAlias(priezviskoAutor);
        this.stredneAutor = stredneAutor;
        this.aliasStredne = vytvaracAliasov.vytvorAlias(stredneAutor);
        this.popisAutor = popisAutor;
    }
    
    public Autor(String meno, String popis) {
        CitacVstupu citacVstupu = new CitacVstupu();
        String[] vstup = citacVstupu.vratPodretazceZoVstupu(meno);
        if(vstup.length == 2) {
            this.menoAutor = vstup[0];
            this.aliasMeno = vytvaracAliasov.vytvorAlias(this.menoAutor);
            this.priezviskoAutor = vstup[1];
            this.aliasPriezvisko = vytvaracAliasov.vytvorAlias(this.priezviskoAutor);
        } else {
            this.menoAutor = vstup[0];
            this.aliasMeno = vytvaracAliasov.vytvorAlias(this.menoAutor);
            this.priezviskoAutor = vstup[2];
            this.aliasPriezvisko = vytvaracAliasov.vytvorAlias(this.priezviskoAutor);
            this.stredneAutor = vstup[1];
            this.aliasStredne = vytvaracAliasov.vytvorAlias(this.stredneAutor);
        }
        
    }
    
    public Long getIdAutor() {
        return idAutor;
    }
    
    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }
    
    public String getMenoAutor() {
        return menoAutor;
    }
    
    public void setMenoAutor(String menoAutor) {
        this.menoAutor = menoAutor;
        this.aliasMeno = vytvaracAliasov.vytvorAlias(menoAutor);
    }
    
    public String getAliasMeno() {
        return aliasMeno;
    }
    
    public void setAliasMeno(String aliasMeno) {
        this.aliasMeno = aliasMeno;
    }
    
    public String getPriezviskoAutor() {
        return priezviskoAutor;
    }
    
    public void setPriezviskoAutor(String priezviskoAutor) {
        this.priezviskoAutor = priezviskoAutor;
        this.aliasPriezvisko = vytvaracAliasov.vytvorAlias(priezviskoAutor);
    }
    
    public String getAliasPriezvisko() {
        return aliasPriezvisko;
    }
    
    public void setAliasPriezvisko(String aliasPriezvisko) {
        this.aliasPriezvisko = aliasPriezvisko;
    }
    
    public String getStredneAutor() {
        return stredneAutor;
    }
    
    public void setStredneAutor(String stredneAutor) {
        this.stredneAutor = stredneAutor;
        this.stredneAutor = vytvaracAliasov.vytvorAlias(stredneAutor);
    }
    
    public String getAliasStredne() {
        return aliasStredne;
    }
    
    public void setAliasStredne(String aliasStredne) {
        this.aliasStredne = aliasStredne;
    }
    
    public String getPopisAutor() {
        return popisAutor;
    }
    
    public void setPopisAutor(String popisAutor) {
        this.popisAutor = popisAutor;
    }
    
}
