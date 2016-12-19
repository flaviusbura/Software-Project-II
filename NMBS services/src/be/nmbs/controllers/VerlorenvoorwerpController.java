package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import be.nmbs.database.VerlorenVoorwerpenDAO;
import be.nmbs.logic.VerlorenVoorwerp;
import be.nmbs.tablemodels.VerlorenvoorwerpTableModel;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.NieuwVerlorenvoorwerpView;
import be.nmbs.userInterface.VerlorenvoorwerpView;
import be.nmbs.userInterface.View;

public class VerlorenvoorwerpController {
	 @SuppressWarnings("unused")
	private static boolean ALLOW_COLUMN_SELECTION = false;
	 @SuppressWarnings("unused")
	private static boolean ALLOW_ROW_SELECTION = true;
	
	private static VerlorenVoorwerpenDAO verlorenvoorwerpdao;

	public VerlorenvoorwerpController(View view) {
		verlorenvoorwerpdao = new VerlorenVoorwerpenDAO();
		
		VerlorenvoorwerpView.getBtnZoekOmschrijving().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        String oms = VerlorenvoorwerpView.getTxtType().getText();
		        
		        ArrayList<VerlorenVoorwerp> allVerlorenvoorwerp = verlorenvoorwerpdao.getAllOpSoortLike(oms);
		        
		        VerlorenvoorwerpTableModel verlorenvoorwerpTableModel = new VerlorenvoorwerpTableModel();
		        verlorenvoorwerpTableModel.setVoorwerpen(allVerlorenvoorwerp);
		        
		     	VerlorenvoorwerpView.getTabel().setModel(verlorenvoorwerpTableModel);
		     	VerlorenvoorwerpView.getTabel().setVisible(true); 	
			}
		});
			
		VerlorenvoorwerpView.getBtnVorigScherm().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
		
		VerlorenvoorwerpView.getBtnNieuwVerlorenvoorwerp().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
					JOptionPane.showMessageDialog(null, "Kies een voorwerp in de tabel dat je wilt terug geven en dus uit de inventaris halen");
				}
			
				verlorenvoorwerpdao.updateActief(voorwerpID);
				String oms = VerlorenvoorwerpView.getTxtType().getText();
			      
			        
		        ArrayList<VerlorenVoorwerp> allVerlorenvoorwerp = verlorenvoorwerpdao.getAllOpSoort(oms);
		        
		        VerlorenvoorwerpTableModel verlorenvoorwerpTableModel = new VerlorenvoorwerpTableModel();
		        verlorenvoorwerpTableModel.setVoorwerpen(allVerlorenvoorwerp);
		        
		        
		     	VerlorenvoorwerpView.getTabel().setModel(verlorenvoorwerpTableModel);
		     	VerlorenvoorwerpView.getTabel().setVisible(true);
		     	VerlorenvoorwerpView.clearFields();
			}		
		});
	}
}
