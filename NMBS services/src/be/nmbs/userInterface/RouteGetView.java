package be.nmbs.userInterface;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import be.nmbs.controllers.RouteGetController;
import be.nmbs.logic.ApiCaller;
import be.nmbs.logic.Route;

public class RouteGetView {
	private static JPanel panel;
	private static JButton back;
	private static JLabel info;
	private static JTable table;

	private static ArrayList<Route> routes;
	
	private static boolean ALLOW_COLUMN_SELECTION = false;
	private static boolean ALLOW_ROW_SELECTION = true;
	
	@SuppressWarnings("unused")
	private static RouteGetController routeGetController;

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view, String departureStation, String arrivalStation, Calendar departure) {			
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c;
		
		ApiCaller caller = new ApiCaller();
		
		routes = caller.getTimedRouteInfo(departureStation, arrivalStation, departure.getTime());
		
		System.out.println(departure.getTimeInMillis());
		if (routes == null) {
			info = new JLabel("Geen routes gevonden");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(info, c);	
			
			back = new JButton("Terug naar zoeken");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			panel.add(back, c);	
		} else {
			table = new JTable();
			table.setPreferredScrollableViewportSize(new Dimension(500, 200));
			
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.VERTICAL;
			c.gridx = 0;
			c.gridheight = 3;
			
			table.setVisible(false);
			
			JScrollPane scrollPane = new JScrollPane(table);
			
			panel.add(scrollPane);
			
			back = new JButton("Terug naar zoeken");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			panel.add(back, c);
		}
		
		routeGetController = new RouteGetController(view, routes);
		return panel;
	}

	public static void setRouteGetControllerToNull() {
		routeGetController = null;
	}

	public static JButton getBack() {
		return back;
	}
	
	public static JTable getTable() {
		return table;
	}

	public static void setTabel(JTable table) {
		RouteGetView.table = table;
	}
}