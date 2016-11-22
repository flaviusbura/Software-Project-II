package be.nmbs.logic;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 * @author Abdel-Portable
 *
 */

public class AbonnementTest {

	private Abonnement abonnement;
	private Abonnement abonnementMetParam;
	private Korting korting;
	private Klant klant;
	private Prijs prijs;
	
	/**
	 * Objecten declareren om deze te kunnen hergebruiken
	 * @throws Exception
	 */
	
	@Before
	public void setup()  throws Exception {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		korting = new Korting(1, 0.5, "Korting", true, "Standaard");
		klant = new Klant();
		prijs = new Prijs();
		abonnementMetParam = new Abonnement(1,klant, 1,"Brussel-Mechelen", ts, ts, prijs, korting, true);
	}
	/**
	 * aanroep test constructor
	 */
	
	@Test
	public void aanmakenAbonnement() {
		assertNotNull(abonnement);
		assertEquals(0, abonnement.getAbonnementId());
	}
	
	/**
	 * parameter initialisatie test
	 */
	@Test
	
	public void aanmakenAbonnementMetParam() {
		assertNotNull(abonnementMetParam);
		assertEquals(1, abonnementMetParam.getAbonnementId());
		assertEquals(korting, abonnementMetParam.getKorting());
		assertEquals(true, abonnementMetParam.isActief());
		assertEquals(klant, abonnementMetParam.getKlant());
		assertEquals("testroute", abonnementMetParam.getRoute());
		assertEquals("november", abonnementMetParam.getEindDatum());
		assertEquals(prijs, abonnementMetParam.getPrijs());
		
	
	}

	/*
	 * getters testen
	 */
	@Test
	public void testGetId(){
		assertEquals(1,abonnementMetParam.getAbonnementId());
	}
	@Test
	public void testGetKorting(){
		assertEquals(korting,abonnementMetParam.getKorting());
	}
	@Test
	public void testGetActief(){
		assertEquals(true,abonnementMetParam.isActief());
	}
	@Test
	public void testGetKlant(){
		assertEquals(klant,abonnementMetParam.getKlant());
	}
	@Test
	public void testGetRoute(){
		assertEquals("testroute",abonnementMetParam.getRoute());
	}
	@Test
	public void testGetEindDatum(){
		assertEquals("november",abonnementMetParam.getEindDatum());
	}
	@Test
	public void testGetPrijs(){
		assertEquals(prijs,abonnementMetParam.getPrijs());
	}
	/**
	 *  test setters
	 */
	@Test
	public void testSetId(){
		abonnementMetParam.setAbonnementId(2);
		assertEquals(2,abonnementMetParam.getAbonnementId());
	}
	@Test
	public void testSetKorting(){
		korting = new Korting(0, 0, null, false, null);
		abonnementMetParam.setKorting(korting);
		assertEquals(korting,abonnementMetParam.getKorting());
	}
	@Test
	public void testSetActief(){
		abonnementMetParam.setActief(false);;
		assertEquals(false,abonnementMetParam.isActief());
	}
	@Test
	public void testSetKlant(){
		klant = null;
		abonnementMetParam.setKlant(klant);
		assertEquals(klant,abonnementMetParam.getKlant());
	}
	@Test
	public void testSetRoute(){
		abonnementMetParam.setRoute("testerino");
		assertEquals("testerino",abonnementMetParam.getRoute());
	}
	@Test
	public void testSetEindDatum(){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		abonnementMetParam.setEindDatum(ts);
		assertEquals(ts,abonnementMetParam.getEindDatum());
	}
	@Test
	public void testSetPrijs(){
		prijs = null;
		abonnementMetParam.setPrijs(prijs);
		assertEquals(prijs,abonnementMetParam.getPrijs());
	}
	
	@Test
	public void testHashcode() {
		abonnement = abonnementMetParam;
		assertEquals(abonnement.hashCode(), abonnementMetParam.hashCode());
	}
	/**
	 * Deze methode test de equals() van de klasse Prijs
	 */
	@Test
	public void testEquals() {
		abonnement = abonnementMetParam;
		assertTrue(abonnement.equals(abonnementMetParam));
	}
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void teardown() throws Exception {
		abonnement = null;
		abonnementMetParam = null;
		korting = null;
		klant = null;
		prijs = null;
	}
}
