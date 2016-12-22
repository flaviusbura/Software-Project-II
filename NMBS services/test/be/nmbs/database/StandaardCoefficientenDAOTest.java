package be.nmbs.database;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.nmbs.logic.Gebruiker;

public class StandaardCoefficientenDAOTest {

	/*@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
*/
	@Test
	public void test() {
		Gebruiker gebruiker = new Gebruiker(1, "test", "test", "testSpring", "test", 1, true);
		GebruikerDAO dao = new GebruikerDAO();
		dao.insert(gebruiker);
	}

}
