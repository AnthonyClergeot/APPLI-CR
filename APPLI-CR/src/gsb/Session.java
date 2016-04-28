package gsb;

import java.sql.Date;

public class Session {
	
	private static Session session = null ;
	
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
	
	private Session(String matricule, String nom, String prenom,
			String adresse, String cp, String ville, Date dateEmbauche,
			String login, String mdp, String secCode, String labCode, String regCode) {
		super();
		System.out.println("Session::Session()") ;
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
		
		Session.session = this ;
	}
	
	public static void ouvrirSession(String matricule, String nom, String prenom,
			String adresse, String cp, String ville, Date dateEmbauche,
			String login, String mdp, String secCode, String labCode, String regCode) {
		System.out.println("Session::ouvrirSession()") ;
		
		if(session == null) {
			new Session(matricule, nom, prenom, adresse, cp, ville, dateEmbauche,
					login, mdp, secCode, labCode, regCode) ;
			
		}
	}
	
	public static void fermerSession() {
		session = null ;
	}

	public static Session getSession() {
		return session;
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
		return regCode;
	}

	@Override
	public String toString() {
		return "Session [matricule=" + matricule + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville="
				+ ville + ", dateEmbauche=" + dateEmbauche + ", login=" + login
				+ ", mdp=" + mdp + ", secCode=" + secCode + ", labCode="
				+ labCode + ", regCode=" + regCode + "]";
	}
	
}
