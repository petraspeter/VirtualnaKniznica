package sk.upjs.ics.paz1c.databazovyDao;

import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.entity.Pouzivatel;

/**
 *
 * @author raven
 */
public class DatabazovyPouzivatelDaoTest {
    
    public DatabazovyPouzivatelDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of prihlasPouzivatela method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testPrihlasPouzivatela() {
        System.out.println("prihlasPouzivatela");
        String meno = "";
        String heslo = "";
        DatabazovyPouzivatelDao instance = null;
        Pouzivatel expResult = null;
        Pouzivatel result = instance.prihlasPouzivatela(meno, heslo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of zaregistrujPouzivatela method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testZaregistrujPouzivatela() {
        System.out.println("zaregistrujPouzivatela");
        String meno = "";
        String heslo = "";
        String email = "";
        DatabazovyPouzivatelDao instance = null;
        instance.zaregistrujPouzivatela(meno, heslo, email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of oblubeneKnihy method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testOblubeneKnihy() {
        System.out.println("oblubeneKnihy");
        Pouzivatel pouzivatel = null;
        DatabazovyPouzivatelDao instance = null;
        List<Kniha> expResult = null;
        List<Kniha> result = instance.oblubeneKnihy(pouzivatel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of rozcitaneKnihySoStranami method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testRozcitaneKnihySoStranami() {
        System.out.println("rozcitaneKnihySoStranami");
        Pouzivatel pouzivatel = null;
        DatabazovyPouzivatelDao instance = null;
        Map<Kniha, Integer> expResult = null;
        Map<Kniha, Integer> result = instance.rozcitaneKnihySoStranami(pouzivatel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of pridalPouzivatel method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testPridalPouzivatel() {
        System.out.println("pridalPouzivatel");
        Pouzivatel pouzivatel = null;
        DatabazovyPouzivatelDao instance = null;
        List<Kniha> expResult = null;
        List<Kniha> result = instance.pridalPouzivatel(pouzivatel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of overMenoAHeslo method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testOverMenoAHeslo() throws Exception {
        System.out.println("overMenoAHeslo");
        String meno = "";
        String heslo = "";
        DatabazovyPouzivatelDao instance = null;
        boolean expResult = false;
        boolean result = instance.overMenoAHeslo(meno, heslo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of pridajOblubenu method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testPridajOblubenu() {
        System.out.println("pridajOblubenu");
        Pouzivatel pouzivatel = null;
        Kniha kniha = null;
        DatabazovyPouzivatelDao instance = null;
        instance.pridajOblubenu(pouzivatel, kniha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of pridajRozcitanu method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testPridajRozcitanu() {
        System.out.println("pridajRozcitanu");
        Pouzivatel pouzivatel = null;
        Kniha kniha = null;
        int strana = 0;
        DatabazovyPouzivatelDao instance = null;
        instance.pridajRozcitanu(pouzivatel, kniha, strana);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of nacitajPouzivatela method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testNacitajPouzivatela() {
        System.out.println("nacitajPouzivatela");
        Long id = null;
        DatabazovyPouzivatelDao instance = null;
        Pouzivatel expResult = null;
        Pouzivatel result = instance.nacitajPouzivatela(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of odoberOblubenu method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testOdoberOblubenu() {
        System.out.println("odoberOblubenu");
        Pouzivatel pouzivatel = null;
        Kniha kniha = null;
        DatabazovyPouzivatelDao instance = null;
        instance.odoberOblubenu(pouzivatel, kniha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of odoberRozcitanu method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testOdoberRozcitanu() {
        System.out.println("odoberRozcitanu");
        Pouzivatel pouzivatel = null;
        Kniha kniha = null;
        DatabazovyPouzivatelDao instance = null;
        instance.odoberRozcitanu(pouzivatel, kniha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of rozcitaneKnihy method, of class DatabazovyPouzivatelDao.
     */
    @Test
    public void testRozcitaneKnihy() {
        System.out.println("rozcitaneKnihy");
        Pouzivatel pouzivatel = null;
        DatabazovyPouzivatelDao instance = null;
        List<Kniha> expResult = null;
        List<Kniha> result = instance.rozcitaneKnihy(pouzivatel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
