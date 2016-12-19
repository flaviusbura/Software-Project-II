package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JOptionPane;

import be.nmbs.logic.ApiCaller;
import be.nmbs.logic.Route;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.RouteAskView;
import be.nmbs.userInterface.RouteGetView;
import be.nmbs.userInterface.View;

public class RouteAskController {	
	public RouteAskController(View view) {
		
		RouteAskView.getBtnZoeken().addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				RouteGetView.setRouteGetControllerToNull();
				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1"));
				
				// Filtering out text na '/' 
				int iend = RouteAskView.getDepartureField().getSelectedItem().toString().indexOf("/");
				
				String departure;
				if (iend != -1) {
					departure = RouteAskView.getDepartureField().getSelectedItem().toString().substring(0 , iend);
				} else {
					departure = RouteAskView.getDepartureField().getSelectedItem().toString();
				}
				
				iend = RouteAskView.getArrivalField().getSelectedItem().toString().indexOf("/");
				
				String arrival;
				if (iend != -1) {
					arrival = RouteAskView.getArrivalField().getSelectedItem().toString().substring(0 , iend);
				} else {
					arrival = RouteAskView.getArrivalField().getSelectedItem().toString();
				}
				
				if (departure != arrival) {
					// Calendar fixen
					cal.setTime((Date) RouteAskView.getTimeSpinner().getValue());
					SimpleDateFormat firstDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String date = RouteAskView.getDatePicker().getJFormattedTextField().getText();
					Date d = null;
					try {
						d = firstDateFormat.parse(date);
						cal.set(Calendar.YEAR, d.getYear() + 1900);
						cal.set(Calendar.MONTH, d.getMonth());
						cal.set(Calendar.DATE, d.getDate());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					ArrayList<Route> routes = ApiCaller.getTimedRouteInfo(departure, arrival, cal.getTime());
					
					if (routes != null)
						view.changeView(RouteGetView.initialize(view, routes, departure, arrival, cal));
					else 
						JOptionPane.showMessageDialog(null, "Geen routes gevonden.");
				} else {
					JOptionPane.showMessageDialog(null, "Geen routes gevonden.");
				}
			}
		});
		
		RouteAskView.getHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}