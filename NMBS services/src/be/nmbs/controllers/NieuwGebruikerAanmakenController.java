package be.nmbs.controllers;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;

public class NieuwGebruikerAanmakenController {
	private final GebruikerDAO gebruikerDAO = new GebruikerDAO();
	
	public boolean addUser(Gebruiker g) {
		return gebruikerDAO.insert(g);
	}
}