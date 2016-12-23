package be.nmbs.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdresTest {
	private Adres adres;
	private Adres adres2;

	@Before
	public void setUp() throws Exception {
		adres = new Adres("MijnStraat", "3", 1700, "2", "Dilbeek", "Belgie", true);
		adres2 = new Adres("MijnStraat", "3", 1700, "2", "Dilbeek", 2, "Belgie", true);
	}

	/**
	 * Deze methode test of een adres-object wordt aangemaakt.
	 */
	@Test
	public void testAanmakenAdres() {
		assertNotNull(adres);
		assertTrue(adres.getHuisnummer().equals("3"));
	}

	/**
	 * Deze methode gaat testen of de initialisatie van de parameters juist
	 * gebeurd
	 */
	@Test
	public void testInitParametersZonderAdresId() {
		assertTrue(adres.getStraat().equals("MijnStraat"));
		assertTrue(adres.getHuisnummer().equals("3"));
		assertEquals(1700, adres.getPostcode());
		assertTrue(adres.getBus().equals("2"));
		assertTrue(adres.getWoonplaats().equals("Dilbeek"));
		assertTrue(adres.getLand().equals("Belgie"));
		assertTrue(adres.getActief());
	}

	/**
	 * Deze methode gaat testen of de initialisatie van de parameters juist
	 * gebeurd
	 */
	@Test
	public void testInitParametersMetAdresId() {
		assertTrue(adres2.getStraat().equals("MijnStraat"));
		assertTrue(adres.getHuisnummer().equals("3"));
		assertEquals(1700, adres2.getPostcode());
		assertTrue(adres2.getBus().equals("2"));
		assertTrue(adres2.getWoonplaats().equals("Dilbeek"));
		assertEquals(2, adres2.getAdresId());
		assertTrue(adres2.getLand().equals("Belgie"));
		assertTrue(adres2.getActief());
	}

	/*
	 *   getters testen
	 */
	@Test
	public void testGetId() {
		assertEquals(2, adres2.getAdresId());
	}

	@Test
	public void testGetStraat() {
		assertTrue(adres2.getStraat().equals("MijnStraat"));
	}

	@Test
	public void testGetHuisnummer() {
		assertTrue(adres.getHuisnummer().equals("3"));
	}

	@Test
	public void testGetPostcode() {
		assertEquals(1700, adres2.getPostcode());
	}

	@Test
	public void testGetBus() {
		assertTrue(adres2.getBus().equals("2"));
	}

	@Test
	public void testGetWoonplaats() {
		assertTrue(adres2.getWoonplaats().equals("Dilbeek"));
	}

	@Test
	public void testGetLand() {
		assertTrue(adres2.getLand().equals("Belgie"));
	}

	@Test
	public void testGetActief() {
		assertTrue(adres2.getActief());
	}

	/*
	 * setters testen
	 */

	@Test
	public void testSetAdresId() {
		adres2.setAdresId(10);
		assertEquals(10, adres2.getAdresId());
	}

	@Test
	public void testSetStraat() {
		adres2.setStraat("Brusselstraat");
		assertTrue(adres2.getStraat().equals("Brusselstraat"));
	}

	@Test
	public void testSetHuisnummer() {
		adres2.setHuisnummer("20");
		assertTrue(adres2.getHuisnummer().equals("20"));
	}

	@Test
	public void testSetPostcode() {
		adres2.setPostcode(1070);
		assertEquals(1070, adres2.getPostcode());
	}

	@Test
	public void testSetBus() {
		adres2.setBus("4");
		assertTrue(adres2.getBus().equals("4"));
	}

	@Test
	public void testSetWoonplaats() {
		adres2.setWoonplaats("Anderlecht");
		assertTrue(adres2.getWoonplaats().equals("Anderlecht"));
	}

	@Test
	public void testSetLand() {
		adres2.setLand("MijnLand");
		assertTrue(adres2.getLand().equals("MijnLand"));
	}

	@Test
	public void testSetActief() {
		adres2.setActief(false);
		assertFalse(adres2.getActief());
	}

	@After
	public void tearDown() throws Exception {
		adres = null;
		adres2 = null;
	}
}
