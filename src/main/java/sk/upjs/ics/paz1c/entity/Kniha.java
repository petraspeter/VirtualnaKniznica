package sk.upjs.ics.paz1c.entity;

import sk.upjs.ics.paz1c.pomocneTriedy.VytvaracAliasov;

/**
 *
 * @author raven
 */
public class Kniha {
    
    /*
    instancne premenne
    */
    private Long idKniha;
    
    private String nazovKniha;
    
    private String aliasKniha;
    
    private Long autorKniha;
    
    private String urlKniha;
    
    private Long pridalKniha;
    
    private String formatKniha;
    
    private Long zaner;
    
    private String jazyk1;
        
    private String jazyk2;
    
    private Long oblubenostKniha;
    
    private Long pocetStran;
    
    private String popisKniha;
    
    /*
    konstruktory
    */
    public Kniha() {
    }
    
    public Kniha(Long idKniha, String nazovKniha, Long autorKniha, String urlKniha, Long pridalKniha,
            String formatKniha, Long zaner, String jazyk1, String jazyk2,
            Long oblubenostKniha, Long pocetStran, String popisKniha) {
        VytvaracAliasov vytvaracAliasov = new VytvaracAliasov();
        this.idKniha = idKniha;
        this.nazovKniha = nazovKniha;
        this.aliasKniha = vytvaracAliasov.vytvorAlias(nazovKniha);
        this.autorKniha = autorKniha;
        this.urlKniha = urlKniha;
        this.pridalKniha = pridalKniha;
        this.formatKniha = formatKniha;
        this.zaner = zaner;
        this.jazyk1 = jazyk1;
        this.jazyk2 = jazyk2;
        this.oblubenostKniha = oblubenostKniha;
        this.pocetStran = pocetStran;
        this.popisKniha = popisKniha;
    }
    
    public Kniha(Long idKniha, String nazovKniha, Long autorKniha, String urlKniha,
            Long pridalKniha, String formatKniha, Long zaner1, String jazyk1) {
        VytvaracAliasov vytvaracAliasov = new VytvaracAliasov();
        this.idKniha = idKniha;
        this.nazovKniha = nazovKniha;
        this.aliasKniha = vytvaracAliasov.vytvorAlias(nazovKniha);
        this.autorKniha = autorKniha;
        this.urlKniha = urlKniha;
        this.pridalKniha = pridalKniha;
        this.formatKniha = formatKniha;
        this.zaner = zaner1;
        this.jazyk1 = jazyk1;
    }
    
    /*
    gettre a settre
    */
    public Long getIdKniha() {
        return idKniha;
    }
    
    public void setIdKniha(Long idKniha) {
        this.idKniha = idKniha;
    }
    
    public String getNazovKniha() {
        return nazovKniha;
    }
    
    public void setNazovKniha(String nazovKniha) {
        this.nazovKniha = nazovKniha;
    }
    
    public String getAliasKniha() {
        return aliasKniha;
    }
    
    public void setAliasKniha(String aliasKniha) {
        this.aliasKniha = aliasKniha;
    }
    
    public Long getAutorKniha() {
        return autorKniha;
    }
    
    public void setAutorKniha(Long autorKniha) {
        this.autorKniha = autorKniha;
    }
    
    public String getUrlKniha() {
        return urlKniha;
    }
    
    public void setUrlKniha(String urlKniha) {
        this.urlKniha = urlKniha;
    }
    
    public Long getPridalKniha() {
        return pridalKniha;
    }
    
    public void setPridalKniha(Long pridalKniha) {
        this.pridalKniha = pridalKniha;
    }
    
    public String getFormatKniha() {
        return formatKniha;
    }
    
    public void setFormatKniha(String formatKniha) {
        this.formatKniha = formatKniha;
    }
    
    public Long getZaner() {
        return zaner;
    }
    
    public void setZaner(Long zaner) {
        this.zaner = zaner;
    }
    
    public String getJazyk1() {
        return jazyk1;
    }
    
    public void setJazyk1(String jazyk1) {
        this.jazyk1 = jazyk1;
    }
    
    public String getJazyk2() {
        return jazyk2;
    }
    
    public void setJazyk2(String jazyk2) {
        this.jazyk2 = jazyk2;
    }
    
    public Long getOblubenostKniha() {
        return oblubenostKniha;
    }
    
    public void setOblubenostKniha(Long oblubenostKniha) {
        this.oblubenostKniha = oblubenostKniha;
    }
    
    public Long getPocetStran() {
        return pocetStran;
    }
    
    public void setPocetStran(Long pocetStran) {
        this.pocetStran = pocetStran;
    }
    
    public String getPopisKniha() {
        return popisKniha;
    }
    
    public void setPopisKniha(String popisKniha) {
        this.popisKniha = popisKniha;
    }
    
}
