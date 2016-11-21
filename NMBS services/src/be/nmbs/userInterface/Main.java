package be.nmbs.userInterface;

import java.sql.Timestamp;
import java.util.ArrayList;

import be.nmbs.controllers.LoginController;
import be.nmbs.database.AbonnementDAO;
import be.nmbs.database.GebruikerDAO;
import be.nmbs.database.KlantDAO;
import be.nmbs.database.KortingDAO;
import be.nmbs.database.PrijsDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Klant;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;

public class Main {
	public static void main(String[] args) {

		LoginController lc = new LoginController();

		/*
		 * Klant klant = new Klant(); klant.setContactId(1); Prijs prijs = new
		 * Prijs(); prijs.setPrijs_id(1); Korting korting = new Korting(1, 1,
		 * "iets", true, "type"); Abonnement abonnement = new Abonnement(1,
		 * klant, 21, "Brussel-Gent", prijs, korting, true); AbonnementDAO dao =
		 * new AbonnementDAO(); //dao.insertDrieMaandAbonnement(abonnement);
		 * abonnement.setAbonnementId(24);
		 * dao.verlengAbonnementMetDrieMaand(abonnement); //Timestamp timestamp
		 * = dao.getEindDatum(abonnement);
		 */

		/*Klant klant = new Klant(1, "Flavius", "Bura", 1, "0489245923", true);
		Klant klant2 = new Klant(1, "Klant", "Klant", 1, "0489245924", true);

		KlantDAO dao = new KlantDAO();

		dao.insert(klant);
		dao.insert(klant2);

		ArrayList<Klant> lijst = new ArrayList<>();

		lijst = dao.getAll();

		for (Klant k : lijst) {
			System.out.println("Klantnaam: " + k.getAchternaam());
		}*/
		
		
	}	
}
