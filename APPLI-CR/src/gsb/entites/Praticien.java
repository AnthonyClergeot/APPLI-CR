package gsb.entites;

public class Praticien {
	private int numero ;
	private String nom ;
	private String prenom ;
	private String adresse ;
	private String codePostal ;
	private String ville ;
	private Float coefNotoriete ;
	private String codeType ;
	private String dateDerniereVisite;
	private int coefConfiance;
	
	public Praticien(int numero, String nom, String prenom, String adresse, String codePostal, String ville, Float coefNotoriete, String codeType, String dateDerniereVisite, int coefConfiance) {
		super() ;
		System.out.println("Praticien::Praticien(int,String,String,String,String,String,Float,String)") ;
		this.numero = numero ;
		this.nom = nom ;
		this.prenom = prenom ;
		this.adresse = adresse ;
		this.codePostal = codePostal ;
		this.ville = ville ;
		this.coefNotoriete = coefNotoriete ;
		this.codeType = codeType ;
		this.dateDerniereVisite = dateDerniereVisite ;
		this.coefConfiance = coefConfiance ;
	}
	
	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getDateDerniereVisite() {
		return dateDerniereVisite;
	}

	public void setDateDerniereVisite(String dateDerniereVisite) {
		this.dateDerniereVisite = dateDerniereVisite;
	}

	public int getCoefConfiance() {
		return coefConfiance;
	}

	public void setCoefConfiance(int coefConfiance) {
		this.coefConfiance = coefConfiance;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Float getCoefNotoriete() {
		return coefNotoriete;
	}
	public void setCoefNotoriete(Float coefNotoriete) {
		this.coefNotoriete = coefNotoriete;
	}
	
	

}
