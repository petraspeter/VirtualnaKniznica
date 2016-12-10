package sk.upjs.ics.paz1c.databazovyDao;

import com.mysql.cj.jdbc.MysqlDataSource;
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
        String sql = "SELECT * FROM kniha JOIN autor on kniha.autor_kniha = autor.id_autor WHERE "
                + "autor.alias_meno LIKE '%' ? '%' AND autor.alias_priezvisko LIKE '%' ? '%'";
        return jdbcTemplate.query(sql, mapovacKnih, meno, priezvisko);
    }
    
    @Override
    public List<Kniha> najdiKnihuPodlaAutora(Long id) {
        String sql = "SELECT * FROM kniha JOIN autor on kniha.autor_kniha = autor.id_autor WHERE "
                + "autor.id_autor = ?";
        return jdbcTemplate.query(sql, mapovacKnih, id);
    }
    
    @Override
    public Autor najdiAutora(String meno, String priezvisko, String stredne) {
        String sql = "SELECT * FROM autor WHERE autor.alias_meno LIKE '%' ? '%' "
                + "AND autor.alias_priezvisko LIKE '%' ? '%' AND autor.alias_stredne LIKE '%' ? '%'";
        return jdbcTemplate.queryForObject(sql, mapovacAutorov, meno, priezvisko, stredne);
        
    }
    
    @Override
    public Autor najdiAutora(String meno, String priezvisko) {
        String sql = "SELECT * FROM autor WHERE autor.alias_meno = ? AND autor.alias_priezvisko = ?";
        return jdbcTemplate.queryForObject(sql, mapovacAutorov, meno, priezvisko);
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
        vlozAutoraZMapy.put("popis_autor", autor.getPopisAutor());
        vlozAutoraZMapy.put("fotka_autor", autor.getFotkaAutor());
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
                + "popis_autor = :popis_autor, fotka_autor = :fotka_autor";
        namedParameterJdbcTemplate.update(sql, vlozAutoraZMapy);
    }
    
    @Override
    public void upravAutora(Autor autor) {
        Map<String, Object> vlozAutoraZMapy = new HashMap<>();
        vlozAutoraZMapy.put("id_autor", autor.getIdAutor());
        vlozAutoraZMapy.put("popis_autor", autor.getPopisAutor());
        vlozAutoraZMapy.put("fotka_autor", autor.getFotkaAutor());
        String sql = "UPDATE autor SET popis_autor = :popis_autor, fotka_autor = :fotka_autor WHERE "
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
    
}