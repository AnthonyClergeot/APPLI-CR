package gsb;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VueChoisirDateCR extends JDialog implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private ControleurChoisirDateCR controleur ;
	
	private ModeleGsb modele = ModeleGsb.getModeleGsb() ;
	private VueGsb vueGsb ;
	
	private JComboBox<String> cbMois = new JComboBox<String>() ;
	private JComboBox<Integer> cbAnnees = new JComboBox<Integer>() ;
	private JButton bValider = new JButton("Valider") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	public VueChoisirDateCR(VueGsb vueGsb) {
		super(vueGsb,"Date des comptes-rendus",true);
		System.out.println("VueChoisirDateCR::VueChoisirDateCR()") ;
		this.vueGsb = vueGsb ;
		this.creerInterfaceUtilisateur() ;
		this.controleur = new ControleurChoisirDateCR(this, vueGsb) ;
		this.initialiser();
		this.setPreferredSize(new Dimension(250, 150)) ;
		this.pack();
		this.setLocationRelativeTo(vueGsb) ;
		this.setResizable(false) ;
		this.setVisible(true) ;
	}

	public JComboBox<String> getCbMois() {
		return cbMois;
	}

	public JComboBox<Integer> getCbAnnees() {
		return cbAnnees;
	}

	public JButton getbValider() {
		return bValider;
	}

	public JButton getbAnnuler() {
		return bAnnuler;
	}

	/** Créer l'interface utilisateur
	 * 
	 */
	private void creerInterfaceUtilisateur(){
		System.out.println("VueChoisirDateCR::creerInterfaceUtilisateur()") ;
		
		Container conteneur = this.getContentPane() ;
		
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxMois = Box.createHorizontalBox() ;
		Box boxAnnee = Box.createHorizontalBox() ;
		Box boxLigne = Box.createHorizontalBox() ;
		Box boxActions = Box.createHorizontalBox() ;
		
		boxMois.add(Box.createHorizontalStrut(5)) ;
		boxMois.add(new JLabel("Mois : ")) ;
		boxAnnee.add(Box.createHorizontalStrut(5)) ;
		boxAnnee.add(new JLabel("Année : ")) ;
		
		boxMois.add(Box.createHorizontalStrut(12)) ;
		boxMois.add(this.cbMois) ;
		boxMois.add(Box.createHorizontalStrut(5)) ;
		boxAnnee.add(this.cbAnnees) ;
		boxAnnee.add(Box.createHorizontalStrut(5)) ;
		
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		boxLigne.add(new JSeparator()) ;
		boxLigne.add(Box.createHorizontalStrut(5)) ;
		
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bValider) ;
		boxActions.add(Box.createHorizontalStrut(5)) ;
		boxActions.add(this.bAnnuler) ;
		boxActions.add(Box.createHorizontalStrut(5)) ;
		
		boxPrincipale.add(Box.createVerticalStrut(8)) ;
		boxPrincipale.add(boxMois) ;
		boxPrincipale.add(Box.createVerticalStrut(8)) ;
		boxPrincipale.add(boxAnnee) ;
		boxPrincipale.add(Box.createVerticalStrut(10)) ;
		boxPrincipale.add(boxLigne) ;
		boxPrincipale.add(Box.createVerticalStrut(10)) ;
		boxPrincipale.add(boxActions) ;
		boxPrincipale.add(Box.createVerticalStrut(5)) ;
		
		conteneur.add(boxPrincipale) ;
		
		Dimension dimensionBouton = this.bAnnuler.getPreferredSize() ;
		
		this.bValider.setPreferredSize(dimensionBouton) ;
		this.bValider.setMaximumSize(dimensionBouton) ;
		this.bValider.setMinimumSize(dimensionBouton) ;
		
	}
	
	
	/** Initialiser les champs (liste des clients, liste des véhicules et date de retour prévue
	 * 
	 */
	private void initialiser(){
		System.out.println("VueChoisirDateCR::initialiser()") ;
		int anneeCourante = new DateFR().getAnnee() ;
		
		List<String> mois = new ArrayList<String>() ;
		mois.add("01 - Janvier") ;
		mois.add("02 - Fevrier") ;
		mois.add("03 - Mars") ;
		mois.add("04 - Avril") ;
		mois.add("05 - Mai") ;
		mois.add("06 - Juin") ;
		mois.add("07 - Juillet") ;
		mois.add("08 - Août") ;
		mois.add("09 - Septembre") ;
		mois.add("10 - Octobre") ;
		mois.add("11 - Novembre") ;
		mois.add("12 - Décembre") ;
		for(int i = 0 ; i < mois.size() ; i++) {
			this.cbMois.addItem(mois.get(i)) ;
		}
		
		List<Integer> annees = new ArrayList<Integer>() ;
		for(int i = 1990 ; i <= anneeCourante ; i++) {
			annees.add(i) ;
		} 
		
		for(int i = 0 ; i < annees.size() ; i++) {
			this.cbAnnees.addItem(annees.get(i)) ;
		} 
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
