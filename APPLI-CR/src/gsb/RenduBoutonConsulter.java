package gsb;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class RenduBoutonConsulter extends JButton implements TableCellRenderer {

	private static final long serialVersionUID = 1L ;
	
	public RenduBoutonConsulter(){
		super() ;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		Visiteur visiteur = ((ModeleListeVisiteurs) table.getModel()).getVisiteur(row) ;
		
		this.setText("Compte-rendu") ;
		
		if(column == 4 ) {
			this.setEnabled(true) ;
			return this ;
		}
		
		return null ;
	}

}