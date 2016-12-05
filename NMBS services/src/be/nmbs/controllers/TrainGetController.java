package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.logic.Trein;
import be.nmbs.tablemodels.TrainTableModel;
import be.nmbs.userInterface.TrainAskView;
import be.nmbs.userInterface.TrainGetView;
import be.nmbs.userInterface.View;

public class TrainGetController {
	
	public TrainGetController(View view, Trein train) {
		if (train != null) {
			TrainTableModel trainModel = new TrainTableModel();
	        trainModel.setTrain(train);
	        
	     	TrainGetView.getTable().setModel(trainModel);
	     	TrainGetView.getTable().setVisible(true);
		}
		
		TrainGetView.getBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				TrainAskView.setTrainAskControllerToNull();
				view.changeView(TrainAskView.initialize(view));
			}
		});
	}
}