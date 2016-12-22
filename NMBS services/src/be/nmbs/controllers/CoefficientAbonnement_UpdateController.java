package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.CoefficientAbonnementDAO;
import be.nmbs.logic.TypeAbonnement;
import be.nmbs.userInterface.CoefficientAbonnement_UpdateView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;

//CoefficientAbonnement_UpdateView
public class CoefficientAbonnement_UpdateController {

	public CoefficientAbonnement_UpdateController(View view) {
		CoefficientAbonnement_UpdateView.getUpdateCoeff().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TypeAbonnement typeAboId = (TypeAbonnement) CoefficientAbonnement_UpdateView.getTypeLijst()
						.getSelectedItem();

				double coeff = Double.parseDouble(CoefficientAbonnement_UpdateView.getTxtCoeff().getText());
				CoefficientAbonnementDAO caDao = new CoefficientAbonnementDAO();
			
				caDao.updateCoefficient_ById(typeAboId.getId(), coeff);

				JOptionPane.showMessageDialog(view.getPanel(), "Coefficient upgedate");

			}
		});

		CoefficientAbonnement_UpdateView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}

}
