package gsb.techniques;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDGsb {
	
	private String dbUrl = "jdbc:mysql://localhost/GsbCRSlamV2015" ;
	private String user = "root" ;
	private String password = "mysql" ;
	
	private static Connection connexion = null ;
	
	private ConnexionBDGsb() {
		super() ;
		
		System.out.println("ConnexionBDGsb::ConnexionBDGsb()") ;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance() ;
			ConnexionBDGsb.connexion = DriverManager.getConnection(this.dbUrl, this.user, this.password) ;
		} catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnexion() {
		System.out.println("ConnexionBDGsb::getConnexion()") ;
		
		if(ConnexionBDGsb.connexion == null) {
			new ConnexionBDGsb() ;
		}
		return ConnexionBDGsb.connexion ;
	}
}
