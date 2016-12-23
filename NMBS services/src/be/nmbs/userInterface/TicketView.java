package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.TicketController;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.Prijs_ticket;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.Ticket;
import be.nmbs.logic.TypeTicket;

public class TicketView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JLabel beginStationLabel = new JLabel("Vertrekstation");
	private final JLabel lblPrijs = new JLabel("prijs");
	private final JLabel klasseLabel = new JLabel("Klasse");
	private final JLabel soortLabel = new JLabel("Soort ticket");
	private final JLabel eindStationLabel = new JLabel("Eindstation");
	private final JLabel datumLabel = new JLabel("Datum");
	private final JLabel kortingLabel = new JLabel("Korting");
	private final JLabel stationLabel = new JLabel("Station");
	private final JLabel typeLabel = new JLabel("Type");

	private final JTextField soortTextField = new JTextField(10);
	private final JTextField datumTextField = new JTextField(10);
	private final JTextField klasseTextField = new JTextField(10);

	private JComboBox<Prijs> prijsComboBox;
	private JComboBox<Korting> kortingComboBox = new JComboBox<Korting>();;
	private JComboBox<String> stationComboBox;
	private JComboBox<String> beginStationComboBox;
	private JComboBox<String> eindStationComboBox;
	private JComboBox<TypeTicket> typeComboBox;
	
	private final JButton buyTicketButton = new JButton("Ticket kopen");
	private final JButton backButton = new JButton("Terug");
	
	private final TicketController ticketController = new TicketController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Fetching All Stations for Comboboxes
		ArrayList<StationNMBS> allStations = ticketController.getAllStations();

		String[] stationLijst = new String[allStations.size()];
		
		for(int i=0; i < allStations.size(); i++) {
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
		
		// Add Soort Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(soortLabel, c);
		
		// Add Soort Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(soortTextField, c);

		// Add Datum Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(datumLabel, c);
		
		// Add Datum Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String strDate = sdfDate.format(new Date());
		datumTextField.setText(strDate);
		panel.add(datumTextField, c);
		
		// Add Klasse Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 5;
		panel.add(klasseLabel, c);
		
		// Add Klasse Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 5;
		panel.add(klasseTextField, c);

		/*
		// Add Prijs Label
		 * c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 6;
		panel.add(prijsLabel, c);
		

		// Add Prijs Combobox
		ArrayList<Prijs> allPrijzen = prijsdao.getAll();

		prijsComboBox = new JComboBox<Prijs>();
		for(Prijs prijs : allPrijzen) {
			prijzenLijst.addItem(prijs);
		}
				
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 6;
		panel.add(prijsComboBox, c);
		
		*/
		
		// Add Korting Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 7;
		panel.add(kortingLabel, c);
		
		// Add Korting Combobox
		ArrayList<Korting> allKorting = ticketController.getAllKortingen();
		for(Korting korting : allKorting) {
			kortingComboBox.addItem(korting);
		}
		
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 7;
		panel.add(kortingComboBox, c);

		// Add Type Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 8;
		panel.add(typeLabel, c);

		// Add Type Combobox
		ArrayList<TypeTicket> allType = ticketController.getAllTicketTypes();
		typeComboBox = new JComboBox<TypeTicket>();
		for (TypeTicket typeTicket : allType) {
			typeComboBox.addItem(typeTicket);
		}
		
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 8;
		panel.add(typeComboBox, c);
		
		// Add Station Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 9;
		panel.add(stationLabel, c);
		
		// Add Station Combobox
		stationComboBox = new JComboBox<String>(stationLijst);
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 9;
		panel.add(stationComboBox, c);
		
		// Add Buy Ticket Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 10;
		panel.add(buyTicketButton, c);
		
		buyTicketButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// String startstation = (String)
					// TicketView.getBeginstationlijst().getSelectedItem();
					StationNMBS startstation = new StationNMBS(beginStationComboBox.getSelectedItem().toString());
					String soort = soortTextField.getText();
					String datum = datumTextField.getText();

					DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					Date date = format.parse(datum);
					Long tijd = date.getTime();
					Timestamp ts = new Timestamp(tijd);
					int klas = Integer.parseInt(klasseTextField.getText());

					StationNMBS eindstation = new StationNMBS(eindStationComboBox.getSelectedItem().toString());
					// String eindstation = (String)
					// TicketView.getEindstationlijst().getSelectedItem();

					//Prijs prijs = (Prijs) TicketView.getPrijzenlijst().getSelectedItem();
					//int prijsId = prijs.getPrijsId();
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
					
					double totaal = basisprijs*coef;
					System.out.println("totaal " + totaal);
					
					Prijs_ticket prijs_ticket = new Prijs_ticket(typeTicketId,coefid,basisprijsid,totaal);
					
					int idvoorprijs = ticketController.insertTicketPrijs(prijs_ticket);
					prijs_ticket.setPrijs_ticketid(idvoorprijs);
					Korting korting = (Korting) kortingComboBox.getSelectedItem();
					int kortingId = korting.getId();
					StationNMBS station = new StationNMBS(stationComboBox.getSelectedItem().toString());
					int gebruikerId = View.getIngelogdGebruiker().getId();
					
					Ticket ticket = new Ticket(startstation, soort, ts, klas, true, eindstation, prijs_ticket,kortingId, station, gebruikerId);
					ticketController.insertTicket(ticket);

					/**
					 * Variabelen declarern om de prijs berekening mogelijk
					 * maken	
					 */
					TypeTicket type = (TypeTicket) typeComboBox.getSelectedItem();
					int typeId = type.getId();
//
//					BasisprijsTicketDAO bptDAO = new BasisprijsTicketDAO();
//					CoefficientTicketDAO ctDAO = new CoefficientTicketDAO();
//					KortingDAO kortingDAO = new KortingDAO();
//					double prijs2 = bptDAO.getPrijs_ById(typeId);
//					double coeff = ctDAO.getCoefficient_ById(typeId);
//					Korting korting2 = kortingDAO.getKorting(kortingId);
//					double kortingPercentage;
//					double kortingHoeveelheid = korting2.getHoeveelheid();
//					double totaalZonderKorting = 0;
//					double totaalMetKorting = 0;
					
					/**
					 * Prijs berekening
					 */
//					totaalZonderKorting = (prijs2 * coeff);
//					kortingPercentage = (totaalZonderKorting / 100) * kortingHoeveelheid;
//					totaalMetKorting = totaalZonderKorting - kortingPercentage;

//					JOptionPane.showMessageDialog(view.getPanel(),
//							"Ticket aangemaakt" + "\n" + "Prijs is: €" + totaalMetKorting);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
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
