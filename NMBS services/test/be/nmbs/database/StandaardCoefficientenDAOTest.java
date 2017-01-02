package be.nmbs.database;

import org.junit.Test;

import be.nmbs.logic.Gebruiker;

public class StandaardCoefficientenDAOTest {
	@Test
	public void test() {
		Gebruiker gebruiker = new Gebruiker(1, "test", "test", "testSpring", "test", 1, true);
		GebruikerDAO dao = new GebruikerDAO();
		dao.insert(gebruiker);
	}
}