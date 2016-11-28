package be.nmbs.tablemodels;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import be.nmbs.logic.VerlorenVoorwerp;

public class VerlorenvoorwerpTableModel implements TableModel {

	/*
	 * public String getColumnName(int col) {
        return columnNames[col].toString();
    }
    public int getRowCount() { return rowData.length; }
    public int getColumnCount() { return columnNames.length; }
    public Object getValueAt(int row, int col) {
        return rowData[row][col];
    }
    public boolean isCellEditable(int row, int col)
        { return true; }
    public void setValueAt(Object value, int row, int col) {
        rowData[row][col] = value;
        fireTableCellUpdated(row, col);
    }
	 */
	
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
				return "station";
				
			case 2:
				return "omschrijving";
				
			case 3: 
				return "datum";
		
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
				return voorwerpen.get(rowIndex).getTimestamp();
		
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
