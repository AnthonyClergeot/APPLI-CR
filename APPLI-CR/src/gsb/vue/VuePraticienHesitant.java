package gsb.vue;

import gsb.controleur.ControleurListePraticienHesitant;
import gsb.modele.ModeleListePraticien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class VuePraticienHesitant extends JPanel{
	
	private ControleurListePraticienHesitant controleur ;
	private ModeleListePraticien modele = new ModeleListePraticien() ;
	private JTable tabPraticiens ;
	private VueGsb vueParente ;
	private JLabel jlTitre = new JLabel("Liste des praticiens hésitant");
	
	public VuePraticienHesitant(VueGsb vue) {
		super() ;
		System.out.println("VueListePraticienHesitant::VueListePraticienHesitant()") ;
		
		this.vueParente = vue ;
		this.controleur = new ControleurListePraticienHesitant(this) ;
		this.creerInterfaceUtilisateur() ;
	}

	public void creerInterfaceUtilisateur() {
		System.out.println("VueListePraticienHesitant::creerintefraceUtilisateiu()") ;
		Box boxPrincipale = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox();
		Box boxTableau = Box.createVerticalBox() ;
		this.jlTitre.setFont(new Font("SansSerif", Font.PLAIN, 18));
		boxEtiquette.add(this.jlTitre) ;
		
		this.tabPraticiens = new JTable(this.modele) ;
		this.tabPraticiens.setRowHeight(30) ;
		this.tabPraticiens.setAutoCreateRowSorter(true);
		this.tabPraticiens.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JScrollPane spPraticiens = new JScrollPane(this.tabPraticiens) ;
		spPraticiens.setPreferredSize(new Dimension(1090, 420)) ;
		boxTableau.add(spPraticiens) ;
		
		boxPrincipale.add(boxEtiquette) ;
		boxPrincipale.add(boxTableau) ;
		
		this.add(boxPrincipale) ;
	}
	
	public void trierPraticienHesitant(int indiceTri) {
		System.out.println("VueListePraticienHesitant::trierPraticienHesitant(int indiceTri)") ;
		System.out.println("IndiceTri : " + indiceTri);
		
		if(indiceTri == 1){
			
			this.modele.sortByCoeffConfiance();
			this.modele.actualiser();
			
			System.out.println("CoeffCOnfiance : " + this.modele.toString());
		} else if(indiceTri == 2) {
			
			this.modele.sortByCoeffNotoriete();
			this.modele.actualiser();

			System.out.println("CoeffNotoriete : " +this.modele.toString());
		} else if(indiceTri == 3){
			
			this.modele.sortByTempsDepuisDernièreVisite();
			this.modele.actualiser();

			System.out.println("tempsderniereVisite : " +this.modele.toString());

		}
		
	}
}
