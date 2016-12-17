package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.CoefficientAbonnement_AddView;
import be.nmbs.userInterface.CoefficientAbonnement_UpdateView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.PrijsCoefficient_AbonnementView;
import be.nmbs.userInterface.View;

public class PrijsCoefficient_AbonnementController {

	public PrijsCoefficient_AbonnementController(View view) {
		
		PrijsCoefficient_AbonnementView.getDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsCoefficient_AbonnementView.setPrijsCoefficient_AbonnementControllerToNull();;
				PrijsCoefficient_AbonnementView.setHomeControllerToNull();
				//change here
				view.changeView(PrijsCoefficient_AbonnementView.initialize(view));
			}
		});
		
		PrijsCoefficient_AbonnementView.getUpdate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsCoefficient_AbonnementView.setPrijsCoefficient_AbonnementControllerToNull();;
				PrijsCoefficient_AbonnementView.setHomeControllerToNull();
				//change here
				view.changeView(CoefficientAbonnement_UpdateView.initialize(view));
			}
		});
		PrijsCoefficient_AbonnementView.getInsert().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsCoefficient_AbonnementView.setPrijsCoefficient_AbonnementControllerToNull();;
				PrijsCoefficient_AbonnementView.setHomeControllerToNull();
				view.changeView(CoefficientAbonnement_AddView.initialize(view));
			}
		});
		PrijsCoefficient_AbonnementView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}

}
