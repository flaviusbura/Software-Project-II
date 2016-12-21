package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.BasisprijsTicketDAO;
import be.nmbs.logic.BasisprijsTicket;
import be.nmbs.userInterface.BasisPrijsTicket_DelView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;

public class BasisPrijsTicket_DelController {
	public BasisPrijsTicket_DelController(View view) {

		BasisPrijsTicket_DelView.getDelPrijs().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Integer id = Integer.parseInt(BasisPrijsTicket_DelView.getTxtPrijs().getText());
				BasisprijsTicketDAO bptDao = new BasisprijsTicketDAO();
				BasisprijsTicket bpt = new BasisprijsTicket(id);
				bptDao.delete(bpt);
				JOptionPane.showMessageDialog(view.getPanel(), "Coefficient deleted");

			}

		});

		BasisPrijsTicket_DelView.getGoBackToHome().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	}
}
