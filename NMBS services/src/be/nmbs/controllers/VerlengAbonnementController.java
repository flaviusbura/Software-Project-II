package be.nmbs.controllers;

import be.nmbs.userInterface.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.AbonnementDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.VerlengAbonnementView;

//VerlengAbonnementView
public class VerlengAbonnementController {

	public VerlengAbonnementController(View view) {
		VerlengAbonnementView.getVerlengMaanden().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int aboId = VerlengAbonnementView.getTxtId().getX();
				AbonnementDAO aboDao = new AbonnementDAO();
				Abonnement abo = new Abonnement();
				abo = aboDao.getAll_ByID(aboId);

				String keuze = (String) VerlengAbonnementView.getCombo().getSelectedItem();

				if (keuze == "3 maanden") {
					aboDao.verlengAbonnementMetDrieMaand(abo);
					JOptionPane.showMessageDialog(view.getPanel(), "Abonnement verlengt met drie maanden");

				} else if (keuze == "6 maanden") {
					aboDao.verlengAbonnementMetZesMaand(abo);
					JOptionPane.showMessageDialog(view.getPanel(), "Abonnement verlengt met zes maanden");
				} else if (keuze == "9 maanden") {
					aboDao.verlengAbonnementMetNegenMaand(abo);
					JOptionPane.showMessageDialog(view.getPanel(), "Abonnement verlengt met negen maanden");

				} else if (keuze == "12 maanden") {
					aboDao.verlengAbonnementMetEenJaar(abo);
					JOptionPane.showMessageDialog(view.getPanel(), "Abonnement verlengt met een jaar");

				}
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