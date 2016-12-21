package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import be.nmbs.database.BasisprijsAbonnementenDAO;
import be.nmbs.database.BasisprijsTicketDAO;
import be.nmbs.database.CoefficientAbonnementDAO;
import be.nmbs.database.CoefficientTicketDAO;
import be.nmbs.database.KortingDAO;
import be.nmbs.database.TicketDAO;
import be.nmbs.database.TicketPrijsDAO;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.Prijs_ticket;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.Ticket;
import be.nmbs.logic.TypeAbonnement;
import be.nmbs.logic.TypeTicket;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.MaakAbonnementView;
import be.nmbs.userInterface.TicketView;
import be.nmbs.userInterface.View;

public class TicketController {

	public TicketController(View view) {
		TicketView.getBtnKoopTicket().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					// String startstation = (String)
					// TicketView.getBeginstationlijst().getSelectedItem();
					StationNMBS startstation = new StationNMBS(
							(String) TicketView.getBeginstationlijst().getSelectedItem());
					String soort = TicketView.getTxtSoort().getText();
					String datum = TicketView.getTxtDatum().getText();

					DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					Date date = format.parse(datum);
					Long tijd = date.getTime();
					Timestamp ts = new Timestamp(tijd);
					int klas = Integer.parseInt(TicketView.getTxtKlasse().getText());

					StationNMBS eindstation = new StationNMBS(
							(String) TicketView.getEindstationlijst().getSelectedItem());
					// String eindstation = (String)
					// TicketView.getEindstationlijst().getSelectedItem();
					String omschrijving = TicketView.getTxtOmschrijving().getText();

					// Prijs prijs = (Prijs)
					// TicketView.getPrijzenlijst().getSelectedItem();
					// int prijsId = prijs.getPrijsId();
					TypeTicket typeTicket = (TypeTicket) TicketView.getTypeLijst().getSelectedItem();
					int typeTicketId = typeTicket.getId();

					BasisprijsTicketDAO bptdao = new BasisprijsTicketDAO();
					int basisprijsid = bptdao.getBasisPrijsIdbyTypeId(typeTicketId);

					double basisprijs = bptdao.getPrijs_ById(typeTicketId);

					CoefficientTicketDAO coefdao = new CoefficientTicketDAO();
					int coefid = coefdao.getCoefficientIdByTypeId(typeTicketId);

					double coef = coefdao.getCoefficient_ById(coefid);

					double totaal = basisprijs * coef;

					Prijs_ticket prijs_ticket = new Prijs_ticket(typeTicketId, coefid, basisprijsid, totaal);
					TicketPrijsDAO ptdao = new TicketPrijsDAO();

					int idvoorprijs = ptdao.insert(prijs_ticket);
					prijs_ticket.setPrijs_ticketid(idvoorprijs);
					Korting korting = (Korting) TicketView.getKortinglijst().getSelectedItem();
					int kortingId = korting.getId();
					StationNMBS station = new StationNMBS((String) TicketView.getStationlijst().getSelectedItem());
					int gebruikerId = View.getIngelogdGebruiker().getId();

					Ticket ticket = new Ticket(startstation, soort, ts, klas, true, eindstation, omschrijving,
							prijs_ticket, kortingId, station, gebruikerId);
					TicketDAO ticketdao = new TicketDAO();
					ticketdao.insert(ticket);

					/**
					 * Variabelen declarern om de prijs berekening mogelijk
					 * maken
					 */
					TypeTicket type = (TypeTicket) TicketView.getTypeLijst().getSelectedItem();
					int typeId = type.getId();
					//
					// BasisprijsTicketDAO bptDAO = new BasisprijsTicketDAO();
					// CoefficientTicketDAO ctDAO = new CoefficientTicketDAO();
					// KortingDAO kortingDAO = new KortingDAO();
					// double prijs2 = bptDAO.getPrijs_ById(typeId);
					// double coeff = ctDAO.getCoefficient_ById(typeId);
					// Korting korting2 = kortingDAO.getKorting(kortingId);
					// double kortingPercentage;
					// double kortingHoeveelheid = korting2.getHoeveelheid();
					// double totaalZonderKorting = 0;
					// double totaalMetKorting = 0;

					/**
					 * Prijs berekening
					 */
					// totaalZonderKorting = (prijs2 * coeff);
					// kortingPercentage = (totaalZonderKorting / 100) *
					// kortingHoeveelheid;
					// totaalMetKorting = totaalZonderKorting -
					// kortingPercentage;

					// JOptionPane.showMessageDialog(view.getPanel(),
					// "Ticket aangemaakt" + "\n" + "Prijs is: €" +
					// totaalMetKorting);
					TicketView.clearFields();

				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

			private CoefficientTicketDAO CoefficientTicketDAO() {
				// TODO Auto-generated method stub
				return null;
			}

			private CoefficientAbonnementDAO CoefficientAbonnementDAO() {
				// TODO Auto-generated method stub
				return null;
			}

			private BasisprijsTicketDAO BasisprijsTicketDAO() {
				// TODO Auto-generated method stub
				return null;
			}

		});

		TicketView.getBtnVorigScherm().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
