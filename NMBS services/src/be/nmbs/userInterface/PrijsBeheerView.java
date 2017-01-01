package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PrijsBeheerView {
	private final JPanel panel = new JPanel(new GridBagLayout());

	private final JButton prijsButton = new JButton("Prijzen");
	private final JButton coefficientButton = new JButton("Coefficient");
	private final JButton backButton = new JButton("Terug");

	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Add Prijs Button
		c.gridx = 0;
		c.gridy = 0;
		panel.add(prijsButton, c);
		
		prijsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijsView newView = new PrijsView();
				view.changeView(newView.initialize(view));
			}
		});
		
		// Add Coefficient Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(coefficientButton, c);
		
		coefficientButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CoefficientView newView = new CoefficientView();
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
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
		
		return panel;
	}
}
