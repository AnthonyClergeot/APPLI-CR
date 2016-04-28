package gsb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControleurAuthentificationGsb implements ActionListener, DocumentListener {
	
	private VueAuthentificationGsb vue ;
	
	private ModeleGsb modele = ModeleGsb.getModeleGsb() ;
	
	private EtatTentativeConnexionGsb etatTentativeConnexion = EtatTentativeConnexionGsb.ABANDON ;
	
	public ControleurAuthentificationGsb(VueAuthentificationGsb vue){
		super() ;
		System.out.println("ControleurAuthentificationGsb::ControleurAuthentificationGsb()") ;
		this.vue = vue ;
		this.enregistrerEcouteur() ;
	}
	
	private void enregistrerEcouteur(){
		System.out.println("ControleurAuthentificationGsb::enregistrerEcouteur()") ;
		
		this.vue.getTfLogin().getDocument().addDocumentListener(this) ;
		this.vue.getPfMDP().getDocument().addDocumentListener(this) ;
		this.vue.getbConnecter().addActionListener(this) ;
		this.vue.getbAnnuler().addActionListener(this) ;
	}
	
	public EtatTentativeConnexionGsb getEtatTentativeConnexionGsb(){
		System.out.println("ControleurAuthentificationGsb::getEtatTentativeConnexion()") ;
		return this.etatTentativeConnexion ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurAuthentificationGsb::actionPerformed()") ;
		if(e.getSource() == this.vue.getbAnnuler()) {
			etatTentativeConnexion = EtatTentativeConnexionGsb.ABANDON ;
			this.vue.dispose() ;
		}
		
		if(e.getSource() == this.vue.getbConnecter()) {
			String login = this.vue.getTfLogin().getText() ;
			@SuppressWarnings("deprecation")
			String mdp = this.vue.getPfMDP().getText() ;
			Delegue user = null ;
			try {
				user = this.modele.getUtilisateur(login, mdp) ;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if(user == null) {
				etatTentativeConnexion = EtatTentativeConnexionGsb.ECHEC ;
				JOptionPane.showMessageDialog(vue, "Login ou mot de passe incorrects") ;
				this.vue.initialiser() ;
			}
			else {
				etatTentativeConnexion = EtatTentativeConnexionGsb.OK ;
				JOptionPane.showMessageDialog(vue, "L'utilisateur " + login + " s'est connecté") ;
				Session.ouvrirSession(user.getMatricule(),
						user.getNom(),
						user.getPrenom(),
						user.getAdresse(),
						user.getCp(),
						user.getVille(),
						user.getDateEmbauche(),
						user.getLogin(),
						user.getMdp(),
						user.getSecCode(),
						user.getLabCode(),
						user.getRegCode()) ;
//				System.out.println(session.getSession()) ;
				this.vue.dispose() ;
			}
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println("ControleurAuthentificationGsb::changedUpdate()") ;
		repercuterSaisieChamps() ;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println("ControleurAuthentificationGsb::insertUpdate()") ;
		repercuterSaisieChamps() ;
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		System.out.println("ControleurAuthentificationGsb::removeUpdate()") ;
		repercuterSaisieChamps() ;
	}
	
	public void repercuterSaisieChamps(){
		System.out.println("ControleurNouvelleLocation::repercuterSaisieChamps()") ;
		String champLogin = this.vue.getTfLogin().getText() ;
		@SuppressWarnings("deprecation")
		String champMdp = this.vue.getPfMDP().getText() ;
		
		boolean champsOk = false ;
		
		if(champLogin.isEmpty() || champMdp.isEmpty()) {
			champsOk = false ;
		}
		else {
			champsOk = true ;
		}
		
		if(champsOk == false){
			this.vue.getbConnecter().setEnabled(false) ;
		}
		else {
			this.vue.getbConnecter().setEnabled(true) ;
		}
	}
	
}