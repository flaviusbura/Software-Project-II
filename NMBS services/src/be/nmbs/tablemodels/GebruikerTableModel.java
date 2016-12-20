package be.nmbs.tablemodels;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import be.nmbs.logic.Gebruiker;

public class GebruikerTableModel implements TableModel {
	
	private ArrayList<Gebruiker> gebruikers;
	
	public void setGebruikers(ArrayList<Gebruiker> gebruikers) {
		this.gebruikers = gebruikers;
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<Gebruiker> getColumnClass(int columnIndex) {
		return Gebruiker.class;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
			case 0:
				return "Gebruiker ID";
			
			case 1:
				return "Voornaam";
				
			case 2:
				return "Achternaam";
				
			case 3: 
				return "Gebruikersnaam";
				
			case 4: 
				return "Rol";
				
			case 5: 
				return "Actief";
		
			default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return gebruikers.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0:
				return gebruikers.get(rowIndex).getId();
			
			case 1:
				return gebruikers.get(rowIndex).getVoornaam();
				
			case 2:
				return gebruikers.get(rowIndex).getAchternaam();
				
			case 3: 
				return gebruikers.get(rowIndex).getUsername();
				
			case 4: 
				if (gebruikers.get(rowIndex).getRol() == 1)
					return "Bediende";
				else
					return "Admin";
				
			case 5: 
				if (gebruikers.get(rowIndex).isActief())
					return "Ja";
				else
					return "Neen";
		
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
