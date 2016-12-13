package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.PrijsBeheerView;
import be.nmbs.userInterface.PrijsCoefficientView;
import be.nmbs.userInterface.PrijsView;
import be.nmbs.userInterface.View;

public class PrijsBeheerController {
	
	//PrijsBeheerView
	public PrijsBeheerController(View view) {

		PrijsBeheerView.getPrijs().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsView.setPrijsControllerToNull();
				PrijsView.setHomeControllerToNull();
				view.changeView(PrijsView.initialize(view));
			}
		});
		
		PrijsBeheerView.getCoefficient().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsCoefficientView.setPrijsCoefficientControllerToNull();
				PrijsCoefficientView.setHomeControllerToNull();
				view.changeView(PrijsCoefficientView.initialize(view));
			}
		});
		
		PrijsBeheerView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
