package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GebruikerView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	private final JButton addGebruikerButton = new JButton("Gebruiker toevoegen");
	private final JButton editGebruikerButton = new JButton("Gebruikers wijzigen");
	private final JButton backButton = new JButton("Terug");
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Add AddGebruiker Button
		c.gridx = 0;
		c.gridy = 0;
		panel.add(addGebruikerButton, c);
		
		addGebruikerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NieuwGebruikerAanmakenView newView = new NieuwGebruikerAanmakenView();
				view.changeView(newView.initialize(view));
			}
		});
		
		// Add EditGebruiker Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(editGebruikerButton, c);
		
		editGebruikerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GebruikerWijzigenView newView = new GebruikerWijzigenView();
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
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
		
		return panel;
	}
}