package be.nmbs.logic;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TicketTest {

	private Ticket ticket;
	private Ticket ticketMetParam;
	Date date = new Date();
	Station station = new Station("bxl-zuid","2","3",date,date,date,date);
	Timestamp ts = new Timestamp(System.currentTimeMillis());

	/**
	 * Hier maken wij de objecten die wij nodig hebben 1 keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		ticket = new Ticket();
		Date date = new Date();
		Station stationTest = new Station("bxl-zuid","2","3",date,date,date,date);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ticketMetParam = new Ticket(1,stationTest,"groep",ts,2,true,stationTest,"omschrijving",1,1,stationTest,1);
	}
	
	/**
	 * Hier testen wij de default constructor
	 */
	@Test
	public void testDefaultConstructor() {
		assertNotNull(ticket);
		assertEquals(null, ticket.getStation());	
	}
		/**
		 * Deze methode test de constructor met parameters
		 */
		@Test
		public void testConstructorMetParameters() {
			assertNotNull(ticketMetParam);
			assertEquals(station, ticketMetParam.getStation());
			assertEquals(station, ticketMetParam.getEindStation());
			assertEquals(1, ticketMetParam.getGebruikerId());
			assertEquals(2, ticketMetParam.getKlas());
			assertEquals(1, ticketMetParam.getKortingId());
			assertEquals("omschrijving", ticketMetParam.getOmschrijving());
			assertEquals(1, ticketMetParam.getPrijsId());
			assertEquals("groep", ticketMetParam.getSoort());
			assertEquals(station, ticketMetParam.getStartStation());
			assertEquals(1, ticketMetParam.getTicket_id());
			assertEquals(ts, ticketMetParam.getTimestamp());
			assertEquals(true, ticketMetParam.isActief());
		}
		
		
		/**
		 * Deze methode gaat testen of het juiste station wordt teruggestuurd
		 */
		@Test
		public void testGetStation() {
			assertEquals(station, ticketMetParam.getStation());
		}
		
		/**
		 * Deze methode gaat testen of het juiste eindstation wordt teruggestuurd
		 */
		@Test
		public void testGetEindstation() {
			assertEquals(station, ticketMetParam.getEindStation());
		}
		/**
		 * Deze methode gaat testen of het juiste gebruiker Id wordt teruggestuurd
		 */
		@Test
		public void testGetGebruikerId() {
			assertEquals(1, ticketMetParam.getGebruikerId());		}
		/**
		 * Deze methode gaat testen of de juiste Klad wordt teruggestuurd
		 */
		@Test
		public void testGetKlas() {
			assertEquals(2, ticketMetParam.getKlas());		}
		/**
		 * Deze methode gaat testen of het juiste korting Id wordt teruggestuurd
		 */
		@Test
		public void testGetKortingId() {
			assertEquals(1, ticketMetParam.getKortingId());
		}
		/**
		 * Deze methode gaat testen of de juiste omschrijving wordt teruggestuurd
		 */
		@Test
		public void testGetOmschrijving() {
			assertEquals("omschrijving", ticketMetParam.getOmschrijving());		}
		/**
		 * Deze methode gaat testen of het juiste prijs Id wordt teruggestuurd
		 */
		@Test
		public void testGetPrijsId() {
			assertEquals(1, ticketMetParam.getPrijsId());		}
		/**
		 * Deze methode gaat testen of de juiste soort wordt teruggestuurd
		 */
		@Test
		public void testGetSoort() {
			assertEquals("groep", ticketMetParam.getSoort());		}
		/**
		 * Deze methode gaat testen of het juiste start station wordt teruggestuurd
		 */
		@Test
		public void testGetStartStation() {
			assertEquals(station, ticketMetParam.getStartStation());		}
		/**
		 * Deze methode gaat testen of het juiste ticket Id wordt teruggestuurd
		 */
		@Test
		public void testGetTicketId() {
			assertEquals(1, ticketMetParam.getTicket_id());		}
		/**
		 * Deze methode gaat testen of de juiste timestamp wordt teruggestuurd
		 */
		@Test
		public void testGetTimestamp() {
			assertEquals(ts, ticketMetParam.getTimestamp());		}
		/**
		 * Deze methode gaat testen of het juiste actief wordt teruggestuurd
		 */
		@Test
		public void testIsActief() {
			assertEquals(true, ticketMetParam.isActief());}		
		
		/**
		 * Deze methode gaat testen of setStation() werkt
		 */
		@Test
		public void testSetStation() {
			ticket.setStation(station);
			assertEquals(station, ticket.getStation());
		}
		/**
		 * Deze methode gaat testen of testSetEindStation() werkt
		 */
		@Test
		public void testSetEindStation() {
			ticket.setEindStation(station);
			assertEquals(station, ticket.getEindStation());
		}
		/**
		 * Deze methode gaat testen of setGebruikerId() werkt
		 */
		@Test
		public void testSetGebruikerId() {
			ticket.setGebruikerId(1);
			assertEquals(1, ticket.getGebruikerId());
		}
		/**
		 * Deze methode gaat testen of setKlas() werkt
		 */
		@Test
		public void testSetKlas() {
			ticket.setKlas(2);
			assertEquals(2, ticket.getKlas());
		}
		/**
		 * Deze methode gaat testen of setKortingId() werkt
		 */
		@Test
		public void testSetKortingId() {
			ticket.setKortingId(1);
			assertEquals(1, ticket.getKortingId());
		}
		/**
		 * Deze methode gaat testen of setOmschrijving() werkt
		 */
		@Test
		public void testSetOmschrijving() {
			ticket.setOmschrijving("omschrijving");
			assertEquals("omschrijving", ticket.getOmschrijving());
		}
		/**
		 * Deze methode gaat testen of setPrijsId() werkt
		 */
		@Test
		public void testSetPrijsId() {
			ticket.setPrijsId(1);
			assertEquals(1, ticket.getPrijsId());
		}
		/**
		 * Deze methode gaat testen of setSoort() werkt
		 */
		@Test
		public void testSetSoort() {
			ticket.setSoort("groep");
			assertEquals("groep", ticket.getSoort());
		}
		/**
		 * Deze methode gaat testen of setStartStation() werkt
		 */
		@Test
		public void testSetStartStation() {
			ticket.setStartStation(station);
			assertEquals(station, ticket.getStartStation());
		}
		/**
		 * Deze methode gaat testen of setTicket_id() werkt
		 */
		@Test
		public void testSetTicketId() {
			ticket.setTicket_id(1);
			assertEquals(1, ticket.getTicket_id());
		}
		/**
		 * Deze methode gaat testen of setTimestamp() werkt
		 */
		@Test
		public void testSetTimestamp() {
			ticket.setTimestamp(ts);
			assertEquals(ts, ticket.getTimestamp());
		}
		/**
		 * Deze methode tests de hashcode() van de klasse Ticket
		 */
		
		@Test
		public void testHashcode() {
			ticket = ticketMetParam;
			assertEquals(ticket.hashCode(), ticket.hashCode());
		}
		
		/**
		 * Deze methode tests de equals() van de klasse Ticket
		 */
		@Test
		public void testEquals() {
			ticket = ticketMetParam;
			assertTrue(ticket.equals(ticketMetParam));
		}
		
		/**
		 * Hier gebeurt de clean-up
		 * @throws Exception
		 */
		@After
		public void tearDown() throws Exception {
			ticket = null;
			ticketMetParam = null;
		}
}
