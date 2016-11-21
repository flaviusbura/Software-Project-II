package be.nmbs.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApiCallerTest {
	private ApiCaller caller;
	private Calendar cal;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben een keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		caller = new ApiCaller();
	}

	/**
	 * Deze methode gaat testen of getRouteInfo werkt.
	 */
	@Test
	public void testGetRouteInfo() {
		ArrayList<Route> routes = new ArrayList<Route>();
		
		routes = caller.getRouteInfo("Mechelen", "Brussel-Zuid");
		assertTrue(routes.size() > 0);
		
		routes = caller.getRouteInfo("niks", "rip");
		assertNull(routes);
	}
	
	/**
	 * Deze methode gaat testen of getTimedRouteInfo werkt.
	 */
	@Test
	public void testGetTimedRouteInfo() {
		ArrayList<Route> routes = new ArrayList<Route>();
		cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT+1"));
		
		cal.setTime(new Date(System.currentTimeMillis()));
		routes = caller.getTimedRouteInfo("Mechelen", "Brussel-Zuid", cal.getTime());
		assertTrue(routes.size() > 0);
	}

	/**
	 * Deze methode gaat testen of getTreinInfo werkt.
	 */
	@Test
	public void testGetTreinInfo() {
		Trein trein;
		trein = caller.getTreinInfo("2309");
		assertTrue(trein.getId().equals("IC 2309"));
		assertTrue(trein.getDepartureStation().equals("Oostende"));
		assertTrue(trein.getTerminusStation().equals("Brussels Airport - Zaventem"));
		assertTrue(trein.getStops().size() > 0);
		
		trein = caller.getTreinInfo("3168");
		assertNull(trein);
	}

	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		caller = null;
		cal = null;
	}
}
