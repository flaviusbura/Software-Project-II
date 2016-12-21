package be.nmbs.tablemodels;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import be.nmbs.logic.VerlorenVoorwerp;

public class VerlorenVoorwerpTableModel implements TableModel {
	private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	
	private ArrayList<VerlorenVoorwerp> voorwerpen;
	
	public void setVoorwerpen(ArrayList<VerlorenVoorwerp> voorwerpen) {
		this.voorwerpen = voorwerpen;
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<VerlorenVoorwerp> getColumnClass(int columnIndex) {
		return VerlorenVoorwerp.class;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
			case 0:
				return "Voorwerp ID";
			
			case 1:
				return "Station";
				
			case 2:
				return "Omschrijving";
				
			case 3: 
				return "Datum";
		
			default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return voorwerpen.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0:
				return voorwerpen.get(rowIndex).getId();
			
			case 1:
				return voorwerpen.get(rowIndex).getStation().getNaam();
				
			case 2:
				return voorwerpen.get(rowIndex).getOmschrijving();
				
			case 3: 
				return sdf.format(voorwerpen.get(rowIndex).getTimestamp());
		
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
