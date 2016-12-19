package be.nmbs.userInterface;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import be.nmbs.controllers.TrainGetController;
import be.nmbs.logic.ApiCaller;
import be.nmbs.logic.Trein;

public class TrainGetView {
	private static JPanel panel;
	private static JButton back;
	private static JLabel info;
	private static JTable table;
	
	private static Trein train;
	
	@SuppressWarnings("unused")
	private static TrainGetController trainGetController;

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view, String id) {			
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c;
		
		ApiCaller caller = new ApiCaller();
		
		train = caller.getTreinInfo(id);
		
		if (train == null) {
			info = new JLabel("Geen trein gevonden");
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
			info = new JLabel("Trein: " + id);
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(info, c);	
			
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
			c.gridy = 2;
			panel.add(back, c);
		}
		
		trainGetController = new TrainGetController(view, train);
		return panel;
	}
	
	@SuppressWarnings("static-access")
	public static JPanel initialize(View view, String id, String departureStation, String arrivalStation, Calendar departure) {			
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c;
		
		ApiCaller caller = new ApiCaller();
		
		train = caller.getTreinInfo(id);
		
		if (train == null) {
			info = new JLabel("Geen trein gevonden");
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
			info = new JLabel("Trein: " + id);
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(info, c);	
			
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
			c.gridy = 2;
			panel.add(back, c);
		}
		
		trainGetController = new TrainGetController(view, train, departureStation, arrivalStation, departure);
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