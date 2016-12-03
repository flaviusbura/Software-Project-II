package be.nmbs.userInterface;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import be.nmbs.controllers.RouteGetController;
import be.nmbs.logic.ApiCaller;
import be.nmbs.logic.Overstap;
import be.nmbs.logic.Route;
import be.nmbs.logic.Station;
import be.nmbs.logic.Trein;

public class RouteGetView {
	private static JPanel panel;
	private static JButton back;
	private static JLabel info;
	private static JSeparator separator;
	private static ArrayList<Route> routes;
	
	@SuppressWarnings("unused")
	private static RouteGetController routeGetController;

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view, String departureStation, String arrivalStation, Calendar departure) {
			ApiCaller caller = new ApiCaller();
			
			routes = caller.getTimedRouteInfo(departureStation, arrivalStation, departure.getTime());
			
			panel = new JPanel(new GridBagLayout());
			
			GridBagConstraints c;
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
				
				back = new JButton("Terug naar zoeken");
				c = new GridBagConstraints();
				c.fill = new GridBagConstraints().HORIZONTAL;
				c.gridx = 0;
				c.gridy = yCount;
				panel.add(back, c);
			}
			
			routeGetController = new RouteGetController(view);
			return panel;
	}

	public static void setRouteGetControllerToNull() {
		routeGetController = null;
	}

	public static JButton getBack() {
		return back;
	}
}