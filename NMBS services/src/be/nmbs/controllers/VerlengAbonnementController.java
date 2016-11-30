package be.nmbs.controllers;

import be.nmbs.userInterface.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.AbonnementDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Gebruiker;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.MaakAbonnementView;
import be.nmbs.userInterface.VerlengAbonnementView;

public class VerlengAbonnementController {

	public VerlengAbonnementController(View view) {
		VerlengAbonnementView.getVerleng3Maanden().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Abonnement Abonnement = (Abonnement)
				// VerlengAbonnementView.getAbonnementIDLijst().getSelectedItem();
				// Abonnement Abonnement = new
				// Abonnement(VerlengAbonnementView.getAbonnementIDLijst().getSelectedItem());
				
				Abonnement abonnement = (Abonnement) VerlengAbonnementView.getAbonnementLijst().getSelectedItem();
				int abonnementID = abonnement.getAbonnementId();
				AbonnementDAO abonnementDao = new AbonnementDAO();
				Abonnement abo = new Abonnement();
				abo = abonnementDao.getAll_ByID(abonnementID);
				abonnementDao.verlengAbonnementMetDrieMaand(abo);
				JOptionPane.showMessageDialog(view.getPanel(), "Abonnement verlengd met driee maanden");
			}
		});
		
		VerlengAbonnementView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}

}
