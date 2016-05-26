package gsb.vue;

import gsb.Session;
import gsb.controleur.ControleurGsb;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VueGsb extends JFrame {
	
	private JFrame frameFenetre ;
	
	private JPanel panelPrincipal ;
	private JMenuBar menubarBarreMenu = new JMenuBar() ;
	private JMenu menuFichier = new JMenu("Fichier") ;
	private JMenu menuAide = new JMenu("Aide") ;
	private JMenu menuConsulter = new JMenu("Consulter") ;
	private JMenuItem itemConnecter = new JMenuItem("Se connecter") ;
	private JMenuItem itemDeconnecter = new JMenuItem("Se déconnecter") ;
	private JMenuItem itemQuitter = new JMenuItem("Quitter") ;
	private JMenuItem itemListeVisiteurs = new JMenuItem("Liste des Visiteurs") ;
	private JMenuItem itemListePraticienHesitant = new JMenuItem("liste des praticiens hésitants") ;
	private JMenuItem itemAide = new JMenuItem("Aide") ;
	private JMenuItem itemAPropos = new JMenuItem("A propos" );
	private JPanel vuePraticienHesitant ;
	private JPanel vueListeVisiteurs;
	private JPanel vueListeCR;
	
	private CardLayout clPanneau = new CardLayout(5, 5) ;
	private Container conteneur = this.getContentPane() ;
	
	private ControleurGsb controleur ;
	private Session session = null ;
	
	public VueGsb() {
		super() ;
		System.out.println("VueGsb::VueGsb()") ;
		
		this.controleur = new ControleurGsb(this) ;
		
		this.setJMenuBar(creerBarreMenu()) ;
		this.setMenuDeconnecte();
	
		
		JPanel vueAccueil = new JPanel() ;
		vueAccueil.add(new JLabel("Accueil")) ;
		vuePraticienHesitant = new VuePraticienHesitant(this) ;
		
		
		this.conteneur.setLayout(clPanneau) ;
		this.conteneur.add(vueAccueil, "VueAccueil") ;
		this.conteneur.add(vuePraticienHesitant, "VuePraticienHesitant") ;
		clPanneau.show(conteneur, "vueAccueil");
		
		this.pack();
		this.setSize(1400, 600) ;
		this.setLocationRelativeTo(null) ;
		this.setVisible(true) ;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public JPanel getVuePraticienHesitant() {
		return vuePraticienHesitant;
	}

	public void setVuePraticienHesitant(JPanel vuePraticienHesitant) {
		this.vuePraticienHesitant = vuePraticienHesitant;
	}

	public JMenuBar creerBarreMenu() {
		
		menuFichier.add(itemConnecter) ;
		menuFichier.add(itemDeconnecter) ;
		menuFichier.add(itemQuitter) ;
		
		menuConsulter.add(itemListePraticienHesitant) ;
		menuConsulter.add(itemListeVisiteurs) ;
		
		menuAide.add(itemAide) ;
		menuAide.add(itemAPropos) ;
		
		menubarBarreMenu.add(menuFichier) ;
		menubarBarreMenu.add(menuConsulter) ;
		menubarBarreMenu.add(menuAide) ;
		
		return menubarBarreMenu ;
	}
	public void setMenuDeconnecte() {
		
		System.out.println("VueGsb::setMenuDeconnecte") ;
		this.menuConsulter.setEnabled(false) ;
		this.itemDeconnecter.setEnabled(false) ;
		this.itemConnecter.setEnabled(true) ;
		
	}
	public void setMenuConnecte() {
		
		System.out.println("VueGsb::setMenuConnecte") ;
		
		this.itemConnecter.setEnabled(false) ;
		this.itemDeconnecter.setEnabled(true) ;
		this.menuConsulter.setEnabled(true) ;
		vueListeVisiteurs = new VueListeVisiteurs(this) ;
		
		this.conteneur.add(vueListeVisiteurs, "VueListeVsiteurs") ;
		
	}
	
	public JPanel getVueListeCR() {
		return vueListeCR;
	}

	public void setVueListeCR(JPanel vueListeCR) {
		this.vueListeCR = vueListeCR;
	}

	public void changerVue(String vue) {
		System.out.println("VueGsb::changerVue("+ vue +")") ;
		this.clPanneau.show(conteneur ,vue) ;
	}
	
	public JFrame getFrameFenetre() {
		return frameFenetre;
	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}


	public JMenuItem getItemConnecter() {
		return itemConnecter;
	}

	public JMenuItem getItemDeconnecter() {
		return itemDeconnecter;
	}

	public JMenuItem getItemQuitter() {
		return itemQuitter;
	}

	public JMenuItem getItemListeVisiteurs() {
		return itemListeVisiteurs;
	}

	public JMenuItem getItemListePraticienHesitant() {
		return itemListePraticienHesitant;
	}

	public JMenuItem getItemAide() {
		return itemAide;
	}

	public JMenuItem getItemAPropos() {
		return itemAPropos;
	}
	
	public void setSession(Session session){
		this.session = session ;
	}
	
	public Session getSession() {
		return this.session ;
	}
	public void creerVueListeCR(String matricule, String mois, String annee){
		System.out.println("VueGsb::creerVueListeCR()") ;
		this.vueListeCR  = new VueListeCR(this, matricule, mois, annee);
		this.conteneur.add(this.vueListeCR, "ListeCR");
	}
}
