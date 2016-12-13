package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.AbonnementView;
import be.nmbs.userInterface.BoeteView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.KlantenBeheerView;
import be.nmbs.userInterface.RouteAskView;
import be.nmbs.userInterface.LoginView;
import be.nmbs.userInterface.PrijsBeheerView;
import be.nmbs.userInterface.TicketView;
import be.nmbs.userInterface.TrainAskView;
import be.nmbs.userInterface.VerlorenvoorwerpView;
import be.nmbs.userInterface.View;

public class HomeController {
	public HomeController(View view) {
		HomeView.getBtnAbonnement().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbonnementView.setAbonnementControllerToNull();
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
		
		HomeView.getBtnRoutes().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RouteAskView.setRouteAskControllerToNull();
				view.changeView(RouteAskView.initialize(view));
			}
		});
		
		HomeView.getBtnTrains().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TrainAskView.setTrainAskControllerToNull();
				view.changeView(TrainAskView.initialize(view));
			}
		});
		
		HomeView.getLogOut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(LoginView.initialize(view));
			}
		});
		
		HomeView.getKlantenBeheer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KlantenBeheerView.setKlantenBeheerControllerToNull();
				view.changeView(KlantenBeheerView.initialize(view));
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
		
		HomeView.getPrijzenBeheer().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsBeheerView.setPrijsBeheerControllerToNull();
				view.changeView(PrijsBeheerView.initialize(view));
				
			}
		});
		
	}
}
