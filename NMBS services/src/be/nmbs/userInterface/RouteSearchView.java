package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JSpinner.DateEditor;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SpinnerDateModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import be.nmbs.controllers.RouteSearchController;
import be.nmbs.logic.DateLabelFormatter;
import be.nmbs.logic.Route;
import be.nmbs.logic.StationNMBS;
import be.nmbs.tablemodels.EmptyTableModel;
import be.nmbs.tablemodels.RouteTableModel;

public class RouteSearchView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	private final JButton backButton = new JButton("Terug");
	private final JButton searchButton = new JButton("Route zoeken");
	private final JButton lookAtTrainButton = new JButton("Trein bekijken");
	private final JLabel departureLabel = new JLabel("Vertrekstation");
	private final JLabel arrivalLabel = new JLabel("Bestemming");
	private final JTable routeTable = new JTable();
	private JComboBox<String> departureComboBox;
	private JComboBox<String> arrivalComboBox;
	private JDatePickerImpl datePicker;
	private JSpinner timeSpinner;
	
	private ArrayList<Route> routes;
	private Calendar cal;
	private String selectedDeparture, selectedArrival;
	
	private final RouteSearchController routeSearchController = new RouteSearchController();

	public JPanel initialize(View view) {
		addStandardItems(view);
		
		return panel;
	}	
	
	public JPanel initialize(View view, ArrayList<Route> routes) {
		addStandardItems(view);
		
		RouteTableModel model = new RouteTableModel();
		this.routes = routes;
		model.setRoutes(routes);
		routeTable.setModel(model);
		
		return panel;
	}	
	
	private void addStandardItems(View view) {
		GridBagConstraints c = new GridBagConstraints();

		ArrayList<StationNMBS> stations = routeSearchController.getAllStations();
		String[] stationLijst = new String[stations.size()];
		
		for(int i=0; i < stations.size(); i++)
			stationLijst[i] = "" + stations.get(i).getNaam();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Add Route Tabel
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 10;
		
		JScrollPane scrollPane = new JScrollPane(routeTable);
		panel.add(scrollPane, c);
		
		routeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (routeTable.getSelectedRow() > -1) {
					if (!routeTable.getValueAt(routeTable.getSelectedRow(), 3).toString().isEmpty() && routeTable.getValueAt(routeTable.getSelectedRow(), 3).toString() != "---") {
						lookAtTrainButton.setEnabled(true);
					} else {
						lookAtTrainButton.setEnabled(false);
					}
		        } else {
		        	lookAtTrainButton.setEnabled(false);
		        }
			}
		});
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Add Look At Train Button
		lookAtTrainButton.setEnabled(false);
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 8;
		panel.add(lookAtTrainButton, c);
		
		lookAtTrainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = (String) routeTable.getValueAt(routeTable.getSelectedRow(), 3);
				String[] idArray = id.split(" ");
				TrainSearchView newView = new TrainSearchView();
				view.changeView(newView.initialize(view, routes, idArray[1]));
			}
		});
		
		// Add Departure Label
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(departureLabel, c);
		
		// Add Departure Field
		departureComboBox = new JComboBox<String>(stationLijst);
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(departureComboBox, c);
		
		// Add Arrival Label
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(arrivalLabel, c);
		
		// Add Arrival Field
		arrivalComboBox = new JComboBox<String>(stationLijst);
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 4;
		panel.add(arrivalComboBox, c);
		
		// Add TimeSpinner
		timeSpinner = new JSpinner(new SpinnerDateModel());
		DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 5;
		panel.add(timeSpinner, c);
		
		// Add DatePicker
		UtilDateModel model = new UtilDateModel();
		cal = routeSearchController.getCurrentDate();
		model.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		model.setSelected(true);

		Properties p = new Properties();
		p.put("text.today", "Vandaag");
		p.put("text.month", "Maand");
		p.put("text.year", "Jaar");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 6;
		panel.add(datePicker, c);

		// Add Search Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 7;
		panel.add(searchButton, c);	
		
		searchButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {				
				// Filtering out text after '/' if there is
				int iend = departureComboBox.getSelectedItem().toString().indexOf("/");
				
				selectedDeparture = "";
				if (iend != -1)
					selectedDeparture = departureComboBox.getSelectedItem().toString().substring(0 , iend);
				else
					selectedDeparture = departureComboBox.getSelectedItem().toString();
				
				iend = arrivalComboBox.getSelectedItem().toString().indexOf("/");
				
				selectedArrival = "";
				if (iend != -1)
					selectedArrival = arrivalComboBox.getSelectedItem().toString().substring(0 , iend);
				else
					selectedArrival = arrivalComboBox.getSelectedItem().toString();
				
				if (selectedDeparture != selectedArrival) {
					// Calendar fixen
					cal.setTime((Date) timeSpinner.getValue());
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					String date = datePicker.getJFormattedTextField().getText();
					Date d = null;
					try {
						d = format.parse(date);
						cal.set(Calendar.YEAR, d.getYear() + 1900);
						cal.set(Calendar.MONTH, d.getMonth());
						cal.setTimeInMillis(cal.getTimeInMillis() + 3600000);
					} catch (ParseException e1) { }
					
					if (d != null) {
						routes = routeSearchController.getRouteInfo(selectedDeparture, selectedArrival, cal);
						
						if (routes != null) {
							RouteTableModel routeModel = new RouteTableModel();
					        routeModel.setRoutes(routes);
					        
					     	routeTable.setModel(routeModel);
						} else {
							JOptionPane.showMessageDialog(null, "Geen routes gevonden.");
							
							EmptyTableModel emptyModel = new EmptyTableModel();
							routeTable.setModel(emptyModel);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Geef een geldige datum in.");

						EmptyTableModel emptyModel = new EmptyTableModel();
						routeTable.setModel(emptyModel);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Geef twee verschillende stations.");

					EmptyTableModel emptyModel = new EmptyTableModel();
					routeTable.setModel(emptyModel);
				}
			}
		});

		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 9;
		panel.add(backButton, c);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}