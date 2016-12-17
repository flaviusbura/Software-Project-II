package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.logic.ApiCaller;
import be.nmbs.logic.Trein;
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
				
				if (!TrainAskView.getTrainField().getText().isEmpty()) {
				String id = TrainAskView.getTrainField().getText();
				
				Trein train = ApiCaller.getTreinInfo(id);
				
				if (train != null)
					view.changeView(TrainGetView.initialize(view, id, train));
				else
					JOptionPane.showMessageDialog(null, "Geen trein gevonden.");
				} else
					JOptionPane.showMessageDialog(null, "Geen trein gevonden.");
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