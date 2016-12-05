package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import be.nmbs.logic.Route;
import be.nmbs.tablemodels.RouteTableModel;
import be.nmbs.userInterface.RouteAskView;
import be.nmbs.userInterface.RouteGetView;
import be.nmbs.userInterface.View;

public class RouteGetController {
	
	public RouteGetController(View view, ArrayList<Route> routes) {
		if (routes != null) {
			RouteTableModel routeModel = new RouteTableModel();
	        routeModel.setRoute(routes.get(0));
	        
	     	RouteGetView.getTable().setModel(routeModel);
	     	RouteGetView.getTable().setVisible(true);
		}
		
		RouteGetView.getBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				RouteAskView.setRouteAskControllerToNull();
				view.changeView(RouteAskView.initialize(view));
			}
		});
	}
}