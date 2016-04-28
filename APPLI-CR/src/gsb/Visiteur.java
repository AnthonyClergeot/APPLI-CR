package gsb;

import java.sql.Date;

/** Représenter un délégué
 *
 */
public class Visiteur {
	private String matricule ;
	private String nom ;
	private String prenom ;
	private String adresse ;
	private String cp ;
	private String ville ;
	private Date dateEmbauche ;
	private String login ;
	private String mdp ;
	private String secCode ;
	private String labCode ;
	private String regCode ;
	
	public Visiteur(String matricule) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Visiteur(String matricule, String nom, String prenom) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Visiteur(String matricule, String nom, String prenom,
			String adresse, String cp, String ville) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}

	public Visiteur(String matricule, String nom, String prenom, String adresse, 
			String cp, String ville, Date dateEmbauche) {
		super();
		this.matricule = matricule ;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp ;
		this.ville = ville ;
		this.dateEmbauche = dateEmbauche ;
	}
	
	public Visiteur(String matricule, String nom, String prenom,
			String adresse, String cp, String ville, Date dateEmbauche,
			String login, String mdp, String secCode, String labCode, String regCode) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.dateEmbauche = dateEmbauche;
		this.login = login;
		this.mdp = mdp;
		this.secCode = secCode;
		this.labCode = labCode;
		this.regCode = regCode;
	}

	public String getMatricule() {
		return matricule;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getCp() {
		return cp;
	}

	public String getVille() {
		return ville;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getMdp() {
		return mdp;
	}

	public String getSecCode() {
		return secCode;
	}

	public String getLabCode() {
		return labCode;
	}
	
	public String getRegCode() {
		return this.regCode;
	}
	
	public Visiteur getVisiteur() {
		return this ;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}

	public void setLabCode(String labCode) {
		this.labCode = labCode;
	} 
	
	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	@Override
	public String toString() {
		return "Delegue [matricule=" + matricule + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville="
				+ ville + ", dateEmbauche=" + dateEmbauche + ", login=" + login
				+ ", mdp=" + mdp + ", secCode=" + secCode + ", labCode="
				+ labCode + ", regCode=" + regCode + "]";
	}

	
}
