package gsb.entites;

import java.sql.Date ;

/** Représenter un compte-rendu
*
*/
public class CompteRendu {
	
	private String visMatricule ;
	private int rapNum ;
	private int praNum ;
	private String rapBilan ;
	private Date rapDateRedaction ;
	private Date rapDateVisite ;
	private int motifCode ;
	private int coefCode ;
	private boolean estConsulte ;
	
	public CompteRendu(String visMatricule, int rapNum, int praNum,
			String rapBilan, Date rapDateRedaction, Date rapDateVisite,
			int motifCode, int coefCode, boolean estConsulte) {
		super();
		this.visMatricule = visMatricule;
		this.rapNum = rapNum;
		this.praNum = praNum;
		this.rapBilan = rapBilan;
		this.rapDateRedaction = rapDateRedaction;
		this.rapDateVisite = rapDateVisite;
		this.motifCode = motifCode;
		this.coefCode = coefCode;
		this.estConsulte = estConsulte;
	}

	public String getVisMatricule() {
		return visMatricule;
	}

	public int getRapNum() {
		return rapNum;
	}

	public int getPraNum() {
		return praNum;
	}

	public String getRapBilan() {
		return rapBilan;
	}

	public Date getRapDateRedaction() {
		return rapDateRedaction;
	}

	public Date getRapDateVisite() {
		return rapDateVisite;
	}

	public int getMotifCode() {
		return motifCode;
	}

	public int getCoefCode() {
		return coefCode;
	}

	public boolean isEstConsulte() {
		return estConsulte;
	}

	public void setVisMatricule(String visMatricule) {
		this.visMatricule = visMatricule;
	}

	public void setRapNum(int rapNum) {
		this.rapNum = rapNum;
	}

	public void setPraNum(int praNum) {
		this.praNum = praNum;
	}

	public void setRapBilan(String rapBilan) {
		this.rapBilan = rapBilan;
	}

	public void setRapDateRedaction(Date rapDateRedaction) {
		this.rapDateRedaction = rapDateRedaction;
	}

	public void setRapDateVisite(Date rapDateVisite) {
		this.rapDateVisite = rapDateVisite;
	}

	public void setMotifCode(int motifCode) {
		this.motifCode = motifCode;
	}

	public void setCoefCode(int coefCode) {
		this.coefCode = coefCode;
	}

	public void setEstConsulte(boolean estConsulte) {
		this.estConsulte = estConsulte;
	}
	

}
