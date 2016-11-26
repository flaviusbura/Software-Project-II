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
public class PrijsTest {
	
	private Prijs prijs;
	private Prijs prijsMetParam;
	
	/**
	 * Objecten declareren om deze te kunnen hergebruiken
	 * @throws Exception
	 */
	
	@Before
	public void setup()  throws Exception {
		prijs = new Prijs();
		prijsMetParam = new Prijs(1,"AbdelTest",99,"Test",true);
	}
	/**
	 * aanroep test constructor
	 */
	@Test
	public void aanmakenPrijs() {
		assertNotNull(prijs);
		assertEquals(0, prijs.getPrijsId());
	}
	
	/**
	 * parameter initialisatie test
	 */
	@Test
	
	public void aanmakenPrijsMetParam() {
		assertNotNull(prijsMetParam);
		assertEquals(1, prijsMetParam.getPrijsId());
		assertEquals("AbdelTest", prijsMetParam.getOmschrijving());
		assertEquals(99,99, prijsMetParam.getPrijs());
		assertEquals("Test", prijsMetParam.getType());
		assertEquals(true, prijsMetParam.getActief());
	
	}
	/*
	 * getID test
	 */
	@Test
	public void testGetPrijsIdMethod(){
		assertEquals(1,prijsMetParam.getPrijsId());
	}
	/**
	 * getOmschijving test
	 */
	@Test
	public void testGetOmschrijvingMethod(){
		assertEquals("AbdelTest",prijsMetParam.getOmschrijving());
	}
	
	/**
	 * getPrijs test
	 */
	
	@Test
	public void testGetPrijsMethod(){
		assertEquals(2,0,prijsMetParam.getPrijs());
	}
	
	/**
	 * getType test
	 */
	@Test
	public void testGetTypeMethod(){
		assertEquals("Test",prijsMetParam.getType());
	}
	/**
	 * getType test
	 */
	@Test
	public void testGetActiefMethod(){
		assertEquals(true,prijsMetParam.getActief());
	}
	/**
	 * setPrijsId test
	 */
	@Test
	public void testSetPrijsId(){
		
		prijsMetParam.setPrijs_id(2);
		assertEquals(2,prijsMetParam.getPrijsId());
	}
	/**
	 * setOmschrijving test
	 */
	@Test
	public void testSetOmschrijving(){
		
		prijsMetParam.setOmschrijving("Test van Abdelilah");
		assertEquals("Test van Abdelilah",prijsMetParam.getOmschrijving());
	}
	/**
	 * setPrijs test
	 */
	
	@Test
	public void testSetPrijs(){
		
		prijsMetParam.setPrijs(22);
		assertEquals(22,22,prijsMetParam.getPrijs());
	}
	/**
	 * setType test
	 */
	@Test
	public void testSetType(){
		
		prijsMetParam.setType("Test van Type");
		assertEquals("Test van Type",prijsMetParam.getType());
	}
	/**
	 * setActief test
	 */
	@Test
	public void testSetActief(){
		
		prijsMetParam.setActief (false);
		assertEquals(false,prijsMetParam.getActief());
		prijsMetParam.setActief (true);
		assertEquals(true,prijsMetParam.getActief());
	}
	/**
	 * Deze methode test de hashcode() van de de klasse Prijs
	 */
	@Test
	public void testHashcode() {
		prijs = prijsMetParam;
		assertEquals(prijs.hashCode(), prijsMetParam.hashCode());
	}
	/**
	 * Deze methode test de equals() van de klasse Prijs
	 */
	@Test
	public void testEquals() {
		prijs = prijsMetParam;
		assertTrue(prijs.equals(prijsMetParam));
	}
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void teardown() throws Exception {
		prijs = null;
		prijsMetParam = null;
	}
	
}
