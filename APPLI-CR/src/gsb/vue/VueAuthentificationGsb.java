package gsb.vue;

import gsb.controleur.ControleurAuthentificationGsb;

import java.awt.Container;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class VueAuthentificationGsb extends JDialog {
	
	private JLabel labelLogin = new JLabel("login") ;
	private JLabel labelMdp = new JLabel("mot de passe") ;
	private JTextField textfieldLogin = new JTextField() ;
	private JPasswordField passwordfieldMdp = new JPasswordField() ;
	private JButton buttonConnecter = new JButton("se connecter") ;
	private JButton buttonAnnuler = new JButton("annuler") ;
	
	private ControleurAuthentificationGsb controleur ;
	private VueGsb vueParent ;
	
	public VueAuthentificationGsb(VueGsb vueParent) {
		super() ;
		
		System.out.println("VueauthentificationGsb::VueAuthentificationGsb()") ;
		this.creerInterfaceUtilisateur() ;
		this.controleur = new ControleurAuthentificationGsb(this) ;
		this.pack();
		this.setTitle("authentification") ;
		this.setLocationRelativeTo(vueParent) ;
		this.setResizable(false) ;
		this.setVisible(true) ;
		
		this.vueParent = vueParent ;
	}
	
	public JTextField getTextfieldLogin() {
		return textfieldLogin;
	}

	public void setTextfieldLogin(JTextField textfieldLogin) {
		this.textfieldLogin = textfieldLogin;
	}

	public JPasswordField getPasswordfieldMdp() {
		return passwordfieldMdp;
	}

	public void setPasswordfieldMdp(JPasswordField passwordfieldMdp) {
		this.passwordfieldMdp = passwordfieldMdp;
	}

	public JButton getButtonConnecter() {
		return buttonConnecter;
	}

	public JButton getButtonAnnuler() {
		return buttonAnnuler;
	}
	public VueGsb getVueParente() {
		return this.vueParent ;
	}

	public void creerInterfaceUtilisateur() {
		
		System.out.println("VueAuthentificationGsb::creerInterfaceUtilisateur()") ;
		Container conteneur = this.getContentPane() ;
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxChamps = Box.createHorizontalBox() ;
		Box boxSaisies = Box.createVerticalBox();
		Box boxEtiquettes = Box.createVerticalBox() ;
		Box boxLigne = Box.createHorizontalBox() ;
		Box boxBoutons = Box.createHorizontalBox() ;
		
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxChamps) ;
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		boxChamps.add(boxEtiquettes) ;
		boxEtiquettes.add(this.labelLogin) ;
		boxEtiquettes.add(Box.createVerticalStrut(5)) ;
		boxEtiquettes.add(this.labelMdp) ;
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		boxChamps.add(boxSaisies) ;
		boxSaisies.add(this.textfieldLogin) ;
		boxSaisies.add(Box.createVerticalStrut(5)) ;
		boxSaisies.add(this.passwordfieldMdp) ;
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxLigne) ;
		boxLigne.add(new JSeparator()) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxBoutons) ;
		boxBoutons.add(this.buttonAnnuler) ;
		boxBoutons.add(this.buttonConnecter) ;
		
		conteneur.add(boxPrincipale) ;
	}
	
}
