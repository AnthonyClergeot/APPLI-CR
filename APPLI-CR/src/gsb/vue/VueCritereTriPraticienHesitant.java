package gsb.vue;

import gsb.controleur.ControleurCritereTriPraticienHesitant;

import java.awt.Container;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class VueCritereTriPraticienHesitant extends JDialog {
	
	private JCheckBox cbCoefConfiance = new JCheckBox("coefficient de confiance croissant") ;
	private JCheckBox cbTempsDepuisDerniereVisite = new JCheckBox("temps depuis la denière visite décroissant") ;
	private JCheckBox cbCoefNotoriete = new JCheckBox("coefficiant de notoriété décroissant") ;
	private JButton boutonValider = new JButton("valider") ;
	

	private JButton boutonAnnuler = new JButton("annuler") ;
	
	private VueGsb vueParente ;
	private ControleurCritereTriPraticienHesitant controleur ;
	
	public VueCritereTriPraticienHesitant(VueGsb vueParente) {
		super() ;
		System.out.println("VueCritereTriPraticienHesitant::Contructeur") ;
		this.vueParente = vueParente ;
		this.controleur = new ControleurCritereTriPraticienHesitant(this) ;
		this.creerInterfaceUtilisateur();
		this.pack();
		this.setTitle("critère de tri") ;
		this.setLocationRelativeTo(vueParente) ;
		this.setResizable(false) ;
		this.setVisible(true) ;
	}
	
	public void creerInterfaceUtilisateur() {
		System.out.println("VueCritereTriPraticienHesitant::ceerInterfaceUtilisateur()") ;
		Container conteneur = this.getContentPane() ;
		Box boxPrincipal = Box.createVerticalBox() ;
		
		Box boxLabel = Box.createHorizontalBox() ;
		JLabel labelCheckBoxs = new JLabel("Selectionnez le critère de tri désiré : ") ;
		boxLabel.add(labelCheckBoxs) ;
		
		Box boxCriteres = Box.createVerticalBox() ;
		boxCriteres.add(this.cbCoefConfiance) ;
		boxCriteres.add(this.cbTempsDepuisDerniereVisite) ;
		boxCriteres.add(this.cbCoefNotoriete) ;
		
		Box boxBouton = Box.createHorizontalBox() ;
		boxBouton.add(this.boutonAnnuler) ;
		boxBouton.add(this.boutonValider) ;
		
		boxPrincipal.add(Box.createHorizontalStrut(10)) ;
		boxPrincipal.add(Box.createVerticalStrut(10)) ;
		boxPrincipal.add(boxLabel);
		boxPrincipal.add(Box.createVerticalStrut(10)) ;
		boxPrincipal.add(boxCriteres);
		boxPrincipal.add(Box.createVerticalStrut(10)) ;
		boxPrincipal.add(boxBouton);
		boxPrincipal.add(Box.createVerticalStrut(10)) ;
		boxPrincipal.add(Box.createHorizontalStrut(10)) ;
		conteneur.add(boxPrincipal) ;
	}
	
	public JCheckBox getCbCoefConfiance() {
		return cbCoefConfiance;
	}

	public void setCbCoefConfiance(JCheckBox cbCoefConfiance) {
		this.cbCoefConfiance = cbCoefConfiance;
	}

	public JCheckBox getCbTempsDepuisDerniereVisite() {
		return cbTempsDepuisDerniereVisite;
	}

	public void setCbTempsDepuisDerniereVisite(JCheckBox cbTempsDepuisDerniereVisite) {
		this.cbTempsDepuisDerniereVisite = cbTempsDepuisDerniereVisite;
	}

	public JCheckBox getCbCoefNotoriete() {
		return cbCoefNotoriete;
	}

	public void setCbCoefNotoriete(JCheckBox cbCoefNotoriete) {
		this.cbCoefNotoriete = cbCoefNotoriete;
	}

	public JButton getBoutonValider() {
		return boutonValider;
	}

	public void setBoutonValider(JButton boutonValider) {
		this.boutonValider = boutonValider;
	}

	public JButton getBoutonAnnuler() {
		return boutonAnnuler;
	}

	public void setBoutonAnnuler(JButton boutonAnnuler) {
		this.boutonAnnuler = boutonAnnuler;
	}

	public VueGsb getVueParente() {
		return vueParente;
	}

	public void setVueParente(VueGsb vueParente) {
		this.vueParente = vueParente;
	}

	public ControleurCritereTriPraticienHesitant getControleur() {
		return controleur;
	}

	public void setControleur(ControleurCritereTriPraticienHesitant controleur) {
		this.controleur = controleur;
	}
	
}
