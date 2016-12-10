package sk.upjs.ics.paz1c.mapovace;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.entity.Kniha;

/**
 *
 * @author raven
 */
public class KnihaRowMapper implements RowMapper<Kniha>{
    
    @Override
    public Kniha mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {               
            Kniha kniha = new Kniha();
            kniha.setIdKniha(rs.getLong("id_kniha"));
            kniha.setNazovKniha(rs.getString("nazov_kniha"));
            kniha.setAliasKniha(rs.getString("alias_kniha"));
            kniha.setAutorKniha(rs.getLong("autor_kniha"));
            kniha.setUrlKniha(rs.getString("url_kniha"));
            kniha.setPridalKniha(rs.getLong("pridal_kniha"));
            kniha.setFormatKniha(rs.getString("format_kniha"));
            kniha.setZaner(rs.getLong("zaner"));            
            kniha.setJazyk1(rs.getString("jazyk_1"));
            kniha.setJazyk2(rs.getString("jazyk_2"));
            kniha.setOblubenostKniha(rs.getLong("oblubenost_kniha"));
            kniha.setPocetStran(rs.getLong("pocet_stran"));
            kniha.setPopisKniha(rs.getString("popis_kniha"));
            return kniha;
        } catch (SQLException e){
            throw new SQLException("Nie je možné namapovať knihu!");
        }
    }
    
}
