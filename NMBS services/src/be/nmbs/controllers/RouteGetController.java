package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.logic.ApiCaller;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.RouteAskView;
import be.nmbs.userInterface.RouteGetView;
import be.nmbs.userInterface.View;

public class RouteGetController {
	
	public RouteGetController(View view) {
		RouteGetView.getBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RouteAskView.setRouteAskControllerToNull();
				view.changeView(RouteAskView.initialize(view));
			}
		});
	}
}