package be.nmbs.tablemodels;

import java.text.SimpleDateFormat;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import be.nmbs.logic.Trein;

public class TrainTableModel implements TableModel {
	private Trein train;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	public void setTrain(Trein train) {
		this.train = train;
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<Trein> getColumnClass(int columnIndex) {
		return Trein.class;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
			case 0:
				return "Station";
			
			case 1:
				return "Spoor";
				
			case 2:
				return "Tijdstip";
		
			default: return "";
		}
	}

	@Override
	public int getRowCount() {
		int counter = 0;
		
		for (int i = 0; i < train.getStops().size(); i++)
			counter++;
		
		return counter;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0:
				return train.getStops().get(rowIndex).getName();
			
			case 1:
				if (train.getStops().get(rowIndex).getArrivalPlatform() != null)
					return train.getStops().get(rowIndex).getArrivalPlatform();
				else
					return train.getStops().get(rowIndex).getDeparturePlatform();
				
			case 2:
				if (train.getStops().get(rowIndex).getArrivalPlatform() != null)
					return sdf.format(train.getStops().get(rowIndex).getArrival());
				else
					return sdf.format(train.getStops().get(rowIndex).getDeparture());
		
			default: 
				return "";
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
