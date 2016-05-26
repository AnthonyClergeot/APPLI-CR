package gsb.controleur;

import gsb.vue.VueAuthentificationGsb;
import gsb.vue.VueCritereTriPraticienHesitant;
import gsb.vue.VueGsb;
import gsb.vue.VueListeVisiteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControleurGsb implements ActionListener{
	private VueGsb vue ;
	
	public ControleurGsb(VueGsb vue) {
		super() ;
		this.vue = vue ;
		this.enregistrerEcouteur() ;
	}
	
	public void enregistrerEcouteur() {
		
		this.vue.getItemConnecter().addActionListener(this) ;
		this.vue.getItemDeconnecter().addActionListener(this) ;
		this.vue.getItemQuitter().addActionListener(this) ;
		this.vue.getItemListeVisiteurs().addActionListener(this) ;
		this.vue.getItemListePraticienHesitant().addActionListener(this) ;
		this.vue.getItemAide().addActionListener(this) ;
		this.vue.getItemAPropos().addActionListener(this) ;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vue.getItemConnecter()) {
			VueAuthentificationGsb vueAuthentification = new VueAuthentificationGsb(this.vue) ;
		}
		if(e.getSource() == this.vue.getItemDeconnecter()) {
			this.vue.setMenuDeconnecte();
		}
		if(e.getSource() == this.vue.getItemQuitter()) {
			int choix = JOptionPane.showConfirmDialog(null, "Quitter l'application?", null, 0) ;
			if(choix == 0) {
				System.exit(0) ;
			}
		}
		if(e.getSource() == this.vue.getItemListePraticienHesitant()) {
			VueCritereTriPraticienHesitant vueCritere = new VueCritereTriPraticienHesitant(this.vue) ;
		}
		if(e.getSource() == this.vue.getItemListeVisiteurs()) {
			VueListeVisiteurs vueListeVisiteurs = new VueListeVisiteurs(this.vue);
			this.vue.changerVue("VueListeVsiteurs");
		}
		
	}
	
}
