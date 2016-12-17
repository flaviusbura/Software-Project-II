package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import be.nmbs.controllers.RouteAskController;
import be.nmbs.database.StationDAO;
import be.nmbs.logic.DateLabelFormatter;
import be.nmbs.logic.StationNMBS;

public class RouteAskView {
	private static JButton home;
	private static JButton btnZoeken;
	private static JPanel panel;
	private static JLabel departureLabel;
	private static JComboBox<String> departureField;
	private static JLabel arrivalLabel;
	private static JComboBox<String> arrivalField;
	private static JDatePickerImpl datePicker;
	private static JSpinner timeSpinner;
	
	private static StationDAO stationdao;
	
	private static RouteAskController routeAskController;

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
			UtilDateModel model = new UtilDateModel();
			Calendar cal = Calendar.getInstance();
			model.setDate(cal.get(cal.YEAR), cal.get(cal.MONTH), cal.get(cal.DATE));
			model.setSelected(true);
			//model.setDate(20,04,2014);
			// Need this...
			Properties p = new Properties();
			p.put("text.today", "Vandaag");
			p.put("text.month", "Maand");
			p.put("text.year", "Jaar");
			JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
			// Don't know about the formatter, but there it is...
			datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
			
			timeSpinner = new JSpinner(new SpinnerDateModel());
			JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
			timeSpinner.setEditor(timeEditor);
			timeSpinner.setValue(new Date());
		
			stationdao = new StationDAO();
			ArrayList<StationNMBS> allStations = stationdao.getAll();
	
			String[] stationLijst = new String[allStations.size()];
			
			for(int i=0; i < allStations.size(); i++)
				stationLijst[i] = "" + allStations.get(i).getNaam();
		
			panel = new JPanel(new GridBagLayout());
			
			departureLabel = new JLabel("Vertrekstation");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(departureLabel, c);
			
			departureField = new JComboBox<String>(stationLijst);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			panel.add(departureField, c);
			
			arrivalLabel = new JLabel("Bestemming");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			panel.add(arrivalLabel, c);
			
			arrivalField = new JComboBox<String>(stationLijst);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			panel.add(arrivalField, c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			panel.add(timeSpinner, c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			panel.add(datePicker, c);

			home = new JButton("Terug naar menu");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			panel.add(home, c);

			btnZoeken = new JButton("Route zoeken");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			panel.add(btnZoeken, c);			
			
			routeAskController = new RouteAskController(view);
			return panel;
	}

	public static void setRouteAskControllerToNull() {
		routeAskController = null;
	}

	// Getters
	public static JButton getHome() {
		return home;
	}

	public static JButton getBtnZoeken() {
		return btnZoeken;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static JLabel getDepartureLabel() {
		return departureLabel;
	}

	public static JComboBox<String> getDepartureField() {
		return departureField;
	}

	public static JLabel getArrivalLabel() {
		return arrivalLabel;
	}

	public static JComboBox<String> getArrivalField() {
		return arrivalField;
	}

	public static StationDAO getStationdao() {
		return stationdao;
	}

	public static RouteAskController getRouteAskController() {
		return routeAskController;
	}

	public static JDatePickerImpl getDatePicker() {
		return datePicker;
	}

	public static JSpinner getTimeSpinner() {
		return timeSpinner;
	}
	
	// Setters
	public static void setHome(JButton home) {
		RouteAskView.home = home;
	}

	public static void setBtnZoeken(JButton btnZoeken) {
		RouteAskView.btnZoeken = btnZoeken;
	}

	public static void setPanel(JPanel panel) {
		RouteAskView.panel = panel;
	}

	public static void setDepartureLabel(JLabel departureLabel) {
		RouteAskView.departureLabel = departureLabel;
	}

	public static void setDepartureField(JComboBox<String> departureField) {
		RouteAskView.departureField = departureField;
	}

	public static void setArrivalLabel(JLabel arrivalLabel) {
		RouteAskView.arrivalLabel = arrivalLabel;
	}

	public static void setArrivalField(JComboBox<String> arrivalField) {
		RouteAskView.arrivalField = arrivalField;
	}

	public static void setDatePicker(JDatePickerImpl datePicker) {
		RouteAskView.datePicker = datePicker;
	}

	public static void setTimeSpinner(JSpinner timeSpinner) {
		RouteAskView.timeSpinner = timeSpinner;
	}

	public static void setStationdao(StationDAO stationdao) {
		RouteAskView.stationdao = stationdao;
	}

	public static void setRouteAskController(RouteAskController routeAskController) {
		RouteAskView.routeAskController = routeAskController;
	}
}
