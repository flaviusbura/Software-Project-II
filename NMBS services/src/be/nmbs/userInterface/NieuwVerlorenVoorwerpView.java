package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner.DateEditor;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import be.nmbs.controllers.NieuwVerlorenVoorwerpController;
import be.nmbs.logic.DateLabelFormatter;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.VerlorenVoorwerp;

public class NieuwVerlorenVoorwerpView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	private final JLabel stationLabel = new JLabel("Station");
	private final JLabel descriptionLabel = new JLabel("Omschrijving");
	private final JLabel typeLabel = new JLabel("Type");
	private final JTextField descriptionTextField = new JTextField();
	private final JTextField typeTextField = new JTextField();
	private final JButton addButton = new JButton("Toevoegen");
	private final JButton backButton = new JButton("Terug");
	private JComboBox<String> stationComboBox;
	private JDatePickerImpl datePicker;
	private JSpinner timeSpinner;
	private Calendar cal;
	
	private final NieuwVerlorenVoorwerpController nieuwVerlorenVoorwerpController = new NieuwVerlorenVoorwerpController();
	
	public JPanel initialize(View view) {	
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		ArrayList<StationNMBS> allStations = nieuwVerlorenVoorwerpController.getAllStations();

		String[] stationLijst = new String[allStations.size()];
		
		for(int i=0; i < allStations.size(); i++) {
			stationLijst[i] = "" + allStations.get(i).getNaam();
		}
		
		// Add Station Label
		c.gridx = 0;
		c.gridy = 0;
		panel.add(stationLabel, c);
		
		// Add Station Combobox
		stationComboBox = new JComboBox<String>(stationLijst);
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(stationComboBox, c);
		
		// Add Description Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(descriptionLabel, c);

		// Add Description Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(descriptionTextField, c);

		// Add Type Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(typeLabel, c);

		// Add Type Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(typeTextField, c);
		
		// Add TimeSpinner
		timeSpinner = new JSpinner(new SpinnerDateModel());
		DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(timeSpinner, c);
		
		// Add DatePicker
		UtilDateModel model = new UtilDateModel();
		cal = nieuwVerlorenVoorwerpController.getCurrentDate();
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
		c.gridy = 3;
		panel.add(datePicker, c);

		// Add Add Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 4;
		panel.add(addButton, c);
		
		addButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				StationNMBS station = new StationNMBS(stationComboBox.getSelectedItem().toString());
				String omschrijving = descriptionTextField.getText();
				String type = typeTextField.getText();
				
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
				
				Timestamp ts = new Timestamp(cal.getTimeInMillis());
				
				VerlorenVoorwerp voorwerp = new VerlorenVoorwerp(station, omschrijving, type, ts, true);
				
				if (nieuwVerlorenVoorwerpController.insertVoorwerp(voorwerp)) {
					JOptionPane.showMessageDialog(null, "Nieuw voorwerp toegevoegd.");
					VerlorenVoorwerpView newView = new VerlorenVoorwerpView();
					view.changeView(newView.initialize(view));
				} else {
					JOptionPane.showMessageDialog(null, "Er ging iets fout bij het toevoegen van het voorwerp.");
				}
			}
		});
		
		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 4;
		panel.add(backButton, c);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VerlorenVoorwerpView newView = new VerlorenVoorwerpView();
				view.changeView(newView.initialize(view));
			}
		});
		
		return panel;
	}
}
