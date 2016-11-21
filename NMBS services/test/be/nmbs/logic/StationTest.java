package be.nmbs.logic;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Abdel-Portable
 *
 */

public class StationTest {

	private Station station;
	private Station stationMetParam;
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	/**
	 * Objecten declareren om deze te kunnen hergebruiken
	 * @throws Exception
	 */
	
	@Before
	public void setup()  throws Exception {
		station = new Station();
		stationMetParam = new Station("Abdel","AbdelTest","Test",format.parse("20-11-2016"),
																format.parse("20-10-2016"),
																format.parse("20-09-2016"),
																format.parse("20-08-2016"));
		
	}
	
	/**
	 * aanroep test constructor
	 */
	@Test
	public void aanmakenStation() {
		assertNotNull(station);
		assertEquals(null,station.getName());
	}
	/**
	 * parameter initialisatie test
	 * @throws ParseException 
	 */
	@Test
	public void aanmakenStationMetParam() throws ParseException {
		assertNotNull(stationMetParam);
		assertEquals("Abdel", stationMetParam.getName());
		assertEquals("AbdelTest", stationMetParam.getArrivalPlatform());
		assertEquals("Test", stationMetParam.getDeparturePlatform());
		assertEquals(format.parse("20-11-2016"), stationMetParam.getArrival());
		assertEquals(format.parse("20-10-2016"), stationMetParam.getArrivalDelay());
		assertEquals(format.parse("20-09-2016"), stationMetParam.getDeparture());
		assertEquals(format.parse("20-08-2016"), stationMetParam.getDepartureDelay());
			
	}
	/*
	 *  getName test
	 */
	@Test
	public void testGetName(){
		assertEquals("Abdel",stationMetParam.getName());
	}
	/**
	 * getArrivalPlatform test
	 */
	@Test
	public void testGetArrivalPlatform(){
		assertEquals("AbdelTest",stationMetParam.getArrivalPlatform());
	}
	
	/**
	 * getDeparturePlatform test
	 */
	
	@Test
	public void testGetDeparturePlatform(){
		assertEquals("Test",stationMetParam.getDeparturePlatform());
	}
	
	/**
	 * getArrival test
	 * @throws ParseException 
	 */
	@Test
	public void testGetArrival() throws ParseException{
		assertEquals(format.parse("20-11-2016"),stationMetParam.getArrival());
	}
	
	/**
	 * getArrivalDelay test
	 * @throws ParseException 
	 */
	@Test
	public void testGetArrivalDelay() throws ParseException{
		assertEquals(format.parse("20-10-2016"),stationMetParam.getArrivalDelay());
	}
	/**
	 * getDeparture test
	 * @throws ParseException 
	 */
	@Test
	public void testGetDeparture() throws ParseException{
		assertEquals(format.parse("20-09-2016"),stationMetParam.getDeparture());
	}
	/**
	 * getDepartureDelay test
	 * @throws ParseException 
	 */
	@Test
	public void testGetDepartureDelay() throws ParseException{
		assertEquals(format.parse("20-08-2016"),stationMetParam.getDepartureDelay());
	}
	
	
	/**
	 * setName test
	 */
	@Test
	public void testSetName(){
		
		stationMetParam.setName("Test1");
		assertEquals("Test1",stationMetParam.getName());
	}
	
	/**
	 * setArrivalPlatform test
	 */
	@Test
	public void testSetArrivalPlatform(){
		
		stationMetParam.setArrivalPlatform("PlatformTest");
		assertEquals("PlatformTest",stationMetParam.getArrivalPlatform());
	}
	/**
	 * setDeparturePlatform test
	 */
	@Test
	public void testSetDeparturePlatform(){
		
		stationMetParam.setDeparturePlatform("DeparturePlatformTest");
		assertEquals("DeparturePlatformTest",stationMetParam.getDeparturePlatform());
	}
	/**
	 * setArrival test
	 * @throws ParseException 
	 */
	@Test
	public void testSetArrival() throws ParseException{
		
		stationMetParam.setArrival(format.parse("12-12-2012"));
		assertEquals(format.parse("12-12-2012"),stationMetParam.getArrival());
	}
	/**
	 * setArrivalDelay test
	 * @throws ParseException 
	 */
	@Test
	public void testSetArrivalDelay() throws ParseException{
		
		stationMetParam.setArrivalDelay(format.parse("12-12-2012"));
		assertEquals(format.parse("12-12-2012"),stationMetParam.getArrivalDelay());
	}
	
	/**
	 * setDeparture test
	 * @throws ParseException 
	 */
	@Test
	public void testSetDeparture() throws ParseException{
		
		stationMetParam.setDeparture(format.parse("12-12-2012"));
		assertEquals(format.parse("12-12-2012"),stationMetParam.getDeparture());
	}
	/**
	 * setDepartureDelay test
	 * @throws ParseException 
	 */
	@Test
	public void testSetDepartureDelay() throws ParseException{
		
		stationMetParam.setDepartureDelay(format.parse("12-12-2012"));
		assertEquals(format.parse("12-12-2012"),stationMetParam.getDepartureDelay());
	}
	
	/**
	 * Deze methode test de hashcode() van de de klasse Prijs
	 */
	@Test
	public void testHashcode() {
		station = stationMetParam;
		assertEquals(station.hashCode(), stationMetParam.hashCode());
	}
	/**
	 * Deze methode test de equals() van de klasse Prijs
	 */
	@Test
	public void testEquals() {
		station = stationMetParam;
		assertTrue(station.equals(stationMetParam));
	}
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void teardown() throws Exception {
		station = null;
		stationMetParam = null;
	}
	
}
