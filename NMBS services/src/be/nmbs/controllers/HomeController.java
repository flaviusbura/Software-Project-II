package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.AbonnementView;
import be.nmbs.userInterface.BoeteView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.LoginView;
import be.nmbs.userInterface.TicketView;
import be.nmbs.userInterface.VerlorenvoorwerpView;
import be.nmbs.userInterface.View;

public class HomeController {
	public HomeController(View view) {
		HomeView.getBtnAbonnement().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbonnementView.setAbonnementControllerToNull();
				AbonnementView.setHomeControllerToNull();
				view.changeView(AbonnementView.initialize(view));
			}
		});
		
		HomeView.getBtnBoete().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BoeteView.setBoeteControllerToNull();
				BoeteView.setHomeControllerToNull();
				view.changeView(BoeteView.initialize(view));
			}
		});
		HomeView.getLogOut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(LoginView.initialize(view));
			}
		});
		
		HomeView.getBtnTicket().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				TicketView.setTicketControllerToNull();
			//	TicketView.setHomeControllerToNull();
				view.changeView(TicketView.initialize(view));
				
			}
		});
		
		HomeView.getBtnVerlorenvoorwerpen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				VerlorenvoorwerpView.setVerlorenvoorwerpControllerToNull();
				//VerlorenvoorwerpView.setHomeControllerToNull();
				view.changeView(VerlorenvoorwerpView.initialize(view));
				
			}
		});
		
		
	}
}
