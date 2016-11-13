package be.nmbs.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class KlantTest {
	private Klant klant;
	private Klant klantMetPram;

	/**
	 * Hier maken wij de objecten die wij nodig hebben één keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		klant = new Klant();
		klantMetPram = new Klant(1, "Flavius", "Bura", 1, "0489245939", true);
	}
	
	/**
	 * Hier testen wij de default constructor
	 */
	@Test
	public void testDefaultConstructor() {
		assertNotNull(klant);
		assertEquals(null, klant.getTelefoon());
	}
	
	/**
	 * Deze methode test de constructor met parameters
	 */
	@Test
	public void testConstructorMetParameters() {
		assertNotNull(klantMetPram);
		assertEquals(1, klantMetPram.getContactId());
		assertEquals("Flavius", klantMetPram.getVoornaam());
		assertEquals("Bura", klantMetPram.getAchternaam());
		assertEquals(1, klantMetPram.getAdresId());
		assertEquals("0489245939", klantMetPram.getTelefoon());
		assertEquals(1, klantMetPram.isActief());
	}
	
	/**
	 * Deze methode gaat testen of het juiste contactId wordt teruggestuurd
	 */
	@Test
	public void testGetContactId() {
		assertEquals(1, klantMetPram.getContactId());
	}
	
	/**
	 * Deze methode gaat testen of het juiste voornaam wordt teruggestuurd
	 */
	@Test
	public void testVoornaam() {
		assertEquals("Flavius", klantMetPram.getVoornaam());
	}
	
	/**
	 * Deze methode gaat testen of het juiste achternaam wordt teruggestuurd
	 */
	@Test
	public void testGetAchternaam() {
		assertEquals("Bura", klantMetPram.getAchternaam());
	}
	
	/**
	 * Deze methode gaat testen of het juiste adresId wordt teruggestuurd
	 */
	@Test
	public void testGetAdresId() {
		assertEquals(1, klantMetPram.getAdresId());
	}
	
	/**
	 * Deze methode gaat testen of het juiste telefoon wordt teruggestuurd
	 */
	@Test
	public void testGetTelefoon() {
		assertEquals("0489245939", klantMetPram.getTelefoon());
	}
	
	/**
	 * Deze methode gaat testen of het gebruiker actief is
	 */
	@Test
	public void testIsActief() {
		assertEquals(1, klantMetPram.isActief());
	}
	
	/**
	 * Deze methode gaat testen of setContactId() werkt
	 */
	@Test
	public void testSetContactId() {
		klant.setContactId(2);
		assertEquals(2, klant.getContactId());
	}
	
	/**
	 * Deze methode gaat testen of setVoornaam() werkt
	 */
	@Test
	public void testSetVoornaam() {
		klant.setVoornaam("MyVoornaam");
		assertEquals("MyVoornaam", klant.getVoornaam());
	}
	
	/**
	 * Deze methode gaat testen of setAchternaam() werkt
	 */
	@Test
	public void testSetAchternaam() {
		klant.setAchternaam("MyAchternaam");
		assertEquals("MyAchternaam", klant.getAchternaam());
	}
	
	/**
	 * Deze methode gaat testen of setAdresId() werkt
	 */
	@Test
	public void testSetAdresId() {
		klant.setAdresId(10);
		assertEquals(10, klant.getAdresId());
	}
	
	/**
	 * Deze methode gaat testen of setTelefoon() werkt
	 */
	@Test
	public void testSetTelefoon() {
		klant.setTelefoon("0489245999");;
		assertEquals("0489245999", klant.getTelefoon());
	}
	
	/**
	 * Deze methode gaat testen of setActief() werkt
	 */
	@Test
	public void testSetActief() {
		klant.setActief(false);;
		assertEquals(0, klant.isActief());
	}
	
	/**
	 * Deze methode tests de haschode() van de klasse Klant
	 */
	@Test
	public void testHashcode() {
		klant = klantMetPram;
		assertEquals(klant.hashCode(), klantMetPram.hashCode());
	}
	
	/**
	 * Deze methode tests de equals() van de klasse Klant
	 */
	@Test
	public void testEquals() {
		klant = klantMetPram;
		assertTrue(klant.equals(klantMetPram));
	}
	
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		klant = null;
		klantMetPram = null;
	}
}
