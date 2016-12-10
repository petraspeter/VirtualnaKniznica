package sk.upjs.ics.paz1c.databazovyDao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import sk.upjs.ics.paz1c.dao.PouzivatelDao;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.entity.Pouzivatel;
import sk.upjs.ics.paz1c.mapovace.KnihaRowMapper;
import sk.upjs.ics.paz1c.mapovace.PouzivatelRowMapper;
import sk.upjs.ics.paz1c.vynimky.NeplatneRegistracneMenoException;
import sk.upjs.ics.paz1c.vynimky.NeuspesnePrihlasenieException;

/*
* @author Raven
*/
public class DatabazovyPouzivatelDao implements PouzivatelDao{
    
    private final JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private KnihaRowMapper mapovacKnih = new KnihaRowMapper();
    private PouzivatelRowMapper mapovacPouzivatelov = new PouzivatelRowMapper();
    
    public DatabazovyPouzivatelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }
    
    @Override
    public Pouzivatel prihlasPouzivatela(String meno, String heslo) throws NeuspesnePrihlasenieException{
        Pouzivatel pouzivatel = new Pouzivatel();
        try {
            boolean prihlas = overMenoAHeslo(meno, heslo);
            if(prihlas) {
                String sql = "SELECT * FROM pouzivatel WHERE meno = ?";
                pouzivatel = jdbcTemplate.queryForObject(sql, mapovacPouzivatelov, meno);
            }
        } catch (DataAccessException | NoSuchAlgorithmException e) {
            throw new NeuspesnePrihlasenieException();
        }
        return pouzivatel;
    }
    
    private boolean overCiExistuje(Pouzivatel pouzivatel) {
        String sql = "SELECT meno_pouzivatel FROM pouzivatel WHERE pouzivatel.meno_pouzivatel = ?";
        try {
            String menoPouzivatela = jdbcTemplate.queryForObject(sql, String.class, pouzivatel.getMenoPouzivatel());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public void zaregistrujPouzivatela(String meno, String heslo, String email) throws NeplatneRegistracneMenoException {
        Pouzivatel p = new Pouzivatel(meno, email);
        if(overCiExistuje(p)) {
            throw new NeplatneRegistracneMenoException();
        } else {
            /*
            generujeme sol hashujeme heslo
            */
            String sol = new BigInteger (130, new SecureRandom ()).toString(32);
            String preHash = heslo + sol;
            String hash = new String();
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(preHash.getBytes());
                byte[] byteHash = md.digest();
                hash = DatatypeConverter.printHexBinary(byteHash);
                /*
                vlozenie pouzivatela do databazy
                */
                Map<String, Object> vlozPouzivatelaZMapy = new HashMap<>();
                vlozPouzivatelaZMapy.put("meno_pouzivatel", meno);
                vlozPouzivatelaZMapy.put("email_pouzivatel", email);
                vlozPouzivatelaZMapy.put("heslo_pouzivatel", hash);
                vlozPouzivatelaZMapy.put("sol_pouzivatel", sol);
                vlozPouzivatelaZMapy.put("je_admin", false);
                String sql = "INSERT INTO pouzivatel SET meno_pouzivatel = :meno_pouzivatel, "
                        + "email_pouzivatel= :email_pouzivatel, heslo_pouzivatel = :heslo_pouzivatel, "
                        + "sol_pouzivatel = :sol_pouzivatel, je_admin = :je_admin";
                namedParameterJdbcTemplate.update(sql, vlozPouzivatelaZMapy);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(DatabazovyPouzivatelDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public List<Kniha> oblubeneKnihy(Pouzivatel pouzivatel) {
        String sql = "SELECT * FROM kniha JOIN oblubene on kniha.id_kniha = oblubene.kniha_oblubene "
                + "WHERE pouzivatel_oblubene = ?";
        return jdbcTemplate.query(sql, mapovacKnih, pouzivatel.getIdPouzivatel());
    }
    
    @Override
    public  Map<Kniha, Integer> rozcitaneKnihy(Pouzivatel pouzivatel) {
        Map<Kniha, Integer> mapa = new HashMap<>();
        String sql1 = "SELECT * FROM kniha JOIN rozcitane on kniha.id_kniha = rozcitane.kniha_rozcitane "
                + "WHERE pouzivatel_rozcitane = ?";
        List<Kniha> knihy = jdbcTemplate.query(sql1, mapovacKnih, pouzivatel.getIdPouzivatel());
        String sql2 = "SELECT strana_rozcitane FROM rozcitane WHERE pouzivatel_rozcitane = ?";
        List<Integer> strany = jdbcTemplate.query(sql2, new RowMapper<Integer>(){
            @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getInt(i);
            }
        }, pouzivatel.getIdPouzivatel());
        for (int i = 0; i < strany.size(); i++) {
            mapa.put(knihy.get(i), strany.get(i));
        }
        return mapa;
    }
    
    @Override
    public List<Kniha> pridalPouzivatel(Pouzivatel pouzivatel) {
        String sql = "SELECT * FROM kniha WHERE kniha.pridal_kniha = ?";
        return jdbcTemplate.query(sql, mapovacKnih, pouzivatel.getIdPouzivatel());
    }
    
    public boolean overMenoAHeslo(String meno, String heslo) throws NoSuchAlgorithmException {
        String sqlSol = "SELECT sol_pouzivatel FROM pouzivatel WHERE pouzivatel.meno_pouzivatel = ?";
        String sqlHash = "SELECT heslo_pouzivatel FROM pouzivatel WHERE pouzivatel.meno_pouzivatel = ?";
        String sol= jdbcTemplate.queryForObject(sqlSol, String.class, meno);
        String hash = jdbcTemplate.queryForObject(sqlHash, String.class, meno);
        heslo = heslo + sol;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update((heslo).getBytes());
        byte[] byteHash = md.digest();
        return DatatypeConverter.printHexBinary(byteHash).equals(hash);
    }
    
}
