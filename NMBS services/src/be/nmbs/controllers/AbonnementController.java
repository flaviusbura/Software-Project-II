package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.*;
import java.sql.*;

import be.nmbs.database.AbonnementDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Klant;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.userInterface.AbonnementView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

//AbonnementView
public class AbonnementController {
	public AbonnementController(View view) {

		AbonnementView.getMaakAbonnement().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {					
					//Klant klant = (Klant) AbonnementView.getKlantenLijst().getSelectedItem();
					//int klantId = klant.getContactId();
					Klant klanten = new Klant((String) AbonnementView.getCbxKlant_Contact().getSelectedItem(),(String) AbonnementView.getCbxKlant_Contact().getSelectedItem());
					
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
	
					Abonnement abonnement = new Abonnement(klanten.getContactId(), gebruikerId, route, ts, ts2, prijsId, kortingId, true);
					//System.out.println((klantId + " " + gebruikerId + " " + route + " "+ts +" "+  ts2 + " "+ prijsId + " " + " "+ kortingId + " "+ true));
					AbonnementDAO abonnementDao = new AbonnementDAO();
					abonnementDao.insertDrieMaandAbonnement(abonnement);

					JOptionPane.showMessageDialog(view.getPanel(), "Abonnement aangemaakt");

				} catch (ParseException e1) {
					e1.printStackTrace();
				}
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
				System.out.println("Gebruiker: " + View.getIngelogdGebruiker().getAchternaam());
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
