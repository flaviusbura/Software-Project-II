package be.nmbs.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasisprijsTicketTest {
	private BasisprijsTicket prijs;
	private BasisprijsTicket prijs2;
	private BasisprijsTicket prijs3;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben één keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		prijs = new BasisprijsTicket(1, 40.49);
		prijs2 = new BasisprijsTicket(2);
		prijs3 = new BasisprijsTicket(3, 4, 30.50);
	}

	/**
	 * Deze methode gaat test of de constructor met een parameter correct
	 * geinitialiseerd wordt
	 */
	@Test
	public void testInitMetEenParam() {
		assertNotNull(prijs2);
		assertEquals(2, prijs2.getBasisprijsId());
	}
	
	/**
	 * Deze methode gaat test of de constructor met twee parameter correct
	 * geinitialiseerd wordt
	 */
	@Test
	public void testInitMetTweeParam() {
		assertNotNull(prijs);
		assertEquals(1, prijs.getTypeTicketId());
	}

	/**
	 * Deze methode gaat test of de constructor met drie parameter correct
	 * geinitialiseerd wordt
	 */
	@Test
	public void testInitMetDrieParam() {
		assertNotNull(prijs3);
		assertEquals(3, prijs3.getBasisprijsId());
	}
	
	/*
	 * getters testen
	 */
	
	@Test
	public void testGetId() {
		assertEquals(3, prijs3.getBasisprijsId());
	}
	
	@Test
	public void testGetTypeAbonnementId() {
		assertEquals(4, prijs3.getTypeTicketId());
	}
	
	@Test
	public void testGetPrijs() {
		assertEquals(30.50, prijs3.getPrijs(), 1);
	}
	
	/*
	 * setters testen
	 */
	
	@Test
	public void testSetId() {
		prijs3.setBasisprijsId(20);
		assertEquals(20, prijs3.getBasisprijsId());
	}
	
	@Test
	public void testSetTypeAbonnementId() {
		prijs3.setTypeTicketId(15);
		assertEquals(15, prijs3.getTypeTicketId());
	}
	
	@Test
	public void testSetPrijs() {
		prijs3.setPrijs(2.40);
		assertEquals(2.40, prijs3.getPrijs(), 1);
	}
	
	@Test
	public void testHashcode() {
		prijs = prijs2;
		assertEquals(prijs.hashCode(), prijs2.hashCode());
	}

	@Test
	public void testEquals() {
		prijs = prijs2;
		assertTrue(prijs.equals(prijs2));
	}
	
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		prijs = null;
		prijs2 = null;
		prijs3 = null;
	}
}

