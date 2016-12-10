package sk.upjs.ics.paz1c.entity;

/**
 *
 * @author raven
 */
public class Pouzivatel {

    private Long idPouzivatel;

    private String menoPouzivatel;

    private String emailPouzivatel;

    private String hesloPouzivatel;

    private String solPouzivatel;

    private boolean jeAdmin;

    public Pouzivatel() {
    }

    public Pouzivatel(Long idPouzivatel, String menoPouzivatel, String emailPouzivatel, String hesloPouzivatel, String solPouzivatel, boolean jeAdmin) {
        this.idPouzivatel = idPouzivatel;
        this.menoPouzivatel = menoPouzivatel;
        this.emailPouzivatel = emailPouzivatel;
        this.hesloPouzivatel = hesloPouzivatel;
        this.solPouzivatel = solPouzivatel;
        this.jeAdmin = jeAdmin;
    }

    public Pouzivatel(Long idPouzivatel, String menoPouzivatel, String hesloPouzivatel, String solPouzivatel, boolean jeAdmin) {
        this.idPouzivatel = idPouzivatel;
        this.menoPouzivatel = menoPouzivatel;
        this.hesloPouzivatel = hesloPouzivatel;
        this.solPouzivatel = solPouzivatel;
        this.jeAdmin = jeAdmin;
    }

    public Pouzivatel(String menoPouzivatel, String emailPouzivatel, String hesloPouzivatel) {
        this.menoPouzivatel = menoPouzivatel;
        this.emailPouzivatel = emailPouzivatel;
        this.hesloPouzivatel = hesloPouzivatel;
    }

    public Pouzivatel(String menoPouzivatel, String emailPouzivatel) {
        this.menoPouzivatel = menoPouzivatel;
        this.emailPouzivatel = emailPouzivatel;
    }  
    
    public Long getIdPouzivatel() {
        return idPouzivatel;
    }

    public void setIdPouzivatel(Long idPouzivatel) {
        this.idPouzivatel = idPouzivatel;
    }

    public String getMenoPouzivatel() {
        return menoPouzivatel;
    }

    public void setMenoPouzivatel(String menoPouzivatel) {
        this.menoPouzivatel = menoPouzivatel;
    }

    public String getEmailPouzivatel() {
        return emailPouzivatel;
    }

    public void setEmailPouzivatel(String emailPouzivatel) {
        this.emailPouzivatel = emailPouzivatel;
    }

    public String getHesloPouzivatel() {
        return hesloPouzivatel;
    }

    public void setHesloPouzivatel(String hesloPouzivatel) {
        this.hesloPouzivatel = hesloPouzivatel;
    }

    public String getSolPouzivatel() {
        return solPouzivatel;
    }

    public void setSolPouzivatel(String solPouzivatel) {
        this.solPouzivatel = solPouzivatel;
    }

    public boolean isJeAdmin() {
        return jeAdmin;
    }

    public void setJeAdmin(boolean jeAdmin) {
        this.jeAdmin = jeAdmin;
    }
        
}
