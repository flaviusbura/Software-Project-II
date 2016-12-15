package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import be.nmbs.database.AbonnementDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.userInterface.HomeView;

import be.nmbs.userInterface.StatistiekView;
import be.nmbs.userInterface.TicketView;
import be.nmbs.userInterface.View;

public class StatistiekController {
	public StatistiekController(View view) {

		StatistiekView.getGoBackToHome().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				HomeView.setHomeControllerToNull();
				view.changeView(HomeView.initialize(view));
			}
		});
		StatistiekView.getGetToday().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Date date = new Date();
				Long tijd = date.getTime();
				Timestamp ts = new Timestamp(tijd);
				ArrayList<Abonnement> abos =new ArrayList();
				AbonnementDAO dao = new AbonnementDAO();
				abos = dao.getAllOnDate(ts);
				StatistiekView.setStatistiekresultaat(abos);
			}
		});
		StatistiekView.getGetThisWeek().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Date date = new Date();
				Date date2 = new Date();
				date2.setHours(date2.getHours()-7);
				Long tijd = date.getTime();
				Long tijd2 = date2.getTime();
				Timestamp ts = new Timestamp(tijd);
				Timestamp ts2 = new Timestamp(tijd2);
				ArrayList<Abonnement> abos =new ArrayList();
				AbonnementDAO dao = new AbonnementDAO();
				abos=dao.getAllBetweenDates(ts, ts2);
				StatistiekView.setStatistiekresultaat(abos);
			}
		});
		StatistiekView.getGetThisMonth().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Date date = new Date();
				Date date2 = new Date();
				date2.setDate(date2.getDate()-30);
				Long tijd = date.getTime();
				Long tijd2 = date2.getTime();
				Timestamp ts = new Timestamp(tijd);
				Timestamp ts2 = new Timestamp(tijd2);
				ArrayList<Abonnement> abos =new ArrayList();
				AbonnementDAO dao = new AbonnementDAO();
				abos=dao.getAllBetweenDates(ts, ts2);
				StatistiekView.setStatistiekresultaat(abos);
			}
		});
		StatistiekView.getGetThisMonth().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Date date = new Date();
				Date date2 = new Date();
				date2.setDate(date2.getDate()-30);
				Long tijd = date.getTime();
				Long tijd2 = date2.getTime();
				Timestamp ts = new Timestamp(tijd);
				Timestamp ts2 = new Timestamp(tijd2);
				ArrayList<Abonnement> abos =new ArrayList();
				AbonnementDAO dao = new AbonnementDAO();
				abos=dao.getAllBetweenDates(ts, ts2);
				StatistiekView.setStatistiekresultaat(abos);
			}
		});
		StatistiekView.getGetBetweenDates().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					String datum = StatistiekView.getDate1().getText();
					String datum2 = StatistiekView.getDate2().getText();
					Date date = format.parse(datum);
					Date date2 = format.parse(datum2);
					Long tijd = date.getTime();
					Long tijd2 = date2.getTime();
					Timestamp ts = new Timestamp(tijd);
					Timestamp ts2 = new Timestamp(tijd2);
					ArrayList<Abonnement> abos =new ArrayList();
					AbonnementDAO dao = new AbonnementDAO();
					abos=dao.getAllBetweenDates(ts, ts2);
					StatistiekView.setStatistiekresultaat(abos);
				}
				catch(ParseException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
}
