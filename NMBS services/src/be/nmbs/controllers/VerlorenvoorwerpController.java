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
import be.nmbs.userInterface.KlantWijzigenView;
import be.nmbs.userInterface.NieuwVerlorenvoorwerpView;
import be.nmbs.userInterface.TicketView;
import be.nmbs.userInterface.VerlorenvoorwerpView;
import be.nmbs.userInterface.View;

public class VerlorenvoorwerpController {
	 private static  boolean ALLOW_COLUMN_SELECTION = false;
	 private static boolean ALLOW_ROW_SELECTION = true;
	 private static VerlorenVoorwerpenDAO verlorenvoorwerpdao;
	 JOptionPane optionPane = new JOptionPane();

	public VerlorenvoorwerpController(View view) {
		
		verlorenvoorwerpdao = new VerlorenVoorwerpenDAO();
		VerlorenvoorwerpView.getBtnZoekOmschrijving().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					
				
				
		        String oms = VerlorenvoorwerpView.getTxtType().getText();
		      
		        
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
		
		
		
		VerlorenvoorwerpView.getBtnNieuwVerlorenvoorwerp().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				//	NieuwVerlorenvoorwerpView.setVerlorenvoorwerpControllerToNull();
					
					view.changeView(NieuwVerlorenvoorwerpView.initialize(view));
					}
				});
		
		
		
		VerlorenvoorwerpView.getBtnTerugGegeven().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int row = VerlorenvoorwerpView.getTabel().getSelectedRow();
				int voorwerpID = 0;
				try {
					voorwerpID = (int) VerlorenvoorwerpView.getTabel().getModel().getValueAt(row, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Kies een voorwerp in de tabel die je wilt terug geven en dus uit de inventaris halen");
				}
			
					
				
				verlorenvoorwerpdao.updateActief(voorwerpID);
				 String oms = VerlorenvoorwerpView.getTxtType().getText();
			      
			        
			        ArrayList<VerlorenVoorwerp> allVerlorenvoorwerp = verlorenvoorwerpdao.getAllOpSoort(oms);
			        
			        VerlorenvoorwerpTableModel verlorenvoorwerpTableModel = new VerlorenvoorwerpTableModel();
			        verlorenvoorwerpTableModel.setVoorwerpen(allVerlorenvoorwerp);
			        
			        
			     	VerlorenvoorwerpView.getTabel().setModel(verlorenvoorwerpTableModel);
			     	VerlorenvoorwerpView.getTabel().setVisible(true);
				}
					
				});
		
		
	
	
	}

}
