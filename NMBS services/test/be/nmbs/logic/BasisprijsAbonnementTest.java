package be.nmbs.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasisprijsAbonnementTest {
	private BasisprijsAbonnement prijs;
	private BasisprijsAbonnement prijs2;
	private BasisprijsAbonnement prijs3;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben één keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		prijs = new BasisprijsAbonnement(1, 40.49);
		prijs2 = new BasisprijsAbonnement(2);
		prijs3 = new BasisprijsAbonnement(3, 4, 30.50);
	}

	/**
	 * Deze methode gaat test of de constructor met een parameter correct
	 * geinitialiseerd wordt
	 */
	@Test
	public void testInitMetEenParam() {
		assertNotNull(prijs2);
		assertEquals(2, prijs2.getId());
	}
	
	/**
	 * Deze methode gaat test of de constructor met twee parameter correct
	 * geinitialiseerd wordt
	 */
	@Test
	public void testInitMetTweeParam() {
		assertNotNull(prijs);
		assertEquals(1, prijs.getTypeAbonnementId());
	}

	/**
	 * Deze methode gaat test of de constructor met drie parameter correct
	 * geinitialiseerd wordt
	 */
	@Test
	public void testInitMetDrieParam() {
		assertNotNull(prijs3);
		assertEquals(3, prijs3.getId());
	}
	
	/*
	 * getters testen
	 */
	
	@Test
	public void testGetId() {
		assertEquals(3, prijs3.getId());
	}
	
	@Test
	public void testGetTypeAbonnementId() {
		assertEquals(4, prijs3.getTypeAbonnementId());
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
		prijs3.setId(20);
		assertEquals(20, prijs3.getId());
	}
	
	@Test
	public void testSetTypeAbonnementId() {
		prijs3.setTypeAbonnementId(15);
		assertEquals(15, prijs3.getTypeAbonnementId());
	}
	
	@Test
	public void testSetPrijs() {
		prijs3.setPrijs(2.40);;
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
