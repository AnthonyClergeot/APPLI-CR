package gsb;

import gsb.controleur.ControleurBoutonConsulterCR;
import gsb.vue.VueGsb;
import gsb.vue.VueListeVisiteurs;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class EditeurBoutonConsulterCR extends DefaultCellEditor {
	
	protected JButton bouton ;
	private boolean isPushed ;
	static JCheckBox checkBox = new JCheckBox() ;
	private ControleurBoutonConsulterCR controleur ;
	private VueListeVisiteurs vue ;
	private VueGsb vueGsb ;
	
	public EditeurBoutonConsulterCR(VueListeVisiteurs vue, VueGsb vueGsb) {
		super(checkBox) ;
		System.out.println("EditeurBoutonConsulterCR::EditeurBoutonConsulterCR()") ;
		bouton = new JButton() ;
		this.controleur = new ControleurBoutonConsulterCR(this, vueGsb) ;
		this.vue = vue ;
		this.vueGsb = vueGsb ;
		bouton.addActionListener(controleur) ;
		this.controleur.setEditeur(this) ;
	}
	
	public Component getTableCellEditorComponent(JTable table, Object objet, boolean bool, int row, int column) {
		controleur.setRow(row) ;
		controleur.setColumn(column) ;
		controleur.setTable(table) ;
		bouton.setText("Compte-rendu") ;
		
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

	public ControleurBoutonConsulterCR getControleur() {
		return controleur;
	}

	public void setBouton(JButton bouton) {
		this.bouton = bouton;
	}

	public void setPushed(boolean isPushed) {
		this.isPushed = isPushed;
	}

	public VueListeVisiteurs getVue() {
		return vue;
	}

	public VueGsb getVueGsb() {
		return vueGsb;
	}

	public static void setCheckBox(JCheckBox checkBox) {
		EditeurBoutonConsulterCR.checkBox = checkBox;
	}

	public void setControleur(ControleurBoutonConsulterCR controleur) {
		this.controleur = controleur;
	}

}