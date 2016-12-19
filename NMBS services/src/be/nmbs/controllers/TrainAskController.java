package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.TrainAskView;
import be.nmbs.userInterface.TrainGetView;
import be.nmbs.userInterface.View;

public class TrainAskController {	
	public TrainAskController(View view) {
		
		TrainAskView.getBtnZoeken().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TrainGetView.setTrainGetControllerToNull();
				
				String id = TrainAskView.getTrainField().getText();
				
				view.changeView(TrainGetView.initialize(view, id));
			}
		});
		
		TrainAskView.getHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}