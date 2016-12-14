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
            System.out.println(prihlas);
            if(prihlas) {
                String sql = "SELECT * FROM pouzivatel WHERE meno_pouzivatel = ?";
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
    public  Map<Kniha, Integer> rozcitaneKnihySoStranami(Pouzivatel pouzivatel) {
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
    
    @Override
    public void pridajOblubenu(Pouzivatel pouzivatel, Kniha kniha) {
        String sql = "SELECT id_oblubene from oblubene WHERE oblubene.kniha_oblubene = ? "
                + "AND oblubene.pouzivatel_oblubene = ?";
        /*
        pozrieme sa, ci ju uz nahodou nemame v oblubenych
        */
        try {
            /*
            ak ano, tak nic nerobime
            */
            long l = jdbcTemplate.queryForObject(sql, Long.class, kniha.getIdKniha(), pouzivatel.getIdPouzivatel());
        } catch (Exception e) {
            /*
            ak nie, tak ju pridame
            */
            Map<String, Object> pridajOblubenu = new HashMap<>();
            pridajOblubenu.put("kniha_oblubene", kniha.getIdKniha());
            pridajOblubenu.put("pouzivatel_oblubene",  pouzivatel.getIdPouzivatel());
            sql = "INSERT INTO oblubene SET kniha_oblubene = :kniha_oblubene, "
                    + "pouzivatel_oblubene = :pouzivatel_oblubene";
            namedParameterJdbcTemplate.update(sql, pridajOblubenu);
        }
    }
    
    @Override
    public void pridajRozcitanu(Pouzivatel pouzivatel, Kniha kniha, int strana) {
        String sql = "SELECT id_rozcitane from rozcitane WHERE rozcitane.kniha_rozcitane = ? "
                + "AND rozcitane.pouzivatel_rozcitane = ?";
        /*
        pozrieme sa, ci ju uz nahodou nemame v rozcitanych
        */
        try {
            /*
            ak ano, tak updatneme stranu
            */
            long l = jdbcTemplate.queryForObject(sql, Long.class, kniha.getIdKniha(), pouzivatel.getIdPouzivatel());
            Map<String, Object> pridajRozcitanu = new HashMap<>();
            pridajRozcitanu.put("id_rozcitane",  l);
            pridajRozcitanu.put("strana_rozcitane",  strana);
            sql = "INSERT INTO rozcitane SET strana_rozcitane = :strana_rozcitane "
                    + "WHERE id_rozcitane = :id_rozcitane";
            namedParameterJdbcTemplate.update(sql, pridajRozcitanu);
        } catch (Exception e) {
            /*
            ak nie, tak ju pridame
            */
            Map<String, Object> pridajRozcitanu = new HashMap<>();
            pridajRozcitanu.put("kniha_rozcitane", kniha.getIdKniha());
            pridajRozcitanu.put("pouzivatel_rozcitane",  pouzivatel.getIdPouzivatel());
            pridajRozcitanu.put("strana_rozcitane",  strana);
            sql = "INSERT INTO rozcitane SET kniha_rozcitane = :kniha_rozcitane, "
                    + "pouzivatel_rozcitane = :pouzivatel_rozcitane, strana_rozcitane = :strana_rozcitane";
            namedParameterJdbcTemplate.update(sql, pridajRozcitanu);
        }
    }
    
    @Override
    public Pouzivatel nacitajPouzivatela(Long id) {
        String sql = "SELECT * FROM pouzivatel WHERE id_pouzivatel = ?";
        return jdbcTemplate.queryForObject(sql, mapovacPouzivatelov, id);
    }
    
    @Override
    public void odoberOblubenu(Pouzivatel pouzivatel, Kniha kniha) {
        String sql = "DELETE FROM oblubene WHERE pouzivatel_oblubene = ? AND kniha_oblubene = ?";
        jdbcTemplate.update(sql, pouzivatel.getIdPouzivatel(), kniha.getIdKniha());
    }
    
    @Override
    public void odoberRozcitanu(Pouzivatel pouzivatel, Kniha kniha) {
        String sql = "DELETE FROM rozcitane WHERE pouzivatel_rozcitane = ? AND kniha_rozcitane = ?";
        jdbcTemplate.update(sql, pouzivatel.getIdPouzivatel(), kniha.getIdKniha());
    }
    
    @Override
    public List<Kniha> rozcitaneKnihy(Pouzivatel pouzivatel) {
        String sql1 = "SELECT * FROM kniha JOIN rozcitane on kniha.id_kniha = rozcitane.kniha_rozcitane "
                + "WHERE pouzivatel_rozcitane = ?";
        return jdbcTemplate.query(sql1, mapovacKnih, pouzivatel.getIdPouzivatel());
    }
    
}
