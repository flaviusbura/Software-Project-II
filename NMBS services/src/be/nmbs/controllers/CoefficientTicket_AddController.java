package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import be.nmbs.database.CoefficientTicketDAO;
import be.nmbs.logic.CoefficientTicket;
import be.nmbs.logic.TypeTicket;
import be.nmbs.userInterface.CoefficientTicket_AddView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;

//CoefficientTicket_AddView
public class CoefficientTicket_AddController {

	public CoefficientTicket_AddController(View view) {
		CoefficientTicket_AddView.getAddCoeff().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TypeTicket typeAboId = (TypeTicket) CoefficientTicket_AddView.getTypeLijst().getSelectedItem();
				double coeff = Double.parseDouble(CoefficientTicket_AddView.getTxtCoeff().getText());

				CoefficientTicket ct = new CoefficientTicket(typeAboId.getId(), coeff);
				CoefficientTicketDAO ctDao = new CoefficientTicketDAO();

				ctDao.insert(ct);
				JOptionPane.showMessageDialog(view.getPanel(), "Coefficient toegevoegd");

			}
		});

		CoefficientTicket_AddView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}
}
