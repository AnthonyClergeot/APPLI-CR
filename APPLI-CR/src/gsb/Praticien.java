package gsb;

/** Représenter un Praticien
*
*/
public class Praticien {
	
	private int praNum ;
	private String praNom ;
	private String praPrenom ;
	private String praAdresse ;
	private String praCP ;
	private String praVille ;
	private float praCoefNotoriete ;
	private String typCode ;
	
	public Praticien(int praNum, String praNom, String praPrenom,
			String praAdresse, String praCP, String praVille,
			float praCoefNotoriete, String typCode) {
		super();
		this.praNum = praNum;
		this.praNom = praNom;
		this.praPrenom = praPrenom;
		this.praAdresse = praAdresse;
		this.praCP = praCP;
		this.praVille = praVille;
		this.praCoefNotoriete = praCoefNotoriete;
		this.typCode = typCode;
	}

	public int getPraNum() {
		return praNum;
	}

	public String getPraNom() {
		return praNom;
	}

	public String getPraPrenom() {
		return praPrenom;
	}

	public String getPraAdresse() {
		return praAdresse;
	}

	public String getPraCP() {
		return praCP;
	}

	public String getPraVille() {
		return praVille;
	}

	public float getPraCoefNotoriete() {
		return praCoefNotoriete;
	}

	public String getTypCOde() {
		return typCode;
	}

	public void setPraNum(int praNum) {
		this.praNum = praNum;
	}

	public void setPraNom(String praNom) {
		this.praNom = praNom;
	}

	public void setPraPrenom(String praPrenom) {
		this.praPrenom = praPrenom;
	}

	public void setPraAdresse(String praAdresse) {
		this.praAdresse = praAdresse;
	}

	public void setPraCP(String praCP) {
		this.praCP = praCP;
	}

	public void setPraVille(String praVille) {
		this.praVille = praVille;
	}

	public void setPraCoefNotoriete(float praCoefNotoriete) {
		this.praCoefNotoriete = praCoefNotoriete;
	}

	public void setTypCOde(String typCOde) {
		this.typCode = typCOde;
	}
	
}
