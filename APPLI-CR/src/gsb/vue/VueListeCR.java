package gsb.vue;

import gsb.EditeurBoutonAfficherCR;
import gsb.RenduBoutonAfficher;
import gsb.RenduCelluleListeCR;
import gsb.controleur.ControleurBoutonAfficherCR;
import gsb.modele.ModeleListeCR;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VueListeCR extends JPanel {
	
	private static final long serialVersionUID = 1L ;
	
	private ModeleListeCR modeleTabCR = new ModeleListeCR() ;
	private JTable tabCR ;
	private JLabel ListeCR = new JLabel("Liste des comptes-rendus") ;
	private RenduCelluleListeCR RenduCelluleListeCR = new RenduCelluleListeCR() ;
	private RenduBoutonAfficher RenduBoutonAfficher = new RenduBoutonAfficher() ;
	private EditeurBoutonAfficherCR EditeurBoutonAfficherCR ;
	private String vis_matricule;
	private String mois;
	private String annee;
	private ControleurBoutonAfficherCR controleur;
	/** Constructeur
	 * 
	 */
	public VueListeCR(VueGsb vue, String matricule, String mois, String annee){
		super() ;
		System.out.println("VueListeCR::VueListeCR()") ;
		this.vis_matricule = matricule;
		this.mois = mois;
		this.annee = annee;
		EditeurBoutonAfficherCR = new EditeurBoutonAfficherCR(this);
		this.creerInterfaceUtilisateur() ;
		this.appliquerRendu() ;
		this.appliquerEditeur() ;
		this.controleur = new ControleurBoutonAfficherCR(EditeurBoutonAfficherCR);
	}
	
	public void setModeleTabCR(ModeleListeCR modeleTabCR) {
		this.modeleTabCR = modeleTabCR;
	}

	public String getVis_matricule() {
		return vis_matricule;
	}

	public void setVis_matricule(String vis_matricule) {
		this.vis_matricule = vis_matricule;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	/** Agencer les composants graphiques
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueListeCR::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		this.modeleTabCR.getComptesRendus(this.vis_matricule, this.mois, this.annee);
		this.tabCR = new JTable(this.modeleTabCR) ;
		this.tabCR.setRowHeight(30) ;
		
		JScrollPane spClients = new JScrollPane(this.tabCR) ;
		spClients.setPreferredSize(new Dimension(900 , 350)) ;
		
		boxTableau.add(spClients) ;
		boxEtiquette.add(ListeCR) ;
		boxPrincipale.add(boxEtiquette) ;
		boxPrincipale.add(boxTableau) ;
		
		this.add(boxPrincipale) ;
		
	}

	public ModeleListeCR getModeleTabCR() {
		return modeleTabCR;
	}

	public JTable getTabCR() {
		return tabCR;
	}
	
	public void appliquerRendu() {
		this.tabCR.setDefaultRenderer(Object.class, RenduCelluleListeCR) ;
		if(tabCR.getColumnClass(5) == JButton.class) {
			this.tabCR.setDefaultRenderer(JButton.class, RenduBoutonAfficher) ;
		}
	}
	
	public void appliquerEditeur() {
		this.tabCR.setDefaultEditor(Object.class, EditeurBoutonAfficherCR) ;
	}

}
