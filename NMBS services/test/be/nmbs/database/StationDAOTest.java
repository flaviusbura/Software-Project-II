package be.nmbs.database;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.nmbs.logic.StationNMBS;

public class StationDAOTest {
	private ArrayList<StationNMBS> stations;
	private StationDAO dao;

	/**
	 * Hier maken wij de objecten die wij nodig hebben 1 keer aan zodat wij die
	 * niet telkens in elke test opnieuw moeten aanmaken
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		stations = new ArrayList<>();
		dao = new StationDAO();
	}

	/**
	 * Deze meyhode gaat testen of alle stations gevraagd en ontvangen worden
	 * van de database.
	 */
	@Test
	public void testGetAll() {
		stations = dao.getAll();
		//Ik weet dat op de database 645 stations zijn ingevoerd
		assertEquals(645, stations.size());
	}

	/**
	 * Hier gebeurt de clean-up
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dao = null;
		stations = null;
	}
}
