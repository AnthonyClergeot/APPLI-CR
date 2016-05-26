package gsb.controleur;

import gsb.EditeurBoutonAfficherCR;
import gsb.entites.CompteRendu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControleurBoutonAfficherCR implements ActionListener {
	
	private int row ;
	private int column ;
	private JTable table ;
	private EditeurBoutonAfficherCR editeur ;
	private JFrame vue ;
	
	public ControleurBoutonAfficherCR(EditeurBoutonAfficherCR editeur){
		super() ;
		System.out.println("ControleurBoutonAfficherCR::ControleurBoutonAfficherCR()") ;
		this.editeur = editeur ;
	}
	
	public EditeurBoutonAfficherCR getEditeur() {
		return editeur;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public JTable getTable() {
		return table;
	}

	public void setEditeur(EditeurBoutonAfficherCR editeur) {
		this.editeur = editeur;
	}

	public void setRow(int row) {
		this.row = row ;
	}
	
	public void setColumn(int column) {
		this.column = column ;
	}
	
	public void setTable(JTable table) {
		this.table = table ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurBoutonAfficherCR::actionPerformed()") ;
		if(e.getSource() == this.editeur.getBouton()) {
			CompteRendu compteRendu = this.editeur.getVue().getModeleTabCR().getCompteRendu(this.row);
			JOptionPane.showMessageDialog(this.vue, compteRendu.toString(),
					"Rapport de visite n° " + compteRendu.getRapNum() + " du visiteur de matricule " + compteRendu.getVisMatricule(), JOptionPane.DEFAULT_OPTION);
		}
	}

}
