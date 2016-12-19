package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.BasisprijsTicketDAO;
import be.nmbs.logic.BasisprijsTicket;
import be.nmbs.logic.TypeTicket;
import be.nmbs.userInterface.BasisPrijsTicket_AddView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;
//BasisPrijsTicket_AddView
public class BasisPrijsTicket_AddController {

	public BasisPrijsTicket_AddController(View view) {
		BasisPrijsTicket_AddView.getAddPrijs().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TypeTicket typeAboId = (TypeTicket) BasisPrijsTicket_AddView.getTypeLijst().getSelectedItem();
				double prijs = Double.parseDouble(BasisPrijsTicket_AddView.getTxtPrijs().getText());

				BasisprijsTicket bpt = new BasisprijsTicket(typeAboId.getId(), prijs);
				BasisprijsTicketDAO bptDao = new BasisprijsTicketDAO();

				bptDao.insert(bpt);
				JOptionPane.showMessageDialog(view.getPanel(), "Prijs toegevoegd");

			}
		});

		BasisPrijsTicket_AddView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}

}
