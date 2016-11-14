package be.nmbs.userInterface;

import be.nmbs.database.AbonnementDAO;
import be.nmbs.database.KlantDAO;
import be.nmbs.database.KortingDAO;
import be.nmbs.database.PrijsDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Klant;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;

public class Main {
	public static void main(String[] args) {
		KortingDAO dao = new KortingDAO();
		Korting korting = dao.getKorting(1);
		KlantDAO dao2 = new KlantDAO();
		Klant klant = dao2.getKlantById(1);
		String route = new String("string");
		String eindDatum = "einddatum";
		PrijsDAO dao3 = new PrijsDAO();
		Prijs prijs = dao3.getPrijsByPrijsId(1);
		Abonnement abonnement = new Abonnement(1, korting, true, klant, route, eindDatum, prijs);
		Abonnement abonnement2 = new Abonnement(2, korting, false, klant, route, eindDatum, prijs);
		
		AbonnementDAO daoAb = new AbonnementDAO();
		//daoAb.insert(abonnement);
		daoAb.insert(abonnement2);
		
		
	
	}
}
