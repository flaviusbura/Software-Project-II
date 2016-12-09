package be.nmbs.controllers;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import be.nmbs.database.BoeteDAO;
import be.nmbs.database.TicketDAO;
import be.nmbs.logic.Boete;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.Station;

import be.nmbs.logic.Ticket;
import be.nmbs.userInterface.BoeteView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.LoginView;

import be.nmbs.userInterface.View;

public class BoeteController {
	public BoeteController(View view) {
		BoeteView.getBetaalBoete().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int boeteId = Integer.parseInt(BoeteView.getTxtBoeteId().getText());

				boolean betaald = BoeteView.getCbBetaald().isSelected();
				BoeteDAO boetedao = new BoeteDAO();
				while (boetedao.getBoeteIdBy_BoeteId(boeteId) == 0) {
					javax.swing.JOptionPane.showMessageDialog(null,"Please enter an existing ID");
					JFrame frame = new JFrame("InputDialog Example #1");
					boeteId = Integer.parseInt(JOptionPane.showInputDialog(frame, "Try again"));
					
				}
				boetedao.updateBetaaldByBoeteId(boeteId, betaald);
				JOptionPane.showMessageDialog(view.getPanel(), "Boete betaald");

			}

		});

		BoeteView.getBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Gebruiker: " + View.getIngelogdGebruiker().getAchternaam());
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});

	}
}
