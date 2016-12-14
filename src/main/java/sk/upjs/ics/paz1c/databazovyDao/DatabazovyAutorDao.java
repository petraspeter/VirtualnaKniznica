package sk.upjs.ics.paz1c.databazovyDao;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import sk.upjs.ics.paz1c.dao.AutorDao;
import sk.upjs.ics.paz1c.entity.Autor;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.mapovace.AutorRowMapper;
import sk.upjs.ics.paz1c.mapovace.KnihaRowMapper;
import sk.upjs.ics.paz1c.pomocneTriedy.CitacVstupu;
import sk.upjs.ics.paz1c.pomocneTriedy.VytvaracAliasov;
import sk.upjs.ics.paz1c.vynimky.AutorUzExistujeException;

/**
 *
 * @author raven
 */
public class DatabazovyAutorDao implements AutorDao{
    
    private MysqlDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private KnihaRowMapper mapovacKnih = new KnihaRowMapper();
    private AutorRowMapper mapovacAutorov = new AutorRowMapper();
    
    public DatabazovyAutorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }
    
    @Override
    public List<Kniha> najdiKnihuPodlaAutora(String meno, String priezvisko, String stredne) {
        if(stredne != null) {
            String sql = "SELECT * FROM kniha JOIN autor on kniha.autor_kniha = autor.id_autor WHERE "
                    + "autor.alias_meno LIKE '%' ? '%' AND autor.alias_priezvisko LIKE '%' ? '%' "
                    + "AND autor.alias_stredne LIKE '%' ? '%'";
            return jdbcTemplate.query(sql, mapovacKnih, meno, priezvisko, stredne);
        } else {
            return najdiKnihuPodlaAutora(meno, priezvisko);
        }
    }
    
    private List<Kniha> najdiKnihuPodlaAutora(String meno, String priezvisko) {
        if (priezvisko != null) {
            String sql = "SELECT * FROM kniha JOIN autor on kniha.autor_kniha = autor.id_autor WHERE "
                    + "autor.alias_meno LIKE '%' ? '%' AND autor.alias_priezvisko LIKE '%' ? '%'";
            return jdbcTemplate.query(sql, mapovacKnih, meno, priezvisko);
        } else {
            return najdiKnihuPodlaAutora(meno);
        }
    }
    
    private List<Kniha> najdiKnihuPodlaAutora(String meno) {
        String sql1 = "SELECT * FROM kniha JOIN autor on kniha.autor_kniha = autor.id_autor WHERE "
                + "autor.alias_meno LIKE '%' ? '%'";
        List<Kniha> knihy = jdbcTemplate.query(sql1, mapovacKnih, meno);
        String sql2 = "SELECT * FROM kniha JOIN autor on kniha.autor_kniha = autor.id_autor WHERE "
                + "autor.alias_priezvisko LIKE '%' ? '%'";
        List<Kniha> knihy2 = (jdbcTemplate.query(sql2, mapovacKnih, meno));
        knihy.addAll(knihy2);
        return knihy;
    }
    
    @Override
    public List<Kniha> najdiKnihuPodlaAutora(Long id) {
        String sql = "SELECT * FROM kniha JOIN autor on kniha.autor_kniha = autor.id_autor WHERE "
                + "autor.id_autor = ?";
        return jdbcTemplate.query(sql, mapovacKnih, id);
    }
    
    @Override
    public Autor najdiAutora(String meno, String stredne, String priezvisko) {
        if (priezvisko != null && !priezvisko.equals("")) {
            String sql = "SELECT * FROM autor WHERE autor.alias_meno = ? "
                    + "AND autor.alias_priezvisko = ? AND autor.alias_stredne = ? ";
            return jdbcTemplate.queryForObject(sql, mapovacAutorov, meno, priezvisko, stredne);
        } else {
            return najdiAutora(meno, stredne);
        }
    }
    
    private Autor najdiAutora(String meno, String priezvisko) {
        if (priezvisko != null) {
            String sql = "SELECT * FROM autor WHERE autor.alias_meno = ? AND autor.alias_priezvisko = ?";
            return jdbcTemplate.queryForObject(sql, mapovacAutorov, meno, priezvisko);
        } else {
            return najdiAutora(meno);
        }
    }
    
    private Autor najdiAutora(String meno) {
        String sql = "SELECT * FROM autor WHERE autor.alias_meno = ? OR autor.alias_priezvisko = ?";
        return jdbcTemplate.queryForObject(sql, mapovacAutorov, meno);
    }
    
    @Override
    public Autor najdiAutora(Long id) {
        String sql = "SELECT * FROM autor WHERE autor.id_autor = ?";
        return jdbcTemplate.queryForObject(sql, mapovacAutorov, id);
    }
    
    @Override
    public void pridajAutora(Autor autor) throws AutorUzExistujeException{
        if(existujeUzAutor(autor)) {
            throw new AutorUzExistujeException();
        }
        VytvaracAliasov vytvaracAliasov = new VytvaracAliasov();
        autor.setAliasMeno(vytvaracAliasov.vytvorAlias(autor.getMenoAutor()));
        autor.setAliasPriezvisko(vytvaracAliasov.vytvorAlias(autor.getPriezviskoAutor()));
        Map<String, Object> vlozAutoraZMapy = new HashMap<>();
        vlozAutoraZMapy.put("meno_autor", autor.getMenoAutor());
        vlozAutoraZMapy.put("alias_meno", autor.getAliasMeno());
        vlozAutoraZMapy.put("priezvisko_autor", autor.getPriezviskoAutor());
        vlozAutoraZMapy.put("alias_priezvisko", autor.getAliasPriezvisko());
        if(autor.getPopisAutor() != null) {
            vlozAutoraZMapy.put("popis_autor", autor.getPopisAutor());
        }
        if (autor.getStredneAutor() != null) {
            autor.setAliasStredne(vytvaracAliasov.vytvorAlias(autor.getStredneAutor()));
            vlozAutoraZMapy.put("stredne_autor", autor.getStredneAutor());
            vlozAutoraZMapy.put("alias_stredne", autor.getAliasStredne());
        } else {
            vlozAutoraZMapy.put("stredne_autor", autor.getStredneAutor());
            vlozAutoraZMapy.put("alias_stredne", autor.getAliasStredne());
            
        }
        
        String sql = "INSERT INTO autor SET meno_autor = :meno_autor, alias_meno= :alias_meno,"
                + " priezvisko_autor = :priezvisko_autor, alias_priezvisko = :alias_priezvisko, "
                + "stredne_autor = :stredne_autor, alias_stredne = :alias_stredne, "
                + "popis_autor = :popis_autor";
        namedParameterJdbcTemplate.update(sql, vlozAutoraZMapy);
    }
    
    @Override
    public void upravAutora(Autor autor) {
        Map<String, Object> vlozAutoraZMapy = new HashMap<>();
        vlozAutoraZMapy.put("id_autor", autor.getIdAutor());
        vlozAutoraZMapy.put("popis_autor", autor.getPopisAutor());
        String sql = "UPDATE autor SET popis_autor = :popis_autor WHERE "
                + "id_autor = :id_autor";
        namedParameterJdbcTemplate.update(sql, vlozAutoraZMapy);
    }
    
    @Override
    public void vymazAutora(Autor autor) {
        String sql = "DELETE FROM autor WHERE id = ?";
        jdbcTemplate.update(sql, autor.getIdAutor());
    }
    
    private boolean existujeUzAutor(Autor autor) {
        VytvaracAliasov va = new VytvaracAliasov();
        String m = va.vytvorAlias(autor.getMenoAutor());
        String p = va.vytvorAlias(autor.getPriezviskoAutor());
        try {
            Autor a = najdiAutora(m, p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /*
    vracia slovnik autorov
    */
    @Override
    public List<String> nacitajAutorov() {
        List<Autor> autori = najdiAutorov();
        List<String> mena = new ArrayList<>();
        for (Autor autor : autori) {
            if(autor.getStredneAutor() != null) {
                mena.add(autor.getMenoAutor().toLowerCase() + " " +
                        autor.getStredneAutor().toLowerCase() + " " + autor.getPriezviskoAutor().toLowerCase());
            } else {
                mena.add(autor.getMenoAutor().toLowerCase() + " " +
                        autor.getPriezviskoAutor().toLowerCase());
            }
        }
        return mena;
    }
    
    private List<Autor> najdiAutorov() {
        String sql = "SELECT * FROM autor";
        return jdbcTemplate.query(sql, mapovacAutorov);
    }
    
    @Override
    public Autor nacitajAutora(String zoStringu) {
        CitacVstupu citacVstupu = new CitacVstupu();
        String[] vstup = citacVstupu.vratPodretazceZoVstupu(zoStringu);
        if(vstup.length > 2) {
            return najdiAutora(vstup[0], vstup[1], vstup[2]);
        } else {
            if(vstup.length == 1) {
                return najdiAutora(vstup[0], null, null);
            } else {
                return najdiAutora(vstup[0], null, vstup[1]);
            }
        }
    }
    
    @Override
    public void upravAutorov(List<Autor> autori) {
        for (Autor autor : autori) {
            upravAutora(autor);
        }
    }
    
}
