package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import be.nmbs.database.BoeteDAO;
import be.nmbs.database.TicketDAO;
import be.nmbs.logic.Boete;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.Station;

import be.nmbs.logic.Ticket;
import be.nmbs.userInterface.BoeteView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.LoginView;

import be.nmbs.userInterface.View;

public class BoeteController {
	public BoeteController(View view) {
		BoeteView.getBetaalBoete().addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				try {
				//double d = Double.parseDouble(TextField.getString()); 
				int boeteId = Integer.parseInt(BoeteView.getTxtBoeteId().getText());
				int klantContactId = Integer.parseInt(BoeteView.getTxtKlantContactId().getText());
				double prijs = Double.parseDouble(BoeteView.getTxtPrijs().getText());
				//datum omzetten
				String datum = BoeteView.getTxtDatum().getText();
				DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Date date = format.parse(datum);
				Long tijd = date.getTime();
				Timestamp ts = new Timestamp(tijd);
				
				//betaalDatum omzetten
				String betaalDatum = BoeteView.getTxtDatum().getText();
				DateFormat format2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Date date2 = format.parse(datum);
				Long tijd2 = date.getTime();
				Timestamp ts2 = new Timestamp(tijd);
				
				boolean betaald = Boolean.parseBoolean(BoeteView.getCbBetaald().getText());
				Boete boete = new Boete(boeteId,klantContactId,prijs,ts,ts2,betaald);
				BoeteDAO boetedao = new BoeteDAO();
				boetedao.updateBetaaldByKlantId(boete);
				JOptionPane.showMessageDialog(view.getPanel(), "Boete a");
				
				BoeteView.clearFields();
				//public Boete(int boeteId, int klantContactId,double prijs,Timestamp datum,Timestamp betaalDatum, boolean betaald)
				}catch (ParseException  e1)
				{
					e1.printStackTrace();
				}
			}
				
		});
BoeteView.getBack().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
						System.out.println("Gebruiker: " + View.getIngelogdGebruiker().getAchternaam());
						HomeView.setHomeControllerToNull();
						view.changeView(HomeView.initialize(view));
					}
				});
	
	}
}
