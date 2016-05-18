package gsb;

import gsb.entites.CompteRendu;
import gsb.modele.ModeleListeCR;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RenduBoutonAfficher extends JButton implements TableCellRenderer {
	
private static final long serialVersionUID = 1L ;
	
	public RenduBoutonAfficher(){
		super() ;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		CompteRendu compteRendu = ((ModeleListeCR) table.getModel()).getCompteRendu(row) ;
		
		this.setText("Afficher") ;
		
		if(column == 5 ) {
			this.setEnabled(true) ;
			return this ;
		}
		
		return null ;
	}

}
