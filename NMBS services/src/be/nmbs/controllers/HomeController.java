package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import be.nmbs.userInterface.AbonnementView;
import be.nmbs.userInterface.BoeteView;
import be.nmbs.userInterface.GebruikerView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.KlantenBeheerView;
import be.nmbs.userInterface.RouteSearchView;
import be.nmbs.userInterface.StatistiekView;
import be.nmbs.userInterface.LoginView;
import be.nmbs.userInterface.PrijsBeheerView;
import be.nmbs.userInterface.TicketView;
import be.nmbs.userInterface.TrainSearchView;
import be.nmbs.userInterface.VerlorenVoorwerpView;
import be.nmbs.userInterface.View;
import be.nmbs.database.PushDAO;

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
				RouteSearchView newView = new RouteSearchView();
				view.changeView(newView.initialize(view));
			}
		});
		
		HomeView.getBtnTrains().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TrainSearchView newView = new TrainSearchView();
				view.changeView(newView.initialize(view));
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
				view.changeView(TicketView.initialize(view));
			}
		});
		
		HomeView.getBtnVerlorenvoorwerpen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VerlorenVoorwerpView newView = new VerlorenVoorwerpView();
				view.changeView(newView.initialize(view));
			}
		});
		if (View.getIngelogdGebruiker().getRol() == 2) {
			HomeView.getBtnStatistieken().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					StatistiekView.setStatistiekControllerToNull();
					view.changeView(StatistiekView.initialize(view));
				}
			});
			
			HomeView.getGebruikersBeheer().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					GebruikerView.setGebruikerControllerToNull();
					view.changeView(GebruikerView.initialize(view));
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
		
		HomeView.getBtnPush().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				PushDAO pushdao = new PushDAO();
				try {
					pushdao.Push();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		
	}
}
