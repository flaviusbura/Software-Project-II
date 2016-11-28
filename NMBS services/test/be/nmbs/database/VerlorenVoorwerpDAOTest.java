package be.nmbs.database;

import static org.junit.Assert.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.nmbs.logic.Klant;
import be.nmbs.logic.Station;
import be.nmbs.logic.VerlorenVoorwerp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VerlorenVoorwerpDAOTest {

	private VerlorenVoorwerpenDAO dao;
	private VerlorenVoorwerp verlorenVoorwerp1;
	private VerlorenVoorwerp verlorenVoorwerp2;
	private VerlorenVoorwerp verlorenVoorwerp3;
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	private Station station;
	
		/**
	 * Hier maken wij de objecten die wij nodig hebben één keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		verlorenVoorwerp1 = new VerlorenVoorwerp(1,station,"Test",true);
		verlorenVoorwerp2 = new VerlorenVoorwerp(2,station,"Test2",true);
		verlorenVoorwerp3 = new VerlorenVoorwerp(3,station,"Test3",true);
		
		dao = new VerlorenVoorwerpenDAO();
	}
	
	/**
	 * Deze methode test of de methode insert() werkt
	 */

	/**
	 * Deze methode gaat test of hiermee alle gebruikers kunnen opgevraagt worden
	 */
	/*
	@Test
	public void testGetAll() {
		ArrayList<Klant> lijst = new ArrayList<Klant>();
		lijst = dao.getAll();
		
		assertTrue(klant.equals(lijst.get(0)));
		assertTrue(klant2.equals(lijst.get(1)));
	}
	*/
	
	
	@Test
	public void testGetAll() {
		ArrayList<VerlorenVoorwerp> lijst = new ArrayList<VerlorenVoorwerp>();
		lijst = dao.getAll();
		assertTrue(verlorenVoorwerp1.equals(lijst.get(0)));
		assertTrue(verlorenVoorwerp2.equals(lijst.get(1)));
		
		
	}

	/**
	 *Deze methode gaat testen of het wachtwood van een gebruiker gewijzigd wordt
	 */
	@Test
	public void testUpdateActief() {
		verlorenVoorwerp1.setActief(true);
		dao.updateActief(verlorenVoorwerp1);
		verlorenVoorwerp3 = dao.getById(verlorenVoorwerp1.getId());
		assertEquals(true,verlorenVoorwerp3.isActief());
	}
	
	
	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		verlorenVoorwerp1 = null;
		verlorenVoorwerp2 = null;
		verlorenVoorwerp3 = null;
		dao = null;
	}

}
