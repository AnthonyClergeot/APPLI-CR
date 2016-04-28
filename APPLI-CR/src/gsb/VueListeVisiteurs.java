package gsb;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class VueListeVisiteurs extends JPanel {
	
private static final long serialVersionUID = 1L ;
	
	private VueGsb vueGsb ;
	private ModeleListeVisiteurs modeleTabVisiteurs = new ModeleListeVisiteurs() ;
	private JTable tabVisiteurs ;
	private JLabel ListeVisiteurs = new JLabel("Liste des visiteurs") ;
	private RenduCelluleListeVisiteurs RenduCelluleListeVisiteurs = new RenduCelluleListeVisiteurs() ;
	private RenduBoutonConsulter RenduBoutonConsulter = new RenduBoutonConsulter() ;
	private EditeurBoutonConsulterCR EditeurBoutonConsulterCR = new EditeurBoutonConsulterCR(this, vueGsb) ;
	
	/** Constructeur
	 * 
	 */
	public VueListeVisiteurs(VueGsb vueGsb){
		super() ;
		System.out.println("VueListeVisiteurs::VueListeVisiteurs()") ;
		this.vueGsb = vueGsb ;
		this.creerInterfaceUtilisateur() ;
		this.appliquerRendu() ;
		this.appliquerEditeur() ;
	}
	
	/** Agencer les composants graphiques
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueListeVisiteurs::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		
		this.tabVisiteurs = new JTable(this.modeleTabVisiteurs) ;
		this.tabVisiteurs.setRowHeight(30) ;
		JScrollPane spVisiteurs = new JScrollPane(this.tabVisiteurs) ;
		spVisiteurs.setPreferredSize(new Dimension(900 , 350)) ;
		
		boxTableau.add(spVisiteurs) ;
		boxEtiquette.add(ListeVisiteurs) ;
		boxPrincipale.add(boxEtiquette) ;
		boxPrincipale.add(boxTableau) ;
		
		this.add(boxPrincipale) ;
	}
	
	public JTable getTabClients() {
		return tabVisiteurs;
	}

	public ModeleListeVisiteurs getModeleTabClients() {
		return modeleTabVisiteurs;
	}
	
	public VueGsb getVueGsb() {
		return vueGsb;
	}

	public void appliquerRendu() {
		this.tabVisiteurs.setDefaultRenderer(Object.class, RenduCelluleListeVisiteurs) ;
		if(tabVisiteurs.getColumnClass(4) == JButton.class) {
			this.tabVisiteurs.setDefaultRenderer(JButton.class, RenduBoutonConsulter) ;
		}
	}
	
	public void appliquerEditeur() {
		this.tabVisiteurs.setDefaultEditor(Object.class, EditeurBoutonConsulterCR) ;
	}

}
