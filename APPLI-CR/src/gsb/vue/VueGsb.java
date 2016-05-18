package gsb.vue;

import gsb.controleur.ControleurGsb;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VueGsb extends JFrame {
	
	private ControleurGsb controleurGsb ;
	
	JMenuBar barreMenus = new JMenuBar() ;
	private JMenu menuFichier = new JMenu("Fichier") ;
	private JMenu menuConsulter = new JMenu("Consulter") ;
	private JMenu menuAide = new JMenu("Aide") ;
	
	private JMenuItem itemAccueil = new JMenuItem("Accueil") ;
	private JMenuItem itemConnecter  = new JMenuItem("Se connecter") ;
	private JMenuItem itemDeconnecter  = new JMenuItem("Se déconnecter") ;
	private JMenuItem itemQuitter = new JMenuItem("Quitter") ;
	private JMenuItem itemListeVisiteur= new JMenuItem("Liste des visiteurs") ;
	private JMenuItem itemListePraticienHesitant= new JMenuItem("Liste des praticiens hésitants") ;
	private JMenuItem itemAide= new JMenuItem("Aide") ;
	private JMenuItem itemAPropos= new JMenuItem("A propos") ;
	
	private CardLayout clPanneaux ;
	private Container conteneur ;
	
	private VueAccueilGsb Accueil = new VueAccueilGsb() ;
	private JPanel vuePraticienHesitant = new VuePraticienHesitant(this) ; ;
//	private VueListeVisiteurs ListeVisiteurs = new VueListeVisiteurs(this) ;
//	private VueListeCR ListeCR = new VueListeCR() ;
	
	public VueGsb() {
		super();
		System.out.println("VuePrincipale::VuePrincipale()") ;
		
		this.setTitle("APPLI-CR") ;
		this.setSize(1300,600) ; 
		this.setLocationRelativeTo(null) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		
		this.creerBarreMenus() ;
		this.setMenusDeconnecte();
		this.setVisible(true) ;
		
		this.controleurGsb = new ControleurGsb(this) ;
		
		clPanneaux = new CardLayout(5 , 5) ;
		conteneur = this.getContentPane() ;
		conteneur.setLayout(clPanneaux) ;
		
		conteneur.add(Accueil, "Accueil") ;
		conteneur.add(vuePraticienHesitant, "VuePraticienHesitant") ;
//		conteneur.add(ListeVisiteurs, "ListeVisiteurs") ;
//		conteneur.add(ListeCR, "ListeCR") ;
		
		clPanneaux.show(conteneur, "Accueil") ;
		
	}
	
	public ControleurGsb getControleurGsb() {
		return this.controleurGsb ;
	}

	public JMenuItem getItemAccueil() {
		return itemAccueil;
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

	public JMenuItem getItemListeVisiteur() {
		return itemListeVisiteur;
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
	
	public Container getConteneur() {
		return conteneur;
	}

	public CardLayout getClPanneaux() {
		return clPanneaux;
	}
	
	public VueGsb getVueGsb() {
		return this ;
	}

	public void setConteneur(Container conteneur) {
		this.conteneur = conteneur;
	}

	public void changerVue(String panel) {
		System.out.println("VuePrincipale::changerVue()") ;
		clPanneaux.show(conteneur, panel) ;
	}
	
	public JPanel getVuePraticienHesitant() {
		return vuePraticienHesitant;
	}

	public void setVuePraticienHesitant(JPanel vuePraticienHesitant) {
		this.vuePraticienHesitant = vuePraticienHesitant;
	}
	
	public void setMenusConnecte(){
		System.out.println("VuePrincipale::setMenusConnecte()") ;
		
		this.itemAccueil.setEnabled(true) ;
		this.itemDeconnecter.setEnabled(true) ;
		this.itemConnecter.setEnabled(false) ;
		this.menuConsulter.setEnabled(true) ;
		this.itemListeVisiteur.setEnabled(true) ;
		this.itemListePraticienHesitant.setEnabled(true) ;
	}
	
	public void setMenusDeconnecte(){
		System.out.println("VuePrincipale::setMenusDeconnecte()") ;
		
		this.itemAccueil.setEnabled(true) ;
		this.itemDeconnecter.setEnabled(false) ;
		this.itemConnecter.setEnabled(true) ;
		this.menuConsulter.setEnabled(false) ;
		this.itemListeVisiteur.setEnabled(false) ;
		this.itemListePraticienHesitant.setEnabled(false) ;
	}
	
	private void creerBarreMenus(){
		System.out.println("VuePrincipale::creerBarreMenus()") ;
		
		menuFichier.add(this.itemAccueil) ;
		menuFichier.addSeparator() ;
		menuFichier.add(this.itemConnecter) ;
		menuFichier.add(this.itemDeconnecter) ;
		menuFichier.addSeparator() ;
		menuFichier.add(this.itemQuitter) ;
		
		menuConsulter.add(this.itemListeVisiteur) ;
		menuConsulter.add(this.itemListePraticienHesitant) ;
		
		menuAide.add(this.itemAide) ;
		menuAide.add(this.itemAPropos) ;
		
		barreMenus.add(menuFichier) ;
		barreMenus.add(menuConsulter) ;
		barreMenus.add(menuAide) ;
		
		this.setJMenuBar(barreMenus) ;
		
	}
	
}
