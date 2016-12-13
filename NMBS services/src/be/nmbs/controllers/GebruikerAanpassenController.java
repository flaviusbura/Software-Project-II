package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;
import be.nmbs.userInterface.GebruikerAanpassenView;
import be.nmbs.userInterface.GebruikerWijzigenView;
import be.nmbs.userInterface.View;

public class GebruikerAanpassenController {
	private static GebruikerDAO dao;
	
	public GebruikerAanpassenController(View view, Gebruiker gebruiker) {
		dao = new GebruikerDAO();
		
		GebruikerAanpassenView.getFirstName().setText(gebruiker.getVoornaam());
		GebruikerAanpassenView.getLastName().setText(gebruiker.getAchternaam());
		GebruikerAanpassenView.getUsername().setText(gebruiker.getUsername());
		
		// Vanaf RoleCombo alles nog toevoegen
		
     	GebruikerAanpassenView.getBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GebruikerWijzigenView.setGebruikerWijzigenControllerToNull();
				view.changeView(GebruikerWijzigenView.initialize(view));
			}
		});
	}
}