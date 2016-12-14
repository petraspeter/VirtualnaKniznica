package sk.upjs.ics.paz1c.databazovyDao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.entity.Kniha;

/**
 *
 * @author raven
 */
public class DatabazovyKnihaDaoTest {
    
    public DatabazovyKnihaDaoTest() {
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
     * Test of najdiPodlaNazvu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiPodlaNazvu() {
        System.out.println("najdiPodlaNazvu");
        String nazov = "";
        DatabazovyKnihaDao instance = null;
        List<Kniha> expResult = null;
        List<Kniha> result = instance.najdiPodlaNazvu(nazov);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of najdiPodlaFormatu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiPodlaFormatu() {
        System.out.println("najdiPodlaFormatu");
        String format = "";
        DatabazovyKnihaDao instance = null;
        List<Kniha> expResult = null;
        List<Kniha> result = instance.najdiPodlaFormatu(format);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of najdiPodlaZanru method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiPodlaZanru() {
        System.out.println("najdiPodlaZanru");
        String zaner = "";
        DatabazovyKnihaDao instance = null;
        List<Kniha> expResult = null;
        List<Kniha> result = instance.najdiPodlaZanru(zaner);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of najdiPodlaJazyka method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiPodlaJazyka() {
        System.out.println("najdiPodlaJazyka");
        String jazyk = "";
        DatabazovyKnihaDao instance = null;
        List<Kniha> expResult = null;
        List<Kniha> result = instance.najdiPodlaJazyka(jazyk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of najdiPodlaOblubenosti method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiPodlaOblubenosti() {
        System.out.println("najdiPodlaOblubenosti");
        DatabazovyKnihaDao instance = null;
        List<Kniha> expResult = null;
        List<Kniha> result = instance.najdiPodlaOblubenosti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of vymazKnihu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testVymazKnihu_Long() {
        System.out.println("vymazKnihu");
        Long id = null;
        DatabazovyKnihaDao instance = null;
        instance.vymazKnihu(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of vymazKnihu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testVymazKnihu_Kniha() {
        System.out.println("vymazKnihu");
        Kniha kniha = null;
        DatabazovyKnihaDao instance = null;
        instance.vymazKnihu(kniha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of najdiKnihu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNajdiKnihu() {
        System.out.println("najdiKnihu");
        Long id = null;
        DatabazovyKnihaDao instance = null;
        Kniha expResult = null;
        Kniha result = instance.najdiKnihu(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of upravKnihu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testUpravKnihu() {
        System.out.println("upravKnihu");
        Kniha kniha = null;
        DatabazovyKnihaDao instance = null;
        instance.upravKnihu(kniha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of pridajKnihu method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testPridajKnihu() {
        System.out.println("pridajKnihu");
        Kniha kniha = null;
        DatabazovyKnihaDao instance = null;
        instance.pridajKnihu(kniha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of vratZaner method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testVratZaner_long() {
        System.out.println("vratZaner");
        long idZanru = 0L;
        DatabazovyKnihaDao instance = null;
        String expResult = "";
        String result = instance.vratZaner(idZanru);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of nacitajZanre method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNacitajZanre() {
        System.out.println("nacitajZanre");
        DatabazovyKnihaDao instance = null;
        List<String> expResult = null;
        List<String> result = instance.nacitajZanre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of nacitajKnihy method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testNacitajKnihy() {
        System.out.println("nacitajKnihy");
        DatabazovyKnihaDao instance = null;
        List<String> expResult = null;
        List<String> result = instance.nacitajKnihy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of upravKnihy method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testUpravKnihy() {
        System.out.println("upravKnihy");
        List<Kniha> knihy = null;
        DatabazovyKnihaDao instance = null;
        instance.upravKnihy(knihy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of vratZaner method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testVratZaner_String() {
        System.out.println("vratZaner");
        String zaner = "";
        DatabazovyKnihaDao instance = null;
        Long expResult = null;
        Long result = instance.vratZaner(zaner);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of pridajZaner method, of class DatabazovyKnihaDao.
     */
    @Test
    public void testPridajZaner() {
        System.out.println("pridajZaner");
        String zaner = "";
        DatabazovyKnihaDao instance = null;
        instance.pridajZaner(zaner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
