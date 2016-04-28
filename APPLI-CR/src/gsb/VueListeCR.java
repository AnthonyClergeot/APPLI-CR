package gsb;

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
	private EditeurBoutonAfficherCR EditeurBoutonAfficherCR = new EditeurBoutonAfficherCR(this) ;
	
	/** Constructeur
	 * 
	 */
	public VueListeCR(){
		super() ;
		System.out.println("VueListeCR::VueListeCR()") ;
		this.creerInterfaceUtilisateur() ;
		this.appliquerRendu() ;
		this.appliquerEditeur() ;
	}
	
	/** Agencer les composants graphiques
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueListeCR::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
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
