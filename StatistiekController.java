package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import be.nmbs.userInterface.HomeView;

import be.nmbs.userInterface.StatistiekView;
import be.nmbs.userInterface.View;

public class StatistiekController {
	public StatistiekController(View view) {

		StatistiekView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
