package be.nmbs.tablemodels;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import be.nmbs.logic.Route;

public class RouteTableModel implements TableModel {	
	private ArrayList<Route> routes;
	private ArrayList<Integer> whitespaces;
	
	public void setRoutes(ArrayList<Route> routes) {
		this.routes = routes;
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<Route> getColumnClass(int columnIndex) {
		return Route.class;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
			case 0:
				return "Station";
			
			case 1:
				return "Tijdstip";
				
			case 2:
				return "Spoor";
				
			case 3:
				return "Trein";
				
			case 4:
				return "Opstapspoor";
				
			case 5:
				return "Tijdstip";
		
			default: return "";
		}
	}

	@Override
	public int getRowCount() {
		whitespaces = new ArrayList<Integer>();
		int counter = 0;
		
		for (int i = 0; i < routes.size(); i++) {
			counter++;
			
			for (int j = 0; j < routes.get(i).getOverstappen().size(); j++)
				counter++;
			
			whitespaces.add(counter);
		}
		
		return counter;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (whitespaces.contains(rowIndex)) {
			switch(columnIndex) {
				default: 
					return "";
			}
		} else {
			for (int i = 0; i < whitespaces.size(); i++) {
				if (rowIndex < whitespaces.get(i)) {
					Route route = routes.get(i);
					int pos = whitespaces.get(i) - route.getOverstappen().size() + rowIndex;
					
					System.out.println(pos + " - " + whitespaces.get(i) + " - " + route.getOverstappen().size());
					if (route.getOverstappen().size() > pos) {
						switch(columnIndex) {
							case 0:
								if (route.getOverstappen().get(pos).getStation() == null || route.getOverstappen().get(pos).getStation() == "null")
									return route.getStepOn();
								else
									return route.getOverstappen().get(pos).getStation();
							
							case 1:
								if (route.getOverstappen().get(pos).getDeparture() != null)
									return route.getOverstappen().get(pos).getDeparture().toString();
								else
									return "";
								
							case 2:
								return route.getOverstappen().get(pos).getStepOffPlatform();
								
							case 3: 
								if (route.getOverstappen().size() > pos)
									return route.getOverstappen().get(pos).getId();
								else
									return "";
								
							case 4:
								return route.getOverstappen().get(pos).getStepOnPlatform();
								
							case 5:
								if (route.getOverstappen().get(pos).getDeparture() != null)
									return route.getOverstappen().get(pos).getDeparture().toString();
								else
									return "";
						}
					} else {
						switch(columnIndex) {
							default:
								return "";
						}
					}
					break;
				}
			}
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}
}
