package gsb.modele;

import gsb.entites.Praticien;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeleListePraticien extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Praticien> lesPraticiens = ModeleGsb.getModeleGsb().getListeDesPraticiensHesitantOrderByCoeffConfiance();
	private String[] entetes = {"nom","prenom", "nombre de jours depuis la dernière visiste","coefficient confiance", "coefficiant notoriété"} ;
	
	public ModeleListePraticien() {
		super() ;
		System.out.println("ModeleListePraticien::ModeleListePraticien()") ;
	}
	
	public int getRowCount() {
		System.out.println("ModeleListePraticiens::getRowCount()") ;
		int nbLignes = this.lesPraticiens.size() ;
		return nbLignes ;
	}
	
	public int getColumnCount() {
		System.out.println("ModeleListePraticiens::getColumnCount()") ;
		int nbColonnes = entetes.length ;
		return nbColonnes ;
	}
	
	public String getColumnName(int i){
		System.out.println("ModeleListePraticiens::getColumnName()") ;
		String nomColonne = entetes[i] ;
		return nomColonne ;
	}
	
	public Object getValueAt(int i, int l) {
		System.out.println("ModeleListePraticiens::getValueAt()") ;
		Object obj = null ;
		switch(l) {
		case 0 :
			obj = this.lesPraticiens.get(i).getNom() ;
			break;
		case 1 :
			obj = this.lesPraticiens.get(i).getPrenom() ;
			break;
		case 2 :
			obj = this.lesPraticiens.get(i).getDateDerniereVisite() ;
			break;
		case 3 :
			obj = this.lesPraticiens.get(i).getCoefConfiance() ;
			break;
		case 4 :
			obj = this.lesPraticiens.get(i).getCoefNotoriete() ;
			break;
		
			
		}
		return obj ;
	}
	
	public void actualiser(){
		System.out.println("ModeleListeClients::actualiser()") ;
		this.fireTableDataChanged();
	}
	
	public void sortByCoeffNotoriete(){
		this.lesPraticiens = ModeleGsb.getModeleGsb().getListeDesPraticiensHesitantOrderByCoeffNotoriete();
	}
	
	public void sortByCoeffConfiance(){
		this.lesPraticiens = ModeleGsb.getModeleGsb().getListeDesPraticiensHesitantOrderByCoeffConfiance();

	}
	
	public void sortByTempsDepuisDernièreVisite(){
		this.lesPraticiens = ModeleGsb.getModeleGsb().getListeDesPraticiensHesitantOrderByDepuisDerniereVisite();

	}
}
