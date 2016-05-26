package gsb.modele;

import gsb.Session;
import gsb.entites.Visiteur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ModeleListeVisiteurs extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	private List<Visiteur> visiteurs ;
	private final String[] entetes = {"Matricule","Nom","Prénom","Laboratoire", "Consulter CR"} ;
	
	public ModeleListeVisiteurs(){
		super() ;
		System.out.println("ModeleListeVisiteurs::ModeleListeVisiteurs()") ;
		
		this.visiteurs = ModelGsb.getModele().getVisiteursRegion(Session.getSession().getRegionCode());
		
	}
	
	
	
	@Override
	public int getRowCount() {
		System.out.println("ModeleListeVisiteurs::getRowCount()") ;
		return this.visiteurs.size() ;
	}

	@Override
	public int getColumnCount() {
		System.out.println("ModeleListeVisiteurs::getColumnCount()") ;
		return this.entetes.length ;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		System.out.println("ModeleListeVisiteurs::getColumnName()") ;
		return this.entetes[columnIndex] ;
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		System.out.println("ModeleListeVisiteurs::getColumnClass()") ;
		
		switch(columnIndex) {
		
			case 0 : 
				return String.class ;
			
			case 1 : 
				return String.class ;
			
			case 2 : 
				return String.class  ;
			
			case 3 : 
				return String.class ;
				
			case 4 : 
				return JButton.class ;
			
			default :
				return Object.class ;
				
		}
		
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		System.out.println("ModeleListeLocations::isCellEditable("+rowIndex+","+columnIndex+")") ;
		if(columnIndex == 4) {
			return true ;
		}
		else {
			return false ;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("ModeleListeVisiteurs::getValueAt("+rowIndex+","+columnIndex+")") ;
		
		Object resultat = null ;
		
		switch(columnIndex) {
		
			case 0 : 
				resultat = this.visiteurs.get(rowIndex).getMatricule() ;
				break ;
			
			case 1 : 
				resultat = this.visiteurs.get(rowIndex).getNom() ;
				break ;
			
			case 2 : 
				resultat = this.visiteurs.get(rowIndex).getPrenom() ;
				break ;
			
			case 3 : 
				try {
					resultat = ModelGsb.getModele().getNomLabo(this.visiteurs.get(rowIndex).getLabCode()) ;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break ;
			
		}
		
		return resultat ;
	}
	
	public void actualiser(){
		System.out.println("ModeleListeVisiteurs::actualiser()") ;
		this.fireTableDataChanged();
	} 
	
	public Visiteur getVisiteur(int indiceLigne) {
		return this.visiteurs.get(indiceLigne) ;
	}

}
