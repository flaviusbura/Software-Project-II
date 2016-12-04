package be.nmbs.userInterface;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import be.nmbs.controllers.RouteGetController;
import be.nmbs.logic.ApiCaller;
import be.nmbs.logic.Route;

public class RouteGetView {
	private static JPanel panel;
	private static JButton back;
	private static JLabel info;
	private static JTable table;
	private static JSeparator separator;
	
	private static ArrayList<Route> routes;
	
	private static boolean ALLOW_COLUMN_SELECTION = false;
	private static boolean ALLOW_ROW_SELECTION = true;
	
	@SuppressWarnings("unused")
	private static RouteGetController routeGetController;

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view, String departureStation, String arrivalStation, Calendar departure) {			
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c;
		
		ApiCaller caller = new ApiCaller();
		
		routes = caller.getTimedRouteInfo(departureStation, arrivalStation, departure.getTime());
		
		System.out.println(departure.getTimeInMillis());
		if (routes == null) {
			info = new JLabel("Geen routes gevonden");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(info, c);	
			
			back = new JButton("Terug naar zoeken");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			panel.add(back, c);	
		} else {
			table = new JTable();
			table.setPreferredScrollableViewportSize(new Dimension(500, 200));
			
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.VERTICAL;
			c.gridx = 0;
			c.gridheight = 3;
			
			table.setVisible(false);
			
			JScrollPane scrollPane = new JScrollPane(table);
			
			panel.add(scrollPane);
			
			back = new JButton("Terug naar zoeken");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			panel.add(back, c);
		}
		
		/*
		GridBagConstraints sepConstraints = new GridBagConstraints();
		sepConstraints.weightx = 1.0;
        sepConstraints.fill = GridBagConstraints.HORIZONTAL;
        sepConstraints.gridwidth = GridBagConstraints.REMAINDER;
        
		if (routes == null) {
			info = new JLabel("Geen routes gevonden");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(info, c);	
			
			back = new JButton("Terug naar zoeken");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			panel.add(back, c);	
		} else {
			info = new JLabel("Tijdstip");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(info, c);	
			
			info = new JLabel("Spoor");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			panel.add(info, c);	
			
			info = new JLabel("Station");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 2;
			c.gridy = 0;
			panel.add(info, c);	
			
			int yCount = 1;
			for (int i = 0; i < routes.size(); i++) {
				ArrayList<Overstap> overstappen = routes.get(i).getOverstappen();
				Station lastStop = routes.get(i).getTreinen().get(routes.get(i).getTreinen().size() - 1).getStops().get(routes.get(i).getTreinen().get(routes.get(i).getTreinen().size() -1).getStops().size() - 1);
				
				for (int j = 0; j < overstappen.size(); j++) {
					Overstap overstap = overstappen.get(j);
					
					info = new JLabel(overstap.getId() + " | Richting " + overstap.getTerminus());
					c = new GridBagConstraints();
					c.fill = new GridBagConstraints().HORIZONTAL;
					c.gridx = 2;
					c.gridy = yCount;
					panel.add(info, c);
					
					if (overstap.getStation() != "" && overstap.getStation() != "null") {
						info = new JLabel(overstap.getDeparture().toString());
						c = new GridBagConstraints();
						c.fill = new GridBagConstraints().HORIZONTAL;
						c.gridx = 0;
						c.gridy = yCount;
						panel.add(info, c);	
						
						info = new JLabel("Spoor " + overstap.getStepOnPlatform());
						c = new GridBagConstraints();
						c.fill = new GridBagConstraints().HORIZONTAL;
						c.gridx = 1;
						c.gridy = yCount;
						panel.add(info, c);	
						
						info = new JLabel(overstap.getStation());
						c = new GridBagConstraints();
						c.fill = new GridBagConstraints().HORIZONTAL;
						c.gridx = 2;
						c.gridy = yCount;
						panel.add(info, c);	
						
						yCount++;
					}
					
					info = new JLabel(overstap.getArrival().toString());
					c = new GridBagConstraints();
					c.fill = new GridBagConstraints().HORIZONTAL;
					c.gridx = 0;
					c.gridy = yCount;
					panel.add(info, c);
					
					info = new JLabel("Spoor " + overstap.getStepOffPlatform());
					c = new GridBagConstraints();
					c.fill = new GridBagConstraints().HORIZONTAL;
					c.gridx = 1;
					c.gridy = yCount;
					panel.add(info, c);
					
					yCount++;
					
					info = new JLabel(overstap.getDeparture().toString());
					c = new GridBagConstraints();
					c.fill = new GridBagConstraints().HORIZONTAL;
					c.gridx = 0;
					c.gridy = yCount;
					panel.add(info, c);
					
					info = new JLabel(overstap.getStepOnPlatform());
					c = new GridBagConstraints();
					c.fill = new GridBagConstraints().HORIZONTAL;
					c.gridx = 1;
					c.gridy = yCount;
					panel.add(info, c);
					
					yCount++;
					
					separator = new JSeparator(JSeparator.HORIZONTAL);
					separator.setPreferredSize(new Dimension(5,1));
					sepConstraints.fill = GridBagConstraints.VERTICAL;
					sepConstraints.weighty = 1;
					sepConstraints.gridx = 0;
					sepConstraints.gridy = yCount;
					panel.add(info, sepConstraints);	
					yCount++;
				}
				
				info = new JLabel(lastStop.getArrivalDelay().toString());
				c = new GridBagConstraints();
				c.fill = new GridBagConstraints().HORIZONTAL;
				c.gridx = 0;
				c.gridy = yCount;
				panel.add(info, c);	
				
				info = new JLabel("Spoor " + lastStop.getArrivalPlatform());
				c = new GridBagConstraints();
				c.fill = new GridBagConstraints().HORIZONTAL;
				c.gridx = 1;
				c.gridy = yCount;
				panel.add(info, c);	
				
				info = new JLabel("Eindhalte " + lastStop.getName());
				c = new GridBagConstraints();
				c.fill = new GridBagConstraints().HORIZONTAL;
				c.gridx = 2;
				c.gridy = yCount;
				panel.add(info, c);
				
				yCount++;
			}
			*/
		
		routeGetController = new RouteGetController(view, routes);
		return panel;
	}

	public static void setRouteGetControllerToNull() {
		routeGetController = null;
	}

	public static JButton getBack() {
		return back;
	}
	
	public static JTable getTable() {
		return table;
	}

	public static void setTabel(JTable table) {
		RouteGetView.table = table;
	}
}