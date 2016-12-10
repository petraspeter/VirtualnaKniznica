package sk.upjs.ics.paz1c.entity;

import sk.upjs.ics.paz1c.pomocneTriedy.VytvaracAliasov;

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
    
    private String fotkaAutor;
    
    public Autor() {
    }
    
    public Autor(Long idAutor, String menoAutor,  String priezviskoAutor, String stredneAutor, String popisAutor, String fotkaAutor) {
        VytvaracAliasov vytvaracAliasov = new VytvaracAliasov();
        this.idAutor = idAutor;
        this.menoAutor = menoAutor;
        this.aliasMeno = vytvaracAliasov.vytvorAlias(menoAutor);
        this.priezviskoAutor = priezviskoAutor;
        this.aliasPriezvisko = vytvaracAliasov.vytvorAlias(priezviskoAutor);
        this.stredneAutor = stredneAutor;
        this.aliasStredne = vytvaracAliasov.vytvorAlias(stredneAutor);
        this.popisAutor = popisAutor;
        this.fotkaAutor = fotkaAutor;
    }
    
    public Autor(Long idAutor, String menoAutor, String priezviskoAutor, String stredneAutor) {
        VytvaracAliasov vytvaracAliasov = new VytvaracAliasov();
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
        this.priezviskoAutor = priezviskoAutor;
        this.stredneAutor = stredneAutor;
    }
    
    public Autor(String menoAutor, String priezviskoAutor, String stredneAutor, String popisAutor, String fotkaAutor) {
        this.menoAutor = menoAutor;
        this.priezviskoAutor = priezviskoAutor;
        this.stredneAutor = stredneAutor;
        this.popisAutor = popisAutor;
        this.fotkaAutor = fotkaAutor;
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
    
    public String getFotkaAutor() {
        return fotkaAutor;
    }
    
    public void setFotkaAutor(String fotkaAutor) {
        this.fotkaAutor = fotkaAutor;
    }
    
}
