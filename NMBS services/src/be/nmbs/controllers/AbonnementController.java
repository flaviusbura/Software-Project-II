package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import be.nmbs.userInterface.AbonnementView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.MaakAbonnementView;
import be.nmbs.userInterface.VerlengAbonnementView;
import be.nmbs.userInterface.View;

//AbonnementView
public class AbonnementController {
	public AbonnementController(View view) {

		AbonnementView.getMaakAbonnement().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MaakAbonnementView.setMaakAbonnement();
				MaakAbonnementView.setHomeControllerToNull();
				view.changeView(MaakAbonnementView.initialize(view));
			}
		});
		
		AbonnementView.getVerlengAbonnement().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VerlengAbonnementView.setVerlengAbonnementControllerToNull();
				VerlengAbonnementView.setHomeControllerToNull();
				view.changeView(VerlengAbonnementView.initialize(view));
			}
		});
		/*
		AbonnementView.getVerlengDrieMaanden().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {					
					Klant klant = (Klant) AbonnementView.getKlantenLijst().getSelectedItem();
					int klantId = klant.getContactId();
				
					
					Gebruiker gebruiker = (Gebruiker) AbonnementView.getGebruikerLijst().getSelectedItem();
					int gebruikerId = gebruiker.getId();
					String route = AbonnementView.getTxtRoute().getText();

					// startDatum omzetten
					String startDatum = AbonnementView.getTxtStartDatum().getText();
					DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					Date date = format.parse(startDatum);
					Long tijd = date.getTime();
					Timestamp ts = new Timestamp(tijd);

					// eindDatum omzetten
					
					String eindDatum = AbonnementView.getTxtStartDatum().getText();				
					Date date2 = format.parse(eindDatum);
					Long tijd2 = date2.getTime();
					Timestamp ts2 = new Timestamp(tijd2);
					
			
					//Gebruiker gebruiker = new Gebruiker((int) AbonnementView.getCbxGebruiker().getSelectedItem());
					Prijs prijs = (Prijs) AbonnementView.getPrijzenLijst().getSelectedItem();
					int prijsId = prijs.getPrijsId();

					Korting korting = (Korting) AbonnementView.getKortingLijst().getSelectedItem();
					int kortingId = korting.getId();
	
					Abonnement abonnement = new Abonnement(klantId, gebruikerId, route, ts, ts2, prijsId, kortingId, true);
					//System.out.println((klantId + " " + gebruikerId + " " + route + " "+ts +" "+  ts2 + " "+ prijsId + " " + " "+ kortingId + " "+ true));
					AbonnementDAO abonnementDao = new AbonnementDAO();
					abonnementDao.verlengAbonnementMetDrieMaand(abonnement);

					JOptionPane.showMessageDialog(view.getPanel(), "Abonnement aangemaakt");

				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
			*/
		AbonnementView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
