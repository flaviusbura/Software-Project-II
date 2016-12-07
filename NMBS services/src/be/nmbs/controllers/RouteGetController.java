package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import be.nmbs.logic.Route;
import be.nmbs.tablemodels.RouteTableModel;
import be.nmbs.userInterface.RouteAskView;
import be.nmbs.userInterface.TrainGetView;
import be.nmbs.userInterface.RouteGetView;
import be.nmbs.userInterface.View;

public class RouteGetController {
	
	public RouteGetController(View view, ArrayList<Route> routes, String departureStation, String arrivalStation, Calendar departure) {
		if (routes != null) {
			RouteTableModel routeModel = new RouteTableModel();
	        routeModel.setRoutes(routes);
	        
	     	RouteGetView.getTable().setModel(routeModel);
	     	RouteGetView.getTable().setEnabled(true);
	     	RouteGetView.getTable().setVisible(true);
		}
		
		RouteGetView.getBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RouteGetView.getTable().setVisible(false);
				RouteAskView.setRouteAskControllerToNull();
				view.changeView(RouteAskView.initialize(view));
			}
		});
		
		RouteGetView.getTrain().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (RouteGetView.getTable().getSelectedRow() != -1) {
					int selectedRow = RouteGetView.getTable().getSelectedRow();
					String id = (String) RouteGetView.getTable().getValueAt(selectedRow, 3);
					if (id != "") {
						String[] idArray = id.split(" ");
						RouteGetView.getTable().setVisible(false);
						TrainGetView.setTrainGetControllerToNull();
						view.changeView(TrainGetView.initialize(view, idArray[1], departureStation, arrivalStation, departure));
					}
				}
			}
		});
	}
}