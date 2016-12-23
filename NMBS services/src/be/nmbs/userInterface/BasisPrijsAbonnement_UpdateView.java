package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.BasisPrijsAbonnement_UpdateController;
import be.nmbs.logic.TypeAbonnement;

public class BasisPrijsAbonnement_UpdateView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JLabel typeLabel = new JLabel("Type Abonnement");
	private final JLabel prijsLabel = new JLabel("Update naar");

	private final JTextField prijsTextField= new JTextField(10);
	
	private final JButton updateButton = new JButton("Prijs Updaten");
	private final JButton backButton = new JButton("Terug");
	
	private JComboBox<TypeAbonnement> typeComboBox;

	private final BasisPrijsAbonnement_UpdateController basisPrijsAbonnement_UpdateController = new BasisPrijsAbonnement_UpdateController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	
		// Add Type Label
		c.gridx = 0;
		c.gridy = 0;
		panel.add(typeLabel, c);
		
		// Add Type Combo Box
		ArrayList<TypeAbonnement> allType = basisPrijsAbonnement_UpdateController.getAllAbonnementTypes();
		typeComboBox = new JComboBox<>();
		for (TypeAbonnement ta : allType) {
			typeComboBox.addItem(ta);
		}
		
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(typeComboBox, c);
		
		// Add Prijs Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(prijsLabel, c);
		
		// Add Prijs Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(prijsTextField, c);

		// Add Update Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(updateButton, c);
		
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TypeAbonnement typeAboId = (TypeAbonnement) typeComboBox.getSelectedItem();

				try {
					double prijs = Double.parseDouble(prijsTextField.getText());
				
					if (basisPrijsAbonnement_UpdateController.updatePrijs(typeAboId.getId(), prijs)) {
						JOptionPane.showMessageDialog(view.getPanel(), "Prijs aangepast.");
					} else {
						JOptionPane.showMessageDialog(view.getPanel(), "Er is iets misgelopen bij het aanpassen van de prijs, probeer opnieuw.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(view.getPanel(), "Geef een geldige prijs in.");
				}
			}
		});
		
		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(backButton, c);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsAbonnementView newView = new BasisPrijsAbonnementView();
				view.changeView(newView.initialize(view));
			}
		});

		return panel;
	}
}