package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import be.nmbs.userInterface.View;
import java.sql.Timestamp;

import be.nmbs.database.CoefficientAbonnementDAO;
import be.nmbs.database.CoefficientTicketDAO;
import be.nmbs.database.BasisprijsAbonnementenDAO;
import be.nmbs.database.BasisprijsTicketDAO;
import be.nmbs.database.AbonnementDAO;
import be.nmbs.database.AbonnementPrijsDAO;
import be.nmbs.database.AbonnementTypeDAO;
import be.nmbs.database.KlantDAO;
import be.nmbs.database.KortingDAO;
import be.nmbs.database.TicketPrijsDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Klant;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.Prijs_abonnement;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.TypeAbonnement;
import be.nmbs.userInterface.MaakAbonnementView;
import be.nmbs.userInterface.TicketView;
import be.nmbs.userInterface.HomeView;
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

					String route = (String) MaakAbonnementView.getDepartureField().getSelectedItem() + " - "
							+ (String) MaakAbonnementView.getArrivalField().getSelectedItem();
					Timestamp startDatum = new Timestamp(System.currentTimeMillis());
					// eindDatum omzetten
					DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					String eindDatum = MaakAbonnementView.getTxtEindDatum().getText();
					Date date2 = format.parse(eindDatum);
					Long tijd2 = date2.getTime();
					Timestamp ts2 = new Timestamp(tijd2);

					Korting korting = (Korting) MaakAbonnementView.getKortingLijst().getSelectedItem();
					int kortingId = korting.getId();
					AbonnementTypeDAO typeDAO = new AbonnementTypeDAO();
					try {
						int row = MaakAbonnementView.getTable().getSelectedRow();
						int contactID = Integer
								.valueOf((String) MaakAbonnementView.getTable().getModel().getValueAt(row, 0));

						// typeDAO.insertTypeAbonnement(aboDao.getIdByStartDatum(startDatum),
						// keuze);
						/**
						 * Variabelen declarern om de prijs berekening mogelijk
						 * maken
						 */
						TypeAbonnement type = (TypeAbonnement) MaakAbonnementView.getTypeLijst().getSelectedItem();
						BasisprijsAbonnementenDAO bpaDAO = new BasisprijsAbonnementenDAO();
						CoefficientAbonnementDAO caDAO = new CoefficientAbonnementDAO();
						KortingDAO kortingDAO = new KortingDAO();

						int typeAbonnementId = type.getId();

						int basisprijsid = bpaDAO.getBasisPrijsIdbyTypeId(typeAbonnementId);

						double basisprijs = bpaDAO.getPrijs_ById(typeAbonnementId);

						int coefid = caDAO.getCoefficientIdByTypeId(typeAbonnementId);
						System.out.println("coefid: " + coefid);

						double coef = caDAO.getCoefficient_ById(coefid);
						System.out.println("coef: " + coef);

						double totaal = basisprijs * coef;
						System.out.println("totaal: " + totaal);

						Prijs_abonnement prijs_abonnement = new Prijs_abonnement(typeAbonnementId, coefid, basisprijsid,
								totaal);
						Abonnement abonnement = new Abonnement(contactID, gebruiker.getId(), route, ts2, kortingId,
								prijs_abonnement, true);

						AbonnementPrijsDAO apdao = new AbonnementPrijsDAO();

						int idvoorprijs = apdao.insert(prijs_abonnement);
						prijs_abonnement.setPrijs_abonnementid(idvoorprijs);
						abonnement.setPrijsId(prijs_abonnement);
						System.out.println("idvoorprijs: " + idvoorprijs);
						System.out.println("Prijs abonnement ID: " + prijs_abonnement.getPrijs_abonnementid());

						// System.out.println("abonnementid: " +
						// abonnement.getPrijsAboId().getPrijs_abonnementid());
						AbonnementDAO aboDao = new AbonnementDAO();
						String keuze = (String) MaakAbonnementView.getCombo().getSelectedItem();

						if (keuze == "3 maanden") {
							aboDao.insertDrieMaandAbonnement(abonnement, startDatum);

						} else if (keuze == "6 maanden") {
							aboDao.insertZesMaandAbonnement(abonnement, startDatum);

						} else if (keuze == "9 maanden") {
							aboDao.insertNegenMaandAbonnement(abonnement, startDatum);

						} else if (keuze == "12 maanden") {
							aboDao.insertEenJaarAbonnement(abonnement, startDatum);

						}
						/**
						 * Prijs berekening
						 */

						JOptionPane.showMessageDialog(view.getPanel(), "Abonnement aangemaakt voor " + keuze);

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
		MaakAbonnementView.getToonPrijs().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TypeAbonnement type = (TypeAbonnement) MaakAbonnementView.getTypeLijst().getSelectedItem();
				Korting korting = (Korting) MaakAbonnementView.getKortingLijst().getSelectedItem();
				int kortingId = korting.getId();
				System.out.println("KortingId: " + kortingId);
				int typeId = type.getId();
				System.out.println("typeId: " + typeId);
				BasisprijsAbonnementenDAO bpaDAO = new BasisprijsAbonnementenDAO();
				CoefficientAbonnementDAO caDAO = new CoefficientAbonnementDAO();
				KortingDAO kortingDAO = new KortingDAO();
				double prijs2 = bpaDAO.getPrijs_ById(typeId);
				System.out.println("prijs2: " + prijs2);
				double coeff = caDAO.getCoefficient_ById(typeId);
				System.out.println("coeff: " + coeff);
				Korting korting2 = kortingDAO.getKorting(kortingId);
				System.out.println("korting2: " + korting2);
				double kortingPercentage;
				double kortingHoeveelheid = korting2.getHoeveelheid();
				double totaalZonderKorting = 0;
				double totaalMetKorting = 0;

				/**
				 * Prijs berekening
				 */
				totaalZonderKorting = (prijs2 * coeff);
				kortingPercentage = (totaalZonderKorting / 100) * kortingHoeveelheid;
				totaalMetKorting = totaalZonderKorting - kortingPercentage;
				System.out.println("totaalZonderKorting: " + totaalZonderKorting);
				System.out.println("kortingPercentage: " + kortingPercentage);
				System.out.println("totaalMetKorting: " + totaalMetKorting);
				JOptionPane.showMessageDialog(view.getPanel(),
						"Abonnement aangemaakt" + "\n" + "Prijs is: €" + totaalMetKorting);

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