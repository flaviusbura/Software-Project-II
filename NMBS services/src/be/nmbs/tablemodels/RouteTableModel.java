package be.nmbs.tablemodels;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import be.nmbs.logic.Route;

public class RouteTableModel implements TableModel {	
	private Route route;
	
	public void setRoute(Route route) {
		this.route = route;
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
		return 4;
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
		
			default: return "";
		}
	}

	@Override
	public int getRowCount() {
		int counter = 0;
		
		for (int i = 0; i < route.getOverstappen().size(); i++)
			counter++;
		
		return counter + 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (route.getOverstappen().size() <= rowIndex) {			
			switch(columnIndex) {
			case 0:
				return route.getStepOff();
			
			case 1:
				return route.getTreinen().get(route.getTreinen().size() - 1).getArrival();
				
			case 2:
				return "Aankomst";
				
			case 3: 
				return "";
		
			default: 
				return "";
			}
		} else {
			switch(columnIndex) {
			case 0:
				if (route.getOverstappen().get(rowIndex).getStation() == null || route.getOverstappen().get(rowIndex).getStation() == "null")
					return route.getStepOn();
				else
					return route.getOverstappen().get(rowIndex).getStation();
			
			case 1:
				return route.getOverstappen().get(rowIndex).getArrival().toString();
				
			case 2:
				return route.getOverstappen().get(rowIndex).getStepOffPlatform();
				
			case 3: 
				if (route.getOverstappen().size() <= rowIndex)
					return "";
				else
					return route.getOverstappen().get(rowIndex).getId();
		
			default: 
				return "";
			}
		}
		
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
