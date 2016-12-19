package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.BasisprijsAbonnementenDAO;
import be.nmbs.database.CoefficientAbonnementDAO;
import be.nmbs.logic.BasisprijsAbonnement;
import be.nmbs.logic.CoefficientAbonnement;
import be.nmbs.logic.TypeAbonnement;
import be.nmbs.userInterface.BasisPrijsAbonnement_AddView;
import be.nmbs.userInterface.CoefficientAbonnement_AddView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;
//BasisPrijsAbonnement_AddView
public class BasisPrijsAbonnement_AddController {
	public BasisPrijsAbonnement_AddController(View view)
	{
		BasisPrijsAbonnement_AddView.getAddPrijs().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TypeAbonnement typeAboId = (TypeAbonnement) BasisPrijsAbonnement_AddView.getTypeLijst().getSelectedItem();
				double prijs = Double.parseDouble(BasisPrijsAbonnement_AddView.getTxtPrijs().getText());
				BasisprijsAbonnement bpa = new BasisprijsAbonnement(typeAboId.getId(),prijs);
				BasisprijsAbonnementenDAO bpaDao = new BasisprijsAbonnementenDAO();
				bpaDao.insert(bpa);
				JOptionPane.showMessageDialog(view.getPanel(), "Prijs toegevoegd");
				
				}
		}); 
		
		
		BasisPrijsAbonnement_AddView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
