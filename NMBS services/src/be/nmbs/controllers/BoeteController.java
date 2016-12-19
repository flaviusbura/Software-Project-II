package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
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

				Integer boeteId = Integer.parseInt(BoeteView.getTxtBoeteId().getText());

				boolean betaald = BoeteView.getCbBetaald().isSelected();
				BoeteDAO boetedao = new BoeteDAO();
				while (boetedao.getBoeteIdBy_BoeteId(boeteId) == 0 ) {

					try {
						javax.swing.JOptionPane.showMessageDialog(null, "Please enter an existing ID");
						JFrame frame = new JFrame("InputDialog Example #1");
						boeteId = Integer.parseInt(JOptionPane.showInputDialog(frame, "Try again"));

					} catch (NumberFormatException e1) {
						boeteId = 0;
					}
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
