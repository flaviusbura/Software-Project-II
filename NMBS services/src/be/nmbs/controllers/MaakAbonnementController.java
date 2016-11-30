package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import be.nmbs.database.AbonnementDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Klant;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.StationNMBS;
import be.nmbs.userInterface.MaakAbonnementView;
import be.nmbs.userInterface.TicketView;
import be.nmbs.userInterface.HomeView;

import be.nmbs.userInterface.View;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

//MaakAbonnementView
public class MaakAbonnementController {
	public MaakAbonnementController(View view) {

		MaakAbonnementView.getMaakAbonnement().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				
					
					//StationNMBS startstation = new StationNMBS((String) TicketView.getBeginstationlijst().getSelectedItem());
					//int s_n = (Integer) jComboBoxSN.getSelectedItem();
					//Gebruiker gebruiker = new Gebruiker((Integer) MaakAbonnementView.getGebruikerLijst().getSelectedItem());
					
					Klant klanten = (Klant) MaakAbonnementView.getKlantenLijst().getSelectedItem();
					int klantId = klanten.getContactId();
					
					Gebruiker gebruiker = (Gebruiker) MaakAbonnementView.getGebruikerLijst().getSelectedItem();
					int gebruikerId = gebruiker.getId();
					String route = MaakAbonnementView.getTxtRoute().getText();

					// startDatum omzetten
					String startDatum = MaakAbonnementView.getTxtStartDatum().getText();
					DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					Date date = format.parse(startDatum);
					Long tijd = date.getTime();
					Timestamp ts = new Timestamp(tijd);

					// eindDatum omzetten

					String eindDatum = MaakAbonnementView.getTxtStartDatum().getText();
					Date date2 = format.parse(eindDatum);
					Long tijd2 = date2.getTime();
					Timestamp ts2 = new Timestamp(tijd2);

				
					Prijs prijs = (Prijs) MaakAbonnementView.getPrijzenLijst().getSelectedItem();
					int prijsId = prijs.getPrijsId();

					Korting korting = (Korting) MaakAbonnementView.getKortingLijst().getSelectedItem();
					int kortingId = korting.getId();

					Abonnement abonnement = new Abonnement(klantId, gebruikerId, route, ts, ts2, prijsId,
							kortingId, true);
					AbonnementDAO abonnementDao = new AbonnementDAO();
					//System.out.println(klanten.getContactId()+" "+gebruikerId+" "+route+" "+ts+" "+ts2+" "+prijsId+" "+kortingId);
					abonnementDao.insertDrieMaandAbonnement(abonnement);
					
					JOptionPane.showMessageDialog(view.getPanel(), "Abonnement aangemaakt");

				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});

		MaakAbonnementView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
