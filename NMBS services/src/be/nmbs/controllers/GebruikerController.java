package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import be.nmbs.userInterface.GebruikerView;
import be.nmbs.userInterface.GebruikerWijzigenView;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.NieuwGebruikerAanmakenView;
import be.nmbs.userInterface.View;

public class GebruikerController {
	public GebruikerController(View view) {
		GebruikerView.getNieuweGebruiker().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NieuwGebruikerAanmakenView.setNieuwGebruikerAanmakenControllerToNull();
				view.changeView(NieuwGebruikerAanmakenView.initialize(view));
			}
		});
		
		GebruikerView.getGebruikerAanpassen().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GebruikerWijzigenView newView = new GebruikerWijzigenView();
				view.changeView(newView.initialize(view));
			}
		});
		
		GebruikerView.getHome().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
	}
}
