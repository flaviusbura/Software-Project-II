package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.KlantenBeheerController;

public class NieuwAbonnementAanmakenView {
	private static JButton aboMaken;
	private static JButton actieAnnuleren;
	private static JLabel voornaam;
	private static JTextField voornaamText;
	private static JLabel naam;
	private static JTextField naamText;
	//private static JComboBox<E>
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static KlantenBeheerController klantenBeheerController;

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
			panel = new JPanel(new GridBagLayout());

			voornaam = new JLabel("Voornaam");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(voornaam, c);

			voornaamText = new JTextField(30);
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			panel.add(voornaamText, c);
			
			klantenBeheerController = new KlantenBeheerController(view);
			return panel;
	}
}
