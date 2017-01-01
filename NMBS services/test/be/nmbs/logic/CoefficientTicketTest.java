package be.nmbs.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoefficientTicketTest {

	private CoefficientTicket coefficient;
	private CoefficientTicket coefficient2;
	private CoefficientTicket coefficient3;

	/**
	 * Hier maken wij de objecten die wij nodig hebben één keer aan zodat wij
	 * die niet telkens in elke test opnieuw moeten aanmaken
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		coefficient = new CoefficientTicket(1, 40.49);
		coefficient2 = new CoefficientTicket(2);
		coefficient3 = new CoefficientTicket(3, 4, 30.50);
	}

	/**
	 * Deze methode gaat test of de constructor met een parameter correct
	 * geinitialiseerd wordt
	 */
	@Test
	public void testInitMetEenParam() {
		assertNotNull(coefficient2);
		assertEquals(2, coefficient2.getCoefficientTicketId());
	}

	/**
	 * Deze methode gaat test of de constructor met twee parameter correct
	 * geinitialiseerd wordt
	 */
	@Test
	public void testInitMetTweeParam() {
		assertNotNull(coefficient);
		assertEquals(1, coefficient.getTypeTicketId());
	}

	/**
	 * Deze methode gaat test of de constructor met drie parameter correct
	 * geinitialiseerd wordt
	 */
	@Test
	public void testInitMetDrieParam() {
		assertNotNull(coefficient3);
		assertEquals(3, coefficient3.getCoefficientTicketId());
	}

	/*
	 * getters testen
	 */

	@Test
	public void testGetId() {
		assertEquals(3, coefficient3.getCoefficientTicketId());
	}

	@Test
	public void testGetTypeAbonnementId() {
		assertEquals(4, coefficient3.getTypeTicketId());
	}

	@Test
	public void testGetCoefficient() {
		assertEquals(30.50, coefficient3.getCoefficient(), 1);
	}

	/*
	 * setters testen
	 */

	@Test
	public void testSetId() {
		coefficient3.setCoefficientTicketId(20);
		assertEquals(20, coefficient3.getCoefficientTicketId());
	}

	@Test
	public void testSetTypeAbonnementId() {
		coefficient3.setTypeTicketId(15);
		assertEquals(15, coefficient3.getTypeTicketId());
	}

	@Test
	public void testSetCoefficient() {
		coefficient3.setCoefficient(2.40);
		;
		assertEquals(2.40, coefficient3.getCoefficient(), 1);
	}

	@Test
	public void testHashcode() {
		coefficient = coefficient2;
		assertEquals(coefficient.hashCode(), coefficient2.hashCode());
	}

	@Test
	public void testEquals() {
		coefficient = coefficient2;
		assertTrue(coefficient.equals(coefficient2));
	}

	/**
	 * Hier gebeurt de clean-up
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		coefficient = null;
		coefficient2 = null;
		coefficient3 = null;
	}

}

