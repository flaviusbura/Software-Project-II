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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import be.nmbs.controllers.MaakAbonnementController;
import be.nmbs.database.KlantDAO;
import be.nmbs.exceptions.KlantOnactiefException;
import be.nmbs.logic.Abonnement;
import be.nmbs.logic.DateLabelFormatter;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Klant;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.Prijs_abonnement;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.TypeAbonnement;
import be.nmbs.tablemodels.KlantTableModel;

/**
 * 
 * @author Abdel-Portable
 *
 */
public class MaakAbonnementView {
	private final JPanel panel = new JPanel(new GridBagLayout());

	private final JTextField searchTextField = new JTextField();

	private final JLabel typeLabel = new JLabel("Type");
	private final JLabel kortingLabel = new JLabel("Korting");
	private final JLabel prijsLabel = new JLabel("Prijs");
	private final JLabel departureLabel = new JLabel("Vertrekstation");
	private final JLabel arrivalLabel = new JLabel("Bestemming");
	private final JLabel startDatumLabel = new JLabel("Startdatum");
	private final JLabel maandenLabel = new JLabel("Geldig");

	private final JTable klantTable = new JTable();

	private final String[] tab = { "3 maanden", "6 maanden", "9 maanden", "12 maanden" };
	private final JComboBox<String> maandenComboBox = new JComboBox<String>(tab);

	private final JButton searchButton = new JButton("Zoek Klant");
	private final JButton showPriceButton = new JButton("Toon Prijs");
	private final JButton maakAbonnementButton = new JButton("Maak Abonnement");
	private final JButton backButton = new JButton("Terug");

	private JComboBox<String> departureComboBox;
	private JComboBox<String> arrivalComboBox;
	private JComboBox<Prijs> prijsComboBox = new JComboBox<Prijs>();
	private JComboBox<TypeAbonnement> typeComboBox;
	private JComboBox<Korting> kortingComboBox;

	private JDatePickerImpl startDatePicker;
	private Calendar cal;

	private final MaakAbonnementController maakAbonnementController = new MaakAbonnementController();

	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();

		// Add Klant Table
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 10;
		klantTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane scrollPane = new JScrollPane(klantTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel.add(scrollPane, c);

		// Add Station List For Comboboxes
		ArrayList<StationNMBS> stations = maakAbonnementController.getAllStations();
		String[] stationList = new String[stations.size()];

		for (int i = 0; i < stations.size(); i++)
			stationList[i] = "" + stations.get(i).getNaam();

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		// Add Search Text Field
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(searchTextField, c);

		// Add Search Button
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 0;
		panel.add(searchButton, c);

		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!searchTextField.getText().isEmpty()) {
					String oms = searchTextField.getText();

					ArrayList<Klant> klanten = maakAbonnementController.getAllKlantenByLike(oms);

					KlantTableModel klantTableModel = new KlantTableModel();
					klantTableModel.setKlanten(klanten);

					klantTable.setModel(klantTableModel);
				} else {
					JOptionPane.showMessageDialog(null, "Geef een geldige waarde in.");
				}
			}
		});

		// Add Departure Label
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(departureLabel, c);

		// Add Departure Combobox
		departureComboBox = new JComboBox<String>(stationList);
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 1;
		panel.add(departureComboBox, c);

		// Add Arrival Label
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(arrivalLabel, c);

		// Add Arrival Combobox
		arrivalComboBox = new JComboBox<String>(stationList);
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 2;
		panel.add(arrivalComboBox, c);

		// Add Startdatum Label
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(startDatumLabel, c);

		// Add Start Datum Picker
		UtilDateModel model = new UtilDateModel();
		cal = maakAbonnementController.getCurrentDate();
		model.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		model.setSelected(true);

		Properties p = new Properties();
		p.put("text.today", "Vandaag");
		p.put("text.month", "Maand");
		p.put("text.year", "Jaar");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		startDatePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 3;
		panel.add(startDatePicker, c);

		/*
		 * ArrayList<Prijs> allPrijzen =
		 * maakAbonnementController.getAllPrijzen(); for (Prijs prijs :
		 * allPrijzen) { prijsComboBox.addItem(prijs); }
		 */

		// Add Prijs Label
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 4;
		panel.add(prijsLabel, c);

		/*
		 * // Add Prijs Combobox c.gridx = 2; c.gridy = 4;
		 * panel.add(prijsComboBox, c);
		 */

		// Add Korting Label
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 5;
		panel.add(kortingLabel, c);

		ArrayList<Korting> allKorting = maakAbonnementController.getAllKortingen();
		kortingComboBox = new JComboBox<>();
		for (Korting korting : allKorting) {
			kortingComboBox.addItem(korting);
		}
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 5;
		panel.add(kortingComboBox, c);

		// Add Maanden Label
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 6;
		panel.add(maandenLabel, c);

		// Add Maanden Combobox
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 6;
		panel.add(maandenComboBox, c);

		ArrayList<TypeAbonnement> allType = maakAbonnementController.getAllAbonnementTypes();
		typeComboBox = new JComboBox<TypeAbonnement>();
		for (TypeAbonnement typeAbonnement : allType) {
			typeComboBox.addItem(typeAbonnement);
		}

		// Add Type Label
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 7;
		panel.add(typeLabel, c);

		// Add Type List
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 7;
		panel.add(typeComboBox, c);

		// Add Show Price Button
		c.gridx = 2;
		c.gridy = 10;
		panel.add(showPriceButton, c);

		showPriceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TypeAbonnement type = (TypeAbonnement) typeComboBox.getSelectedItem();
				Korting korting = (Korting) kortingComboBox.getSelectedItem();
				int kortingId = korting.getId();
				int typeId = type.getId();
				double prijs2 = maakAbonnementController.getPrijs(typeId);
				double coeff = maakAbonnementController.getCoefficient(typeId);
				Korting korting2 = maakAbonnementController.getKorting(kortingId);
				double kortingPercentage;
				double kortingHoeveelheid = korting2.getHoeveelheid();
				double totaalZonderKorting = 0;
				double totaalMetKorting = 0;

				totaalZonderKorting = (prijs2 * coeff);
				kortingPercentage = (totaalZonderKorting / 100) * kortingHoeveelheid;
				totaalMetKorting = totaalZonderKorting - kortingPercentage;
				NumberFormat number = NumberFormat.getNumberInstance();
				number.setMaximumFractionDigits(2);
				String tzk = number.format(totaalZonderKorting);
				String kp = number.format(kortingPercentage);
				String tmk = number.format(totaalMetKorting);
				JOptionPane.showMessageDialog(panel,
						"Totaal zonder korting: " + tzk + "\nKortingpercentage: " + kp + "\nTotaal: " + tmk);
			}
		});

		// Add Maak Abonnement Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 8;
		panel.add(maakAbonnementButton, c);

		maakAbonnementButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Gebruiker gebruiker = View.getIngelogdGebruiker();

					String route = departureComboBox.getSelectedItem().toString() + " - "
							+ arrivalComboBox.getSelectedItem().toString();

					// eindDatum omzetten
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date date2 = format.parse(startDatePicker.getJFormattedTextField().getText());
					Long tijd2 = date2.getTime();
					Timestamp ts2 = new Timestamp(tijd2);

					Korting korting = (Korting) kortingComboBox.getSelectedItem();
					try {
						int row = klantTable.getSelectedRow();
						int contactID = Integer.valueOf(klantTable.getModel().getValueAt(row, 0).toString());
						KlantDAO dao = new KlantDAO();
						boolean actief = dao.getActiefById(contactID);
						if (actief == false) {
							throw new KlantOnactiefException();
						}
						/*
						 * Variabelen declareren om de prijs berekening mogelijk
						 * maken
						 */
						TypeAbonnement type = (TypeAbonnement) typeComboBox.getSelectedItem();

						int typeAbonnementId = type.getId();
						int basisprijsid = maakAbonnementController.getBasisPrijsId(typeAbonnementId);
						double basisprijs = maakAbonnementController.getPrijs(typeAbonnementId);
						int coefid = maakAbonnementController.getCoefficientId(typeAbonnementId);
						double coef = maakAbonnementController.getCoefficient(coefid);
						double totaal = basisprijs * coef;
						Prijs_abonnement prijs_abonnement = new Prijs_abonnement(typeAbonnementId, coefid, basisprijsid,
								totaal);
						Abonnement abonnement = new Abonnement(contactID, gebruiker.getId(), route, ts2,
								korting.getId(), prijs_abonnement, true);

						int idvoorprijs = maakAbonnementController.insertAbonnementPrijs(prijs_abonnement);
						prijs_abonnement.setPrijs_abonnementid(idvoorprijs);
						abonnement.setPrijsId(prijs_abonnement);
						String keuze = maandenComboBox.getSelectedItem().toString();

						if (maakAbonnementController.insertAbonnement(keuze, abonnement)) {
							JOptionPane.showMessageDialog(panel, "Abonnement aangemaakt voor " + keuze);
						} else {
							JOptionPane.showMessageDialog(panel,
									"Er is iets misgelopen bij het maken van het abonnement, probeer opnieuw.");
						}
					} catch (ArrayIndexOutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null,
								"U heeft geen rij geselecteerd!\nSelecteer een klant voor wie u een abonnement\nwenst aan te maken.");
					} catch (KlantOnactiefException e2) {
						JOptionPane.showMessageDialog(null,
								"Er mogen geen abonnementen aangamaakt worden\nvoor onactieve klanten.");
					}
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});

		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 8;
		panel.add(backButton, c);

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbonnementView newView = new AbonnementView();
				view.changeView(newView.initialize(view));
			}
		});

		return panel;
	}
}