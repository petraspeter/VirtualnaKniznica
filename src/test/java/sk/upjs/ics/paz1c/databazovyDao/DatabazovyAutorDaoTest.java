package sk.upjs.ics.paz1c.databazovyDao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.paz1c.entity.Autor;
import sk.upjs.ics.paz1c.entity.Kniha;

/**
 *
 * @author raven
 */
public class DatabazovyAutorDaoTest {
    
    
    public DatabazovyAutorDaoTest() {
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
     * Test of najdiKnihuPodlaAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testNajdiKnihuPodlaAutora_3args() {
        System.out.println("najdiKnihuPodlaAutora");
        String meno = "";
        String priezvisko = "";
        String stredne = "";
        DatabazovyAutorDao instance = null;
        List<Kniha> expResult = null;
        List<Kniha> result = instance.najdiKnihuPodlaAutora(meno, priezvisko, stredne);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of najdiKnihuPodlaAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testNajdiKnihuPodlaAutora_Long() {
        System.out.println("najdiKnihuPodlaAutora");
        Long id = null;
        DatabazovyAutorDao instance = null;
        List<Kniha> expResult = null;
        List<Kniha> result = instance.najdiKnihuPodlaAutora(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of najdiAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testNajdiAutora_3args() {
        System.out.println("najdiAutora");
        String meno = "";
        String stredne = "";
        String priezvisko = "";
        DatabazovyAutorDao instance = null;
        Autor expResult = null;
        Autor result = instance.najdiAutora(meno, stredne, priezvisko);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of najdiAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testNajdiAutora_Long() {
        System.out.println("najdiAutora");
        Long id = null;
        DatabazovyAutorDao instance = null;
        Autor expResult = null;
        Autor result = instance.najdiAutora(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of pridajAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testPridajAutora() {
        System.out.println("pridajAutora");
        Autor autor = null;
        DatabazovyAutorDao instance = null;
        instance.pridajAutora(autor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of upravAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testUpravAutora() {
        System.out.println("upravAutora");
        Autor autor = null;
        DatabazovyAutorDao instance = null;
        instance.upravAutora(autor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of vymazAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testVymazAutora() {
        System.out.println("vymazAutora");
        Autor autor = null;
        DatabazovyAutorDao instance = null;
        instance.vymazAutora(autor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of nacitajAutorov method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testNacitajAutorov() {
        System.out.println("nacitajAutorov");
        DatabazovyAutorDao instance = null;
        List<String> expResult = null;
        List<String> result = instance.nacitajAutorov();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of nacitajAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testNacitajAutora() {
        System.out.println("nacitajAutora");
        String zoStringu = "";
        DatabazovyAutorDao instance = null;
        Autor expResult = null;
        Autor result = instance.nacitajAutora(zoStringu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of upravAutorov method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testUpravAutorov() {
        System.out.println("upravAutorov");
        List<Autor> autori = null;
        DatabazovyAutorDao instance = null;
        instance.upravAutorov(autori);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
