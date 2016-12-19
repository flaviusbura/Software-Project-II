package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.CoefficientAbonnementDAO;
import be.nmbs.logic.CoefficientAbonnement;
import be.nmbs.userInterface.CoefficientAbonnement_DelView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;
//CoefficientAbonnement_DelView
public class CoefficientAbonnement_DelController {

	public CoefficientAbonnement_DelController(View view) {

		CoefficientAbonnement_DelView.getDelCoeff().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Integer id = Integer.parseInt(CoefficientAbonnement_DelView.getTxtCoeff().getText());
				CoefficientAbonnementDAO caDao = new CoefficientAbonnementDAO();
				CoefficientAbonnement ca = new CoefficientAbonnement(id);
				
				caDao.delete(ca);
	
				JOptionPane.showMessageDialog(view.getPanel(), "Coefficient deleted");

			}

		});

		CoefficientAbonnement_DelView.getGoBackToHome().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}

}
