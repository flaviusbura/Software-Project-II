package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.PrijsCoefficientView;
import be.nmbs.userInterface.PrijsCoefficient_AbonnementView;
import be.nmbs.userInterface.PrijsCoefficient_TicketView;
import be.nmbs.userInterface.View;

public class PrijsCoefficientController {

	public PrijsCoefficientController(View view)
	{
		
		
		PrijsCoefficientView.getVoorAbo().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsCoefficient_AbonnementView.setPrijsCoefficient_AbonnementControllerToNull();
				view.changeView(PrijsCoefficient_AbonnementView.initialize(view));
			}
		});
		
		PrijsCoefficientView.getVoorTicket().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsCoefficient_TicketView.setPrijsCoefficient_TicketControllerToNull();
				view.changeView(PrijsCoefficient_TicketView.initialize(view));
			}
		});
		
		PrijsCoefficientView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}
	
}
