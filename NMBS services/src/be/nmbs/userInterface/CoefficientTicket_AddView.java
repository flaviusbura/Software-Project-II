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

import be.nmbs.controllers.CoefficientTicket_AddController;
import be.nmbs.logic.CoefficientTicket;
import be.nmbs.logic.TypeTicket;

public class CoefficientTicket_AddView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JLabel typeLabel = new JLabel("Type ticket");
	private final JLabel coefficientLabel = new JLabel("Coëfficient");
	
	private final JTextField coefficientTextField = new JTextField(10);
	
	private JComboBox<TypeTicket> typeComboBox;
	
	private final JButton addButton = new JButton("Coëfficient toevoegen");
	private final JButton backButton = new JButton("Terug");

	private CoefficientTicket_AddController coefficientTicket_AddController = new CoefficientTicket_AddController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	
		// Add Type Label
		c.gridx = 0;
		c.gridy = 0;
		panel.add(typeLabel, c);
		
		// Add Type Combobox
		ArrayList<TypeTicket> allType = coefficientTicket_AddController.getAllTicketTypes();
		typeComboBox = new JComboBox<>();
		for (TypeTicket tt : allType) {
			typeComboBox.addItem(tt);
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
				TypeTicket typeAboId = (TypeTicket) typeComboBox.getSelectedItem();
				
				try {
					double coeff = Double.parseDouble(coefficientTextField.getText());
	
					CoefficientTicket ct = new CoefficientTicket(typeAboId.getId(), coeff);
	
					if (coefficientTicket_AddController.insertCoefficient(ct)) {
						JOptionPane.showMessageDialog(panel, "Coëfficient toegevoegd.");
					} else {
						JOptionPane.showMessageDialog(panel, "Er is iets foutgelopen bij het toevoegen van de coëfficient, probeer opnieuw.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(panel, "Geef een geldige coëfficient in.");
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
				CoefficientTicketView newView = new CoefficientTicketView();
				view.changeView(newView.initialize(view));
			}
		});

		return panel;
	}
}