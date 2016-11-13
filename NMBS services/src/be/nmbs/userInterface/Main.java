package be.nmbs.userInterface;

<<<<<<< HEAD
=======
import java.util.ArrayList;

import be.nmbs.database.*;
import be.nmbs.logic.*;

>>>>>>> refs/heads/Sam
public class Main {
	public static void main(String[] args) {
<<<<<<< HEAD
		/*Date datum = new Date(2016, 11, 13);
		Date betaalDatum = new Date(2016, 11, 15);
		Boete boete = new Boete(1, 1, 10.30, datum, betaalDatum, false);
		Boete boete2 = new Boete(2, 2, 5.20, datum, betaalDatum, false);
=======
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
		Station station = new Station();
		Station startStation = new Station();
		Station eindStation = new Station();
		Date date = new Date("10/10/1010");
		startStation.setName("Midi");
		eindStation.setName("Noord");
		station.setName("Gent");
>>>>>>> refs/heads/Sam
		
		BoeteDAO dao = new BoeteDAO();
		
		//dao.insert(boete);
		//dao.insert(boete2);
		boete2.setBetaald(true);
		dao.updateBetaaldByKlantId(boete2);
		ArrayList<Boete> lijst = new ArrayList<Boete>();
		lijst = dao.getAll();
		
<<<<<<< HEAD
		for (Boete boete3 : lijst) {
			System.out.println("Betaald: " + boete3.isBetaald());
		}*/
=======
		for (Gebruiker g : gebruikers) {
			System.out.println("Gebruikersnaam: " + g.getAchternaam());
		}
>>>>>>> refs/heads/Sam
	}
}
