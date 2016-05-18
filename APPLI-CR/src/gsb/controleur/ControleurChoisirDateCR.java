package gsb.controleur;

import gsb.modele.ModeleGsb;
import gsb.vue.VueChoisirDateCR;
import gsb.vue.VueGsb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControleurChoisirDateCR implements ActionListener, DocumentListener {
	
	private VueChoisirDateCR vue ;
	private VueGsb vueGsb ;
	
	private ModeleGsb modele = ModeleGsb.getModeleGsb() ;
	
	public ControleurChoisirDateCR(VueChoisirDateCR vue, VueGsb vueGsb) {
		super();
		System.out.println("ControleurChoisirDateCR::ControleurChoisirDateCR()") ;
		this.vue = vue ;
		this.vueGsb = vueGsb ;
		this.enregistrerEcouteur() ;
	}

	public VueChoisirDateCR getVue() {
		return vue;
	}

	public void setVue(VueChoisirDateCR vue) {
		this.vue = vue;
	}

	/** Enregistrer le contrôleur comme écouteur des boutons et de la zone de saisie de la date de retour prévue
	 * 
	 */
	private void enregistrerEcouteur(){
		System.out.println("ControleurChoisirDateCR::enregistrerEcouteur()") ;
		this.vue.getbValider().addActionListener(this) ;
		this.vue.getbAnnuler().addActionListener(this) ;
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println("ControleurChoisirDateCR::insertUpdate()") ;
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		System.out.println("ControleurChoisirDateCR::removeUpdate()") ;
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println("ControleurChoisirDateCR::changedUpdate()") ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurChoisirDateCR::actionPerformed()") ;
		if(e.getSource() == this.vue.getbAnnuler()) {
			this.vue.dispose() ;
		}
		
		if(e.getSource() == this.vue.getbValider()) {
//			String mois = this.vue.getCbMois().getSelectedItem().toString() ;
//			Integer annee = (Integer) this.vue.getCbAnnees().getSelectedItem() ;
//			System.out.println(mois + " " + annee) ;
			this.vueGsb.changerVue("ListeCR") ;
			this.vue.dispose() ;
		}
		
	}
	
}
