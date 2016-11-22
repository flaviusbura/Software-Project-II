package be.nmbs.database;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.nmbs.logic.Gebruiker;

public class GebruikerDAOTest {
	private GebruikerDAO dao;
	private Gebruiker gebruiker;
	private Gebruiker gebruiker2;
	private Gebruiker gebruiker3;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben één keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		gebruiker = new Gebruiker(1, "Flavius", "Bura", "flaviusbura", "wachtwoord", 2, true);
		gebruiker2 = new Gebruiker(2, "User", "user", "user", "password", 1 , true);
		gebruiker3 = new Gebruiker(3, "Test", "TestNaam", "test", "test", 2, true);
		dao = new GebruikerDAO();
	}
	public GebruikerDAOTest() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Deze methode test of de methode insert() werkt
	 */
	@Test
	public void testInsert() {
		//dao.insert(gebruiker);
		//dao.insert(gebruiker2);
		//dao.insert(gebruiker3);
		
		gebruiker3 = dao.getGebruikerOpNaamEnVoornaam(gebruiker);
		assertTrue(gebruiker.getVoornaam().equals(gebruiker3.getVoornaam()));
		assertTrue(gebruiker.getAchternaam().equals(gebruiker3.getAchternaam()));
		gebruiker3 = dao.getGebruikerOpNaamEnVoornaam(gebruiker2);
		assertTrue(gebruiker2.getVoornaam().equals(gebruiker3.getVoornaam()));
		assertTrue(gebruiker2.getAchternaam().equals(gebruiker3.getAchternaam()));
	}

	/**
	 * Deze methode gaat test of hiermee alle gebruikers kunnen opgevraagt worden
	 */
	@Test
	public void testGetAll() {
		ArrayList<Gebruiker> lijst = new ArrayList<Gebruiker>();
		lijst = dao.getAll();
		
		assertTrue(gebruiker.equals(lijst.get(0)));
		assertTrue(gebruiker2.equals(lijst.get(1)));
	}

	/**
	 *Deze methode gaat testen of het wachtwood van een gebruiker gewijzigd wordt
	 */
	@Test
	public void testUpdateWachtwoord() {
		gebruiker.setWachtwoord("gewijzigd");
		dao.updateWachtwoordById(gebruiker);
		gebruiker3 = dao.getGebruikerOpNaamEnVoornaam(gebruiker);
		assertEquals("gewijzigd", gebruiker3.getWachtwoord());
	}
	/**
	 * Deze methode gaat testen of een gebruiker verijderd wordt
	 */
	@Test
	public void testGebruikerVerwijderen() {
		dao.delete(gebruiker3);
		gebruiker3 = dao.getGebruikerOpNaamEnVoornaam(gebruiker3);
		assertNull(gebruiker3);
	}
	
	/**
	 * Deze methode gaat testen of getGebruikerOpNaamEnVoornaam werkt
	 */
	@Test
	public void testGetGebruikerOpNaamEnVoornaam() {
		gebruiker3 = dao.getGebruikerOpNaamEnVoornaam(gebruiker);
		assertTrue(gebruiker3.getVoornaam().equals(gebruiker.getVoornaam()));
		assertTrue(gebruiker3.getAchternaam().equals(gebruiker.getAchternaam()));
	}
	
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		gebruiker = null;
		gebruiker2 = null;
		gebruiker3 = null;
		dao = null;
	}
}
