package be.nmbs.userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class HoofdmenuGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoofdmenuGUI window = new HoofdmenuGUI();
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
	public HoofdmenuGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("D:\\SamL\\Pictures\\nmbsoranje2.jpg"));
		lblLogo.setBounds(0, 0, 408, 206);
		frame.getContentPane().add(lblLogo);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setOpaque(true);
		lblHeader.setBackground(new Color(252, 172, 53));
		lblHeader.setForeground(Color.ORANGE);
		lblHeader.setBounds(0, 0, 2097, 206);
		frame.getContentPane().add(lblHeader);
		
		JButton btnTreinInfo = new JButton("trein informatie");
		btnTreinInfo.setForeground(new Color(0, 0, 0));
		btnTreinInfo.setBackground(new Color(70, 130, 180));
		btnTreinInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreinInfoGUI ti = new TreinInfoGUI();
				ti.newTreinInfo();
				frame.setVisible(false);
			}
		});
		btnTreinInfo.setBounds(65, 248, 204, 59);
		frame.getContentPane().add(btnTreinInfo);
		
		JButton btnAbonnementen = new JButton("abonnementen");
		btnAbonnementen.setBackground(new Color(70, 130, 180));
		btnAbonnementen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AbonnementenGUI aboGUI = new AbonnementenGUI();
				aboGUI.newAboGUI();
				frame.setVisible(false);
			}
		});
		btnAbonnementen.setBounds(65, 342, 204, 59);
		frame.getContentPane().add(btnAbonnementen);
		
		JButton btnBoetes = new JButton("boetes");
		btnBoetes.setBackground(new Color(70, 130, 180));
		btnBoetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoetesGUI bg = new BoetesGUI();
				bg.newBoetesGUI();
				frame.setVisible(false);
			}
		});
		btnBoetes.setBounds(65, 426, 204, 59);
		frame.getContentPane().add(btnBoetes);
		
		JButton btnTicket = new JButton("ticket");
		btnTicket.setBackground(new Color(70, 130, 180));
		btnTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketGUI tg = new TicketGUI();
				tg.newTicketGUI();
				frame.setVisible(false);
			}
		});
		btnTicket.setBounds(65, 518, 204, 59);
		frame.getContentPane().add(btnTicket);
		
		JButton btnStationInformatie = new JButton("station informatie");
		btnStationInformatie.setBackground(new Color(70, 130, 180));
		btnStationInformatie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StationInfoGUI sig = new StationInfoGUI();
				sig.newStationInfoGUI();
				frame.setVisible(false);
			}
		});
		btnStationInformatie.setBounds(65, 606, 204, 59);
		frame.getContentPane().add(btnStationInformatie);
		
		JButton btnRouteInformatie = new JButton("route informatie");
		btnRouteInformatie.setBackground(new Color(70, 130, 180));
		btnRouteInformatie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RouteInfoGUI rig = new RouteInfoGUI();
				rig.newRouteInfoGUI();
				frame.setVisible(false);
			}
		});
		btnRouteInformatie.setBounds(379, 248, 204, 59);
		frame.getContentPane().add(btnRouteInformatie);
		
		JButton btnGroepsreservaties = new JButton("groepsreservaties");
		btnGroepsreservaties.setBackground(new Color(70, 130, 180));
		btnGroepsreservaties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GroepsreservatiesGUI sig = new GroepsreservatiesGUI();
				sig.newGroepsReservatieGUI();
				frame.setVisible(false);
			}
		});
		btnGroepsreservaties.setBounds(379, 342, 204, 59);
		frame.getContentPane().add(btnGroepsreservaties);
		
		JButton btnVerlorenVoorwerpen = new JButton("verloren voorwerpen");
		btnVerlorenVoorwerpen.setBackground(new Color(70, 130, 180));
		btnVerlorenVoorwerpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerlorenVoorwerpenGUI vvg = new VerlorenVoorwerpenGUI();
				vvg.newVerloorenVoorwerpGUI();
				frame.setVisible(false);
			}
		});
		btnVerlorenVoorwerpen.setBounds(379, 426, 204, 59);
		frame.getContentPane().add(btnVerlorenVoorwerpen);
	}

}
