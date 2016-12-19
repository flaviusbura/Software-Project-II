package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import be.nmbs.userInterface.NieuwAdresView;
import be.nmbs.database.KlantDAO;
import be.nmbs.database.Klant_adresDAO;
import be.nmbs.exceptions.EnkelCijfersException;
import be.nmbs.exceptions.EnkelLettersException;
import be.nmbs.exceptions.NietGeldigePostcodeException;
import be.nmbs.logic.Klant;
import be.nmbs.logic.VeiligeInvoer;
import be.nmbs.userInterface.HelperView;
import be.nmbs.userInterface.KlantWijzigenView;
import be.nmbs.userInterface.KlantenBeheerView;
import be.nmbs.userInterface.View;

public class KlantWijzigenController {
	private JOptionPane jOptionPane = new JOptionPane();
	private HelperView helpMe;
	private ArrayList<Klant> lijst = new ArrayList<>();
	private KlantDAO klantDAO = new KlantDAO();
	private static String naam;

	public KlantWijzigenController(View view) {
		KlantWijzigenView.getVoornaam().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpMe = new HelperView("Voornaam wijzigen", "Nieuwe voornaam");
				helpMe.getOk().addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int contactID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 0));
							String voornaam = helpMe.getjTextField().getText();
							if (VeiligeInvoer.checkForOnlyLetters(voornaam) == false) {
								throw new EnkelLettersException();
							} else {
								KlantDAO klantDAO = new KlantDAO();
								klantDAO.updateVoornaamByContactId(contactID, voornaam);
								jOptionPane.showMessageDialog(null, "Voornaam geupdatet!");
								helpMe.getjFrame().dispose();
								lijst = klantDAO.getAllByAchternaam(naam);
								KlantWijzigenView.setLijst(lijst);
								KlantWijzigenView.setKlantWijzigenControllerToNull();
								view.changeView(KlantWijzigenView.initialize(view));
							}
						} catch (ArrayIndexOutOfBoundsException e2) {
							helpMe.getjFrame().dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (EnkelLettersException e3) {
							helpMe.getjTextField().setText("");
							jOptionPane.showMessageDialog(null,
									"Dit veldje mag niet leeg zijn en/of andere\nkarakters dan letters bevatten.");
						}
					}
				});

				helpMe.getAnnuleren().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						helpMe.getjFrame().dispose();
					}
				});
			}
		});

		KlantWijzigenView.getNaam().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpMe = new HelperView("Achternaam wijzigen", "Nieuwe achternaam");
				helpMe.getOk().addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int contactID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 0));
							String voornaam = helpMe.getjTextField().getText();
							if (VeiligeInvoer.checkForOnlyLetters(voornaam) == false) {
								throw new EnkelLettersException();
							} else {
								KlantDAO klantDAO = new KlantDAO();
								klantDAO.updateAchternaamByContactId(contactID, voornaam);
								jOptionPane.showMessageDialog(null, "Achternaam geupdatet!");
								helpMe.getjFrame().dispose();
								lijst = klantDAO.getAllByAchternaam(naam);
								KlantWijzigenView.setLijst(lijst);
								KlantWijzigenView.setKlantWijzigenControllerToNull();
								view.changeView(KlantWijzigenView.initialize(view));
							}
						} catch (ArrayIndexOutOfBoundsException e2) {
							helpMe.getjFrame().dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (EnkelLettersException e3) {
							helpMe.getjTextField().setText("");
							jOptionPane.showMessageDialog(null,
									"Dit veldje mag niet leeg zijn en/of andere\nkarakters dan letters bevatten.");
						}
					}
				});

				helpMe.getAnnuleren().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						helpMe.getjFrame().dispose();
					}
				});
			}
		});

		KlantWijzigenView.getTelefoon().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpMe = new HelperView("Telefoon wijzigen", "Nieuwe telefoon");
				helpMe.getOk().addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int contactID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 0));
							String telefoon = helpMe.getjTextField().getText();
							if (VeiligeInvoer.checkForOnlyNumbers(telefoon) == false) {
								throw new EnkelCijfersException();
							} else {
								KlantDAO klantDAO = new KlantDAO();
								klantDAO.updateTelefoonByContactId(contactID, telefoon);
								jOptionPane.showMessageDialog(null, "Telefoon geupdatet!");
								helpMe.getjFrame().dispose();
								lijst = klantDAO.getAllByAchternaam(naam);
								KlantWijzigenView.setLijst(lijst);
								KlantWijzigenView.setKlantWijzigenControllerToNull();
								view.changeView(KlantWijzigenView.initialize(view));
							}
						} catch (ArrayIndexOutOfBoundsException e2) {
							helpMe.getjFrame().dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (EnkelCijfersException e3) {
							helpMe.getjTextField().setText("");
							jOptionPane.showMessageDialog(null,
									"Dit veldje mag niet leeg zijn en/of andere\nkarakters dan cijfers bevatten.");
						}
					}
				});

				helpMe.getAnnuleren().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						helpMe.getjFrame().dispose();
					}
				});
			}
		});

		KlantWijzigenView.getLand().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpMe = new HelperView("Land wijzigen", "Nieuw land");
				helpMe.getOk().addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							String land = helpMe.getjTextField().getText();
							if (VeiligeInvoer.checkForOnlyLetters(land) == false) {
								throw new EnkelLettersException();
							} else {
								Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
								klant_adresDAO.updateLandByAdresId(adresID, land);
								jOptionPane.showMessageDialog(null, "Land geupdatet!");
								helpMe.getjFrame().dispose();
								lijst = klantDAO.getAllByAchternaam(naam);
								KlantWijzigenView.setLijst(lijst);
								KlantWijzigenView.setKlantWijzigenControllerToNull();
								view.changeView(KlantWijzigenView.initialize(view));
							}
						} catch (ArrayIndexOutOfBoundsException e2) {
							helpMe.getjFrame().dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (EnkelLettersException e3) {
							helpMe.getjTextField().setText("");
							jOptionPane.showMessageDialog(null,
									"Dit veldje mag niet leeg zijn en/of andere\nkarakters dan letters bevatten.");
						}
					}
				});

				helpMe.getAnnuleren().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						helpMe.getjFrame().dispose();
					}
				});
			}
		});

		KlantWijzigenView.getStraat().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpMe = new HelperView("Straat wijzigen", "Nieuwe straat");
				helpMe.getOk().addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							String straat = helpMe.getjTextField().getText();
							if (VeiligeInvoer.checkForOnlyLetters(straat) == false) {
								throw new EnkelLettersException();
							} else {
								Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
								klant_adresDAO.updateStraatByAdresId(adresID, straat);
								jOptionPane.showMessageDialog(null, "Straat geupdatet!");
								helpMe.getjFrame().dispose();
								lijst = klantDAO.getAllByAchternaam(naam);
								KlantWijzigenView.setLijst(lijst);
								KlantWijzigenView.setKlantWijzigenControllerToNull();
								view.changeView(KlantWijzigenView.initialize(view));
							}
						} catch (ArrayIndexOutOfBoundsException e2) {
							helpMe.getjFrame().dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (EnkelLettersException e3) {
							helpMe.getjTextField().setText("");
							jOptionPane.showMessageDialog(null,
									"Dit veldje mag niet leeg zijn en/of andere\nkarakters dan letters bevatten.");
						}
					}
				});

				helpMe.getAnnuleren().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						helpMe.getjFrame().dispose();
					}
				});
			}
		});

		KlantWijzigenView.getHuisnummer().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpMe = new HelperView("Huisnummer wijzigen", "Nieuw huisnummer");
				helpMe.getOk().addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							int huisnummer = 0;
							huisnummer = Integer.valueOf(helpMe.getjTextField().getText());
							Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
							klant_adresDAO.updateNrByAdresId(adresID, huisnummer);
							jOptionPane.showMessageDialog(null, "Huisnummer geupdatet!");
							helpMe.getjFrame().dispose();
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (ArrayIndexOutOfBoundsException e2) {
							helpMe.getjFrame().dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (NumberFormatException e3) {
							helpMe.getjTextField().setText("");
							jOptionPane.showMessageDialog(null,
									"Dit veldje mag niet leeg zijn en/of andere\nkarakters dan cijfers bevatten.");
						}
					}
				});

				helpMe.getAnnuleren().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						helpMe.getjFrame().dispose();
					}
				});
			}
		});

		KlantWijzigenView.getPostcode().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpMe = new HelperView("Postcode wijzigen", "Nieuwe postcode");
				helpMe.getOk().addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							int postcode = 0;
							postcode = Integer.valueOf(helpMe.getjTextField().getText());
							if (postcode > 9999 || postcode < 1000) {
								throw new NietGeldigePostcodeException();
							} else {
								Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
								klant_adresDAO.updatePostcodeByAdresId(adresID, postcode);
								jOptionPane.showMessageDialog(null, "Postcode geupdatet!");
								helpMe.getjFrame().dispose();
								lijst = klantDAO.getAllByAchternaam(naam);
								KlantWijzigenView.setLijst(lijst);
								KlantWijzigenView.setKlantWijzigenControllerToNull();
								view.changeView(KlantWijzigenView.initialize(view));
							}
						} catch (ArrayIndexOutOfBoundsException e2) {
							helpMe.getjFrame().dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (NumberFormatException e3) {
							helpMe.getjTextField().setText("");
							jOptionPane.showMessageDialog(null,
									"Een postcode bestaat enkel uit cijfers.\nProbeer opnieuw!");
						} catch (NietGeldigePostcodeException e4) {
							helpMe.getjTextField().setText("");
							jOptionPane.showMessageDialog(null, "Het ingevoerde postcode is ongeldig!");
						}
					}
				});

				helpMe.getAnnuleren().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						helpMe.getjFrame().dispose();
					}
				});
			}
		});

		KlantWijzigenView.getWoonplaats().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpMe = new HelperView("Woonplaats wijzigen", "Nieuwe woonplaats");
				helpMe.getOk().addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							String woonplaats = helpMe.getjTextField().getText();
							if (VeiligeInvoer.checkForOnlyLetters(woonplaats) == false) {
								throw new EnkelLettersException();
							} else {
								Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
								klant_adresDAO.updateWoonplaatsByAdresId(adresID, woonplaats);
								jOptionPane.showMessageDialog(null, "Woonplaats geupdatet!");
								helpMe.getjFrame().dispose();
								lijst = klantDAO.getAllByAchternaam(naam);
								KlantWijzigenView.setLijst(lijst);
								KlantWijzigenView.setKlantWijzigenControllerToNull();
								view.changeView(KlantWijzigenView.initialize(view));
							}
						} catch (ArrayIndexOutOfBoundsException e2) {
							helpMe.getjFrame().dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (EnkelLettersException e3) {
							helpMe.getjTextField().setText("");
							jOptionPane.showMessageDialog(null,
									"Dit veldje mag niet leeg zijn en/of andere\nkarakters dan letters bevatten.");
						}
					}
				});

				helpMe.getAnnuleren().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						helpMe.getjFrame().dispose();
					}
				});
			}
		});

		KlantWijzigenView.getBus().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				helpMe = new HelperView("Bus wijzigen", "Nieuwe bus");
				helpMe.getOk().addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							String bus = helpMe.getjTextField().getText();
							if (VeiligeInvoer.checkForOnlyNumbers(bus) == false) {
								throw new EnkelCijfersException();
							} else {
								Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
								klant_adresDAO.updateBusByAdresId(adresID, bus);
								jOptionPane.showMessageDialog(null, "Bus geupdatet!");
								helpMe.getjFrame().dispose();
								lijst = klantDAO.getAllByAchternaam(naam);
								KlantWijzigenView.setLijst(lijst);
								KlantWijzigenView.setKlantWijzigenControllerToNull();
								view.changeView(KlantWijzigenView.initialize(view));
							}
						} catch (ArrayIndexOutOfBoundsException e2) {
							helpMe.getjFrame().dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (EnkelCijfersException e3) {
							helpMe.getjTextField().setText("");
							jOptionPane.showMessageDialog(null,
									"Dit veldje mag niet leeg zijn en/of andere\nkarakters dan cijfers bevatten.");
						}
					}
				});

				helpMe.getAnnuleren().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						helpMe.getjFrame().dispose();
					}
				});
			}
		});

		KlantWijzigenView.getAdresButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NieuwAdresView.setNieuwAdresControllerToNull();
				view.changeView(NieuwAdresView.initialize(view));
			}
		});

		KlantWijzigenView.getBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				KlantenBeheerView.setKlantenBeheerControllerToNull();
				view.changeView(KlantenBeheerView.initialize(view));
			}
		});

		KlantWijzigenView.getZoek().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				naam = KlantWijzigenView.getZoekText().getText();
				if (naam.equals("")) {
					JOptionPane.showMessageDialog(null, "Geef een geldige invoer.");
					KlantWijzigenView.getLijst().clear();
					KlantWijzigenView.getZoekText().setText("");
					KlantWijzigenView.setKlantWijzigenControllerToNull();
					view.changeView(KlantWijzigenView.initialize(view));
				} else {
					lijst = klantDAO.getAllByAchternaam(naam);
					if (lijst.size() == 0) {
						JOptionPane.showMessageDialog(null, "Geen klanten gevonden met deze achternaam.");
						KlantWijzigenView.setKlantWijzigenControllerToNull();
						KlantWijzigenView.getLijst().clear();
						view.changeView(KlantWijzigenView.initialize(view));
					} else {
						KlantWijzigenView.setLijst(lijst);
						KlantWijzigenView.setKlantWijzigenControllerToNull();
						view.changeView(KlantWijzigenView.initialize(view));
					}
				}
			}
		});
	}
}
