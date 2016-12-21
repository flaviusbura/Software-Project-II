package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.BasisprijsTicketDAO;
import be.nmbs.logic.TypeTicket;
import be.nmbs.userInterface.BasisPrijsTicket_UpdateView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;

public class BasisPrijsTicket_UpdateController {

	public BasisPrijsTicket_UpdateController(View view) {
		BasisPrijsTicket_UpdateView.getUpdatePrijs().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TypeTicket typeAboId = (TypeTicket) BasisPrijsTicket_UpdateView.getTypeLijst().getSelectedItem();

				double coeff = Double.parseDouble(BasisPrijsTicket_UpdateView.getTxtPrijs().getText());
				
				BasisprijsTicketDAO bptDAO = new BasisprijsTicketDAO();
				bptDAO.updatePrijs_ById(typeAboId.getId(), coeff);

				JOptionPane.showMessageDialog(view.getPanel(), "Prijs upgedate");

			}
		});

		BasisPrijsTicket_UpdateView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}

}
