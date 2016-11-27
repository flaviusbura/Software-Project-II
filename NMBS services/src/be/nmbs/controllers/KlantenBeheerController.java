package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.KlantenBeheerView;
import be.nmbs.userInterface.NieuweKlantAanmakenView;
import be.nmbs.userInterface.View;

public class KlantenBeheerController {
	public KlantenBeheerController(View view) {
		KlantenBeheerView.getNieuweKlantaanmaken().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NieuweKlantAanmakenView.setNieuweKlantAanmakenControllerToNull();;
				view.changeView(NieuweKlantAanmakenView.initialize(view));
			}
		});
		
		KlantenBeheerView.getKlantWijzigen().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
			}
		});
		
		KlantenBeheerView.getHome().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
