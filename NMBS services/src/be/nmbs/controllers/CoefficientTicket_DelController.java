package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.CoefficientTicketDAO;
import be.nmbs.logic.CoefficientTicket;
import be.nmbs.userInterface.CoefficientTicket_DelView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;
//CoefficientTicket_DelView
public class CoefficientTicket_DelController {

	public CoefficientTicket_DelController(View view) {

		CoefficientTicket_DelView.getDelCoeff().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Integer id = Integer.parseInt(CoefficientTicket_DelView.getTxtCoeff().getText());
				CoefficientTicketDAO ctDao = new CoefficientTicketDAO();
				CoefficientTicket ct = new CoefficientTicket(id);
				ctDao.delete(ct);
				JOptionPane.showMessageDialog(view.getPanel(), "Coefficient deleted");

			}

		});

		CoefficientTicket_DelView.getGoBackToHome().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
