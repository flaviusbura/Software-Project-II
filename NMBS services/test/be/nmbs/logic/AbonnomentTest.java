package be.nmbs.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 * @author Abdel-Portable
 *
 */

public class AbonnomentTest {

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
		
		abonnementMetParam = new Abonnement(1,korting,true,klant,"testroute","november",prijs);
	}
	/**
	 * aanroep test constructor
	 */
	
	@Test
	public void aanmakenAbonnement() {
		assertNotNull(abonnement);
		assertEquals(0, abonnement.getId());
	}
	
	/**
	 * parameter initialisatie test
	 */
	@Test
	
	public void aanmakenAbonnementMetParam() {
		assertNotNull(abonnementMetParam);
		assertEquals(1, abonnementMetParam.getId());
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
		assertEquals(1,abonnementMetParam.getId());
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
		
		abonnementMetParam.setId(2);
		assertEquals(2,abonnementMetParam.getId());
	}
	@Test
	public void testSetKorting(){
		
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
		
		abonnementMetParam.setEindDatum("December");
		assertEquals("December",abonnementMetParam.getEindDatum());
	}
	@Test
	public void testSetPrijs(){
		
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
	}
}
