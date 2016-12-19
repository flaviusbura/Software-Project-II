package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.BasisPrijsAbonnementView;
import be.nmbs.userInterface.BasisPrijsAbonnement_AddView;
import be.nmbs.userInterface.BasisPrijsAbonnement_DelView;
import be.nmbs.userInterface.BasisPrijsAbonnement_UpdateView;
import be.nmbs.userInterface.BasisPrijsTicketView;
import be.nmbs.userInterface.BasisPrijsTicket_AddView;
import be.nmbs.userInterface.BasisPrijsTicket_DelView;
import be.nmbs.userInterface.BasisPrijsTicket_UpdateView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;
//BasisPrijsTicketView
public class BasisPrijsTicketController {


	public BasisPrijsTicketController(View view) {
		
		BasisPrijsTicketView.getDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsTicket_DelView.setBasisPrijsTicket_DelControllerToNull();
				BasisPrijsTicket_DelView.setHomeControllerToNull();
				//change here
				view.changeView(BasisPrijsTicket_DelView.initialize(view));
			}
		});
		
		BasisPrijsTicketView.getUpdate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsTicket_UpdateView.setBasisPrijsTicket_UpdateControllerToNull();
				BasisPrijsTicket_UpdateView.setHomeControllerToNull();
				//change here
				view.changeView(BasisPrijsTicket_UpdateView.initialize(view));
			}
		});
		BasisPrijsTicketView.getInsert().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsTicket_AddView.setBasisPrijsTicket_AddControllerToNull();
				BasisPrijsTicket_AddView.setHomeControllerToNull();
				view.changeView(BasisPrijsTicket_AddView.initialize(view));
			}
		});
		BasisPrijsTicketView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
