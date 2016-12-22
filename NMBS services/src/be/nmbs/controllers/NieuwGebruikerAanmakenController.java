package be.nmbs.controllers;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Hashing;

public class NieuwGebruikerAanmakenController {
	private final GebruikerDAO gebruikerDAO = new GebruikerDAO();
	
	public boolean addUser(Gebruiker g) {
		return gebruikerDAO.insert(g);
	}
	
	public String hashPassword(String password) {
		return Hashing.hashPaswoord(password);
	}
}