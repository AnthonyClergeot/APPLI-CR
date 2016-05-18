package gsb.controleur;

import gsb.EditeurBoutonConsulterCR;
import gsb.techniques.DateFR;
import gsb.vue.VueGsb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControleurBoutonConsulterCR implements ActionListener {

	private int row ;
	private int column ;
	private JTable table ;
	private EditeurBoutonConsulterCR editeur ;
	private VueGsb vueGsb ;
	
	private JComboBox<String> cbMois = new JComboBox<String>() ;
	private JComboBox<Integer> cbAnnees = new JComboBox<Integer>() ;
	private JLabel mois = new JLabel("Mois : ") ;
	private JLabel annee = new JLabel("Année : ") ;
	private JButton bValider = new JButton("Valider") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	private Object [] tab = {
								mois,
								cbMois,
								annee,
								cbAnnees
							} ;
	private Object [] tab2 = {
								bValider,
								bAnnuler
							} ;
	
	public ControleurBoutonConsulterCR(EditeurBoutonConsulterCR editeur, VueGsb vueGsb) {
		super() ;
		System.out.println("ControleurBoutonConsulterCR::ControleurBoutonConsulterCR()") ;
		this.editeur = editeur ;
		this.vueGsb = vueGsb ;
		this.initialiser();
	}
	
	public EditeurBoutonConsulterCR getEditeur() {
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

	public void setEditeur(EditeurBoutonConsulterCR editeur) {
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
	
	public VueGsb getVueGsb() {
		return vueGsb;
	}
	
	private void initialiser(){
		System.out.println("VueChoisirDateCR::initialiser()") ;
		this.bValider.addActionListener(this) ;
		this.bAnnuler.addActionListener(this) ;
		
		int anneeCourante = new DateFR().getAnnee() ;
		
		List<String> mois = new ArrayList<String>() ;
		mois.add("01 - Janvier") ;
		mois.add("02 - Fevrier") ;
		mois.add("03 - Mars") ;
		mois.add("04 - Avril") ;
		mois.add("05 - Mai") ;
		mois.add("06 - Juin") ;
		mois.add("07 - Juillet") ;
		mois.add("08 - Août") ;
		mois.add("09 - Septembre") ;
		mois.add("10 - Octobre") ;
		mois.add("11 - Novembre") ;
		mois.add("12 - Décembre") ;
		for(int i = 0 ; i < mois.size() ; i++) {
			this.cbMois.addItem(mois.get(i)) ;
		}
		
		List<Integer> annees = new ArrayList<Integer>() ;
		for(int i = 1990 ; i <= anneeCourante ; i++) {
			annees.add(i) ;
		} 
		
		for(int i = 0 ; i < annees.size() ; i++) {
			this.cbAnnees.addItem(annees.get(i)) ;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurBoutonConsulterCR::actionPerformed()") ;
		if(e.getSource() == this.editeur.getBouton()) {
//			VueChoisirDateCR date = new VueChoisirDateCR(this.vueGsb) ;
			JOptionPane.showOptionDialog(null, tab, "Date des comptes-rendus", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tab2, null) ;
		}
		if (e.getSource() == bValider) {
			this.vueGsb.changerVue("ListeCR") ;
		}
		if (e.getSource() == bAnnuler) {
			
		}
	}

}