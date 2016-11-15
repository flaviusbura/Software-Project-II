package be.nmbs.userInterface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TreinInfoGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newTreinInfo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreinInfoGUI window = new TreinInfoGUI();
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
	public TreinInfoGUI() {
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
		
		JLabel lblInfo = new JLabel("info");
		lblInfo.setBounds(26, 160, 46, 14);
		frame.getContentPane().add(lblInfo);

		
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
