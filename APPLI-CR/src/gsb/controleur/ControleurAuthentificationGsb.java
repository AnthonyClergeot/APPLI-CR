package gsb.controleur;

import gsb.EtatTentativeConnexionGsb;
import gsb.Session;
import gsb.entites.Delegue;
import gsb.modele.ModelGsb;
import gsb.vue.VueAuthentificationGsb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControleurAuthentificationGsb implements ActionListener {
	
	private VueAuthentificationGsb vue ;
	private EtatTentativeConnexionGsb etatTentativeConnexionGsb = EtatTentativeConnexionGsb.ABANDON ;
	private ModelGsb model = ModelGsb.getModele() ;
	
	public ControleurAuthentificationGsb(VueAuthentificationGsb vue) {
		this.vue = vue;
		this.enregistrerEcouteur() ;
	}
	
	public void enregistrerEcouteur() {
		this.vue.getButtonAnnuler().addActionListener(this) ;
		this.vue.getButtonConnecter().addActionListener(this) ;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurAuthentification::ActionPerformed()") ;
		if(e.getSource() == this.vue.getButtonAnnuler()) {
			this.vue.dispose() ;
		}
		
		if(e.getSource() == this.vue.getButtonConnecter()) {
			
			System.out.println(this.etatTentativeConnexionGsb) ;
			String login = this.vue.getTextfieldLogin().getText() ;
			String mdp = String.valueOf(this.vue.getPasswordfieldMdp().getPassword()) ;
			
			
			System.out.println("login : [" + login + "] mot de passe : [" + mdp + "]") ;	
			
			try {	
				Delegue delegue = this.model.getUnDelegue(login, mdp) ;
				
				if(delegue != null) {
					Session.ouvrirSession(login, delegue.getRegionCode()) ;
					this.vue.getVueParente().setSession(Session.getSession()) ;		
					this.setEtatTentativeConnexionGsb(EtatTentativeConnexionGsb.OK) ;
					System.out.println(this.etatTentativeConnexionGsb) ;
					System.out.println("Session ==> " + this.vue.getVueParente().getSession()) ;
					JOptionPane.showMessageDialog(null, "Bienvenu " + login) ;
					this.vue.dispose() ;
					
				}else {
				this.setEtatTentativeConnexionGsb(EtatTentativeConnexionGsb.ECHEC) ;
					System.out.println(this.etatTentativeConnexionGsb) ;
					JOptionPane.showConfirmDialog(null, "login ou mot de passe incorrecte...", "ERROR", 0) ;
					this.vue.getTextfieldLogin().setText(null) ;
					this.vue.getPasswordfieldMdp().setText(null);
					
				}
				if(this.etatTentativeConnexionGsb == EtatTentativeConnexionGsb.OK){	
					this.vue.getVueParente().setMenuConnecte() ;
				}
			} catch (SQLException l){
				System.out.println(l.getMessage()) ;
			}
		 
		}
		
	}
	
	public EtatTentativeConnexionGsb getEtatTentativeConnexionGsb() {
		 return this.etatTentativeConnexionGsb ;
	}
	
	public void setEtatTentativeConnexionGsb(EtatTentativeConnexionGsb etatTentativeConnexionGsb) {
		this.etatTentativeConnexionGsb = etatTentativeConnexionGsb ;
	}
	
	

}
