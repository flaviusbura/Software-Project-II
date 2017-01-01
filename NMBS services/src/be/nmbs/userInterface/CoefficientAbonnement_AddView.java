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

import be.nmbs.controllers.CoefficientAbonnement_AddController;
import be.nmbs.logic.CoefficientAbonnement;
import be.nmbs.logic.TypeAbonnement;

public class CoefficientAbonnement_AddView {
	private final JPanel panel = new JPanel(new GridBagLayout());

	private final JLabel typeLabel = new JLabel("Type Abonnement");
	private final JLabel coefficientLabel = new JLabel("Coefficient");
	
	private final JTextField coefficientTextField = new JTextField(10);
	
	private JComboBox<TypeAbonnement> typeComboBox;
	
	private final JButton addButton = new JButton("Coefficient Toevoegen");
	private final JButton backButton = new JButton("Terug");

	private CoefficientAbonnement_AddController coefficientAbonnement_AddController = new CoefficientAbonnement_AddController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	
		// Add Type Label
		c.gridx = 0;
		c.gridy = 0;
		panel.add(typeLabel, c);
		
		// Add Type Combobox
		ArrayList<TypeAbonnement> allType = coefficientAbonnement_AddController.getAllAbonnementTypes();
		typeComboBox = new JComboBox<TypeAbonnement>();
		for (TypeAbonnement ta : allType) {
			typeComboBox.addItem(ta);
		}
		
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(typeComboBox, c);
		
		// Add Coefficient Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(coefficientLabel, c);
		
		// Add Coefficient Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(coefficientTextField, c);

		// Add Add Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(addButton, c);
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TypeAbonnement typeAboId = (TypeAbonnement) typeComboBox.getSelectedItem();
				
				try {
					double coeff = Double.parseDouble(coefficientTextField.getText());
					
					CoefficientAbonnement ca = new CoefficientAbonnement(typeAboId.getId(),coeff);
					
					if (coefficientAbonnement_AddController.insertAbbonementCoefficient(ca)) {
						JOptionPane.showMessageDialog(panel, "Coefficient toegevoegd.");
					} else {
						JOptionPane.showMessageDialog(panel, "Er is iets foutgelopen bij het toevoegen van de coefficient, probeer opnieuw.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(panel, "Geef een geldige coefficient in.");
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
				CoefficientAbonnementView newView = new CoefficientAbonnementView();
				view.changeView(newView.initialize(view));
			}
		});

		return panel;
	}
}