package be.nmbs.tablemodels;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import be.nmbs.logic.Route;

public class RouteTableModel implements TableModel {	
	private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
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
				return "Aankomst";
				
			case 2:
				return "Spoor";
				
			case 3:
				return "Trein";
				
			case 4:
				return "Overstap op";
				
			case 5:
				return "Vertrek";
		
			default: return "";
		}
	}

	@Override
	public int getRowCount() {
		whitespaces = new ArrayList<Integer>();
		int counter = 0;
		
		for (int i = 0; i < routes.size(); i++) {
			if (i != 0)
				counter++;
			
			for (int j = 0; j < routes.get(i).getOverstappen().size(); j++)
				counter++;
			
			if (i < routes.size())
				whitespaces.add(counter);
		}
		
		return counter;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (whitespaces.contains(rowIndex)) {
			switch(columnIndex) {
				default: 
					return "---";
			}
		} else {
			for (int i = 0; i < whitespaces.size(); i++) {
				if (rowIndex < whitespaces.get(i)) {
					Route route = routes.get(i);
					
					int pos;
					if (i == 0) {
						pos = rowIndex;
					} else
						pos = rowIndex - whitespaces.get(i - 1) - 1;
					
					if (route.getOverstappen().size() > pos) {
						switch(columnIndex) {
							case 0:
								return route.getOverstappen().get(pos).getStation();
							
							case 1:
								if (route.getOverstappen().get(pos).getArrival() != null)
									return sdf.format(route.getOverstappen().get(pos).getArrival());
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
								if (route.getOverstappen().get(pos).getStepOnPlatform() != "null" && pos > 0)
									return route.getOverstappen().get(pos).getStepOnPlatform();
								else
									return "";
								
							case 5:
								if (route.getOverstappen().get(pos).getDeparture() != null && pos > 0)
									return sdf.format(route.getOverstappen().get(pos).getDeparture());
								else
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
