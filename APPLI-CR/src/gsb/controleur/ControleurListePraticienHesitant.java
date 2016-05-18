package gsb.controleur;

import gsb.vue.VuePraticienHesitant;

public class ControleurListePraticienHesitant {
	private VuePraticienHesitant vue;
	//private ModeleListePraticien modele = ModeleListePraticien.getModel() ;
	
	
	public ControleurListePraticienHesitant(VuePraticienHesitant vue) {
		super() ;
		System.out.println("ControleurPraticienHesitant::ControleurPraticienHesitant(VueListePraticienHesitant)") ;
		
		this.vue = vue ;
	}
	
}
