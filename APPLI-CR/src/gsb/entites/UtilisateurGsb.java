package gsb.entites;

/** Représenter un utilisateur
 *
 */
public class UtilisateurGsb {

	private String login ;
	private String mdp ;
	
	/** Constructeur
	 * @param login Le nom de connexion
	 * @param mdp Le mot de passe
	 */
	public UtilisateurGsb(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
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

	@Override
	public String toString() {
		return "Utilisateur [login=" + login + ", mdp=" + mdp + "]";
	}
	
}
