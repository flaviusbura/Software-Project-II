package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import be.nmbs.database.Klant_adresDAO;
import be.nmbs.logic.Adres;
import be.nmbs.userInterface.NieuwAdresView;
import be.nmbs.userInterface.KlantWijzigenView;
import be.nmbs.userInterface.View;

public class NieuwAdresController {
	private int adresId;
	private Adres adres;
	private Klant_adresDAO klant_adresDAO;

	public NieuwAdresController(View view) {
		NieuwAdresView.getKlantAdresWijzigen().addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int row = KlantWijzigenView.getTable().getSelectedRow();
					adresId = Integer.valueOf((String) KlantWijzigenView.getTable().getModel().getValueAt(row, 1));
					String straat = NieuwAdresView.getStraatText().getText();
					int huisnummer = Integer.parseInt(NieuwAdresView.getNrText().getText());
					String bus = NieuwAdresView.getBusText().getText();
					int postcode = Integer.parseInt(NieuwAdresView.getPostcodeText().getText());
					String stad = NieuwAdresView.getStadText().getText();
					String land = NieuwAdresView.getLandText().getText();
					adres = new Adres(straat, huisnummer, postcode, bus, stad, land, true);
					adres.setAdresId(adresId);
					klant_adresDAO = new Klant_adresDAO();
					klant_adresDAO.updateAdresKlant(adres);
					JOptionPane optionPane = new JOptionPane();
					optionPane.showMessageDialog(null, "Adres geupdatet!");
					KlantWijzigenView.setKlantWijzigenControllerToNull();
					view.changeView(KlantWijzigenView.initialize(view));
				} catch (ArrayIndexOutOfBoundsException indexE) {
					JOptionPane jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null, "U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
					KlantWijzigenView.setKlantWijzigenControllerToNull();
					view.changeView(KlantWijzigenView.initialize(view));
				}
			}
		});

		NieuwAdresView.getActieannuleren().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				KlantWijzigenView.setKlantWijzigenControllerToNull();
				view.changeView(KlantWijzigenView.initialize(view));
			}
		});
	}
}
