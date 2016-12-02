package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.AbonnementView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.NieuwAbonnementAanmakenView;
import be.nmbs.userInterface.View;

public class AbonnementController {
	public AbonnementController(View view) {
		AbonnementView.getNieuwAboMaken().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NieuwAbonnementAanmakenView.setNieuwAbonnementAanmakenControllerToNull();
				view.changeView(NieuwAbonnementAanmakenView.initialize(view));
			}
		});
		
		AbonnementView.getHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
