package sk.upjs.ics.paz1c.mapovace;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.entity.Autor;

/**
 *
 * @author raven
 */
public class AutorRowMapper implements RowMapper<Autor>{
    
    @Override
    public Autor mapRow(ResultSet rs, int i) throws SQLException {
        try {
            Autor autor = new Autor();
            autor.setIdAutor(rs.getLong("id_autor"));
            autor.setMenoAutor(rs.getString("meno_autor"));
            autor.setAliasMeno(rs.getString("alias_meno"));
            autor.setPriezviskoAutor(rs.getString("priezvisko_autor"));
            autor.setAliasPriezvisko(rs.getString("alias_priezvisko"));
            autor.setStredneAutor(rs.getString("stredne_autor"));
            autor.setAliasStredne(rs.getString("alias_stredne"));
            autor.setPopisAutor(rs.getString("popis_autor"));
            autor.setFotkaAutor(rs.getString("fotka_autor"));
            return autor;
        } catch (SQLException e) {
            throw new SQLException("Nie je možné namapovať autora!");
        }
    }
    
    
    
    
}
