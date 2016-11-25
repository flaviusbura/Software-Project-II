package be.nmbs.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TreinTest {
	private Trein trein;
	private List<Station> myList;
	/**
	 * Hier maken wij de objecten die wij nodig hebben 1 keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		myList = new ArrayList<Station>();
		Date datum=new Date();
		Station test = new Station("Vilvoorde","2", "2",datum,datum, datum, datum);
		myList.add(test);
		trein = new Trein("2", "Mechelen", "Brussel-Zuid",myList, false);
	}
	/**
	 * Deze methode test de constructor met parameters
	 */
	@Test
	public void testConstructorMetParameters() {
		assertNotNull(trein);
		assertEquals("2", trein.getId());
		assertEquals("Mechelen",trein.getDepartureStation());
		assertEquals("Brussel-Zuid",trein.getTerminusStation());
		assertEquals(myList,trein.getStops());
		assertEquals(false,trein.isCancelled());
	}
	/**
	 * Deze methode gaat testen of het juiste id wordt teruggestuurd
	 */
	@Test
	public void testGetId(){
		assertEquals("2",trein.getId());
	}
	/**
	 * Deze methode gaat testen of het juiste startstation wordt teruggestuurd
	 */
	@Test
	public void testGetDeparture(){
		assertEquals("Mechelen",trein.getDepartureStation());
	}
	/**
	 * Deze methode gaat testen of het juiste eindstation wordt teruggestuurd
	 */
	@Test
	public void testGetTerminus(){
		assertEquals("Brussel-Zuid",trein.getTerminusStation());
	}
	/**
	 * Deze methode gaat testen of de juiste tussenstop stations worden teruggestuurd
	 */
	@Test
	public void testGetStops(){
		assertEquals(myList,trein.getStops());
	}
	/**
	 * Deze methode gaat testen of de juiste cancelled variabele wordt teruggestuurd
	 */
	@Test
	public void testGetCancelled(){
		assertEquals(false,trein.isCancelled());
	}
	/**
	 * Deze methode gaat testen of het setId werkt
	 */
	@Test
	public void testSetId(){
		trein.setId("5");
		assertEquals("5",trein.getId());
	}
	/**
	 * Deze methode gaat testen of het setDeparture werkt
	 */
	@Test
	public void testSetDeparture(){
		trein.setDepartureStation("Vilvoorde");
		assertEquals("Vilvoorde",trein.getDepartureStation());
	}
	/**
	 * Deze methode gaat testen of het setTerminus werkt
	 */
	@Test
	public void testSetTerminus(){
		trein.setTerminusStation("Brussel-Noord");
		assertEquals("Brussel-Noord",trein.getTerminusStation());
	}
	/**
	 * Deze methode gaat testen of setStops werkt
	 */
	@Test
	public void testSetStops(){
		myList = new ArrayList<Station>();
		Date datum=new Date();
		Station test = new Station("Brussel-Centraal","2", "2",datum,datum, datum, datum);
		myList.add(test);
		trein.setStops(myList);
		assertEquals(myList,trein.getStops());
	}
	/**
	 * Deze methode gaat testen of setCancelled werkt
	 */
	@Test
	public void testSetCancelled(){
		trein.setCancelled(true);
		assertEquals(true,trein.isCancelled());
	}
	
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		trein = null;
	}
}
