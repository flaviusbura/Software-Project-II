package be.nmbs.userInterface;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;


public class KeuzeSchermView {
	private static JButton btnAbonnement;
	private static JButton btnBoete;
	private static JButton btnTicket;
	private static JButton btnVerlorenvoorwerpen;
	private static JButton btnOpzoeken;
	
	
	@SuppressWarnings("static-access")
	public static JPanel initialiseView() {
		JPanel panel = new JPanel();
		
		btnAbonnement = new JButton("Abonnementen");
		GridBagConstraints c = new GridBagConstraints();
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(btnAbonnement, c);
		
		btnTicket = new JButton("Tickets");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(btnTicket, c);
		
		btnVerlorenvoorwerpen = new JButton("Verlorenvoorwerpen");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(btnVerlorenvoorwerpen, c);
		
		btnBoete = new JButton("Boetes");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(btnBoete, c);
		
		btnOpzoeken = new JButton("Trein opzoeken");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(btnOpzoeken, c);
		return panel;
		
	}
	

	public static JButton getBtnAbonnement() {
		return btnAbonnement;
	}

}
