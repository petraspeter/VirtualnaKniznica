package sk.upjs.ics.paz1c.databazovyDao;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.dao.KnihaDao;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.tovaren.MagicFactory;

/**
 *
 * @author raven
 */
public class DatabazovyKnihaDaoTest {
    
    private KnihaDao knihaDao;
    private JdbcTemplate jdbcTemplate;
    
    public DatabazovyKnihaDaoTest() {
        this.jdbcTemplate = new JdbcTemplate(MagicFactory.INSTANCE.dataSource());
        this.knihaDao = MagicFactory.INSTANCE.knihaDao();
    }
   
    
    /**
     * Test of najdiPodlaNazvu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiPodlaNazvu() {
        assertNotNull(knihaDao.najdiPodlaNazvu("havran"));
    }
    
    /**
     * Test of najdiPodlaFormatu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiPodlaFormatu() {
        assertNotNull(knihaDao.najdiPodlaFormatu("pdf"));
    }
    
    /**
     * Test of najdiPodlaZanru method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiPodlaZanru() {
        assertNotNull(knihaDao.najdiPodlaZanru("fantasy"));
    }
    
    /**
     * Test of najdiPodlaJazyka method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiPodlaJazyka() {    
        assertNotNull(knihaDao.najdiPodlaJazyka("cz"));
    }
    
    /**
     * Test of najdiPodlaOblubenosti method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiPodlaOblubenosti() {
        assertNotNull(knihaDao.najdiPodlaOblubenosti());
    }
    
       
    /**
     * Test of vymazKnihu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testVymazKnihu_Long() {
       knihaDao.vymazKnihu(19L);
    }
    
    /**
     * Test of vymazKnihu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testVymazKnihu_Kniha() {
        Kniha k = knihaDao.najdiKnihu(12L);
        knihaDao.vymazKnihu(k);
    }
    
    /**
     * Test of najdiKnihu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiKnihu() {
        assertNotNull(knihaDao.najdiKnihu(5L));
    }
        
    /**
     * Test of vratZaner method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testVratZaner_long() {
        assertEquals("Esej", knihaDao.vratZaner(8));
    }
    
    /**
     * Test of nacitajZanre method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNacitajZanre() {
        assertNotNull(knihaDao.nacitajZanre());
    }
    
    /**
     * Test of nacitajKnihy method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNacitajKnihy() {
        assertNotNull(knihaDao.nacitajKnihy());
    }
        
    /**
     * Test of vratZaner method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testVratZaner_String() {
        assertNotNull(knihaDao.vratZaner("Esej"));
    }
    
    /**
     * Test of pridajZaner method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testPridajZaner() {
        knihaDao.pridajZaner("Uplne novy zaner");
    }
    
}
