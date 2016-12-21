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

import be.nmbs.controllers.TicketController;
import be.nmbs.logic.DateLabelFormatter;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.Ticket;

public class TicketView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final String[] labelTexts = {"Vertrekstation", "Eindstation", "Soort ticket", "Klasse", "Omschrijving", "Prijs", "Korting", "Station" };
	private JLabel infoLabel;
	
	private JTextField typeTextField;
	private final JComboBox<String> klasseComboBox = new JComboBox<String>();
	private JTextField descriptionTextField = new JTextField();
	private JComboBox<Prijs> prijsComboBox;
	private JComboBox<Korting> kortingComboBox = new JComboBox<Korting>();
	private JComboBox<String> stationComboBox;
	private JComboBox<String> vertrekComboBox;
	private JComboBox<String> aankomstComboBox;
	private JDatePickerImpl datePicker;
	private JSpinner timeSpinner;
	
	private final JButton buyButton = new JButton("Koop ticket");
	private final JButton backButton = new JButton("Terug");
	
	private final TicketController ticketController = new TicketController();
	
	private Calendar cal;
	
	public JPanel initialize(View view) {		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;   
		
		ArrayList<StationNMBS> allStations = ticketController.getAllStations();

		String[] stationLijst = new String[allStations.size()];
		
		for(int i=0; i < allStations.size(); i++) {
			stationLijst[i] = "" + allStations.get(i).getNaam();
		}
		
		// Add Info Labels
		infoLabel = new JLabel(labelTexts[0]);
		c.gridx = 0;
		c.gridy = 0;
		panel.add(infoLabel, c);

		infoLabel = new JLabel(labelTexts[1]);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(infoLabel, c);
		
		infoLabel = new JLabel(labelTexts[2]);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(infoLabel, c);
		
		infoLabel = new JLabel(labelTexts[3]);
		c.gridx = 0;
		c.gridy = 5;
		panel.add(infoLabel, c);
		
		infoLabel = new JLabel(labelTexts[4]);
		c.gridx = 0;
		c.gridy = 6;
		panel.add(infoLabel, c);

		infoLabel = new JLabel(labelTexts[5]);
		c.gridx = 0;
		c.gridy = 7;
		panel.add(infoLabel, c);

		infoLabel = new JLabel(labelTexts[6]);
		c.gridx = 0;
		c.gridy = 8;
		panel.add(infoLabel, c);
		
		infoLabel = new JLabel(labelTexts[7]);
		c.gridx = 0;
		c.gridy = 9;
		panel.add(infoLabel, c);
		
		// Add Vertrek Combobox
		vertrekComboBox = new JComboBox<String>(stationLijst);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(vertrekComboBox, c);
		
		// Add Aankomst Combobox
		aankomstComboBox = new JComboBox<String>(stationLijst);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(aankomstComboBox, c);

		// Add Soort Text Field
		typeTextField = new JTextField(10);
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
		cal = ticketController.getCurrentDate();
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
	
		// Add Klasse Combobox
		klasseComboBox.addItem("2e");
		klasseComboBox.addItem("1e");
		c.gridx = 1;
		c.gridy = 5;
		panel.add(klasseComboBox, c);
		
		// Add Description Text Field
		c.gridx = 1;
		c.gridy = 6;
		panel.add(descriptionTextField, c);
		
		
		/*ArrayList<Prijs> allPrijzen = prijsdao.getAll();

		prijzenLijst = new JComboBox<Prijs>();
		for(Prijs prijs : allPrijzen) {
			prijzenLijst.addItem(prijs);
		}
				
		c.gridx = 1;
		c.gridy = 7;
		panel.add(prijzenLijst, c);*/
			
		// Add Korting Combobox
		ArrayList<Korting> allKorting = ticketController.getAllKortingen();		
		for(Korting korting : allKorting) {
			kortingComboBox.addItem(korting);
		}
		c.gridx = 1;
		c.gridy = 8;
		panel.add(kortingComboBox, c);

		// Add Station Combobox
		stationComboBox = new JComboBox<String>(stationLijst);
		c.gridx = 1;
		c.gridy = 9;
		panel.add(stationComboBox, c);
		
		// Add Buy Button
		c.gridx = 0;
		c.gridy = 10;
		panel.add(buyButton, c);
		
		buyButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// String startstation = (String) TicketView.getBeginstationlijst().getSelectedItem();
				StationNMBS startstation = new StationNMBS(vertrekComboBox.getSelectedItem().toString());
				String soort = typeTextField.getText();
				
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

				int klasse = 0;
				if (klasseComboBox.getSelectedItem().toString() == "1e") {
					klasse = 1;
				} else if (klasseComboBox.getSelectedItem().toString() == "2e") {
					klasse = 2;
				}
				
				StationNMBS eindstation = new StationNMBS(aankomstComboBox.getSelectedItem().toString());
				String omschrijving = descriptionTextField.getText();
				
				Prijs prijs = (Prijs) prijsComboBox.getSelectedItem();
				int prijsId = prijs.getPrijsId();
				
				Korting korting = (Korting) kortingComboBox.getSelectedItem();
				int kortingId = korting.getId();
				
				StationNMBS station = new StationNMBS(stationComboBox.getSelectedItem().toString());
				int gebruikerId = View.getIngelogdGebruiker().getId();
				
				Ticket ticket = new Ticket(startstation, soort, ts, klasse, true, eindstation, omschrijving, prijsId, kortingId, station, gebruikerId);
				
				if (ticketController.insertTicket(ticket)) {
					JOptionPane.showMessageDialog(null, "Ticket aangemaakt.");
				} else {
					JOptionPane.showMessageDialog(null, "Fout tijdens het aanmaken van ticket, probeer opnieuw.");
				}
			}

		});
		
		// Add Back Button
		c.gridx = 1;
		c.gridy = 10;
		panel.add(backButton, c);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
	
		return panel;
	}
}