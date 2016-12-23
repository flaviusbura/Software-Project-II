package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BasisPrijsTicketView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JButton insertButton = new JButton("Prijs toevoegen");
	private final JButton deleteButton = new JButton("Prijs verwijderen");
	private final JButton updateButton = new JButton("Prijs updaten");
	private final JButton backButton = new JButton("Terug");

	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		// Add Insert Button
		c.gridx = 0;
		c.gridy = 0;
		panel.add(insertButton, c);
		
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsTicket_AddView newView = new BasisPrijsTicket_AddView();
				view.changeView(newView.initialize(view));
			}
		});

		// Add Delete Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(deleteButton, c);
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsTicket_DelView newView = new BasisPrijsTicket_DelView();
				view.changeView(newView.initialize(view));
			}
		});

		// Add Update Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(updateButton, c);
		
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsTicket_UpdateView newView = new BasisPrijsTicket_UpdateView();
				view.changeView(newView.initialize(view));
			}
		});

		// Add Back Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(backButton, c);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsView newView = new PrijsView();
				view.changeView(newView.initialize(view));
			}
		});

		return panel;
	}
}