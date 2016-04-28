package gsb;

import java.sql.* ;
import java.sql.PreparedStatement;

import javax.swing.* ;

import com.mysql.jdbc.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.* ;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeleGsb {
	
	private static ModeleGsb modele = null ;
	private static java.sql.Connection connexionBdd = null ;
	private java.sql.Statement stmt;
	private PreparedStatement pstmt ;
	private ResultSet resultat;
	
	private ModeleGsb() {
		super() ;
		System.out.println("ModeleGsb::ModeleGsb()") ;
	}
	
	public static ModeleGsb getModeleGsb() {
		System.out.println("ModeleGsb::getModeleGsb()") ;
		if(modele == null) {
			modele = new ModeleGsb() ;
		}
		
		return modele ;
	}
	
	public List<Visiteur> getVisiteursRegion(String region) throws SQLException {
		System.out.println("ModeleGsb::getVisiteursRegion()") ;
		
		List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>() ;
		
		try {
			connexionBdd = ConnexionBdd.getConnexionBdd() ;
			stmt = connexionBdd.createStatement() ;
			
			String requete = "SELECT VISITEUR.VIS_MATRICULE, VIS_NOM, VIS_PRENOM, VIS_ADRESSE, VIS_CP, VIS_VILLE, "
					+ "VIS_DATEEMBAUCHE, VIS_LOGIN, VIS_MDP, SEC_CODE, LAB_CODE, REG_CODE "
					+ "FROM VISITEUR INNER JOIN TRAVAILLER "
					+ "ON VISITEUR.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE "
					+ "WHERE JJMMAA = (SELECT MAX(JJMMAA) "
						+ "FROM TRAVAILLER AS t "
						+ "WHERE t.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE) "
					+ "AND TRA_ROLE = 'Visiteur' "
					+ "AND REG_CODE = ? " ;
			
			pstmt = (PreparedStatement) connexionBdd.prepareStatement(requete) ;
			pstmt.setString(1, region) ;
			resultat = pstmt.executeQuery() ;
			
			while(resultat.next()) {
				String matricule = resultat.getString("VIS_MATRICULE") ; ;
				String nom = resultat.getString("VIS_NOM") ;
				String prenom = resultat.getString("VIS_PRENOM") ;
				String adresse = resultat.getString("VIS_ADRESSE") ;
				String cp = resultat.getString("VIS_CP") ;
				String ville = resultat.getString("VIS_VILLE") ;
				Date dateEmbauche = resultat.getDate("VIS_DATEEMBAUCHE") ;
				String login = resultat.getString("VIS_LOGIN") ;
				String mdp = resultat.getString("VIS_MDP") ;
				String secCode = resultat.getString("SEC_CODE") ;
				String labCode = resultat.getString("LAB_CODE") ;
				String regCode = resultat.getString("REG_CODE") ;
//				System.out.println(matricule + " - " + nom + " " + prenom + " " + adresse + " " + cp
//						+ " " + ville + " " + dateEmbauche + " " + login + " " + mdp
//						+ " " + secCode + " " + labCode + " " + regCode) ;
				
				lesVisiteurs.add(new Visiteur(matricule, nom, prenom, adresse, cp, ville, 
						dateEmbauche, login, mdp, secCode, labCode, regCode)) ;
				
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage()) ;
			
			e.printStackTrace();
		}
		finally {
			stmt.close() ;
			resultat.close() ;
		}
		
		return lesVisiteurs ;
	}
	
	public List<Delegue> getDelegues() throws SQLException {
		System.out.println("ModeleGsb::getDelegues()") ;
		
		List<Delegue> lesDelegues = new ArrayList<Delegue>() ;
		
		try {
			connexionBdd = ConnexionBdd.getConnexionBdd() ;
			stmt = connexionBdd.createStatement() ;
			
			String requete = "SELECT VISITEUR.VIS_MATRICULE, VIS_NOM, VIS_PRENOM, VIS_ADRESSE, VIS_CP, VIS_VILLE, "
					+ "VIS_DATEEMBAUCHE, VIS_LOGIN, VIS_MDP, SEC_CODE, LAB_CODE, REG_CODE "
					+ "FROM VISITEUR INNER JOIN TRAVAILLER "
					+ "ON VISITEUR.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE "
					+ "WHERE JJMMAA = (SELECT MAX(JJMMAA) "
						+ "FROM TRAVAILLER AS t "
						+ "WHERE t.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE)"
					+ "AND TRA_ROLE = 'Délégué'" ;
					
			
			resultat = stmt.executeQuery(requete) ;
			
			while(resultat.next()) {
				String matricule = resultat.getString("VIS_MATRICULE") ; ;
				String nom = resultat.getString("VIS_NOM") ;
				String prenom = resultat.getString("VIS_PRENOM") ;
				String adresse = resultat.getString("VIS_ADRESSE") ;
				String cp = resultat.getString("VIS_CP") ;
				String ville = resultat.getString("VIS_VILLE") ;
				Date dateEmbauche = resultat.getDate("VIS_DATEEMBAUCHE") ;
				String login = resultat.getString("VIS_LOGIN") ;
				String mdp = resultat.getString("VIS_MDP") ;
				String secCode = resultat.getString("SEC_CODE") ;
				String labCode = resultat.getString("LAB_CODE") ;
				String regCode = resultat.getString("REG_CODE") ;
//				System.out.println(matricule + " - " + nom + " " + prenom + " " + adresse + " " + cp
//						+ " " + ville + " " + dateEmbauche + " " + login + " " + mdp
//						+ " " + secCode + " " + labCode + " " + regCode) ;
				
				lesDelegues.add(new Delegue(matricule, nom, prenom, adresse, cp, ville, 
						dateEmbauche, login, mdp, secCode, labCode, regCode)) ;
				
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage()) ;
			
			e.printStackTrace();
		}
		finally {
			stmt.close() ;
			resultat.close() ;
		}
		return lesDelegues;
		
	}
	
	public Delegue getUtilisateur(String login, String mdp) throws SQLException {
		System.out.println("ModeleGsb::getUtilisateur()") ;
		Delegue utilisateur = null ;
		
		try {
			int i = 0 ;
			while(i < this.getDelegues().size() && utilisateur == null){
				if( this.getDelegues().get(i).getLogin().equals(login) &&
						this.getDelegues().get(i).getMdp().equals(mdp)){
					utilisateur = this.getDelegues().get(i) ;
				}
				else {
					i = i + 1 ;
				}
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage()) ;
			
			e.printStackTrace();
		}
		return utilisateur ;
	}
	
	public String getNomLabo(String regCode) throws SQLException {
		System.out.println("ModeleGsb::getNomLabo()") ;
		
		String nomLabo = null ;
		
		try {
			connexionBdd = ConnexionBdd.getConnexionBdd() ;
			stmt = connexionBdd.createStatement() ;
			
			String requete = "SELECT LAB_NOM "
					+ "FROM LABORATOIRE "
					+ "WHERE LAB_CODE = ? " ;
			
			pstmt = (PreparedStatement) connexionBdd.prepareStatement(requete) ;
			pstmt.setString(1, regCode) ;
			resultat = pstmt.executeQuery() ;
				
			if(resultat.next()) {
				nomLabo = resultat.getString("LAB_NOM") ;
			}
			
		}
		
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage()) ;
			
			e.printStackTrace();
		}
		finally {
			stmt.close() ;
			resultat.close() ;
		}
		return nomLabo;
	}
	
	public List<CompteRendu> getComptesRendusVisiteurs(String visMatricule) throws SQLException {
		System.out.println("ModeleGsb::getComptesRendusVisiteurs()") ;
		
		List<CompteRendu> lesComptesRendus = new ArrayList<CompteRendu>() ;
		
		try {
			connexionBdd = ConnexionBdd.getConnexionBdd() ;
			stmt = connexionBdd.createStatement() ;
			
			String requete = "SELECT VIS_MATRICULE, RAP_NUM, PRA_NUM, RAP_BILAN, RAP_DATE_REDACTION, "
					+ "RAP_DATE_VISITE, MOT_CODE, COEF_CODE, EST_CONSULTE "
					+ "FROM RAPPORT_VISITE "
					+ "WHERE VIS_MATRICULE = ? " ;
			
			pstmt = (PreparedStatement) connexionBdd.prepareStatement(requete) ;
			pstmt.setString(1, visMatricule) ;
			resultat = pstmt.executeQuery() ;
			
			while(resultat.next()) {
				String matricule  = resultat.getString("VIS_MATRICULE") ; ;
				int rapNum = resultat.getInt("RAP_NUM") ;
				int praNum = resultat.getInt("PRA_NUM") ;
				String rapBilan = resultat.getString("RAP_BILAN") ;
				Date rapDateRedaction = resultat.getDate("RAP_DATE_REDACTION") ;
				Date rapDateVisite = resultat.getDate("RAP_DATE_VISITE") ;
				int motifCode = resultat.getInt("MOT_CODE") ;
				int coefCode = resultat.getInt("COEF_CODE") ;
				boolean estConsulte = resultat.getBoolean("EST_CONSULTE") ;
				
				lesComptesRendus.add(new CompteRendu(matricule, rapNum, praNum, rapBilan, rapDateRedaction, rapDateVisite, 
						motifCode, coefCode, estConsulte)) ;
				
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage()) ;
			
			e.printStackTrace();
		}
		finally {
			stmt.close() ;
			resultat.close() ;
		}
		
		return lesComptesRendus ;
	}
	
	public List<Praticien> getPraticiens() throws SQLException {
		System.out.println("ModeleGsb::getPraticiens()") ;
		
		List<Praticien> lesPraticiens = new ArrayList<Praticien>() ;
		
		try {
			connexionBdd = ConnexionBdd.getConnexionBdd() ;
			stmt = connexionBdd.createStatement() ;
			
			String requete = "SELECT PRA_NUM, PRA_NOM, PRA_PRENOM, PRA_ADRESSE, PRA_CP, PRA_VILLE, "
					+ "PRA_COEFNOTORIETE, TYP_CODE "
					+ "FROM PRATICIEN " ;
			
			resultat = stmt.executeQuery(requete) ;
			
			while(resultat.next()) {
				int praNum = resultat.getInt("PRA_NUM") ; ;
				String praNom = resultat.getString("PRA_NOM") ;
				String praPrenom = resultat.getString("PRA_PRENOM") ;
				String praAdresse = resultat.getString("PRA_ADRESSE") ;
				String praCP = resultat.getString("PRA_CP") ;
				String praVille = resultat.getString("PRA_VILLE") ;
				float praCoefNotoriete = resultat.getFloat("PRA_COEFNOTORIETE") ;
				String typCode = resultat.getString("TYP_CODE") ;
				
				lesPraticiens.add(new Praticien(praNum, praNom, praPrenom, praAdresse, praCP, praVille, 
						praCoefNotoriete, typCode)) ;
				
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage()) ;
			
			e.printStackTrace();
		}
		finally {
			stmt.close() ;
			resultat.close() ;
		}
		return lesPraticiens;
		
	}
	
	public String getNomPraticien(int praNum) throws SQLException {
		System.out.println("ModeleGsb::getNomPraticien()") ;
		
		String nomPraticien = null ;
		
		try {
			connexionBdd = ConnexionBdd.getConnexionBdd() ;
			stmt = connexionBdd.createStatement() ;
			
			String requete = "SELECT PRA_NOM "
					+ "FROM PRATICIEN "
					+ "WHERE PRA_NUM = ? " ;
			
			pstmt = (PreparedStatement) connexionBdd.prepareStatement(requete) ;
			pstmt.setInt(1, praNum) ;
			resultat = pstmt.executeQuery() ;
			
			if(resultat.next()) {
				nomPraticien = resultat.getString("PRA_NOM") ;
			}
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage()) ;
			
			e.printStackTrace();
		}
		finally {
			stmt.close() ;
			resultat.close() ;
		}
		
		return nomPraticien ;
	}
	
	public String getVillePraticien(int praNum) throws SQLException {
		System.out.println("ModeleGsb::getNomPraticien()") ;
		
		String villePraticien = null ;
		
		try {
			connexionBdd = ConnexionBdd.getConnexionBdd() ;
			stmt = connexionBdd.createStatement() ;
			
			String requete = "SELECT PRA_VILLE "
					+ "FROM PRATICIEN "
					+ "WHERE PRA_NUM = ? " ;
			
			pstmt = (PreparedStatement) connexionBdd.prepareStatement(requete) ;
			pstmt.setInt(1, praNum) ;
			resultat = pstmt.executeQuery() ;
			
			if(resultat.next()) {
				villePraticien = resultat.getString("PRA_VILLE") ;
			}
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage()) ;
			
			e.printStackTrace();
		}
		finally {
			stmt.close() ;
			resultat.close() ;
		}
		
		return villePraticien ;
	}
	
}


