package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

				//change here
				view.changeView(BasisPrijsTicket_DelView.initialize(view));
			}
		});
		
		BasisPrijsTicketView.getUpdate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsTicket_UpdateView.setBasisPrijsTicket_UpdateControllerToNull();
				
				//change here
				view.changeView(BasisPrijsTicket_UpdateView.initialize(view));
			}
		});
		BasisPrijsTicketView.getInsert().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsTicket_AddView.setBasisPrijsTicket_AddControllerToNull();
				view.changeView(BasisPrijsTicket_AddView.initialize(view));
			}
		});
		BasisPrijsTicketView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}
}
