package be.nmbs.database;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.nmbs.logic.Klant;

public class KlantDAOTest {
	private Klant klant;
	private Klant klant2;
	private Klant klant3;
	private KlantDAO dao;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben één keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		klant = new Klant(1, "Flavius", "Bura", 1, "0489245939", true);
		klant2 = new Klant(2, "Klant", "Klant", 1, "0489245999", true);
		klant3 = new Klant(3, "MyKlant", "MyKlant", 1, "0489245989", true);
		dao = new KlantDAO();
	}

	/**
	 * Deze methode gaat test of de methode insert() van de klasse KlantDAO werkt
	 */
	@Test
	public void testInsert() {
		//dao.insert(klant);
		//dao.insert(klant2);
		//dao.insert(klant3);
		
		klant3 = dao.getKlantOpNaamEnVoornaam(klant);
		assertTrue(klant.getVoornaam().equals(klant3.getVoornaam()));
		assertTrue(klant.getAchternaam().equals(klant3.getAchternaam()));
		klant3 = dao.getKlantOpNaamEnVoornaam(klant2);
		assertTrue(klant2.getVoornaam().equals(klant3.getVoornaam()));
		assertTrue(klant2.getAchternaam().equals(klant3.getAchternaam()));
	}
	
	/**
	 * Deze methode gaat testen als alle klanten worden teruggestuurd
	 */
	@Test
	public void testGetAll() {
		ArrayList<Klant> lijst = new ArrayList<Klant>();
		lijst = dao.getAll();
		
		assertTrue(klant.equals(lijst.get(0)));
		assertTrue(klant2.equals(lijst.get(1)));
	}
	
	/**
	 * Deze test gaat de methode UpdateTelefoon() testen om te zien als de wijzigingen 
	 * op de database gebeuren
	 */
	@Test
	public void testUpdateTelefoon() {
		klant.setTelefoon("029487345");
		dao.updateTelefoonByContactId(klant);
		klant3 = dao.getKlantOpNaamEnVoornaam(klant);
		assertEquals(klant.getTelefoon(), klant3.getTelefoon());
	}
	
	/**
	 * Deze methode test of een klant verwijderd wordt op de database
	 */
	@Test
	public void testKlantVerijderen() {
		dao.delete(klant3);
		klant3 = dao.getKlantOpNaamEnVoornaam(klant3);
		assertNull(klant3);
	}
	
	/**
	 * Deze methode gaat testen of getKlantOpNaamEnVoornaam werkt
	 */
	@Test
	public void testGetGebruikerOpNaamEnVoornaam() {
		klant3 = dao.getKlantOpNaamEnVoornaam(klant);
		assertTrue(klant3.getVoornaam().equals(klant.getVoornaam()));
		assertTrue(klant3.getAchternaam().equals(klant.getAchternaam()));
	}
	
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		klant = null;
		klant2 = null;
		klant3 = null;
		dao = null;
	}
}
