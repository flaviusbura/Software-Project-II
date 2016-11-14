package be.nmbs.userInterface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BoetesGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newBoetesGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoetesGUI window = new BoetesGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BoetesGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBoetes = new JLabel("boetes");
		lblBoetes.setBounds(88, 149, 46, 14);
		frame.getContentPane().add(lblBoetes);

		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("D:\\SamL\\Pictures\\nmbsoranje2.jpg"));
		lblLogo.setBounds(0, 0, 408, 206);
		frame.getContentPane().add(lblLogo);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setOpaque(true);
		lblHeader.setBackground(new Color(252, 172, 53));
		lblHeader.setBounds(0, 0, 2097, 206);
		frame.getContentPane().add(lblHeader);
	}

}
