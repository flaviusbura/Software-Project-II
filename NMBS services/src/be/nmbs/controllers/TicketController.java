package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import be.nmbs.database.TicketDAO;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.Ticket;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.TicketView;
import be.nmbs.userInterface.View;

public class TicketController {

	public TicketController(View view) {
		TicketView.getBtnKoopTicket().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
				// String startstation = (String) TicketView.getBeginstationlijst().getSelectedItem();
					StationNMBS startstation = new StationNMBS((String) TicketView.getBeginstationlijst().getSelectedItem());
					String soort = TicketView.getTxtSoort().getText();
					String datum = TicketView.getTxtDatum().getText();
					
					DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					Date date = format.parse(datum);
					Long tijd = date.getTime();
					Timestamp ts = new Timestamp(tijd);
					int klas =  Integer.parseInt(TicketView.getTxtKlasse().getText());
					
					StationNMBS eindstation = new StationNMBS((String) TicketView.getEindstationlijst().getSelectedItem());
				//	String eindstation = (String) TicketView.getEindstationlijst().getSelectedItem();
					String omschrijving = TicketView.getTxtOmschrijving().getText();
					
					Prijs prijs = (Prijs) TicketView.getPrijzenlijst().getSelectedItem();
					int prijsId = prijs.getPrijsId();
					
					Korting korting = (Korting) TicketView.getKortinglijst().getSelectedItem();
					int kortingId = korting.getId();
					StationNMBS station = new StationNMBS((String) TicketView.getStationlijst().getSelectedItem());
					int gebruikerId = View.getIngelogdGebruiker().getId();
					
					Ticket ticket = new Ticket(startstation,soort,ts,klas,true,eindstation,omschrijving,prijsId,kortingId,station,gebruikerId);
					TicketDAO ticketdao = new TicketDAO();
					ticketdao.insert(ticket);
					JOptionPane.showMessageDialog(view.getPanel(), "Ticket aangemaakt");
					
					TicketView.clearFields();
					
				}catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

		});
		
		TicketView.getBtnVorigScherm().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
