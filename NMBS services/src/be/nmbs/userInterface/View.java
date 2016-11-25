package be.nmbs.userInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;

import be.nmbs.logic.Gebruiker;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private static Gebruiker ingelogdGebruiker;

	public View() {
		this.setTitle("NMBS Services");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setPanelToNull() {
		panel = null;
	}

	public static void setIngelogdGebruiker(Gebruiker ingelogdGebruiker) {
		View.ingelogdGebruiker = ingelogdGebruiker;
	}

	public static Gebruiker getIngelogdGebruiker() {
		return ingelogdGebruiker;
	}

	public void changeView(JPanel panel) {
		if (this.panel != null) {
			this.panel.removeAll();
			this.setPanelToNull();
			this.setPanel(panel);
			this.add(panel);
			this.setVisible(true);
		} else {
			this.setPanel(panel);
			this.add(panel);
			this.setVisible(true);
		}
	}
}
