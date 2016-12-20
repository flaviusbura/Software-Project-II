package be.nmbs.tablemodels;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import be.nmbs.database.Klant_adresDAO;
import be.nmbs.logic.Adres;
import be.nmbs.logic.Klant;

public class KlantTableModel implements TableModel {
	private ArrayList<Klant> klanten;
	private Klant_adresDAO dao = new Klant_adresDAO();
	private Adres adres;
	
	public void setKlanten(ArrayList<Klant> klanten) {
		this.klanten = klanten;
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<Klant> getColumnClass(int columnIndex) {
		return Klant.class;
	}

	@Override
	public int getColumnCount() {
		return 11;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
			case 0:
				return "Klant ID";
			
			case 1:
				return "Voornaam";
				
			case 2:
				return "Achternaam";
				
			case 3: 
				return "Telefoon";
				
			case 4: 
				return "Straat";
				
			case 5: 
				return "Nummer";
				
			case 6: 
				return "Bus";
				
			case 7: 
				return "Postcode";
				
			case 8: 
				return "Stad";
				
			case 9: 
				return "Land";
				
			case 10: 
				return "Actief";
		
			default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return klanten.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		adres = dao.getAdres(klanten.get(rowIndex).getAdresId());
		
		switch(columnIndex) {
			case 0:
				return klanten.get(rowIndex).getContactId();
			
			case 1:
				return klanten.get(rowIndex).getVoornaam();
				
			case 2:
				return klanten.get(rowIndex).getAchternaam();
				
			case 3: 
				return klanten.get(rowIndex).getTelefoon();
				
			case 4: 
				return adres.getStraat();
				
			case 5: 
				return adres.getHuisnummer();
				
			case 6: 
				return adres.getBus();
				
			case 7: 
				return adres.getPostcode();
				
			case 8: 
				return adres.getWoonplaats();
				
			case 9: 
				return adres.getLand();
				
			case 10: 
				if (klanten.get(rowIndex).isActief())
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
