package be.nmbs.controllers;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.swing.JOptionPane;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;
import be.nmbs.userInterface.KeuzeSchermView;
import be.nmbs.userInterface.View;
import be.nmbs.logic.Hashing;

public class KeuzeSchermController {
	
	public KeuzeSchermController(View view) {
		System.out.println("abo1");
		view.setPanel(KeuzeSchermView.initialiseView());
		view.add(view.getPanel());
		view.setVisible(true);
		KeuzeSchermView.getBtnAbonnement().addActionListener(new ActionListener() {
			
			@SuppressWarnings({ "deprecation", "static-access" })
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("abo2");
			}
		});
	
		}
}
