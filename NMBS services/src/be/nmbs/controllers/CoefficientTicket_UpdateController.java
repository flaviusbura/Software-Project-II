package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.CoefficientTicketDAO;
import be.nmbs.logic.TypeTicket;
import be.nmbs.userInterface.CoefficientTicket_UpdateView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;

public class CoefficientTicket_UpdateController {

	public CoefficientTicket_UpdateController(View view) {
		CoefficientTicket_UpdateView.getUpdateCoeff().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TypeTicket typeAboId = (TypeTicket) CoefficientTicket_UpdateView.getTypeLijst().getSelectedItem();

				double coeff = Double.parseDouble(CoefficientTicket_UpdateView.getTxtCoeff().getText());
				CoefficientTicketDAO ctDao = new CoefficientTicketDAO();

				ctDao.updateCoefficient_ById(typeAboId.getId(), coeff);

				JOptionPane.showMessageDialog(view.getPanel(), "Coefficient upgedate");

			}
		});

		CoefficientTicket_UpdateView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}

}
