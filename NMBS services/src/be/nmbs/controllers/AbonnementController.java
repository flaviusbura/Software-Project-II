package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import be.nmbs.userInterface.AbonnementView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.MaakAbonnementView;
import be.nmbs.userInterface.VerlengAbonnementView;
import be.nmbs.userInterface.View;

//AbonnementView
public class AbonnementController {
	public AbonnementController(View view) {

		AbonnementView.getMaakAbonnement().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MaakAbonnementView.setMaakAbonnementControllerToNull();
				view.changeView(MaakAbonnementView.initialize(view));
			}
		});
		
		AbonnementView.getVerlengAbonnement().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VerlengAbonnementView.setVerlengAbonnementControllerToNull();
				VerlengAbonnementView.setHomeControllerToNull();
				view.changeView(VerlengAbonnementView.initialize(view));
			}
		});
		
		AbonnementView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
