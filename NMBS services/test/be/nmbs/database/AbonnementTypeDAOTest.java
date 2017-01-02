package be.nmbs.database;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbonnementTypeDAOTest {

	@Test
	public void test() {
		AbonnementTypeDAO dao = new AbonnementTypeDAO();
		dao.insertTypeAbonnement(1, "test");
		String type = dao.getTypeVanAbonnement(20);
		assertEquals("test", type);
	}

}
