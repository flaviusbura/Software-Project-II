package be.nmbs.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KortingTest {
	private Korting kortingMetPara;
	/**
	 * Hier maken wij de objecten die wij nodig hebben 1 keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		kortingMetPara = new Korting(5, 0.5, "50% korting",true,"procent");
	}
	/**
	 * Deze methode test de constructor met parameters
	 */
	@Test
	public void testConstructorMetParameters() {
		assertNotNull(kortingMetPara);
		assertEquals(5, kortingMetPara.getId());
		assertEquals(0.5,0.5,kortingMetPara.getHoeveelheid());
		assertEquals("50% korting",kortingMetPara.getOmschrijving());
		assertEquals(true,kortingMetPara.getActief());
		assertEquals("procent",kortingMetPara.getTypeKorting());
	}
	/**
	 * Deze methode gaat testen of het juiste id wordt teruggestuurd
	 */
	@Test
	public void testGetId() {
		assertEquals(5, kortingMetPara.getId());
	}
	
	/**
	 * Deze methode gaat testen of de juiste hoeveelheid wordt teruggestuurd
	 */
	@Test
	public void testHoeveelheid() {
		assertEquals(0.5,0.5, kortingMetPara.getHoeveelheid());
	}
	
	/**
	 * Deze methode gaat testen of de juiste omschrijving wordt teruggegeven
	 */
	@Test
	public void testGetOmschrijving() {
		assertEquals("50% korting", kortingMetPara.getOmschrijving());
	}
	
	/**
	 * Deze methode gaat testen of de juiste actief wordt teruggegeven
	 */
	@Test
	public void testActief() {
		assertEquals(true, kortingMetPara.getActief());
	}
	
	/**
	 * Deze methode gaat testen of het juiste type korting wordt teruggegeven
	 */
	@Test
	public void testGetTypeKorting() {
		assertEquals("procent", kortingMetPara.getTypeKorting());
	}
	
	
	/**
	 * Deze methode gaat testen of setId() werkt
	 */
	@Test
	public void testSetId() {
		kortingMetPara.setId(2);
		assertEquals(2, kortingMetPara.getId());
	}
	
	/**
	 * Deze methode gaat testen of setHoeveelheid werkt
	 */
	@Test
	public void testSetHoeveelheid() {
		kortingMetPara.setHoeveelheid(0.2);
		assertEquals(0.2,0.2, kortingMetPara.getHoeveelheid());
	}
	
	/**
	 * Deze methode gaat testen of setOmschrijving werkt
	 */
	@Test
	public void testSetOmschrijving() {
		kortingMetPara.setOmschrijving("20% korting");
		assertEquals("20% korting", kortingMetPara.getOmschrijving());
	}
	
	
	/**
	 * Deze methode gaat testen of setTypeKorting() werkt
	 */
	@Test
	public void testSetTypeKorting() {
		kortingMetPara.setTypeKorting("percentage");
		assertEquals("percentage", kortingMetPara.getTypeKorting());
	}
	
	/**
	 * Deze methode gaat testen of setActief() werkt
	 */
	@Test
	public void testSetActief() {
		kortingMetPara.setActief(false);
		assertEquals(false, kortingMetPara.getActief());
	}
	
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		kortingMetPara = null;
	}

}
