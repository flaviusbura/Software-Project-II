package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.BasisPrijsTicket_DelController;

public class BasisPrijsTicket_DelView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JLabel prijsLabel = new JLabel("Geef het Basisprijs ID");
	
	private final JTextField prijsTextField = new JTextField(10);

	private final JButton deleteButton = new JButton("Prijs verwijderen");
	private final JButton backButton = new JButton("Terug");

	private BasisPrijsTicket_DelController basisPrijsTicket_DelController = new BasisPrijsTicket_DelController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	
		// Add Prijs Label
		c.gridx = 0;
		c.gridy = 1;
		panel.add(prijsLabel, c);
		
		// Add Prijs Text Field
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(prijsTextField, c);

		// Add Delete Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(deleteButton, c);
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(prijsTextField.getText());
					
					if (basisPrijsTicket_DelController.deletePrijs(id)) {
						JOptionPane.showMessageDialog(panel, "Prijs verwijderd.");
					} else {
						JOptionPane.showMessageDialog(panel, "Er is iets foutgelopen bij het verwijderen van de prijs, probeer opnieuw.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(panel, "Geef een geldig ID in.");
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
				BasisPrijsTicketView newView = new BasisPrijsTicketView();
				view.changeView(newView.initialize(view));
			}
		});

		return panel;
	}
}