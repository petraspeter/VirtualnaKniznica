/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.databazovyDao;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.dao.AutorDao;
import sk.upjs.ics.paz1c.entity.Autor;
import sk.upjs.ics.paz1c.entity.Kniha;
import sk.upjs.ics.paz1c.tovaren.MagicFactory;

/**
 *
 * @author raven
 */
public class DatabazovyAutorDaoTest {

    private AutorDao autorDao;
    private JdbcTemplate jdbcTemplate;

    public DatabazovyAutorDaoTest() {
        this.jdbcTemplate = new JdbcTemplate(MagicFactory.INSTANCE.dataSource());
        this.autorDao = MagicFactory.INSTANCE.autorDao();
    }

    /**
     * Test of najdiKnihuPodlaAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testNajdiKnihuPodlaAutora_3args() {
        System.out.println("najdiKnihuPodlaAutora");
        String meno = "Andrej";
        String priezvisko = "Sapkowski";
        Kniha k = autorDao.najdiKnihuPodlaAutora(meno, priezvisko, null).get(0);
        assertEquals("Křev elfů", k.getNazovKniha());
    }

    /**
     * Test of najdiKnihuPodlaAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testNajdiKnihuPodlaAutora_Long() {
        assertNotNull(autorDao.najdiKnihuPodlaAutora(1L));
    }

    /**
     * Test of najdiAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testNajdiAutora_3args() {
        System.out.println("najdiAutora");
        String meno = "Terry";
        String priezvisko = "pratchett";
        Autor a = autorDao.najdiAutora(meno, priezvisko, null);
        assertNotNull(a);
    }

    /**
     * Test of najdiAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testNajdiAutora_Long() {
        Autor a = autorDao.najdiAutora(1L);
        assertEquals("Edgar", a.getMenoAutor());
    }

    /**
     * Test of pridajAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testPridajAutora() {
        Autor autor = new Autor("martin", "cierny", "existuje", "popis");
        autorDao.pridajAutora(autor);
    }

    /**
     * Test of vymazAutora method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testVymazAutora() {
        Autor autor1 = new Autor("gyula", "ferenc", "istvan", "popis");
        autorDao.pridajAutora(autor1);
        Autor autor = autorDao.najdiAutora("gyula", "ferenc", "istvan");
        autorDao.vymazAutora(autor);
    }

    /**
     * Test of nacitajAutorov method, of class DatabazovyAutorDao.
     */
    @org.junit.Test
    public void testNacitajAutorov() {
        assertNotNull(autorDao.nacitajAutorov());
    }

}
