package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import be.nmbs.controllers.RouteGetController;
import be.nmbs.logic.Route;

public class RouteGetView {
	private static JPanel panel;
	private static JButton back;
	private static JButton train;
	private static JTable table;
	
	@SuppressWarnings("unused")
	private static boolean ALLOW_COLUMN_SELECTION = false;
	@SuppressWarnings("unused")
	private static boolean ALLOW_ROW_SELECTION = true;
	
	@SuppressWarnings("unused")
	private static RouteGetController routeGetController;

	public static JPanel initialize(View view, ArrayList<Route> routes, String departureStation, String arrivalStation, Calendar departure) {			
		panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();

		table = new JTable();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 2;
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		train = new JButton("Trein bekijken");
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		c.ipadx = 50;
		panel.add(train, c);
		
		back = new JButton("Terug naar zoeken");
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(back, c);
		
		routeGetController = new RouteGetController(view, routes, departureStation, arrivalStation, departure);
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

	public static JButton getTrain() {
		return train;
	}

	public static void setTrain(JButton train) {
		RouteGetView.train = train;
	}
}