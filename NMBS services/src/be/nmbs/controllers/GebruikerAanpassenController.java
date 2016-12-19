package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Hashing;
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
		GebruikerAanpassenView.getRoleCombo().addItem("Bediende");
		GebruikerAanpassenView.getRoleCombo().addItem("Admin");
		
		if (gebruiker.getRol() == 1)
			GebruikerAanpassenView.getRoleCombo().setSelectedIndex(0);
		else
			GebruikerAanpassenView.getRoleCombo().setSelectedIndex(1);
		
		if (gebruiker.isActief())
			GebruikerAanpassenView.getActive().setSelected(true);
		
		GebruikerAanpassenView.getSave().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Gebruiker g = dao.getGebruikerOpUsername(GebruikerAanpassenView.getFirstName().getText());
				
				if (g != null && g.getId() != gebruiker.getId())
					JOptionPane.showMessageDialog(null, "ERROR: Gebruikersnaam al in gebruik.");
				else {
					g = new Gebruiker();
					g.setId(gebruiker.getId());
					g.setVoornaam(GebruikerAanpassenView.getFirstName().getText());
					g.setAchternaam(GebruikerAanpassenView.getLastName().getText());
					g.setUsername(GebruikerAanpassenView.getUsername().getText());
					
					if (!GebruikerAanpassenView.getPassword().getText().isEmpty()) {
						try {
							g.setWachtwoord(Hashing.hashPaswoord(GebruikerAanpassenView.getPassword().getText()));
						} catch (NoSuchAlgorithmException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else
						g.setWachtwoord(gebruiker.getWachtwoord());
					
					if (GebruikerAanpassenView.getRoleCombo().getSelectedIndex() == 0)
						g.setRol(1);
					else
						g.setRol(2);
					
					g.setActief(GebruikerAanpassenView.getActive().isSelected());
					
					if (dao.update(g) != 9999) {
						JOptionPane.showMessageDialog(null, "Gebruiker is succesvol aangepast!");
						GebruikerWijzigenView.setGebruikerWijzigenControllerToNull();
						view.changeView(GebruikerWijzigenView.initialize(view));
					} else
						JOptionPane.showMessageDialog(null, "Er is iets foutgegaan bij het opslaan van de gebruiker.");
				}
			}
		});
		
     	GebruikerAanpassenView.getBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GebruikerWijzigenView.setGebruikerWijzigenControllerToNull();
				view.changeView(GebruikerWijzigenView.initialize(view));
			}
		});
	}
}