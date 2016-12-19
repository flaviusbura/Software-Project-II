package be.nmbs.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RouteTest {
	private Route route;
	private Route route2;
	private Route route3;
	ArrayList<Overstap> overstappen;
	ArrayList<Trein> treinen;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben een keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		route = ApiCaller.getRouteInfo("Mechelen", "Brussel-Zuid").get(0);
		
		overstappen = new ArrayList<Overstap>();
		//overstappen.add(new Overstap("1", 1, 2));
		
		treinen = new ArrayList<Trein>();
	//	treinen.add(new Trein("1", "2", "3", null, false));
		
		route3 = new Route("test1", "test2", treinen, overstappen);
	}

	@Test
	public void testRoute() {
		route2 = new Route(route.getStepOn(), route.getStepOff(), route.getTreinen(), route.getOverstappen());
		assertTrue(route2.getClass().equals(route.getClass()));
		assertTrue(route2.getStepOn().equals(route.getStepOn()));
		assertTrue(route2.getStepOff().equals(route.getStepOff()));
		assertTrue(route2.getTreinen().equals(route.getTreinen()));
		assertTrue(route2.getOverstappen().equals(route.getOverstappen()));
	}

	@Test
	public void testGetStepOn() {
		assertEquals("test1", route3.getStepOn());
	}

	@Test
	public void testGetStepOff() {
		assertEquals("test2", route3.getStepOff());
	}

	@Test
	public void testGetTreinen() {
		assertEquals(treinen, route3.getTreinen());
	}

	@Test
	public void testGetOverstappen() {
		assertEquals(overstappen, route3.getOverstappen());
	}

	@Test
	public void testSetStepOn() {
		route3.setStepOn("test3");
		assertEquals("test3", route3.getStepOn());
	}

	@Test
	public void testSetStepOff() {
		route3.setStepOff("test4");
		assertEquals("test4", route3.getStepOff());
	}

	@Test
	public void testSetTreinen() {
		//treinen.add(new Trein("4", "5", "6", null, true));
		route3.setTreinen(treinen);
		assertEquals(treinen, route3.getTreinen());
	}

	@Test
	public void testSetOverstappen() {
		//overstappen.add(new Overstap("2", 3, 4));
		route3.setOverstappen(overstappen);
		assertEquals(overstappen, route3.getOverstappen());
	}

	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		route = null;
		route2 = null;
		overstappen = null;
		treinen = null;
	}
}
