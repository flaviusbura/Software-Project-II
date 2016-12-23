package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author Abdel-Portable
 *
 */
public class AbonnementView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JButton maakAbonnementButton = new JButton("Abonnement aanmaken");
	private final JButton verlengAbonnementButton = new JButton("Abonnement verlengen");
	private final JButton backButton = new JButton("Terug");

	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		// Add Maak Abonnement Button
		c.gridx = 0;
		c.gridy = 0;
		panel.add(maakAbonnementButton, c);
		
		maakAbonnementButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MaakAbonnementView.setMaakAbonnementControllerToNull();
				view.changeView(MaakAbonnementView.initialize(view));
			}
		});
		
		// Add Verleng Abonnement Button
		c.gridx = 0;
		c.gridy = 1;
		panel.add(verlengAbonnementButton, c);
		
		verlengAbonnementButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VerlengAbonnementView.setVerlengAbonnementControllerToNull();
				view.changeView(VerlengAbonnementView.initialize(view));
			}
		});
		
		// Add Back Button
		c.fill = GridBagConstraints.HORIZONTAL;
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