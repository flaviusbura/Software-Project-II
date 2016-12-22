package be.nmbs.tablemodels;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class EmptyTableModel implements TableModel {
	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<Object> getColumnClass(int columnIndex) {
		return Object.class;
	}

	@Override
	public int getColumnCount() {
		return 0;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
			default: return "";
		}
	}

	@Override
	public int getRowCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
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
