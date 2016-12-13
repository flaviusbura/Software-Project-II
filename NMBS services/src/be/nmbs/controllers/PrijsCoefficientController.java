package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.PrijsCoefficientView;
import be.nmbs.userInterface.PrijsView;
import be.nmbs.userInterface.View;

public class PrijsCoefficientController {

	public PrijsCoefficientController(View view)
	{
		
		PrijsCoefficientView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
	
}
