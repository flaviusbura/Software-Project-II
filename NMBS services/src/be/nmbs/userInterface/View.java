package be.nmbs.userInterface;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import be.nmbs.logic.Gebruiker;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private static Gebruiker ingelogdGebruiker;

	public View() {
		this.setTitle("NMBS Services");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
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
			this.panel.setVisible(false);
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
