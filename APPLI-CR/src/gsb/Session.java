package gsb;

public class Session {
	private static Session session = null ;
	private String login ;
	private String regionCode;
	
	private Session(String login, String regionCode){
		super() ;
		System.out.println("Session::Session(String)") ;
		this.regionCode = regionCode;
		this.login = login ;
		this.session = this ;
	}
	
	public static void ouvrirSession(String login, String regionCode) {
		if(session == null) {
			
				new Session(login, regionCode) ;
		}
	}
	
	public static void fermerSession() {
		if (session != null) {
			session = null ;
			
		}
	}
	
	public String getLogin() {
		return this.login ;
	}
	
	public static Session getSession() {
		
		
		return session ;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
}
