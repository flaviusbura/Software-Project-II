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
					
					//StationNMBS startstation = new StationNMBS((String) TicketView.getBeginstationlijst().getSelectedItem());
					
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
					
					Timestamp ts2 = new Timestamp(tijd);
					Calendar cal = Calendar.getInstance();
					cal.setTimeInMillis(ts2.getTime());
					cal.add(Calendar.MONTH,3);
					Timestamp verlengDrieMaanden = new Timestamp(cal.getTime().getTime());
					
					// test boven
					//Gebruiker gebruiker = new Gebruiker((int) AbonnementView.getCbxGebruiker().getSelectedItem());
					Prijs prijs = (Prijs) AbonnementView.getPrijzenLijst().getSelectedItem();
					int prijsId = prijs.getPrijsId();

					Korting korting = (Korting) AbonnementView.getKortingLijst().getSelectedItem();
					int kortingId = korting.getId();
	
					Abonnement abonnement = new Abonnement(klantId, gebruikerId, route, ts, verlengDrieMaanden, prijsId, kortingId, true);
					AbonnementDAO abonnementDao = new AbonnementDAO();
					abonnementDao.verlengAbonnementMetDrieMaand(abonnement);

					JOptionPane.showMessageDialog(view.getPanel(), "Abonnement aangemaakt");

				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});

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
