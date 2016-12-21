package be.nmbs.database;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.nmbs.logic.Korting;

public class KortingDAOTest {
	private Korting korting;
	private Korting korting2;
	private Korting korting3;
	private KortingDAO dao;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben 1 keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		
		korting = new Korting(50,2,"oms",true,"typ");
		korting2 = new Korting(2,2,"oms",true,"typ");
		korting3 = new Korting(3,2,"oms",true,"typ");
		dao = new KortingDAO();
	}

	/**
	 * Deze methode gaat test of de methode getKorting() van de klasse KortingDAO werkt
	 */
	@Test
	public void testGetKorting() {

		
		korting3 = dao.getKorting(korting.getId());
		assertTrue(korting.getTypeKorting().equals(korting3.getTypeKorting()));
		korting3 = dao.getKorting(korting2.getId());
		assertTrue(korting2.getTypeKorting().equals(korting3.getTypeKorting()));
	}
	/**
	 * Deze test gaat de methode update() testen om te zien als de wijzigingen 
	 * op de database gebeuren
	 */
	@Test
	public void TestUpdate() {
	
		korting.setOmschrijving("swag");
		dao.update(korting);
		korting3 = dao.getKorting(korting.getId());
		assertTrue(korting.getOmschrijving().equals(korting3.getOmschrijving()));
	}

	/**
	 * Hier gebeurt de clean-up
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		korting = null;
		korting2 = null;
		korting3 = null;
		dao = null;
	}
}
