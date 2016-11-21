package be.nmbs.userInterface;

import java.sql.Timestamp;

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

	//LoginController lc = new LoginController();
	
//	Gebruiker gebruiker = new Gebruiker();
//	gebruiker.setUsername("Sam");
//	gebruiker.setWachtwoord("xd");
//	GebruikerDAO gebruikerDao = new GebruikerDAO();
//	Gebruiker gebruiker2 = new Gebruiker();
//	gebruiker2 = gebruikerDao.getGebruikerOpUsername("Sam");
//	System.out.println(gebruiker2.getId());
		Klant klant = new Klant();
		klant.setContactId(1);
		Prijs prijs = new Prijs();
		prijs.setPrijs_id(1);
		Korting korting = new Korting(1, 1, "iets", true, "type");
		Abonnement abonnement = new Abonnement(1, klant, 21, "Brussel-Gent", prijs, korting, true);
		AbonnementDAO dao = new AbonnementDAO();
		//dao.insertDrieMaandAbonnement(abonnement);
		abonnement.setAbonnementId(24);
		dao.verlengAbonnementMetDrieMaand(abonnement);
		//Timestamp timestamp = dao.getEindDatum(abonnement);
	}
}
