package sk.upjs.ics.paz1c.tovaren;

import sk.upjs.ics.paz1c.databazovyDao.DatabazovyKnihaDao;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.dao.KnihaDao;
import sk.upjs.ics.paz1c.dao.PouzivatelDao;
import sk.upjs.ics.paz1c.dao.AutorDao;
import sk.upjs.ics.paz1c.databazovyDao.DatabazovyAutorDao;
import sk.upjs.ics.paz1c.databazovyDao.DatabazovyPouzivatelDao;

/**
 *
 * @author Raven
 */
public enum MagicFactory {
    INSTANCE;
    
    private JdbcTemplate jdbcTemplate;
    
    private KnihaDao knihaDao;
    
    private PouzivatelDao pouzivatelDao;
    
    private AutorDao autorDao;
    
    
    public JdbcTemplate jdbcTemplate() {
        if (this.jdbcTemplate == null) {
            this.jdbcTemplate = new JdbcTemplate(dataSource());
        }
        return this.jdbcTemplate;
    }
    
    public KnihaDao knihaDao() {
        if(this.knihaDao == null) {
            this.knihaDao = new DatabazovyKnihaDao(jdbcTemplate);
        }
        return this.knihaDao;
    }
    
    public PouzivatelDao pouzivatelDao() {
        if(this.pouzivatelDao == null) {
            this.pouzivatelDao = new DatabazovyPouzivatelDao(jdbcTemplate);
        }
        return this.pouzivatelDao;
    }
    
    public AutorDao  autorDao() {
        if(this.autorDao == null) {
            this.autorDao = new DatabazovyAutorDao(jdbcTemplate);
        }
        return this.autorDao;
    }
    
    private MysqlDataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        Properties nastavenia = getProperties();
        dataSource.setUrl(nastavenia.getProperty("urlDatabazy"));
        dataSource.setUser(nastavenia.getProperty("pouzivatel"));
        dataSource.setPassword(nastavenia.getProperty("heslo"));
//        dataSource.setUrl("jdbc:mysql://localhost:3306/vlib");
//        dataSource.setUser("vlibRoot");
//        dataSource.setPassword("toor");
return dataSource;

    }
    
    private Properties getProperties() {
        try {
            String suborNastaveni = "/vlib-databaza.properties";
            InputStream vstup = MagicFactory.class.getResourceAsStream(suborNastaveni);
            Properties nastavenia = new Properties();
            nastavenia.load(vstup);
            return nastavenia;
        } catch (IOException e) {
            throw new IllegalStateException("Nenasiel sa konfiguracny subor!");
        }
    }
    
}
