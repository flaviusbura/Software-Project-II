package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.CoefficientAbonnement_DelView;
import be.nmbs.userInterface.CoefficientTicket_AddView;
import be.nmbs.userInterface.CoefficientTicket_DelView;
import be.nmbs.userInterface.CoefficientTicket_UpdateView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.PrijsCoefficient_AbonnementView;
import be.nmbs.userInterface.PrijsCoefficient_TicketView;
import be.nmbs.userInterface.View;

//PrijsCoefficient_TicketView
public class PrijsCoefficient_TicketController {

	public PrijsCoefficient_TicketController(View view) {
		/*
		PrijsCoefficient_AbonnementView.getDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsCoefficient_AbonnementView.setPrijsCoefficient_AbonnementControllerToNull();;
				PrijsCoefficient_AbonnementView.setHomeControllerToNull();
				//change here
				view.changeView(CoefficientAbonnement_DelView.initialize(view));
			}
		});*/
		
		PrijsCoefficient_TicketView.getDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsCoefficient_TicketView.setPrijsCoefficient_TicketControllerToNull();

				// change here
				view.changeView(CoefficientTicket_DelView.initialize(view));
			}
		});

		PrijsCoefficient_TicketView.getUpdate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsCoefficient_TicketView.setPrijsCoefficient_TicketControllerToNull();

				// change here
				view.changeView(CoefficientTicket_UpdateView.initialize(view));
			}
		});
		PrijsCoefficient_TicketView.getInsert().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsCoefficient_TicketView.setPrijsCoefficient_TicketControllerToNull();

				view.changeView(CoefficientTicket_AddView.initialize(view));
			}
		});
		PrijsCoefficient_TicketView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}
}
