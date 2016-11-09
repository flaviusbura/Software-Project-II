package be.nmbs.userInterface;

import java.util.ArrayList;

import be.nmbs.database.*;
import be.nmbs.logic.*;

public class Main {
	public static void main(String[] args) {
		/*Gebruiker gebruiker = new Gebruiker(1, "Flavius", "Bura", "password", 1, true);
		Gebruiker gebruiker2 = new Gebruiker(2, "User", "User", "User", 1, true);
	    gebruikerDAO.insert(gebruiker);
		gebruikerDAO.insert(gebruiker2);*/
		Gebruiker gebruiker = new Gebruiker(1, "Flavius", "Bura", "veranderd", 1, true);
		//Gebruiker gebruiker3 = new Gebruiker(2, "Sam", "Leirens", "samL", 1, true);
		GebruikerDAO gebruikerDAO = new GebruikerDAO();
		//Gebruiker gebruiker2 = new Gebruiker(3, "User", "User", "User", 1, true);
		//gebruikerDAO.insert(gebruiker3);
		//gebruikerDAO.insert(gebruiker2);
		//gebruikerDAO.delete(gebruiker2);
		gebruikerDAO.updateWachtwoordById(gebruiker);
		ArrayList<Gebruiker> gebruikers = new ArrayList<>();
		gebruikers = gebruikerDAO.getAll();
		
		for (Gebruiker g : gebruikers) {
			System.out.println("Gebruikersnaam: " + g.getAchternaam());
		}
		
		Klant klant = new Klant(1, "Flavius", "Bura", 1, "0478593920", true);
		//Klant klant2 = new Klant(2, "Voornaam", "Achternaam", 1, "0473892093", true);
		KlantDAO klantDAO = new KlantDAO();
		
		//klantDAO.insert(klant2);
		//klantDAO.insert(klant);
		//klantDAO.delete(klant2);
		klantDAO.updateTelefoonByContactId(klant);
		ArrayList<Klant> klanten = new ArrayList<Klant>();
		klanten = klantDAO.getAll();
		
		for (Klant klant3 : klanten) {
			System.out.println("Achternaam: " + klant3.getAchternaam());
		}
	}
}
