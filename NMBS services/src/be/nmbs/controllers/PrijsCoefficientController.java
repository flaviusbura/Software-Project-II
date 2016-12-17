package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.AbonnementView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.MaakAbonnementView;
import be.nmbs.userInterface.PrijsCoefficientView;
import be.nmbs.userInterface.PrijsCoefficient_AbonnementView;
import be.nmbs.userInterface.PrijsView;
import be.nmbs.userInterface.View;

public class PrijsCoefficientController {

	public PrijsCoefficientController(View view)
	{
		/*
		 * 
		 * AbonnementView.getMaakAbonnement().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MaakAbonnementView.setMaakAbonnementControllerToNull();
				MaakAbonnementView.setHomeControllerToNull();
				view.changeView(MaakAbonnementView.initialize(view));
			}
		});
		 */
		
		PrijsCoefficientView.getVoorAbo().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsCoefficient_AbonnementView.setPrijsCoefficient_AbonnementControllerToNull();
				PrijsCoefficient_AbonnementView.setHomeControllerToNull();
				view.changeView(PrijsCoefficient_AbonnementView.initialize(view));
			}
		});
		
		PrijsCoefficientView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
	
}
