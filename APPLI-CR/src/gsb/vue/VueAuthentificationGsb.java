package gsb.vue;

import gsb.EtatTentativeConnexionGsb;
import gsb.controleur.ControleurAuthentificationGsb;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class VueAuthentificationGsb extends JDialog {
	
	private static final long serialVersionUID = 1L;

	private ControleurAuthentificationGsb controleur ;
	
	private JTextField tfLogin = new JTextField() ;
	private JPasswordField pfMDP = new JPasswordField() ;
	private JButton bConnecter = new JButton("Se connecter") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	public VueAuthentificationGsb(JFrame vueParente){
		super(vueParente,"Connexion",true) ;
		System.out.println("VueAuthentificationGsb::VueAuthentificationGsb()") ;
		this.creerInterfaceUtilisateur();
		this.controleur = new ControleurAuthentificationGsb(this) ;
		this.pack();
		this.setLocationRelativeTo(vueParente) ;
		this.setResizable(false) ;
		this.initialiser() ;
		this.setVisible(true) ;
	}
	
	public void initialiser(){
		System.out.println("VueAuthentificationGsb::initialiser()") ;
		this.tfLogin.setText("ecadic") ;
		this.pfMDP.setText("azerty") ;
		this.controleur.repercuterSaisieChamps() ;
	}
	
	private void creerInterfaceUtilisateur(){
		System.out.println("VueAuthentificationGsb::creerInterfaceUtilisateur()") ;
		Container conteneur = this.getContentPane() ;
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxChamps = Box.createHorizontalBox() ;
		Box boxSaisies = Box.createVerticalBox() ;
		Box boxEtiquettes = Box.createVerticalBox() ;
		Box boxLigne = Box.createHorizontalBox() ;
		Box boxActions = Box.createHorizontalBox() ;
		
		boxEtiquettes.add(new JLabel("Login : ")) ;
		boxEtiquettes.add(new JLabel("MDP : ")) ;
		
		boxSaisies.add(this.tfLogin) ;
		boxSaisies.add(this.pfMDP) ;
		
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		boxLigne.add(new JSeparator()) ;
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bConnecter) ;
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bAnnuler) ;
		boxActions.add(Box.createHorizontalStrut(5)) ;
		
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		boxChamps.add(boxEtiquettes) ;
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		boxChamps.add(boxSaisies) ;
		boxChamps.add(Box.createHorizontalStrut(5)) ;
		
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxChamps) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxLigne) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		boxPrincipale.add(boxActions) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		
		conteneur.add(boxPrincipale) ;
		
		Dimension dimensionBouton = this.bConnecter.getPreferredSize() ;
		
		this.bAnnuler.setPreferredSize(dimensionBouton) ;
		this.bAnnuler.setMaximumSize(dimensionBouton) ;
		this.bAnnuler.setMinimumSize(dimensionBouton) ;
	}

	public JTextField getTfLogin() {
		return tfLogin;
	}

	public JPasswordField getPfMDP() {
		return pfMDP;
	}

	public JButton getbConnecter() {
		return bConnecter;
	}

	public JButton getbAnnuler() {
		return bAnnuler;
	}
	
	public EtatTentativeConnexionGsb getEtatTentativeConnexionGsb(){
		System.out.println("VueAuthentificationGsb::getEtatTentativeConnexionGsb()") ;
		return this.controleur.getEtatTentativeConnexionGsb() ;
	}
	
}