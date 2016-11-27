package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.AdresWijzigenView;
import be.nmbs.userInterface.KlantWijzigenView;
import be.nmbs.userInterface.KlantenBeheerView;
import be.nmbs.userInterface.TelefoonWijzigenView;
import be.nmbs.userInterface.View;

public class KlantWijzigenController {
	public KlantWijzigenController(View view) {
		KlantWijzigenView.getAdresWijzigen().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdresWijzigenView.setAdresWijzigenControllerToNull();
				view.changeView(AdresWijzigenView.initialize(view));
			}
		});
		
		KlantWijzigenView.getTelefoonWijzigen().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelefoonWijzigenView.setTelefoonWijzigenControllerToNull();
				view.changeView(TelefoonWijzigenView.initialize(view));
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
