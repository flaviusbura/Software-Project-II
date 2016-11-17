package be.nmbs.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OverstapTest {
	private Overstap overstap;
	private Overstap overstapMetParam;

	/**
	 * Hier maken wij de objecten die wij nodig hebben één keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		overstap = new Overstap();
		overstapMetParam = new Overstap("Brussel-Zuid",1,2);
	}
	
	/**
	 * Hier testen wij de default constructor
	 */
	@Test
	public void testDefaultConstructor() {
		assertNotNull(overstap);
		assertEquals(null, overstap.getStation());	
	}
		/**
		 * Deze methode test de constructor met parameters
		 */
		@Test
		public void testConstructorMetParameters() {
			assertNotNull(overstapMetParam);
			assertEquals("Brussel-Zuid", overstapMetParam.getStation());
			assertEquals(1, overstapMetParam.getStepOffPlatform());
			assertEquals(2, overstapMetParam.getStepOnPlatform());
		}
		
		/**
		 * Deze methode gaat testen of het juiste station wordt teruggestuurd
		 */
		@Test
		public void testGetStation() {
			assertEquals("Brussel-Zuid", overstapMetParam.getStation());
		}
		
		/**
		 * Deze methode gaat testen of het juiste StepOffPlatform wordt teruggestuurd
		 */
		@Test
		public void testGetStepOffPlatform() {
			assertEquals(1, overstapMetParam.getStepOffPlatform());
		}
		
		/**
		 * Deze methode gaat testen of het juiste achternaam wordt teruggestuurd
		 */
		@Test
		public void testGetStepOnPlatform() {
			assertEquals(2, overstapMetParam.getStepOnPlatform());
		}
		/**
		 * Deze methode gaat testen of setStation() werkt
		 */
		@Test
		public void testStation() {
			overstap.setStation("Brussel-Noord");
			assertEquals("Brussel-Noord",overstap.getStation());
		}
		
		/**
		 * Deze methode gaat testen of setStepOffPlatform() werkt
		 */
		@Test
		public void testSetStepOffPlatform() {
			overstap.setStepOffPlatform(2);
			assertEquals(2,overstap.getStepOffPlatform());
		}
		
		
		/**
		 * Deze methode gaat testen of setStepOnPlatform() werkt
		 */
		@Test
		public void testSetStepOnPlatform() {
			overstap.setStepOffPlatform(4);
			assertEquals(4,overstap.getStepOffPlatform());
		}
		/**
		 * Deze methode tests de haschode() van de klasse Overstap
		 */
		@Test
		public void testHashcode() {
			overstap = overstapMetParam;
			assertEquals(overstap.hashCode(), overstapMetParam.hashCode());
		}
		
		/**
		 * Deze methode tests de equals() van de klasse Klant
		 */
		@Test
		public void testEquals() {
			overstap = overstapMetParam;
			assertTrue(overstap.equals(overstapMetParam));
		}
		
		/**
		 * Hier gebeurt de clean-up
		 * @throws Exception
		 */
		@After
		public void tearDown() throws Exception {
			overstap = null;
			overstapMetParam = null;
		}
		
	
}
