package be.nmbs.userInterface;

import java.sql.Date;
import java.util.ArrayList;

import be.nmbs.database.VerlorenVoorwerpenDAO;
import be.nmbs.logic.VerlorenVoorwerp;

public class Main {
	public static void main(String[] args) {
		Date datum = new Date(2016, 11, 13);
		VerlorenVoorwerp verlorenVoorwerp = new VerlorenVoorwerp(1, "Midi", "MacBook", datum, true);
		VerlorenVoorwerp verlorenVoorwerp2 = new VerlorenVoorwerp(2, "Gent", "MSI", datum, true);
		
		VerlorenVoorwerpenDAO dao = new VerlorenVoorwerpenDAO();
		
		//dao.insert(verlorenVoorwerp);
		//dao.insert(verlorenVoorwerp2);
		
		ArrayList<VerlorenVoorwerp> lijst = new ArrayList<VerlorenVoorwerp>();
		lijst = dao.getAll();
		
		for (VerlorenVoorwerp voorwerp : lijst) {
			System.out.println("Voorwerp: " + voorwerp.getOmschrijving());
		}
	}
}
