package gsb;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class EditeurBoutonAfficherCR extends DefaultCellEditor {
	
	protected JButton bouton ;
	private boolean isPushed ;
	static JCheckBox checkBox = new JCheckBox() ;
	private ControleurBoutonAfficherCR controleur = new ControleurBoutonAfficherCR(this) ;
	private VueListeCR vue ;
	
	public EditeurBoutonAfficherCR(VueListeCR vueListeCR) {
		super(checkBox) ;
		System.out.println("EditeurBoutonAfficherCR::EditeurBoutonAfficherCR()") ;
		bouton = new JButton() ;
		this.controleur = new ControleurBoutonAfficherCR(this) ;
		this.vue = vueListeCR ;
		bouton.addActionListener(controleur) ;
		this.controleur.setEditeur(this) ;
	}
	
	public Component getTableCellEditorComponent(JTable table, Object objet, boolean bool, int row, int column) {
		controleur.setRow(row) ;
		controleur.setColumn(column) ;
		controleur.setTable(table) ;
		bouton.setText("Afficher") ;
		
		return bouton ;
	}

	public JButton getBouton() {
		return bouton;
	}

	public boolean isPushed() {
		return isPushed;
	}

	public static JCheckBox getCheckBox() {
		return checkBox;
	}

	public ControleurBoutonAfficherCR getControleur() {
		return controleur;
	}

	public void setBouton(JButton bouton) {
		this.bouton = bouton;
	}

	public void setPushed(boolean isPushed) {
		this.isPushed = isPushed;
	}

	public static void setCheckBox(JCheckBox checkBox) {
		EditeurBoutonConsulterCR.checkBox = checkBox;
	}

	public void setControleur(ControleurBoutonAfficherCR controleur) {
		this.controleur = controleur;
	}

}
