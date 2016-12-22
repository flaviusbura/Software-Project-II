package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.CoefficientAbonnementDAO;
import be.nmbs.logic.CoefficientAbonnement;
import be.nmbs.logic.TypeAbonnement;
import be.nmbs.userInterface.CoefficientAbonnement_AddView;
import be.nmbs.userInterface.HomeView; 
import be.nmbs.userInterface.View;
//CoefficientAbonnement_AddView
public class CoefficientAbonnement_AddController {
	
	public CoefficientAbonnement_AddController(View view)
	{
		CoefficientAbonnement_AddView.getAddCoeff().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TypeAbonnement typeAboId = (TypeAbonnement) CoefficientAbonnement_AddView.getTypeLijst().getSelectedItem();
				double coeff = Double.parseDouble(CoefficientAbonnement_AddView.getTxtCoeff().getText());
				
				CoefficientAbonnement ca = new CoefficientAbonnement(typeAboId.getId(),coeff);
				CoefficientAbonnementDAO caDao = new CoefficientAbonnementDAO();
				
				caDao.insert(ca);
				JOptionPane.showMessageDialog(view.getPanel(), "Coefficient toegevoegd");
				
				}
		}); 
		
		
		CoefficientAbonnement_AddView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}

}
