package gsb.controleur;

import gsb.EtatTentativeConnexionGsb;
import gsb.techniques.ConnexionBdd;
import gsb.techniques.Session;
import gsb.vue.VueAuthentificationGsb;
import gsb.vue.VueCritereTriPraticienHesitant;
import gsb.vue.VueGsb;
import gsb.vue.VueListeCR;
import gsb.vue.VueListeVisiteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.* ;

import javax.swing.*;

public class ControleurGsb implements ActionListener {

	private VueGsb vue ;
	private VueListeVisiteurs ListeVisiteurs = new VueListeVisiteurs(vue) ;
	private VueListeCR ListeCR = new VueListeCR() ;
	
	public ControleurGsb(VueGsb vue) {
		super();
		System.out.println("ControleurGsb::ControleurGsb()") ;
		this.vue = vue ;
		this.enregistrerEcouteur();
	}
	
	public VueGsb getVueGsb() {
		return this.vue ;
	}

	public void setVueGsb(VueGsb vue) {
		this.vue = vue ;
	}
	
	private void enregistrerEcouteur(){
		System.out.println("ControleurGsb::enregistrerEcouteur()") ;
		this.vue.getItemAccueil().addActionListener(this) ;
		this.vue.getItemQuitter().addActionListener(this) ;
		this.vue.getItemConnecter().addActionListener(this) ;
		this.vue.getItemDeconnecter().addActionListener(this) ;
		this.vue.getItemListePraticienHesitant().addActionListener(this) ;
		this.vue.getItemListeVisiteur().addActionListener(this) ;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurGsb::actionPerformed()") ;
		Object sourceEvt = e.getSource() ;
		
		if(e.getSource() == this.vue.getItemAccueil()) {
			this.vue.changerVue("Accueil") ;
		}
		
		if(e.getSource() == this.vue.getItemQuitter()) {
			int choix = JOptionPane.showConfirmDialog(vue, "Voulez vous vraiment fermer l'application ?", "Quitter", 0) ;
			if(choix == 0) {
				try {
					ConnexionBdd.getConnexionBdd().close() ;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.exit(0) ;
			}	
		}
		
		if(e.getSource() == this.vue.getItemConnecter()) {
			VueAuthentificationGsb authentification = new VueAuthentificationGsb(this.vue) ;
			EtatTentativeConnexionGsb etat = authentification.getEtatTentativeConnexionGsb() ;
			if(etat == EtatTentativeConnexionGsb.OK) {
				this.vue.setMenusConnecte();
				vue.getConteneur().add(ListeVisiteurs, "ListeVisiteurs") ;
				vue.getConteneur().add(ListeCR, "ListeCR") ;
			}
		}
		
		if(e.getSource() == this.vue.getItemDeconnecter()) {
			int choix = JOptionPane.showConfirmDialog(vue, "Voulez vous vraiment vous deconnecter ?", "Deconnexion", 0) ;
			if(choix == 0) {
				this.vue.setMenusDeconnecte() ;
				Session.getSession().fermerSession() ;
			}
			this.vue.changerVue("Accueil") ;
		}
		
		if(e.getSource() == this.vue.getItemListePraticienHesitant()) {
			VueCritereTriPraticienHesitant vueCritere = new VueCritereTriPraticienHesitant(this.vue) ;
			this.vue.changerVue("vuePraticienHesitant") ;
		}
		
		if(e.getSource() == this.vue.getItemListeVisiteur()) {
			this.vue.changerVue("ListeVisiteurs") ;
		}
	}
	
	
	
}
