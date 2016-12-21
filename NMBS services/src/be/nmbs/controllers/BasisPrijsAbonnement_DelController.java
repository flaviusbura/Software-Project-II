package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.BasisprijsAbonnementenDAO;
import be.nmbs.logic.BasisprijsAbonnement;
import be.nmbs.userInterface.BasisPrijsAbonnement_DelView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;
//BasisPrijsAbonnement_DelView
public class BasisPrijsAbonnement_DelController {

	public BasisPrijsAbonnement_DelController(View view) {
		BasisPrijsAbonnement_DelView.getDelPrijs().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(BasisPrijsAbonnement_DelView.getTxtPrijs().getText());
				BasisprijsAbonnementenDAO bpaDao = new BasisprijsAbonnementenDAO();
				BasisprijsAbonnement bpa = new BasisprijsAbonnement(id);
					
				bpaDao.delete(bpa);

				JOptionPane.showMessageDialog(view.getPanel(), "Prijs deleted");

			}

		});

		BasisPrijsAbonnement_DelView.getGoBackToHome().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}
}
