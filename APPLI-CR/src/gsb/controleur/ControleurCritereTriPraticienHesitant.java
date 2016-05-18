package gsb.controleur;

import gsb.vue.VueCritereTriPraticienHesitant;
import gsb.vue.VuePraticienHesitant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ControleurCritereTriPraticienHesitant implements ActionListener{
	
	private VueCritereTriPraticienHesitant vue ;
	
	public ControleurCritereTriPraticienHesitant(VueCritereTriPraticienHesitant vue) {
		super() ;
		System.out.println("ControleurCritereTriPraticienHesitant::constructeur") ;
		
		this.vue = vue;
		this.enregistrerEcouteur() ;
	}

	public void enregistrerEcouteur() {
		System.out.println("ControleurCritereTriPraticienHesitant::enregistrerEcouteur()") ;
		
		this.vue.getBoutonAnnuler().addActionListener(this) ;
		this.vue.getBoutonValider().addActionListener(this) ;
		this.vue.getCbCoefConfiance().addActionListener(this) ;
		this.vue.getCbCoefNotoriete().addActionListener(this) ;
		this.vue.getCbTempsDepuisDerniereVisite().addActionListener(this) ;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("ControleurCritereTriPraticienHesitant::actionPerformed()") ;
		
		if(e.getSource() == this.vue.getBoutonAnnuler()) {
			this.vue.dispose() ;
		}
		
		if(e.getSource() == this.vue.getCbCoefConfiance()) {
			this.vue.getCbCoefNotoriete().setSelected(false) ;
			this.vue.getCbTempsDepuisDerniereVisite().setSelected(false) ;
		}
		if(e.getSource() == this.vue.getCbTempsDepuisDerniereVisite()) {
			this.vue.getCbCoefNotoriete().setSelected(false) ;
			this.vue.getCbCoefConfiance().setSelected(false) ;
		}
		if(e.getSource() == this.vue.getCbCoefNotoriete()) {
			this.vue.getCbCoefConfiance().setSelected(false) ;
			this.vue.getCbTempsDepuisDerniereVisite().setSelected(false) ;
		}
		
		if(e.getSource() == this.vue.getBoutonValider()) {
			int indiceTri = this.getIndiceTri();
			((VuePraticienHesitant) this.vue.getVueParente().getVuePraticienHesitant()).trierPraticienHesitant(indiceTri) ;
			this.vue.getVueParente().changerVue("VuePraticienHesitant");
			this.vue.dispose() ;
		}
	}
	
	private int getIndiceTri() {
		System.out.println("ControleurcritereTriPraticienHesitant::getIndiceTri") ;
		
		int indiceTri = 1 ;
		
		if(this.vue.getCbCoefNotoriete().isSelected()) {
			indiceTri = 2 ;
		}
		else if(this.vue.getCbTempsDepuisDerniereVisite().isSelected()) {
			indiceTri = 3;
		}
		return indiceTri ;
	}
}
