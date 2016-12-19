package be.nmbs.database;

import static org.junit.Assert.*;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Klant;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.Korting;
/**
 * 
 * @author Abdel-Portable
 *
 */
public class AbonnementDAOTest {

	private AbonnementDAO dao;
	private Abonnement abonnement1;
	private Abonnement abonnement2;
	private Abonnement abonnement3;
	
	Timestamp ts = new Timestamp(System.currentTimeMillis());
	private Klant klant= new Klant(3, "MyKlant", "MyKlant", 1, "0489245989", true);
	@SuppressWarnings("deprecation")
	Timestamp startDatum = new Timestamp(2016, 12, 01, 12, 12, 12,12);
	@SuppressWarnings("deprecation")
	Timestamp eindDatum = new Timestamp(2016, 12, 02, 12, 12, 12,12);
	Prijs prijs=new Prijs(1,"AbdelTest",99,"Test",true);
	Korting korting = new Korting(5, 0.5, "50% korting",true,"procent");
	/**
	 * Objecten declareren zodat we niet telken moeten hermaken
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		abonnement1 = new Abonnement(1, klant,1,"testroute",startDatum,eindDatum,prijs,korting,true);
		abonnement2 = new Abonnement(2, klant,2,"testroute",startDatum,eindDatum,prijs,korting,true);
		abonnement3 = new Abonnement(3, klant,3,"testroute",startDatum,eindDatum,prijs,korting,true);
		dao = new AbonnementDAO();
	}
	
	/**
	 * Deze methode gaat test of de methode insertDrieMaandAbonnement() van de klasse AbonnementDAO werkt
	 */
	@Test
	public void testInsert() {
		abonnement3 = dao.zoekAbonnement(abonnement1);
		assertTrue(abonnement1.getKlant().getAchternaam().equals(abonnement3.getKlant().getAchternaam()));	
	}
}
