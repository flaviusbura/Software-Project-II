package be.nmbs.userInterface;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import be.nmbs.controllers.TrainSearchController;
import be.nmbs.logic.Route;
import be.nmbs.logic.Trein;
import be.nmbs.tablemodels.EmptyTableModel;
import be.nmbs.tablemodels.TrainTableModel;

public class TrainSearchView {
	private final JButton backButton = new JButton("Terug");
	private final JButton searchButton = new JButton("Zoeken");
	private final JPanel trainSearchPanel = new JPanel(new GridBagLayout());
	private final JLabel trainLabel = new JLabel("Trein ID");
	private final JTextField trainTextField = new JTextField();
	private JTable trainTable = new JTable();
	
	private TrainSearchController trainSearchController = new TrainSearchController();

	public JPanel initialize(View view) {
		addStandardItems();
		
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Trein train = trainSearchController.searchTrain(trainTextField.getText().toString());
				
				if (train != null) {
					TrainTableModel trainModel = new TrainTableModel();
					trainModel.setTrain(train);
			        
			     	trainTable.setModel(trainModel);
			     	trainTable.setEnabled(true);
				} else {
					EmptyTableModel emptyModel = new EmptyTableModel();
					trainTable.setModel(emptyModel);
			     	trainTable.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Geen trein gevonden.");
				}
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});

		return trainSearchPanel;
	}
	
	public JPanel initialize(View view, ArrayList<Route> routes, String id) {
		addStandardItems();
		
		trainTextField.setText(id);
		
		Trein train = trainSearchController.searchTrain(id);
		
		if (train != null) {
			TrainTableModel trainModel = new TrainTableModel();
			trainModel.setTrain(train);
	        
	     	trainTable.setModel(trainModel);
	     	trainTable.setEnabled(true);
		} else {
			EmptyTableModel emptyModel = new EmptyTableModel();
			trainTable.setModel(emptyModel);
	     	trainTable.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Geen trein gevonden.");
		}
		
		searchButton.setEnabled(false);
		trainTextField.setEnabled(false);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RouteSearchView newView = new RouteSearchView();
				view.changeView(newView.initialize(view, routes));
			}
		});

		return trainSearchPanel;
	}
	
	private void addStandardItems() {
		GridBagConstraints c = new GridBagConstraints();
		
		// Add Train Table
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 4;
		
		JScrollPane scrollPane = new JScrollPane(trainTable);
		
		trainSearchPanel.add(scrollPane, c);
		
		// Add Train Label
		trainLabel.setPreferredSize(new Dimension(150, 20));
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		trainSearchPanel.add(trainLabel, c);
		
		// Add Train Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		trainSearchPanel.add(trainTextField, c);

		// Add Search Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		trainSearchPanel.add(searchButton, c);
		
		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		trainSearchPanel.add(backButton, c);
	}
}