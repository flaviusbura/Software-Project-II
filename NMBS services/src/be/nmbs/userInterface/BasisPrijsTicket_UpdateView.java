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

import be.nmbs.controllers.BasisPrijsTicket_UpdateController;
import be.nmbs.logic.TypeTicket;

public class BasisPrijsTicket_UpdateView {
	private final JPanel panel = new JPanel(new GridBagLayout());

	private final JLabel typeLabel = new JLabel("Type Ticket");
	private final JLabel prijsLabel = new JLabel("Update naar");
	
	private final JTextField prijsTextField= new JTextField(10);

	private JComboBox<TypeTicket> typeComboBox;
	
	private final JButton updateButton = new JButton("Prijs aanpassen");
	private final JButton backButton = new JButton("Terug");

	private final BasisPrijsTicket_UpdateController basisPrijsTicket_UpdateController = new BasisPrijsTicket_UpdateController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	
		// Add Type Label
		c.gridx = 0;
		c.gridy = 0;
		panel.add(typeLabel, c);
		
		// Add Type Combobox
		ArrayList<TypeTicket> allType = basisPrijsTicket_UpdateController.getAllTicketTypes();
		typeComboBox = new JComboBox<>();
		for (TypeTicket tt : allType) {
			typeComboBox.addItem(tt);
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
				TypeTicket typeAboId = (TypeTicket) typeComboBox.getSelectedItem();

				try {
					double prijs = Double.parseDouble(prijsTextField.getText());
					
					if (basisPrijsTicket_UpdateController.updatePrijs(typeAboId.getId(), prijs)) {
						JOptionPane.showMessageDialog(panel, "Prijs aangepast.");
					} else {
						JOptionPane.showMessageDialog(panel, "Er is iets foutgelopen bij het aanpassen van de prijs, probeer opnieuw.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(panel, "Geef een geldige prijs in.");
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
				BasisPrijsTicketView newView = new BasisPrijsTicketView();
				view.changeView(newView.initialize(view));
			}
		});

		return panel;
	}
}