package gsb;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenduCelluleListeVisiteurs extends DefaultTableCellRenderer {
	
	private static final long serialVersionUID = 1L;

	public RenduCelluleListeVisiteurs(){
		super() ;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		
		DefaultTableCellRenderer composant = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, 
				isSelected, hasFocus,	row, column) ;
		
		if(column == 0 || column == 1 || column == 2 || column == 3) {
			composant.setHorizontalAlignment(CENTER) ;
		}

		return composant ;
	}

}
