package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.BoeteDAO;

import be.nmbs.userInterface.BoeteView;
import be.nmbs.userInterface.HomeView;

import be.nmbs.userInterface.View;

public class BoeteController {
	public BoeteController(View view) {
		BoeteView.getBetaalBoete().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int boeteId = 0;
				if (!BoeteView.getTxtBoeteId().getText().isEmpty()) {
					try {
						boeteId = Integer.parseInt(BoeteView.getTxtBoeteId().getText());
					} catch (NumberFormatException e1) {
						boeteId = 0;
					}
				}
					

				boolean betaald = BoeteView.getCbBetaald().isSelected();
				BoeteDAO boetedao = new BoeteDAO();
				if (boeteId == 0 || boetedao.getBoeteIdBy_BoeteId(boeteId) == 0) {
					javax.swing.JOptionPane.showMessageDialog(null, "Geef aub een bestaand ID in.");
				} else {
					boetedao.updateBetaaldByBoeteId(boeteId, betaald);
					JOptionPane.showMessageDialog(view.getPanel(), "Boete betaald.");
				}
			}

		});

		BoeteView.getBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});

	}
}
