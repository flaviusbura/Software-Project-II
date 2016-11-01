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
		GebruikerDAO gebruikerDAO = new GebruikerDAO();
		Gebruiker gebruiker2 = new Gebruiker(2, "User", "User", "User", 1, true);
		gebruikerDAO.delete(gebruiker2);
		gebruikerDAO.updateWachtwoordById(gebruiker);
		ArrayList<Gebruiker> gebruikers = new ArrayList<>();
		gebruikers = gebruikerDAO.getAll();
		
		for (Gebruiker g : gebruikers) {
			System.out.println("Gebruikersnaam: " + g.getAchternaam());
		}
		
		

	}
}
