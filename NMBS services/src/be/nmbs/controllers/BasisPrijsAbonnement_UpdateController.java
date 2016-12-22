package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.BasisprijsAbonnementenDAO;
import be.nmbs.logic.TypeAbonnement;
import be.nmbs.userInterface.BasisPrijsAbonnement_UpdateView;
import be.nmbs.userInterface.CoefficientAbonnement_UpdateView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;
//BasisPrijsAbonnement_UpdateView
public class BasisPrijsAbonnement_UpdateController {
	public BasisPrijsAbonnement_UpdateController(View view) {
		BasisPrijsAbonnement_UpdateView.getUpdatePrijs().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TypeAbonnement typeAboId = (TypeAbonnement) BasisPrijsAbonnement_UpdateView.getTypeLijst()
						.getSelectedItem();

				double prijs = Double.parseDouble(BasisPrijsAbonnement_UpdateView.getTxtPrijs().getText());
				BasisprijsAbonnementenDAO bpaDao = new BasisprijsAbonnementenDAO();
			
				bpaDao.updatePrijs_ById(typeAboId.getId(), prijs);

				JOptionPane.showMessageDialog(view.getPanel(), "Prijs upgedate");

			}
		});

		BasisPrijsAbonnement_UpdateView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}
}
