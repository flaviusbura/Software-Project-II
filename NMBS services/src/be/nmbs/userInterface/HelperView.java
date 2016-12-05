package be.nmbs.userInterface;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelperView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame getjFrame() {
		return jFrame;
	}

	public JTextField getjTextField() {
		return jTextField;
	}

	private JFrame jFrame;
	private JPanel jPanel;
	private JLabel jLabel;
	private JTextField jTextField;
	private JButton ok;
	private JButton annuleren;
	
	public HelperView(String wijzig, String nieuw) {
		jFrame = new JFrame(wijzig);
		jPanel = new JPanel(new GridBagLayout());
		jLabel = new JLabel(nieuw);
		jTextField = new JTextField(10);
		ok = new JButton("Ok");
		annuleren = new JButton("Annuleren");

		jFrame.setSize(400, 200);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		jFrame.setLocation(dim.width / 2 - jFrame.getSize().width / 2,
				dim.height / 2 - jFrame.getSize().height / 2);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		jPanel.add(jLabel, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		jPanel.add(jTextField, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		jPanel.add(ok, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		jPanel.add(annuleren, c);
		//Dit zorgt ervoor dat de code die in de actionlistener staat wordt afgevuurd als enter ingeduwd wordt.
		jFrame.getRootPane().setDefaultButton(ok);
		
		jFrame.add(jPanel);
		jFrame.setVisible(true);
	}

	public JButton getOk() {
		return ok;
	}

	public JButton getAnnuleren() {
		return annuleren;
	}
}
