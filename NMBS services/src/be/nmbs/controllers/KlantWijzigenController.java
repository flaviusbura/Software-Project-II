package be.nmbs.controllers;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.userInterface.NieuwAdresView;
import be.nmbs.database.KlantDAO;
import be.nmbs.database.Klant_adresDAO;
import be.nmbs.userInterface.KlantWijzigenView;
import be.nmbs.userInterface.KlantenBeheerView;
import be.nmbs.userInterface.View;

public class KlantWijzigenController {
	private JFrame jFrame;
	private JPanel jPanel;
	private JLabel jLabel;
	private JTextField jTextField;
	private JButton ok;
	private JButton annuleren;
	JOptionPane jOptionPane = new JOptionPane();

	public KlantWijzigenController(View view) {
		KlantWijzigenView.getVoornaam().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame = new JFrame("Voornaam wijzigen");
				jPanel = new JPanel(new GridBagLayout());
				jLabel = new JLabel("Nieuwe voornaam");
				jTextField = new JTextField(10);
				ok = new JButton("Ok");
				annuleren = new JButton("Annuleren");

				jFrame.setSize(400, 200);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

				jFrame.add(jPanel);
				jFrame.setVisible(true);
				ok.addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int contactID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 0));
							String voornaam = jTextField.getText();
							KlantDAO klantDAO = new KlantDAO();
							klantDAO.updateVoornaamByContactId(contactID, voornaam);
							jOptionPane.showMessageDialog(null, "Voornaam geupdatet!");
							jFrame.dispose();
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (ArrayIndexOutOfBoundsException e2) {
							jFrame.dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						}
					}
				});

				annuleren.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jFrame.dispose();
					}
				});
			}
		});

		KlantWijzigenView.getNaam().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame = new JFrame("Achternaam wijzigen");
				jPanel = new JPanel(new GridBagLayout());
				jLabel = new JLabel("Nieuwe achternaam");
				jTextField = new JTextField(10);
				ok = new JButton("Ok");
				annuleren = new JButton("Annuleren");

				jFrame.setSize(400, 200);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

				jFrame.add(jPanel);
				jFrame.setVisible(true);
				ok.addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int contactID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 0));
							String voornaam = jTextField.getText();
							KlantDAO klantDAO = new KlantDAO();
							klantDAO.updateAchternaamByContactId(contactID, voornaam);
							jOptionPane.showMessageDialog(null, "Achternaam geupdatet!");
							jFrame.dispose();
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (ArrayIndexOutOfBoundsException e2) {
							jFrame.dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						}
					}
				});

				annuleren.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jFrame.dispose();
					}
				});
			}
		});

		KlantWijzigenView.getTelefoon().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame = new JFrame("Telefoon wijzigen");
				jPanel = new JPanel(new GridBagLayout());
				jLabel = new JLabel("Nieuwe telefoon");
				jTextField = new JTextField(10);
				ok = new JButton("Ok");
				annuleren = new JButton("Annuleren");

				jFrame.setSize(400, 200);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

				jFrame.add(jPanel);
				jFrame.setVisible(true);
				ok.addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int contactID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 0));
							String telefoon = jTextField.getText();
							KlantDAO klantDAO = new KlantDAO();
							klantDAO.updateTelefoonByContactId(contactID, telefoon);
							jOptionPane.showMessageDialog(null, "Telefoon geupdatet!");
							jFrame.dispose();
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (ArrayIndexOutOfBoundsException e2) {
							jFrame.dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						}
					}
				});

				annuleren.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jFrame.dispose();
					}
				});
			}
		});

		KlantWijzigenView.getLand().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame = new JFrame("Land wijzigen");
				jPanel = new JPanel(new GridBagLayout());
				jLabel = new JLabel("Nieuw land");
				jTextField = new JTextField(10);
				ok = new JButton("Ok");
				annuleren = new JButton("Annuleren");

				jFrame.setSize(400, 200);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

				jFrame.add(jPanel);
				jFrame.setVisible(true);
				ok.addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							String land = jTextField.getText();
							Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
							klant_adresDAO.updateLandByAdresId(adresID, land);
							jOptionPane.showMessageDialog(null, "Land geupdatet!");
							jFrame.dispose();
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (ArrayIndexOutOfBoundsException e2) {
							jFrame.dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						}
					}
				});

				annuleren.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jFrame.dispose();
					}
				});
			}
		});

		KlantWijzigenView.getStraat().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame = new JFrame("Straat wijzigen");
				jPanel = new JPanel(new GridBagLayout());
				jLabel = new JLabel("Nieuwe straat");
				jTextField = new JTextField(10);
				ok = new JButton("Ok");
				annuleren = new JButton("Annuleren");

				jFrame.setSize(400, 200);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

				jFrame.add(jPanel);
				jFrame.setVisible(true);
				ok.addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							String straat = jTextField.getText();
							Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
							klant_adresDAO.updateStraatByAdresId(adresID, straat);
							jOptionPane.showMessageDialog(null, "Straat geupdatet!");
							jFrame.dispose();
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (ArrayIndexOutOfBoundsException e2) {
							jFrame.dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						}
					}
				});

				annuleren.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jFrame.dispose();
					}
				});
			}
		});

		KlantWijzigenView.getHuisnummer().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame = new JFrame("Huisnummer wijzigen");
				jPanel = new JPanel(new GridBagLayout());
				jLabel = new JLabel("Nieuw huisnummer");
				jTextField = new JTextField(10);
				ok = new JButton("Ok");
				annuleren = new JButton("Annuleren");

				jFrame.setSize(400, 200);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

				jFrame.add(jPanel);
				jFrame.setVisible(true);
				ok.addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							int huisnummer = 0;
							huisnummer = Integer.valueOf(jTextField.getText());
							Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
							klant_adresDAO.updateNrByAdresId(adresID, huisnummer);
							jOptionPane.showMessageDialog(null, "Huisnummer geupdatet!");
							jFrame.dispose();
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (ArrayIndexOutOfBoundsException e2) {
							jFrame.dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (NumberFormatException e2) {
							jOptionPane.showMessageDialog(null,
									"Een huisnummer bestaat enkel uit cijfers.\nProbeer opnieuw!");
						}
					}
				});

				annuleren.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jFrame.dispose();
					}
				});
			}
		});

		KlantWijzigenView.getPostcode().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame = new JFrame("Postcode wijzigen");
				jPanel = new JPanel(new GridBagLayout());
				jLabel = new JLabel("Nieuwe postcode");
				jTextField = new JTextField(10);
				ok = new JButton("Ok");
				annuleren = new JButton("Annuleren");

				jFrame.setSize(400, 200);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

				jFrame.add(jPanel);
				jFrame.setVisible(true);
				ok.addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							int postcode = 0;
							postcode = Integer.valueOf(jTextField.getText());
							Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
							klant_adresDAO.updatePostcodeByAdresId(adresID, postcode);
							jOptionPane.showMessageDialog(null, "Postcode geupdatet!");
							jFrame.dispose();
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (ArrayIndexOutOfBoundsException e2) {
							jFrame.dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (NumberFormatException e2) {
							jOptionPane.showMessageDialog(null,
									"Een postcode bestaat enkel uit cijfers.\nProbeer opnieuw!");
						}
					}
				});

				annuleren.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jFrame.dispose();
					}
				});
			}
		});

		KlantWijzigenView.getWoonplaats().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame = new JFrame("Woonplaats wijzigen");
				jPanel = new JPanel(new GridBagLayout());
				jLabel = new JLabel("Nieuwe woonplaats");
				jTextField = new JTextField(10);
				ok = new JButton("Ok");
				annuleren = new JButton("Annuleren");

				jFrame.setSize(400, 200);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

				jFrame.add(jPanel);
				jFrame.setVisible(true);
				ok.addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							String woonplaats = jTextField.getText();
							Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
							klant_adresDAO.updateWoonplaatsByAdresId(adresID, woonplaats);
							jOptionPane.showMessageDialog(null, "Woonplaats geupdatet!");
							jFrame.dispose();
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (ArrayIndexOutOfBoundsException e2) {
							jFrame.dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						}
					}
				});

				annuleren.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jFrame.dispose();
					}
				});
			}
		});

		KlantWijzigenView.getBus().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame = new JFrame("Bus wijzigen");
				jPanel = new JPanel(new GridBagLayout());
				jLabel = new JLabel("Nieuwe bus");
				jTextField = new JTextField(10);
				ok = new JButton("Ok");
				annuleren = new JButton("Annuleren");

				jFrame.setSize(400, 200);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

				jFrame.add(jPanel);
				jFrame.setVisible(true);
				ok.addActionListener(new ActionListener() {

					@SuppressWarnings("static-access")
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							int row = KlantWijzigenView.getTable().getSelectedRow();
							int adresID = Integer
									.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
							String bus = jTextField.getText();
							Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
							klant_adresDAO.updateBusByAdresId(adresID, bus);
							jOptionPane.showMessageDialog(null, "Bus geupdatet!");
							jFrame.dispose();
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						} catch (ArrayIndexOutOfBoundsException e2) {
							jFrame.dispose();
							jOptionPane.showMessageDialog(null,
									"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
							KlantWijzigenView.setKlantWijzigenControllerToNull();
							view.changeView(KlantWijzigenView.initialize(view));
						}
					}
				});

				annuleren.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						jFrame.dispose();
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
	}
}
