package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.BasisPrijsAbonnementView;
import be.nmbs.userInterface.BasisPrijsTicketView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.MaakAbonnementView;
import be.nmbs.userInterface.PrijsCoefficientView;
import be.nmbs.userInterface.PrijsCoefficient_AbonnementView;
import be.nmbs.userInterface.PrijsCoefficient_TicketView;
import be.nmbs.userInterface.PrijsView;
import be.nmbs.userInterface.View;

public class PrijsController {
//PrijsView
	public PrijsController(View view)
	{
		PrijsView.getVoorAbo().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsView.setPrijsControllerToNull();
				view.changeView(BasisPrijsAbonnementView.initialize(view));
			}
		});
		
		PrijsView.getVoorTicket().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsView.setPrijsControllerToNull();
				view.changeView(BasisPrijsTicketView.initialize(view));
			}
		});
		
		PrijsView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}
	
	
}
