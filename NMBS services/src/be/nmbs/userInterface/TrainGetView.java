package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import be.nmbs.controllers.TrainGetController;
import be.nmbs.logic.Route;
import be.nmbs.logic.Trein;

public class TrainGetView {
	private static JPanel panel;
	private static JButton back;
	private static JLabel info;
	private static JTable table;
	
	@SuppressWarnings("unused")
	private static TrainGetController trainGetController;

	public static JPanel initialize(View view, String id, Trein train) {			
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c;
		
		info = new JLabel(train.getId());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(info, c);	
		
		table = new JTable();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		panel.add(scrollPane, c);
		
		back = new JButton("Terug naar zoeken");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(back, c);
		
		trainGetController = new TrainGetController(view, train);
		
		return panel;
	}
	
	public static JPanel initialize(View view, ArrayList<Route> routes, Trein train, String departureStation, String arrivalStation, Calendar departure) {			
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c;

		info = new JLabel(train.getId());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(info, c);	
		
		table = new JTable();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		panel.add(scrollPane, c);
		
		back = new JButton("Terug naar zoeken");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(back, c);
		
		trainGetController = new TrainGetController(view, routes, train, departureStation, arrivalStation, departure);
		return panel;
	}

	public static void setTrainGetControllerToNull() {
		trainGetController = null;
	}

	public static JButton getBack() {
		return back;
	}
	
	public static JTable getTable() {
		return table;
	}

	public static void setTabel(JTable table) {
		TrainGetView.table = table;
	}
}