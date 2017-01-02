package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.NumberFormat;
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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import be.nmbs.controllers.TicketController;
import be.nmbs.database.BasisprijsTicketDAO;
import be.nmbs.database.CoefficientTicketDAO;
import be.nmbs.database.KortingDAO;
import be.nmbs.logic.DateLabelFormatter;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs_ticket;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.Ticket;
import be.nmbs.logic.TypeTicket;

public class TicketView {
	private final JPanel panel = new JPanel(new GridBagLayout());

	private final JLabel beginStationLabel = new JLabel("Vertrekstation");
	private final JLabel klasseLabel = new JLabel("Klasse");
	private final JLabel eindStationLabel = new JLabel("Eindstation");
	private final JLabel datumLabel = new JLabel("Datum");
	private final JLabel kortingLabel = new JLabel("Korting");
	private final JLabel stationLabel = new JLabel("Station");
	private final JLabel typeLabel = new JLabel("Type");

	private final JComboBox<String> klasseCombobox = new JComboBox<String>();

	private JComboBox<Korting> kortingComboBox = new JComboBox<Korting>();;
	private JComboBox<String> stationComboBox;
	private JComboBox<String> beginStationComboBox;
	private JComboBox<String> eindStationComboBox;
	private JComboBox<TypeTicket> typeComboBox;
	
	private JDatePickerImpl datePicker;
	private Calendar cal;

	private final JButton buyTicketButton = new JButton("Ticket kopen");
	private final JButton backButton = new JButton("Terug");

	private final TicketController ticketController = new TicketController();

	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		// Fetching All Stations for Comboboxes
		ArrayList<StationNMBS> allStations = ticketController.getAllStations();

		String[] stationLijst = new String[allStations.size()];

		for (int i = 0; i < allStations.size(); i++) {
			stationLijst[i] = "" + allStations.get(i).getNaam();
		}

		// Add Begin Station Label
		c.gridx = 0;
		c.gridy = 0;
		panel.add(beginStationLabel, c);

		// Add Begin Station Combobox
		beginStationComboBox = new JComboBox<String>(stationLijst);
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(beginStationComboBox, c);

		// Add Eind Station Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(eindStationLabel, c);

		// Add Eind Station Combobox
		eindStationComboBox = new JComboBox<String>(stationLijst);
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(eindStationComboBox, c);

		// Add Datum Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(datumLabel, c);
		
		// Add Start Datum Picker
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
		c.gridy = 2;
		panel.add(datePicker, c);

		// Add Klasse Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(klasseLabel, c);

		// Add Klasse Text Field
		klasseCombobox.addItem("1ste klasse");
		klasseCombobox.addItem("2de klasse");
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(klasseCombobox, c);

		// Add Korting Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 4;
		panel.add(kortingLabel, c);

		// Add Korting Combobox
		ArrayList<Korting> allKorting = ticketController.getAllKortingen();
		for (Korting korting : allKorting) {
			kortingComboBox.addItem(korting);
		}

		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 4;
		panel.add(kortingComboBox, c);

		// Add Type Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 5;
		panel.add(typeLabel, c);

		// Add Type Combobox
		ArrayList<TypeTicket> allType = ticketController.getAllTicketTypes();
		typeComboBox = new JComboBox<TypeTicket>();
		for (TypeTicket typeTicket : allType) {
			typeComboBox.addItem(typeTicket);
		}

		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 5;
		panel.add(typeComboBox, c);

		// Add Station Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 6;
		panel.add(stationLabel, c);

		// Add Station Combobox
		stationComboBox = new JComboBox<String>(stationLijst);
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 6;
		panel.add(stationComboBox, c);

		// Add Buy Ticket Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 7;
		panel.add(buyTicketButton, c);

		buyTicketButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				StationNMBS startstation = new StationNMBS(beginStationComboBox.getSelectedItem().toString());
				String soort = "";
				
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

				int klas = 0;
				if (klasseCombobox.getSelectedItem() == "1ste klasse") {
					klas = 1;
				} else {
					klas = 2;
				}
				StationNMBS eindstation = new StationNMBS(eindStationComboBox.getSelectedItem().toString());
				TypeTicket typeTicket = (TypeTicket) typeComboBox.getSelectedItem();
				int typeTicketId = typeTicket.getId();
				System.out.println("typeticketid " + typeTicketId);

				int basisprijsid = ticketController.getBasisPrijsId(typeTicketId);
				System.out.println("basisprijsid " + basisprijsid);

				double basisprijs = ticketController.getBasisPrijs(basisprijsid);
				System.out.println("basisprijs " + basisprijs);

				int coefid = ticketController.getCoefficientId(typeTicketId);
				System.out.println("coefid " + coefid);

				double coef = ticketController.getCoefficient(coefid);
				System.out.println("coef " + coef);

				double totaal = basisprijs * coef;
				System.out.println("totaal " + totaal);

				Prijs_ticket prijs_ticket = new Prijs_ticket(typeTicketId, coefid, basisprijsid, totaal);

				int idvoorprijs = ticketController.insertTicketPrijs(prijs_ticket);
				prijs_ticket.setPrijs_ticketid(idvoorprijs);
				Korting korting = (Korting) kortingComboBox.getSelectedItem();
				int kortingId = korting.getId();
				StationNMBS station = new StationNMBS(stationComboBox.getSelectedItem().toString());
				int gebruikerId = View.getIngelogdGebruiker().getId();

				Ticket ticket = new Ticket(startstation, soort, ts, klas, true, eindstation, prijs_ticket,
						kortingId, station, gebruikerId);
				ticketController.insertTicket(ticket);

				/*
				 * Variabelen declarern om de prijs berekening mogelijk
				 * maken
				 */
				TypeTicket type = (TypeTicket) typeComboBox.getSelectedItem();
				int typeId = type.getId();

				BasisprijsTicketDAO bptDAO = new BasisprijsTicketDAO();
				CoefficientTicketDAO ctDAO = new CoefficientTicketDAO();
				KortingDAO kortingDAO = new KortingDAO();
				double prijs2 = bptDAO.getPrijs_ById(typeId);
				double coeff = ctDAO.getCoefficient_ById(typeId);
				Korting korting2 = kortingDAO.getKorting(kortingId);
				double kortingPercentage;
				double kortingHoeveelheid = korting2.getHoeveelheid();
				double totaalZonderKorting = 0;
				double totaalMetKorting = 0;

				/*
				 * Prijs berekening
				 */
				totaalZonderKorting = (prijs2 * (coeff + 0.5));
				kortingPercentage = (totaalZonderKorting / 100) * kortingHoeveelheid;
				totaalMetKorting = totaalZonderKorting - kortingPercentage;
				NumberFormat number = NumberFormat.getNumberInstance();
				number.setMaximumFractionDigits(2);
				String tmk = number.format(totaalMetKorting);
				JOptionPane.showMessageDialog(view.getPanel(),
						"Ticket aangemaakt" + "\n" + "Prijs is: " + tmk);
			}
		});

		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 7;
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
