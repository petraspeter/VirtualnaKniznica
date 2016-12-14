package sk.upjs.ics.paz1c.databazovyDao;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.dao.PouzivatelDao;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.entity.Pouzivatel;
import sk.upjs.ics.paz1c.tovaren.MagicFactory;

/**
 *
 * @author raven
 */
public class DatabazovyPouzivatelDaoTest {

    private JdbcTemplate jdbcTemplate;
    private PouzivatelDao pouzivatelDao;

    public DatabazovyPouzivatelDaoTest() {
        this.jdbcTemplate = new JdbcTemplate(MagicFactory.INSTANCE.dataSource());
        this.pouzivatelDao = MagicFactory.INSTANCE.pouzivatelDao();

    }

    /**
     * Test of zaregistrujPouzivatela method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testZaregistrujPouzivatela() {
        System.out.println("zaregistrujPouzivatela");
        String meno = "istvan";
        String heslo = "heslo";
        String email = "nemam@nic.td";
        pouzivatelDao.zaregistrujPouzivatela(meno, heslo, email);
        // testujeme aj prihlasenie
        System.out.println("prihlasPouzivatela");
        Pouzivatel p = pouzivatelDao.prihlasPouzivatela(meno, heslo);
        assertNotNull(p);
    }

    /**
     * Test of oblubeneKnihy method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testOblubeneKnihy() {
        System.out.println("oblubeneKnihy");
        Pouzivatel pouzivatel = pouzivatelDao.prihlasPouzivatela("root", "toor");
        List<Kniha> oblubene = pouzivatelDao.oblubeneKnihy(pouzivatel);
        assertEquals("krev elfu", oblubene.get(0).getAliasKniha());
    }

    /**
     * Test of pridalPouzivatel method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testPridalPouzivatel() {
        System.out.println("pridalPouzivatel");
        Pouzivatel pouzivatel = pouzivatelDao.prihlasPouzivatela("peter", "heslo");
        List<Kniha> result = pouzivatelDao.pridalPouzivatel(pouzivatel);
        int expResult = 2;
        assertEquals(expResult, result.size());
    }

    /**
     * Test of pridajOblubenu method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testPridajOblubenu() {
        Pouzivatel p = pouzivatelDao.prihlasPouzivatela("gyula", "heslo");
        Pouzivatel p1 = pouzivatelDao.prihlasPouzivatela("root", "toor");
        int oblubene = pouzivatelDao.oblubeneKnihy(p).size();
        Kniha k = pouzivatelDao.pridalPouzivatel(p1).get(3);
        pouzivatelDao.pridajOblubenu(p, k);
        assertEquals(oblubene + 1, pouzivatelDao.oblubeneKnihy(p).size());
    }

    /**
     * Test of pridajRozcitanu method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testPridajRozcitanu() {
        Pouzivatel p = pouzivatelDao.prihlasPouzivatela("gyula", "heslo");
        Pouzivatel p1 = pouzivatelDao.prihlasPouzivatela("root", "toor");
        int rozcitane = pouzivatelDao.rozcitaneKnihy(p).size();
        Kniha k = pouzivatelDao.pridalPouzivatel(p1).get(3);
        pouzivatelDao.pridajRozcitanu(p, k, 0);
        assertEquals(rozcitane + 1, pouzivatelDao.rozcitaneKnihy(p).size());
    }

    /**
     * Test of nacitajPouzivatela method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testNacitajPouzivatela() {
        Pouzivatel p = pouzivatelDao.nacitajPouzivatela(4L);
        assertNotNull(p);
    }

    /**
     * Test of odoberOblubenu method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testOdoberOblubenu() {
        Pouzivatel p = pouzivatelDao.prihlasPouzivatela("gyula", "heslo");
        Pouzivatel p1 = pouzivatelDao.prihlasPouzivatela("root", "toor");
        Kniha k = pouzivatelDao.pridalPouzivatel(p1).get(4);
        pouzivatelDao.pridajOblubenu(p, k);        
        Kniha k1 = pouzivatelDao.oblubeneKnihy(p).get(0);
        pouzivatelDao.odoberOblubenu(p, k1);
    }

    /**
     * Test of odoberRozcitanu method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testOdoberRozcitanu() {
        Pouzivatel p = pouzivatelDao.prihlasPouzivatela("gyula", "heslo");
        Pouzivatel p1 = pouzivatelDao.prihlasPouzivatela("root", "toor");
        
        Kniha k = pouzivatelDao.pridalPouzivatel(p1).get(3);
        pouzivatelDao.odoberOblubenu(p, k);
    }

    /**
     * Test of rozcitaneKnihy method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testRozcitaneKnihy() {
        Pouzivatel pouzivatel = pouzivatelDao.prihlasPouzivatela("root", "toor");
        List<Kniha> result = pouzivatelDao.rozcitaneKnihy(pouzivatel);
        assertNotNull(result);
    }

}
