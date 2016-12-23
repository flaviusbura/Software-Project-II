package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PrijsView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JButton ticketButton = new JButton("Voor ticket");
	private final JButton abonnementButton = new JButton("Voor abonnement");
	private final JButton backButton = new JButton("Terug");

	public JPanel initialize(View view) {		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		// Add Ticket Button
		c.gridx = 0;
		c.gridy = 0;
		panel.add(ticketButton, c);
		
		ticketButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsTicketView newView = new BasisPrijsTicketView();
				view.changeView(newView.initialize(view));
			}
		});
		
		// Add Abonnement Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(abonnementButton, c);
		
		abonnementButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BasisPrijsAbonnementView newView = new BasisPrijsAbonnementView();
				view.changeView(newView.initialize(view));
			}
		});
		
		// Add Back Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(backButton, c);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsBeheerView newView = new PrijsBeheerView();
				view.changeView(newView.initialize(view));
			}
		});
		
		return panel;
	}
}
