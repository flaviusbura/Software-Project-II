package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import be.nmbs.database.VerlorenVoorwerpenDAO;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.VerlorenVoorwerp;
import be.nmbs.tablemodels.VerlorenvoorwerpTableModel;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.LoginView;
import be.nmbs.userInterface.NieuwVerlorenvoorwerpView;
import be.nmbs.userInterface.TicketView;
import be.nmbs.userInterface.VerlorenvoorwerpView;
import be.nmbs.userInterface.View;

public class NieuwVerlorenvoorwerpController {
	 private static VerlorenVoorwerpenDAO verlorenvoorwerpdao;
	 private static VerlorenVoorwerp voorwerp;
	
	public NieuwVerlorenvoorwerpController(View view) {
		
		verlorenvoorwerpdao = new VerlorenVoorwerpenDAO();
		JOptionPane optionPane = new JOptionPane();
		NieuwVerlorenvoorwerpView.getBtnToevoegen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {

					StationNMBS station = new StationNMBS((String) NieuwVerlorenvoorwerpView.getCbStation().getSelectedItem());
					String omschrijving = NieuwVerlorenvoorwerpView.getTxtOmschrijving().getText();
					String type = NieuwVerlorenvoorwerpView.getTxtType().getText();
					String datum = NieuwVerlorenvoorwerpView.getTxtDatum().getText();
					
					
					DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					Date date;
					date = format.parse(datum);
					Long tijd = date.getTime();
					Timestamp ts = new Timestamp(tijd);
					
					
					voorwerp = new VerlorenVoorwerp(station,omschrijving,type,ts,true);
					
					verlorenvoorwerpdao.insert(voorwerp);
					JOptionPane.showMessageDialog(null, "nieuw verlorenvoorwerp toegevoegt");
					NieuwVerlorenvoorwerpView.clearFields();
					
					
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
		
		     	
			}
		});
		
	
		NieuwVerlorenvoorwerpView.getBtnTerug().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println("Gebruiker: " + View.getIngelogdGebruiker().getAchternaam());
				VerlorenvoorwerpView.setVerlorenvoorwerpControllerToNull();
				view.changeView(VerlorenvoorwerpView.initialize(view));

		     	
			}
		});
	}

}
