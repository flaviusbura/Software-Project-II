package be.nmbs.tablemodels;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import be.nmbs.database.AbonnementDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Gebruiker;
public class StatistiekTableModel implements TableModel {
	private ArrayList<Abonnement> types;
	private ArrayList<Double> totalen;
	private ArrayList<Double> prijzen;
	
	public void setTypen(ArrayList<Abonnement> type) {
		this.types = type;
	}
	public void setTotalalen(ArrayList<Double> totals) {
		this.totalen = totals;
	}
	public void setPrijzen(ArrayList<Double> prices) {
		this.prijzen = prices;
	}
	@Override
	public Class<Abonnement> getColumnClass(int columnIndex) {
		return Abonnement.class;
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
			case 0:
				return "Abonnement type";
			
			case 1:
				return "Totaal verkocht";
				
			case 2:
				return "Omzet";
				
			default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return types.size()+1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0:
				if(rowIndex == types.size()){
					return "Totaal:";
				}
				else{
					AbonnementDAO dao=new AbonnementDAO();
					return dao.getAbonnementType(types.get(rowIndex).getAbonnementId());
				}
				
			case 1:
				if(rowIndex == totalen.size()){
					double total=0.0;
					for(int i=0;i<totalen.size();i++){
						total = total + totalen.get(i);
					}
					return total;
				}
				else{
					return totalen.get(rowIndex);
				}
				
			case 2:
				if(rowIndex == prijzen.size()){
					double total=0.0;
					for(int i=0;i<prijzen.size();i++){
						total = total + prijzen.get(i);
					}
					return total;
				}
				else{
					return prijzen.get(rowIndex);
				}
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

