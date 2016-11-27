package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.KlantDAO;
import be.nmbs.logic.Klant;
import be.nmbs.userInterface.KlantWijzigenView;
import be.nmbs.userInterface.TelefoonWijzigenView;
import be.nmbs.userInterface.View;

public class TelefoonWijzigenController {
	private int contactId = 0;
	private KlantDAO klantDAO;
	private Klant klant;
	public TelefoonWijzigenController(View view) {
		TelefoonWijzigenView.getTelefoonWijzigen().addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				String voornaam = TelefoonWijzigenView.getVoornaamText().getText();
				String naam = TelefoonWijzigenView.getNaamText().getText();
				klantDAO = new KlantDAO();
				contactId = klantDAO.getContactIdOpNaamEnVoornaam(voornaam, naam);
				klant = new Klant();
				klant.setContactId(contactId);
				klant.setTelefoon(TelefoonWijzigenView.getNieuweTelefoonText().getText());
				klantDAO.updateTelefoonByContactId(klant);
				JOptionPane optionPane = new JOptionPane();
				optionPane.showMessageDialog(null, "Telefoon gewijzigd!");
				KlantWijzigenView.setKlantWijzigenControllerToNull();
				view.changeView(KlantWijzigenView.initialize(view));
			}
		});
		
		TelefoonWijzigenView.getActieAnnuleren().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KlantWijzigenView.setKlantWijzigenControllerToNull();
				view.changeView(KlantWijzigenView.initialize(view));
			}
		});
	}
}
