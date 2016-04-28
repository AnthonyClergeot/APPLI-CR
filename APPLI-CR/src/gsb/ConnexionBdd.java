package gsb;

import java.sql.* ;

import javax.swing.JOptionPane;

public class ConnexionBdd {
	
	private static String driver = "com.mysql.jdbc.Driver" ;
	private static final String url = "jdbc:mysql://localhost:3306/GsbCRSlamV2015" ;
	private static final String user = "root" ;
	private static final String mdp = "mysql" ;
	
	private static java.sql.Connection connexionBdd = null ;
	
	private ConnexionBdd() {
		System.out.println("ConnexionBdd::connexionBdd()") ;
		
		try {
			Class.forName(driver).newInstance() ;
			
			ConnexionBdd.connexionBdd = DriverManager.getConnection(url, user, mdp) ;
			
		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage()) ;
		
			e.printStackTrace();
		}
	}
	
	public static java.sql.Connection getConnexionBdd() {
		System.out.println("ConnexionBdd::getConnexionBdd()") ;
		
		if(ConnexionBdd.connexionBdd == null) {
			new ConnexionBdd() ;
		}
		
		return ConnexionBdd.connexionBdd ;
	}

}
