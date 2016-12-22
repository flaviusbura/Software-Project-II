package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.KlantAanpassenController;
import be.nmbs.exceptions.EnkelCijfersException;
import be.nmbs.exceptions.EnkelLettersException;
import be.nmbs.exceptions.NietGeldigePostcodeException;
import be.nmbs.logic.Adres;
import be.nmbs.logic.JTextFieldLimit;
import be.nmbs.logic.Klant;
import be.nmbs.logic.VeiligeInvoer;

public class KlantAanpassenView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final String[] labelTexts = { "Voornaam", "Naam", "Telefoon", "Straat", "Huisnummer", "Bus", "Stad", "Postcode", "Land", "Actief" };
	private JLabel infoLabel;
	
	private final JTextField firstNameTextField = new JTextField(20);
	private final JTextField lastNameTextField = new JTextField(20);
	private final JTextField phoneTextField = new JTextField(20);
	private final JTextField streetTextField = new JTextField(20);
	private final JTextField streetNumberTextField = new JTextField(20);
	private final JTextField busTextField = new JTextField(20);
	private final JTextField postCodeTextField = new JTextField(20);
	private final JTextField cityTextField = new JTextField(20);
	private final JTextField countryTextField = new JTextField(20);
	private final JCheckBox activeCheckBox = new JCheckBox();
	
	private final JButton saveButton = new JButton("Klant opslaan");
	private final JButton backButton = new JButton("Terug");

	private final KlantAanpassenController klantAanpassenController = new KlantAanpassenController();
	
	public JPanel initialize(View view, Klant klant) {
		phoneTextField.setDocument(new JTextFieldLimit(13));
		streetNumberTextField.setDocument(new JTextFieldLimit(5));
		busTextField.setDocument(new JTextFieldLimit(5));
		postCodeTextField.setDocument(new JTextFieldLimit(4));
		
		// Alle info van klant inladen
		firstNameTextField.setText(klant.getVoornaam());
		lastNameTextField.setText(klant.getAchternaam());
		phoneTextField.setText(klant.getTelefoon());
		
		if (klant.isActief()) {
			activeCheckBox.setSelected(true);
		}
		
		Adres adres = klantAanpassenController.getAdres(klant.getAdresId());
		
		streetTextField.setText(adres.getStraat());
		streetNumberTextField.setText(adres.getHuisnummer());
		busTextField.setText(adres.getBus());
		postCodeTextField.setText(String.valueOf(adres.getPostcode()));
		cityTextField.setText(adres.getWoonplaats());
		countryTextField.setText(adres.getLand());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Add Info Labels
		for (int i = 0; i < labelTexts.length; i++) {
			infoLabel = new JLabel(labelTexts[i]);
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = i;
			panel.add(infoLabel, c);
		}
		
		// Add First Name Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(firstNameTextField, c);
		
		// Add Last Name Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(lastNameTextField, c);
		
		// Add Phone Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(phoneTextField, c);
		
		// Add Street Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(streetTextField, c);
		
		// Add Street Number Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 4;
		
		panel.add(streetNumberTextField, c);
		
		// Add Bus Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 5;
		
		panel.add(busTextField, c);
		
		// Add Post Code Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 6;
		panel.add(postCodeTextField, c);
		
		// Add City Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 7;
		panel.add(cityTextField, c);
		
		// Add Country Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 8;
		panel.add(countryTextField, c);
		
		// Add Active Checkbox
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 9;
		panel.add(activeCheckBox, c);
		
		// Add Save Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 10;
		panel.add(saveButton, c);
		
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String straat = streetTextField.getText();
					if (VeiligeInvoer.checkForOnlyLetters(straat) == false) {
						throw new EnkelLettersException();
					}
					
					String huisnummer = streetNumberTextField.getText();
					String bus = busTextField.getText();
					
					int postcode = Integer.parseInt(postCodeTextField.getText());
					if (postcode < 1000 || postcode > 9999) {
						throw new NietGeldigePostcodeException();
					}
					
					String stad = cityTextField.getText();
					if (VeiligeInvoer.checkForOnlyLetters(stad) == false) {
						throw new EnkelLettersException();
					}
					
					String land = countryTextField.getText();
					if (VeiligeInvoer.checkForOnlyLetters(land) == false) {
						throw new EnkelLettersException();
					}
					
					Adres adres = new Adres(straat, huisnummer, postcode, bus, stad, klant.getAdresId(), land, true);
					
					if (klantAanpassenController.updateAdres(adres)) {
						
						String firstName = firstNameTextField.getText();
						if (VeiligeInvoer.checkForOnlyLetters(firstName) == false) {
							throw new EnkelLettersException();
						}
						
						String lastName = lastNameTextField.getText();
						if (VeiligeInvoer.checkForOnlyLetters(lastName) == false) {
							throw new EnkelLettersException();
						}
						
						String phone = phoneTextField.getText();
						if (VeiligeInvoer.checkForOnlyNumbers(phone) == false) {
							throw new EnkelCijfersException();
						}
						
						Klant k = new Klant(klant.getContactId(), firstName, lastName, klant.getAdresId(), phone, activeCheckBox.isSelected());
						if (klantAanpassenController.updateKlant(k)) {
							JOptionPane.showMessageDialog(null, "Klant succesvol opgeslagen!");
							
							KlantBeheerView newView = new KlantBeheerView();
							view.changeView(newView.initialize(view));
						} else {
							JOptionPane.showMessageDialog(null, "Er is iets foutgegaan bij het opslaan van de klant, probeer opnieuw.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Er is iets foutgegaan bij het opslaan van het adres van de klant, probeer opnieuw.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Gelieve alle velden correct in te vullen.");
				} catch (EnkelLettersException e2) {
					JOptionPane.showMessageDialog(null, "U mocht velden niet leeg laten of speciale karakters gebruiken als invoer.");
				} catch (NietGeldigePostcodeException e3) {
					JOptionPane.showMessageDialog(null, "De ingevoerde postcode is ongeldig.");
				} catch (EnkelCijfersException e4) {
					JOptionPane.showMessageDialog(null, "Gelieve cijfers in te vullen waar cijfers verwacht worden.");
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
				KlantBeheerView newView = new KlantBeheerView();
				view.changeView(newView.initialize(view));
			}
		});
		
		return panel;
	}
}