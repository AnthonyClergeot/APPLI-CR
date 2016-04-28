package gsb;

import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueAccueilGsb extends JPanel {
	
	JLabel accueil = new JLabel("Accueil GSB") ;
	
	public VueAccueilGsb() {
		super();
		System.out.println("VueAccueilGsb::VueAccueilGsb()") ;
		this.creerInterfaceUtilisateur() ;
	}
	
	private void creerInterfaceUtilisateur() {
		System.out.println("VueAccueilGsb::creerInterfaceUtilisateur()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		
		boxEtiquette.add(accueil) ;
		boxPrincipale.add(boxEtiquette) ;
		
		this.add(boxPrincipale) ;
		this.setVisible(true) ;
		
	}

}