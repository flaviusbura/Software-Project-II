package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.nmbs.controllers.HomeController;

public class HomeView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JButton logOutButton = new JButton("Uitloggen");
	
	private final JButton abonnementButton = new JButton("Abonnementen");
	private final JButton ticketButton = new JButton("Tickets");
	private final JButton verlorenVoorwerpenButton = new JButton("Verloren voorwerpen");
	private final JButton boeteButton = new JButton("Boetes");
	private final JButton routeButton = new JButton("Routes zoeken");
	private final JButton trainButton = new JButton("Treinen zoeken");
	private final JButton klantenBeheerButton = new JButton("Klantenbeheer");
	private final JButton pushButton = new JButton("Offline gegevens doorsturen");;
	
	private final JButton gebruikersBeheerButton = new JButton("Gebruikersbeheer");
	private final JButton statistiekButton = new JButton("Statistieken");
	private final JButton prijzenBeheerButton = new JButton("Prijzenbeheer");
	
	private final JLabel optionsLabel = new JLabel("Opties");
	private final JLabel adminLabel = new JLabel("Admin");

	private HomeController homeController = new HomeController();

	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Add Logout Button
		c.insets = new Insets(0, 0, 20, 0);
		c.gridx = 0;
		c.gridy = 0;
		panel.add(logOutButton, c);
		
		logOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginView newView = new LoginView();
				view.changeView(newView.initialize(view));
			}
		});
		
		// Add Options Label
		c.insets = new Insets(0, 0, 5, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(optionsLabel, c);

		// Add Abonnement Button
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(abonnementButton, c);
		
		abonnementButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AbonnementView newView = new AbonnementView();
				view.changeView(newView.initialize(view));
			}
		});

		// Add Ticket Button
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(ticketButton, c);
		
		ticketButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TicketView newView = new TicketView();
				view.changeView(newView.initialize(view));
			}
		});

		// Add Verloren Voorwerpen Button
		c.gridx = 2;
		c.gridy = 2;
		panel.add(verlorenVoorwerpenButton, c);
		
		verlorenVoorwerpenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VerlorenVoorwerpView newView = new VerlorenVoorwerpView();
				view.changeView(newView.initialize(view));
			}
		});

		// Add Boete Button
		c.gridx = 3;
		c.gridy = 2;
		panel.add(boeteButton, c);
		
		boeteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BoeteView newView = new BoeteView();
				view.changeView(newView.initialize(view));
			}
		});

		// Add Route Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(routeButton, c);
		
		routeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RouteSearchView newView = new RouteSearchView();
				view.changeView(newView.initialize(view));
			}
		});
		
		// Add Train Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(trainButton, c);
		
		trainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TrainSearchView newView = new TrainSearchView();
				view.changeView(newView.initialize(view));
			}
		});
		
		// Add Klantenbeheer Button
		c.gridx = 2;
		c.gridy = 3;
		panel.add(klantenBeheerButton, c);
		
		klantenBeheerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KlantBeheerView newView = new KlantBeheerView();
				view.changeView(newView.initialize(view));
			}
		});	
		
		// Add Push Button
		c.gridx = 3;
		c.gridy = 3;
		panel.add(pushButton, c);
		
		pushButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (homeController.pushAllToRemote()) {
					JOptionPane.showMessageDialog(null, "Alles is succesvol gepusht naar de database.");
				} else {
					JOptionPane.showMessageDialog(null, "Er is iets fout gegaan tijdens het pushen van de lokale database.");
				}
			}
		});
		
		if (View.getIngelogdGebruiker().getRol() == 2) {
			// Add Admin Label
			c.insets = new Insets(20, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 4;
			panel.add(adminLabel, c);
			
			// Add Gebruikersbeheer Button
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 5;
			panel.add(gebruikersBeheerButton, c);
			
			gebruikersBeheerButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					GebruikerBeheerView newView = new GebruikerBeheerView();
					view.changeView(newView.initialize(view));
				}
			});

			// Add Prijzenbeheer Button
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 5;
			panel.add(prijzenBeheerButton, c);
			
			prijzenBeheerButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PrijsBeheerView.setPrijsBeheerControllerToNull();
					view.changeView(PrijsBeheerView.initialize(view));
					
				}
			});
			
			// Add Statistiek Button
			c.gridx = 2;
			c.gridy = 5;
			panel.add(statistiekButton, c);
			
			statistiekButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					StatistiekView.setStatistiekControllerToNull();
					view.changeView(StatistiekView.initialize(view));
				}
			});
		}
		
		return panel;
	}
}
