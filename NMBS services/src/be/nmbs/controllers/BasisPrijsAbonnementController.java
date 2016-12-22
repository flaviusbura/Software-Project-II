package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.BasisPrijsAbonnementView;
import be.nmbs.userInterface.BasisPrijsAbonnement_AddView;
import be.nmbs.userInterface.BasisPrijsAbonnement_DelView;
import be.nmbs.userInterface.BasisPrijsAbonnement_UpdateView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;
//BasisPrijsAbonnementView
public class BasisPrijsAbonnementController {

	public BasisPrijsAbonnementController(View view) {
		BasisPrijsAbonnementView.getDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsAbonnement_DelView.setBasisPrijsAbonnement_DelControllerToNull();

				//change here
				view.changeView(BasisPrijsAbonnement_DelView.initialize(view));
			}
		});
		
		BasisPrijsAbonnementView.getUpdate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsAbonnement_UpdateView.setBasisPrijsAbonnement_UpdateControllerToNull();

				//change here
				view.changeView(BasisPrijsAbonnement_UpdateView.initialize(view));
			}
		});
		BasisPrijsAbonnementView.getInsert().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsAbonnementView.setBasisPrijsAbonnementControllerToNull();

				view.changeView(BasisPrijsAbonnement_AddView.initialize(view));
			}
		});
		BasisPrijsAbonnementView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}

}
