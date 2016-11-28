package be.nmbs.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import be.nmbs.database.TicketDAO;
import be.nmbs.database.VerlorenVoorwerpenDAO;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.Ticket;
import be.nmbs.logic.VerlorenVoorwerp;
import be.nmbs.tablemodels.VerlorenvoorwerpTableModel;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.TicketView;
import be.nmbs.userInterface.VerlorenvoorwerpView;
import be.nmbs.userInterface.View;

public class VerlorenvoorwerpController {
	 private static  boolean ALLOW_COLUMN_SELECTION = false;
	 private static boolean ALLOW_ROW_SELECTION = true;
	 private static VerlorenVoorwerpenDAO verlorenvoorwerpdao;
	

	public VerlorenvoorwerpController(View view) {
		
		verlorenvoorwerpdao = new VerlorenVoorwerpenDAO();
		VerlorenvoorwerpView.getBtnZoekOmschrijving().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					
				System.out.println("knop geduwt");
				
		        String oms = VerlorenvoorwerpView.getTxtType().getText();
		        System.out.println(oms);
		        
		        ArrayList<VerlorenVoorwerp> allVerlorenvoorwerp = verlorenvoorwerpdao.getAllOpSoort(oms);
		        
		        VerlorenvoorwerpTableModel verlorenvoorwerpTableModel = new VerlorenvoorwerpTableModel();
		        verlorenvoorwerpTableModel.setVoorwerpen(allVerlorenvoorwerp);
		        
		        
		     	VerlorenvoorwerpView.getTabel().setModel(verlorenvoorwerpTableModel);
		     	VerlorenvoorwerpView.getTabel().setVisible(true);
		     	
			}
		});
		
		
		VerlorenvoorwerpView.getBtnVorigScherm().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
						System.out.println("Gebruiker: " + View.getIngelogdGebruiker().getAchternaam());
						HomeView.setHomeControllerToNull();
						view.changeView(HomeView.initialize(view));
					}
				});
	
	}

}
