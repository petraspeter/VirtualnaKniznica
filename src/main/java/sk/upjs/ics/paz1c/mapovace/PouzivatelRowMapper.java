package sk.upjs.ics.paz1c.mapovace;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.entity.Pouzivatel;

/**
 *
 * @author raven
 */
public class PouzivatelRowMapper implements RowMapper<Pouzivatel>{
    
    @Override
    public Pouzivatel mapRow(ResultSet rs, int i) throws SQLException {
        try {
            Pouzivatel pouzivatel = new Pouzivatel();
            pouzivatel.setIdPouzivatel(rs.getLong("id_pouzivatel"));
            pouzivatel.setMenoPouzivatel(rs.getString("meno_pouzivatel"));
            pouzivatel.setEmailPouzivatel(rs.getString("email_pouzivatel"));
            pouzivatel.setHesloPouzivatel(rs.getString("heslo_pouzivatel"));
            pouzivatel.setSolPouzivatel(rs.getString("sol_pouzivatel"));
            pouzivatel.setJeAdmin(rs.getBoolean("je_admin"));
            return pouzivatel;
        } catch (SQLException e) {
            throw new SQLException("Nie je možné namapovať pouzivatela!");
        }
    }
    
}
