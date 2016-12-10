package sk.upjs.ics.paz1c.databazovyDao;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import sk.upjs.ics.paz1c.dao.KnihaDao;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.mapovace.KnihaRowMapper;

/**
 *
 * @author Raven
 */
public class DatabazovyKnihaDao implements KnihaDao{
    
    /*
    ***** vytvorit classu pre stringy dopytov?
    */
    
    private MysqlDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private KnihaRowMapper mapovacKnih = new KnihaRowMapper();
    
    public DatabazovyKnihaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }
    
    @Override
    public List<Kniha> najdiPodlaNazvu(String nazov) {
        String sql = "SELECT * FROM kniha WHERE kniha.alias_kniha LIKE '%' ? '%'" ;
        return jdbcTemplate.query(sql, mapovacKnih, nazov);
    }
    
    @Override
    public List<Kniha> najdiPodlaFormatu(String format) {
        String sql = "SELECT * FROM kniha WHERE kniha.format_kniha = ?" ;
        return jdbcTemplate.query(sql, mapovacKnih, format);
    }
    
    @Override
    public List<Kniha> najdiPodlaZanru(String zaner) {
        String sql = "SELECT * FROM kniha JOIN zaner on kniha.zaner = zaner.id_zaner WHERE"
                + " zaner.alias_zaner LIKE  '%' ? '%'" ;
        return jdbcTemplate.query(sql, mapovacKnih, zaner);
    }
    
    @Override
    public List<Kniha> najdiPodlaJazyka(String jazyk) {
        List<Kniha> vratKnihy = new ArrayList<>();
        String sql1 = "SELECT * FROM kniha WHERE kniha.jazyk_1 = ?";
        vratKnihy = jdbcTemplate.query(sql1, mapovacKnih, jazyk);
        
        String sql2 = "SELECT * FROM kniha WHERE kniha.jazyk_2 = ?";
        vratKnihy.addAll(jdbcTemplate.query(sql2, mapovacKnih, jazyk));
        return vratKnihy;
    }
    
    @Override
    public List<Kniha> najdiPodlaOblubenosti() {
        String sql = "SELECT * FROM kniha ORDER BY kniha.oblubenost_kniha DESC";
        return jdbcTemplate.query(sql, mapovacKnih);
    }
    
    @Override
    public void vymazKnihu(Long id) {
        String sql = "DELETE FROM kniha WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    
    @Override
    public void vymazKnihu(Kniha kniha) {
        String sql = "DELETE FROM kniha WHERE id = ?";
        jdbcTemplate.update(sql, kniha.getIdKniha());
    }
    
    @Override
    public void upravKnihu(Kniha kniha) {
        Map<String, Object> vlozKnihuZMapy = new HashMap<>();
        vlozKnihuZMapy.put("id_kniha", kniha.getIdKniha());
        vlozKnihuZMapy.put("nazov_kniha", kniha.getNazovKniha());
        vlozKnihuZMapy.put("alias_kniha", kniha.getAliasKniha());
        vlozKnihuZMapy.put("autor_kniha", kniha.getAutorKniha());
        vlozKnihuZMapy.put("url_kniha", kniha.getUrlKniha());
        vlozKnihuZMapy.put("pridal_kniha", kniha.getPridalKniha());
        vlozKnihuZMapy.put("format_kniha", kniha.getFormatKniha());
        vlozKnihuZMapy.put("zaner", kniha.getZaner());
        vlozKnihuZMapy.put("jazyk_1", kniha.getJazyk1());
        vlozKnihuZMapy.put("jazyk_2", kniha.getJazyk2());
        vlozKnihuZMapy.put("oblubenost_kniha", kniha.getOblubenostKniha());
        vlozKnihuZMapy.put("pocet_stran", kniha.getPocetStran());
        vlozKnihuZMapy.put("popis_kniha", kniha.getPopisKniha());
        
        String sql = "UPDATE kniha SET nazov_kniha = :nazov_kniha, alias_kniha = :alias_kniha, "
                + "autor_kniha = :autor_kniha, url_kniha = :url_kniha, pridal_kniha = :pridal_kniha, "
                + "format_kniha = :format_kniha, zaner = :zaner, jazyk_1 = :jazyk_1, jazyk_2 = :jazyk_2, "
                + "oblubenost_kniha = :oblubenost_kniha, pocet_stran = :pocet_stran, "
                + "popis_kniha = :popis_kniha WHERE id_kniha = :id_kniha";
        
        namedParameterJdbcTemplate.update(sql, vlozKnihuZMapy);
    }
    
    @Override
    public void pridajKnihu(Kniha kniha) {
        Map<String, Object> vlozKnihuZMapy = new HashMap<>();
        vlozKnihuZMapy.put("nazov_kniha", kniha.getNazovKniha());
        vlozKnihuZMapy.put("alias_kniha", kniha.getAliasKniha());
        vlozKnihuZMapy.put("autor_kniha", kniha.getAutorKniha());
        vlozKnihuZMapy.put("url_kniha", kniha.getUrlKniha());
        vlozKnihuZMapy.put("pridal_kniha", kniha.getPridalKniha());
        vlozKnihuZMapy.put("format_kniha", kniha.getFormatKniha());
        vlozKnihuZMapy.put("zaner", kniha.getZaner());
        vlozKnihuZMapy.put("jazyk_1", kniha.getJazyk1());
        vlozKnihuZMapy.put("jazyk_2", kniha.getJazyk2());
        vlozKnihuZMapy.put("oblubenost_kniha", kniha.getOblubenostKniha());
        vlozKnihuZMapy.put("pocet_stran", kniha.getPocetStran());
        vlozKnihuZMapy.put("popis_kniha", kniha.getPocetStran());

        String sql = "INSERT INTO kniha SET nazov_kniha = :nazov_kniha, alias_kniha = :alias_kniha, "
                + "autor_kniha = :autor_kniha, url_kniha = :url_kniha, pridal_kniha = :pridal_kniha, "
                + "format_kniha = :format_kniha, zaner = :zaner, jazyk_1 = :jazyk_1, jazyk_2 = :jazyk_2, "
                + "oblubenost_kniha = :oblubenost_kniha, pocet_stran = :pocet_stran, "
                + "popis_kniha = :popis_kniha";
        
        namedParameterJdbcTemplate.update(sql, vlozKnihuZMapy);
    }
        
}
