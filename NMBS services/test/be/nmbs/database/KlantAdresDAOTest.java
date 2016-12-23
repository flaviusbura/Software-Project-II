package be.nmbs.database;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.nmbs.logic.Adres;

public class KlantAdresDAOTest {
	private KlantAdresDAO dao;
	private Adres adres;
	private Adres adres2;
	private Adres adres3;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben één keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		adres = new Adres("StraatTest", 2, 1700, "3", "Ternat", "Belgie", true);
		adres2 = new Adres("StraatTest2", 3, 1700, "5", "Anderlecht", "Belgie", true);
		adres3 = new Adres("StraatTest3", 4, 1700, "7", "Brussel", "Belgie", true);
		dao = new KlantAdresDAO();
	}

	/**
	 * Deze methode gaat testen of de insert-methode werkt.
	 */
	@Test
	public void testInsert() {
		//dao.insert(adres);
		//dao.insert(adres2);
		//dao.insert(adres3);
		
		//id 19 is de id van object adres
		adres3 = dao.getAdres(19);
		assertTrue(adres.getStraat().equals(adres3.getStraat()));
		assertTrue(adres.getHuisnummer() == adres3.getHuisnummer());
		assertTrue(adres.getPostcode() == adres3.getPostcode());
		assertTrue(adres.getBus().equals(adres3.getBus()));
		assertTrue(adres.getWoonplaats().equals(adres3.getWoonplaats()));
		assertTrue(adres.getLand().equals(adres3.getLand()));
		assertTrue(adres.getActief() == adres3.getActief());
		
		//id 20 is de id van object adres2
		adres3 = dao.getAdres(20);
		assertTrue(adres2.getStraat().equals(adres3.getStraat()));
		assertTrue(adres2.getHuisnummer() == adres3.getHuisnummer());
		assertTrue(adres2.getPostcode() == adres3.getPostcode());
		assertTrue(adres2.getBus().equals(adres3.getBus()));
		assertTrue(adres2.getWoonplaats().equals(adres3.getWoonplaats()));
		assertTrue(adres2.getLand().equals(adres3.getLand()));
	}
	
	/**
	 * Deze methode test of de getAdresById werkt.
	 */
	@Test
	public void testGetAdresById() {
		adres3 = dao.getAdres(19);
		assertTrue(adres.getStraat().equals(adres3.getStraat()));
		assertTrue(adres.getHuisnummer() == adres3.getHuisnummer());
		assertTrue(adres.getPostcode() == adres3.getPostcode());
		assertTrue(adres.getBus().equals(adres3.getBus()));
		assertTrue(adres.getWoonplaats().equals(adres3.getWoonplaats()));
		assertTrue(adres.getLand().equals(adres3.getLand()));
		assertTrue(adres.getActief() == adres3.getActief());
	}

	/**
	 * Deze methode gaat testen of de actief op false gezet wordt.
	 */
	@Test
	public void testDeleteAdres() {
		adres3 = dao.getAdres(20);
		adres3.setAdresId(20);
		adres3.setActief(false);
		dao.delete(adres3);
		
		assertFalse(adres3.getActief());
	}
	
	/**
	 * Deze methode gaat testen of de methode getAdresIdOpStraatEnNummer() werkt.
	 */
	@Test
	public void testGetAdresIdOpStraatEnNummer() {
		int adresId = dao.getAdresIdOpStraatEnHuisnummer(adres);
		assertEquals(19, adresId);
	}
	
	/**
	 * Deze methode gaat testen of het adres geupdate wordt.
	 */
	@Test
	public void testUpdateAdresKlant() {
		adres3.setStraat("UpdateTest");
		adres3.setHuisnummer(5);
		adres3.setPostcode(1740);
		adres3.setWoonplaats("Ternat");
		adres3.setLand("Land");
		adres3.setBus("bus");
		adres3.setActief(true);
		adres3.setAdresId(22);
		dao.updateAdresKlant(adres3);
		
		adres = dao.getAdres(22);
		assertTrue(adres.getStraat().equals(adres3.getStraat()));
		assertTrue(adres.getHuisnummer() == adres3.getHuisnummer());
		assertTrue(adres.getPostcode() == adres3.getPostcode());
		assertTrue(adres.getBus().equals(adres3.getBus()));
		assertTrue(adres.getWoonplaats().equals(adres3.getWoonplaats()));
		assertTrue(adres.getLand().equals(adres3.getLand()));
		assertTrue(adres.getActief() == adres3.getActief());
	}
	
	/**
	 * Deze methode gaat testen of land gepdate wordt.
	 */
	@Test
	public void testUpdateLandById() {
		dao.updateLandByAdresId(22, "MijnLand");
		adres3 = dao.getAdres(22);
		assertTrue(adres3.getLand().equals("MijnLand"));
	}
	
	/**
	 * Deze methode gaat testen of straat gepdate wordt.
	 */
	@Test
	public void testUpdateStraatByAdresId() {
		dao.updateStraatByAdresId(22, "MijnStraat");
		adres3 = dao.getAdres(22);
		assertTrue(adres3.getStraat().equals("MijnStraat"));
	}
	
	/**
	 * Deze methode gaat testen of het huisnummer gepdate wordt.
	 */
	@Test
	public void testUpdateNrByAdresId() {
		dao.updateNrByAdresId(22, 10);
		adres3 = dao.getAdres(22);
		assertEquals(10, adres3.getHuisnummer());
	}
	
	/**
	 * Deze methode gaat testen of de postcode gepdate wordt.
	 */
	@Test
	public void testUpdatePostcodeByAdresId() {
		dao.updatePostcodeByAdresId(22, 1070);
		adres3 = dao.getAdres(22);
		assertEquals(1070, adres3.getPostcode());
	}
	
	/**
	 * Deze methode gaat testen of de woonplaats gepdate wordt.
	 */
	@Test
	public void testUpdateWoonplaatsByAdresId() {
		dao.updateWoonplaatsByAdresId(22, "MijnWoonplaats");
		adres3 = dao.getAdres(22);
		assertTrue(adres3.getWoonplaats().equals("MijnWoonplaats"));
	}
	
	/**
	 * Deze methode gaat testen of de bus gepdate wordt.
	 */
	@Test
	public void testUpdateBusByAdresId() {
		dao.updateBusByAdresId(22, "7");
		adres3 = dao.getAdres(22);
		assertTrue(adres3.getBus().equals("7"));
	}
	
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		adres = null;
		adres2 = null;
		adres3 = null;
	}
}
