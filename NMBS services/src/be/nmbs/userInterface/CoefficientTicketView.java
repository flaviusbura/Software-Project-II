package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CoefficientTicketView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JButton insertButton = new JButton("Coefficient toevoegen");
	private final JButton deleteButton = new JButton("Coefficient verwijderen");
	private final JButton updateButton = new JButton("Coefficient aanpassen");
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
				CoefficientTicket_AddView newView = new CoefficientTicket_AddView();
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
				CoefficientTicket_DelView newView = new CoefficientTicket_DelView();
				view.changeView(newView.initialize(view));
			}
		});

		// Add UpdateButton
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(updateButton, c);
		
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CoefficientTicket_UpdateView newView = new CoefficientTicket_UpdateView();
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
				CoefficientView newView = new CoefficientView();
				view.changeView(newView.initialize(view));
			}
		});
		
		return panel;
	}
}