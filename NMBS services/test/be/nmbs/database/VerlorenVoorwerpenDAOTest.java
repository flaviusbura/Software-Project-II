package be.nmbs.database;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.VerlorenVoorwerp;
public class VerlorenVoorwerpenDAOTest {
	private VerlorenVoorwerp voorwerp;
	private VerlorenVoorwerp voorwerp2;
	private VerlorenVoorwerp voorwerp3;
	private VerlorenVoorwerpenDAO dao;
	private StationNMBS station;
	private StationNMBS station2;
	private StationNMBS station3;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben 1 keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		station = new StationNMBS("Brussel-Midi");
		station2 = new StationNMBS("Gent");
		station3 = new StationNMBS("Antwerpen-Centraal");
		dao = new VerlorenVoorwerpenDAO();
		voorwerp = new VerlorenVoorwerp(1, station, "MacBook Pro 13'", true);
		voorwerp2 = new VerlorenVoorwerp(2, station2, "Rode Boekentas", true);
		voorwerp3 = new VerlorenVoorwerp(3, station3, "Grijze iPhone", true);
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
		station2 = null;
		station3 = null;
		dao = null;
		voorwerp = null;
		voorwerp2 = null;
		voorwerp3 = null;
	}
}
