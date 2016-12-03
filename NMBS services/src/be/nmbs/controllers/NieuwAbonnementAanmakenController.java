package be.nmbs.controllers;

import be.nmbs.userInterface.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.AbonnementView;
import be.nmbs.userInterface.NieuwAbonnementAanmakenView;

public class NieuwAbonnementAanmakenController {
	public NieuwAbonnementAanmakenController (View view) {
		NieuwAbonnementAanmakenView.getActieAnnuleren().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AbonnementView.setAbonnementControllerToNull();
				view.changeView(AbonnementView.initialize(view));
			}
		});
	}
}
