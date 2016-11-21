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
public class BoeteTest {
	
	private Boete boete;
	private Boete boeteMetParam;
	Timestamp ts = new Timestamp( 2016,  06,  12,  12,  12,  12,  12);

	/**
	 * Objecten declareren om deze te kunnen hergebruiken
	 * @throws Exception
	 */
	
	@Before
	public void setup()   {
		boete = new Boete();
		boeteMetParam = new Boete(1,1,99.99,ts,ts,true);
	}
	/**
	 * aanroep test constructor
	 */
	@Test
	public void aanmakenBoete() {
		assertNotNull(boete);
		assertEquals(1, boeteMetParam.getBoeteId());
	}
	/**
	 * parameter initialisatie test
	 */
	@Test
	public void aanmakenPrijsMetParam() {
		assertNotNull(boeteMetParam);
		assertEquals(1, boeteMetParam.getBoeteId());
		assertEquals(1, boeteMetParam.getKlantContactId());
		assertEquals(99,99, boeteMetParam.getPrijs());
		assertEquals(ts, boeteMetParam.getDatum());
		assertEquals(ts, boeteMetParam.getBetaalDatum());
		assertEquals(true, boeteMetParam.isBetaald());
	
	}
	/**
	 * getters testen
	 */
	@Test
	public void testGetBoete(){
		assertEquals(1,boeteMetParam.getBoeteId());
	}
	@Test
	public void testGetKlantContactId(){
		assertEquals(1,boeteMetParam.getKlantContactId());
	}
	@Test
	public void testGetPrijs(){
		assertEquals(99,99,boeteMetParam.getPrijs());
	}
	@Test
	public void testGetDatum(){
		assertEquals(ts,boeteMetParam.getDatum());
	}
	@Test
	public void testGetBetaalDatum(){
		assertEquals(ts,boeteMetParam.getBetaalDatum());
	}
	@Test
	public void testIsBetaald(){
		assertEquals(true,boeteMetParam.isBetaald());
	}
	
	/**
	 * setters testen 
	*/
	@Test
	public void testSetBoeteId(){
		
		boeteMetParam.setBoeteId(0);
		assertEquals(0,boeteMetParam.getBoeteId());
	}
	@Test
	public void testSetKlantContactId(){
		
		boeteMetParam.setKlantContactId(0);
		assertEquals(0,boeteMetParam.getKlantContactId());
	}
	@Test
	public void testSetPrijs(){
		
		boeteMetParam.setPrijs(0);
		assertEquals(0,0,boeteMetParam.getPrijs());
	}
	@Test
	public void testSetDatum(){
		
		boeteMetParam.setDatum(ts);
		assertEquals(ts,boeteMetParam.getDatum());
	}
	@Test
	public void testSetBetaalDatum(){
		
		boeteMetParam.setBetaalDatum(ts);
		assertEquals(ts,boeteMetParam.getBetaalDatum());
	}@Test
	public void testSetBetaald(){
		
		boeteMetParam.setBetaald(false);
		assertEquals(false,boeteMetParam.isBetaald());
	}
	/**
	 * Deze methode test de hashcode() van de de klasse Prijs
	 */
	@Test
	public void testHashcode() {
		boete = boeteMetParam;
		assertEquals(boete.hashCode(), boeteMetParam.hashCode());
	}
	/**
	 * Deze methode test de equals() van de klasse Prijs
	 */
	@Test
	public void testEquals() {
		boete = boeteMetParam;
		assertTrue(boete.equals(boeteMetParam));
	}
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void teardown() throws Exception {
		boete = null;
		boeteMetParam = null;
	}
	
}
