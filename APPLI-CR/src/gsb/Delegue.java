package gsb;

import java.sql.Date;

public class Delegue extends Visiteur {
	
	public Delegue(String matricule) {
		super(matricule);
	}
	
	public Delegue(String matricule, String nom, String prenom) {
		super(matricule, nom, prenom);
	}

	public Delegue(String matricule, String nom, String prenom, String adresse,
			String cp, String ville, Date dateEmbauche, String login,
			String mdp, String secCode, String labCode, String regCode) {
		super(matricule, nom, prenom, adresse, cp, ville, dateEmbauche, login, mdp,
				secCode, labCode, regCode);
	}
	
	@Override
	public String toString() {
		return "Delegue [getMatricule()=" + getMatricule() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getAdresse()="
				+ getAdresse() + ", getCp()=" + getCp() + ", getVille()="
				+ getVille() + ", getDateEmbauche()=" + getDateEmbauche()
				+ ", getLogin()=" + getLogin() + ", getMdp()=" + getMdp()
				+ ", getSecCode()=" + getSecCode() + ", getLabCode()="
				+ getLabCode() + ", getRegCode()=" + getRegCode()
				+ ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
