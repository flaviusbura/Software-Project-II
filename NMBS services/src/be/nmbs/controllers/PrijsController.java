package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.MaakAbonnementView;
import be.nmbs.userInterface.PrijsView;
import be.nmbs.userInterface.View;

public class PrijsController {
//PrijsView
	public PrijsController(View view)
	{
		
		PrijsView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
	
	
}
