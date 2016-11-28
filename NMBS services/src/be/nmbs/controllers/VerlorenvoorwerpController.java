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
				
				final String[] columnNames = {"Voorwerp ID",
                        "station",
                        "omschrijving",
                        "datum"};

		        
		        String oms = VerlorenvoorwerpView.getTxtType().getText();
		        System.out.println(oms);
		        ArrayList<VerlorenVoorwerp> allVerlorenvoorwerp = verlorenvoorwerpdao.getAllOpSoort(oms);
		        
		        final Object[][] data = new Object[allVerlorenvoorwerp.size()][4];
		        
		        for(int i = 0;i<allVerlorenvoorwerp.size();i++) {
		        	
		        data[i][0] = allVerlorenvoorwerp.get(i).getId();
		        data[i][1] = allVerlorenvoorwerp.get(i).getStation().getNaam();
		        data[i][2] = allVerlorenvoorwerp.get(i).getOmschrijving();
		        data[i][3] = allVerlorenvoorwerp.get(i).getTimestamp();
					
				}
		        
		 
		        final JTable table = new JTable(data, columnNames);
		        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		        table.setFillsViewportHeight(true);
		 
		        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        if (ALLOW_ROW_SELECTION) { // true by default
		            ListSelectionModel rowSM = table.getSelectionModel();
		            rowSM.addListSelectionListener(new ListSelectionListener() {
		                public void valueChanged(ListSelectionEvent e) {
		                    //Ignore extra messages.
		                    if (e.getValueIsAdjusting()) return;
		 
		                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		                    if (lsm.isSelectionEmpty()) {
		                        System.out.println("No rows are selected.");
		                    } else {
		                        int selectedRow = lsm.getMinSelectionIndex();
		                        System.out.println("Row " + selectedRow
		                                           + " is now selected.");
		                    }
		                }
		            });
		        } else {
		            table.setRowSelectionAllowed(false);
		        }
		        
		     VerlorenvoorwerpView.getPanel().add(table);
					//VerlorenvoorwerpView.clearFields();
			
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
