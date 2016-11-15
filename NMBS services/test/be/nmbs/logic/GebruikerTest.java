package be.nmbs.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GebruikerTest {
	
	private Gebruiker gebruiker;
	private Gebruiker gebruikerMetParam;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben één keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setup()  throws Exception {
		gebruiker = new Gebruiker();
		gebruikerMetParam = new Gebruiker(1, "Flavius", "Bura", "wachtwoord", 1, true);
	}
	
	/**
	 * Test om te zien als de default constructor wordt aangeroepen
	 */
	@Test
	public void aanmakenGebruiker() {
		assertNotNull(gebruiker);
		assertEquals(0, gebruiker.getRol());
	}
	/**
	 * Bij het aanmaken van een gebruiker met parameters gaan wij kijken als 
	 * alle waarden juist worden geinitialiseerd
	 */
	@Test
	public void aanmakenGebruikerMetParam() {
		assertNotNull(gebruikerMetParam);
		assertEquals(1, gebruikerMetParam.getId());
		assertEquals("Flavius", gebruikerMetParam.getVoornaam());
		assertEquals("Bura", gebruikerMetParam.getAchternaam());
		assertEquals("wachtwoord", gebruikerMetParam.getWachtwoord());
		assertEquals(1, gebruikerMetParam.getRol());
		assertEquals(true, gebruikerMetParam.isActief());
	}
	
	/**
	 * Deze methode tests de getId()-methode
	 */
	@Test
	public void testGetIdMethod() {
		assertEquals(1, gebruikerMetParam.getId());
	}
	
	/**
	 * Deze methode tests de getVoornaam()-methode
	 */
	@Test
	public void testGetVoornaam() {
		assertEquals("Flavius", gebruikerMetParam.getVoornaam());
	}
	
	/**
	 * Deze methode tests de getAchternaam()-methode
	 */
	@Test
	public void testGetAchternaam() {
		assertEquals("Bura", gebruikerMetParam.getAchternaam());
	}
	
	/**
	 * Deze methode tests de getWachtwoord()-methode
	 */
	@Test
	public void testGetWachtwoord() {
		assertEquals("wachtwoord", gebruikerMetParam.getWachtwoord());
	}
	
	/**
	 * Deze methode tests de getRol()-methode
	 */
	@Test
	public void testGetRol() {
		assertEquals(1, gebruikerMetParam.getRol());
	}
	
	/**
	 * Deze methode tests de isActief()-methode
	 */
	@Test
	public void testIsActief() {
		assertEquals(true, gebruikerMetParam.isActief());
	}
	
	/**
	 * Deze methode tests de setId()-methode
	 */
	@Test
	public void testSetId() {
		gebruikerMetParam.setId(2);
		assertEquals(2, gebruikerMetParam.getId());
	}
	
	/**
	 * Deze methode tests de setVoornaam()-methode
	 */
	@Test
	public void testSetVoornaam() {
		gebruikerMetParam.setVoornaam("An");
		assertEquals("An", gebruikerMetParam.getVoornaam());
	}
	
	/**
	 * Deze methode tests de setAchternaam()-methode
	 */
	@Test
	public void testSetAchternaam() {
		gebruikerMetParam.setAchternaam("Janssens");
		assertEquals("Janssens", gebruikerMetParam.getAchternaam());
	}
	
	/**
	 * Deze methode tests de setWachtwoord()-methode
	 */
	@Test
	public void testSetWachtwoord() {
		gebruikerMetParam.setWachtwoord("password");
		assertEquals("password", gebruikerMetParam.getWachtwoord());
	}
	
	/**
	 * Deze methode tests de setRol()-methode
	 */
	@Test
	public void testSetRol() {
		gebruikerMetParam.setRol(0);
		assertEquals(2, gebruikerMetParam.getRol());
		gebruikerMetParam.setRol(3);
		assertEquals(2, gebruikerMetParam.getRol());
		gebruikerMetParam.setRol(1);
		assertEquals(1, gebruikerMetParam.getRol());
		gebruikerMetParam.setRol(2);
		assertEquals(2, gebruikerMetParam.getRol());
	}

	/**
	 * Deze methode tests de setActief()-methode
	 */
	@Test
	public void testSetActief() {
		gebruikerMetParam.setActief(false);
		assertEquals(false, gebruikerMetParam.isActief());
		gebruikerMetParam.setActief(true);
		assertEquals(true, gebruikerMetParam.isActief());
	}
	
	/**
	 * Deze methode test de hashcode() van de de klasse Gebruiker
	 */
	@Test
	public void testHashcode() {
		gebruiker = gebruikerMetParam;
		assertEquals(gebruiker.hashCode(), gebruikerMetParam.hashCode());
	}
	
	/**
	 * Deze methode test de equals() van de klasse Gebruiker
	 */
	@Test
	public void testEquals() {
		gebruiker = gebruikerMetParam;
		assertTrue(gebruiker.equals(gebruikerMetParam));
	}
	
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void teardown() throws Exception {
		gebruiker = null;
		gebruikerMetParam = null;
	}
}

