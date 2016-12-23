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

import be.nmbs.controllers.BasisPrijsAbonnement_AddController;
import be.nmbs.logic.BasisprijsAbonnement;
import be.nmbs.logic.TypeAbonnement;

public class BasisPrijsAbonnement_AddView {
	private final JPanel panel = new JPanel(new GridBagLayout());

	private final JLabel prijsLabel = new JLabel("Prijs");
	private final JLabel typeLabel = new JLabel("Type Abonnement");
	
	private final JTextField prijsTextField = new JTextField(10);
	
	private final JButton addPrijsButton = new JButton("Prijs Toevoegen");
	private final JButton backButton = new JButton("Terug");

	private JComboBox<TypeAbonnement> typeComboBox;

	private final BasisPrijsAbonnement_AddController basisPrijsAbonnement_AddController = new BasisPrijsAbonnement_AddController();

	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		// Add Type Label
		c.gridx = 0;
		c.gridy = 0;
		panel.add(typeLabel, c);

		// Add Type Combobox
		ArrayList<TypeAbonnement> allType = basisPrijsAbonnement_AddController.getAllAbonnementTypes();
		typeComboBox = new JComboBox<TypeAbonnement>();
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
		c.gridy = 1;
		panel.add(prijsLabel, c);

		// Add Prijs Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(prijsTextField, c);

		// Add Add Prijs Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(addPrijsButton, c);
		
		addPrijsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TypeAbonnement typeAboId = (TypeAbonnement) typeComboBox.getSelectedItem();
				
				try {
					double prijs = Double.parseDouble(prijsTextField.getText());
					
					BasisprijsAbonnement bpa = new BasisprijsAbonnement(typeAboId.getId(), prijs);
					
					if (basisPrijsAbonnement_AddController.insertBasisPrijs(bpa)) {
						JOptionPane.showMessageDialog(panel, "Prijs toegevoegd.");
					} else {
						JOptionPane.showMessageDialog(panel, "Er is iets foutgelopen bij het toevoegen van de prijs, probeer opnieuw.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(panel, "Geef een geldige prijs in.");
				}
			}
		}); 

		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
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