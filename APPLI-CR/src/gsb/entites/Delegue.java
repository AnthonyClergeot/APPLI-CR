package gsb.entites;

public class Delegue {
	
	private String matricule ;
	private String nom ;
	private String prenom ;
	private String login ;
	private String mdp ;
	private String regionCode ;
	
	public Delegue(String matricule, String nom, String prenom, String login, String mdp, String regionCode) {
		super() ;
		System.out.println("Delegue::Delegue()") ;
		
		this.matricule = matricule ;
		this.nom = nom ;
		this.prenom = prenom ;
		this.login = login ;
		this.mdp = mdp ;
		this.regionCode = regionCode ;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	@Override
	public String toString() {
		return "Delegue [matricule=" + matricule + ", nom=" + nom + ", prenom="
				+ prenom + ", login=" + login + ", mdp=" + mdp
				+ ", regionCode=" + regionCode + "]";
	}
	
	
	
}
