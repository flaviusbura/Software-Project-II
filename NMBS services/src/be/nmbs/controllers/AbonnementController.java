package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.AbonnementView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.View;

public class AbonnementController {
	public AbonnementController(View view) {
		System.out.println("abo1");
		AbonnementView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Gebruiker: " + View.getIngelogdGebruiker().getAchternaam());
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
