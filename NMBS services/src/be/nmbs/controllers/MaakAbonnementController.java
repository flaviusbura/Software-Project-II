package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import be.nmbs.userInterface.View;
import java.sql.Timestamp;
import be.nmbs.database.AbonnementDAO;
import be.nmbs.database.AbonnementTypeDAO;
import be.nmbs.database.KlantDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Klant;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.userInterface.MaakAbonnementView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.KlantWijzigenView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//MaakAbonnementView
public class MaakAbonnementController {
	public MaakAbonnementController(View view) {

		MaakAbonnementView.getMaakAbonnement().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					Gebruiker gebruiker = View.getIngelogdGebruiker();
					
					// gebruik van veiligeInvoer klasse
					//String route = VeiligeInvoer.checkString(MaakAbonnementView.getTxtRoute(),MaakAbonnementView.getTxtRoute().getText());
					
					String route = (String) MaakAbonnementView.getDepartureField().getSelectedItem() + " - " + (String) MaakAbonnementView.getArrivalField().getSelectedItem();
					Timestamp startDatum = new Timestamp(System.currentTimeMillis());

					// eindDatum omzetten
					DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					String eindDatum = MaakAbonnementView.getTxtEindDatum().getText();
					Date date2 = format.parse(eindDatum);
					Long tijd2 = date2.getTime();
					Timestamp ts2 = new Timestamp(tijd2);

					Prijs prijs = (Prijs) MaakAbonnementView.getPrijzenLijst().getSelectedItem();
					int prijsId = prijs.getPrijsId();

					Korting korting = (Korting) MaakAbonnementView.getKortingLijst().getSelectedItem();
					int kortingId = korting.getId();
					AbonnementTypeDAO typeDAO = new AbonnementTypeDAO();

					try {
						int row = MaakAbonnementView.getTable().getSelectedRow();
						int contactID = Integer
								.valueOf((String) MaakAbonnementView.getTable().getModel().getValueAt(row, 0));

						Abonnement abonnement = new Abonnement(contactID, gebruiker.getId(), route, ts2, prijsId,
								kortingId, true);

						AbonnementDAO aboDao = new AbonnementDAO();
						String keuze = (String) MaakAbonnementView.getCombo().getSelectedItem();

						if (keuze == "3 maanden") {
							aboDao.insertDrieMaandAbonnement(abonnement, startDatum);
							JOptionPane.showMessageDialog(view.getPanel(), "Abonnement aangemaakt voor drie maanden");
							
						} else if (keuze == "6 maanden") {
							aboDao.insertZesMaandAbonnement(abonnement, startDatum);
							JOptionPane.showMessageDialog(view.getPanel(), "Abonnement aangemaakt voor zes maanden");
							
						} else if (keuze == "9 maanden") {
							aboDao.insertNegenMaandAbonnement(abonnement, startDatum);
							JOptionPane.showMessageDialog(view.getPanel(), "Abonnement aangemaakt voor negen maanden");
							
						} else if (keuze == "12 maanden") {
							aboDao.insertEenJaarAbonnement(abonnement, startDatum);
							JOptionPane.showMessageDialog(view.getPanel(), "Abonnement aangemaakt voor een jaar");
							
						}

						typeDAO.insertTypeAbonnement(aboDao.getIdByStartDatum(startDatum), keuze);
					} catch (ArrayIndexOutOfBoundsException e2) {

						JOptionPane.showMessageDialog(null,
								"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
						MaakAbonnementView.setMaakAbonnementControllerToNull();
						view.changeView(MaakAbonnementView.initialize(view));

					}
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});

		MaakAbonnementView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
		
		MaakAbonnementView.getBtnzoek().addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				String naam;
				naam = MaakAbonnementView.getTxtZoek().getText();
				if (naam.equals("")) {
					JOptionPane.showMessageDialog(null, "Geen klanten gevonden.");
					MaakAbonnementView.getLijst().clear();
					MaakAbonnementView.getTxtZoek().setText("");
					MaakAbonnementView.setMaakAbonnementControllerToNull();
					view.changeView(MaakAbonnementView.initialize(view));
				} else {
					ArrayList<Klant> lijst = new ArrayList<>();
					KlantDAO klantDAO = new KlantDAO();
					lijst = klantDAO.getAllByAchternaam(naam);
					if (lijst.size() == 0) {
						JOptionPane.showMessageDialog(null, "Geen klanten gevonden met deze achternaam.");
						MaakAbonnementView.setMaakAbonnementControllerToNull();
						MaakAbonnementView.getLijst().clear();
						view.changeView(MaakAbonnementView.initialize(view));
					} else {
						MaakAbonnementView.setLijst(lijst);
						MaakAbonnementView.setMaakAbonnementControllerToNull();
						view.changeView(MaakAbonnementView.initialize(view));
					}
				}
			}
		});
	}
}