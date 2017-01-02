package be.nmbs.database;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.VerlorenVoorwerp;

public class VerlorenVoorwerpenDAOTest {
	private VerlorenVoorwerp voorwerp;
	private VerlorenVoorwerpenDAO dao;
	private StationNMBS station;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben 1 keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		station = new StationNMBS("Brussel-Midi");
		dao = new VerlorenVoorwerpenDAO();
		voorwerp = new VerlorenVoorwerp(1, station, "MacBook Pro 13'", true);
	}

	@Test
	public void testInsert() {
		dao.updateActief(32);
		voorwerp = dao.getById(32);
		assertFalse(voorwerp.isActief());
	}

	/**
	 * Hier gebeurt de clean-up
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		station = null;
		dao = null;
		voorwerp = null;
	}
}
