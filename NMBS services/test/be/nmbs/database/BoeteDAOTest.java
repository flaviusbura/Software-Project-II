package be.nmbs.database;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import be.nmbs.logic.Boete;
import be.nmbs.logic.Klant;

public class BoeteDAOTest {
	private Boete boete1;
	private Boete boete2;
	private Boete boete3;
	private BoeteDAO dao;
	private ArrayList<Boete> all;
	
	/**
	 * Hier maken wij de objecten die wij nodig hebben 1 keer aan zodat wij die niet telkens
	 * in elke test opnieuw moeten aanmaken
	 * @throws Exception
	 */
	
	@Before
	public void setUp() throws Exception {
		// klantenID's moeten overeen komen met een klant in de database!
		boete1 = new Boete(10, 7, 5,false);
		boete2 = new Boete(20,7, 7,true);
		boete3 = new Boete(30, 7, 7.5,false);
		dao = new BoeteDAO();
	}
	/**
	 * Deze methode gaat test of de methode insert() van de klasse BoeteDAO werkt
	 */
	@Test
	public void testInsert() {
		dao.insert(boete1);
		dao.insert(boete2);
		dao.insert(boete3);
		
		all = dao.getAll();
		for(int i=0;i<all.size();i++){
			System.out.println(all.get(i).getBoeteId());
		}
		
	}
	
	/**
	 * Deze methode gaat test of de methode updateBetaald() van de klasse BoeteDAO werkt
	 */
	@Test
	public void testUpdateBetaald() {
		boete1.setBetaald(true);
		dao.updateBetaaldByKlantId(boete1);
		all = dao.getAll();
		for(int i=0;i<all.size();i++){
			System.out.println(all.get(i).getBoeteId() + " betaald:" + all.get(i).isBetaald());
		}
		
		
	}

}
