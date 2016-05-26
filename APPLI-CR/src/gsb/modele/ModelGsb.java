package gsb.modele;

import gsb.entites.CompteRendu;
import gsb.entites.Delegue;
import gsb.entites.Praticien;
import gsb.entites.Visiteur;
import gsb.techniques.ConnexionBDGsb;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ModelGsb {
	
	private static ModelGsb modele = null ;
	private Connection connexion = null ;
	private java.sql.Statement stmt = null ;
	private PreparedStatement pstmt = null;
	private ResultSet resultat = null ;
	
	private ModelGsb() {
		super() ;
		
		System.out.println("ModelGsb::ModelGsb()") ;
		
	}
	
	public static ModelGsb getModele() {
		if(ModelGsb.modele == null) {
			ModelGsb.modele = new ModelGsb() ;
		}
		return ModelGsb.modele ;
	}
	
	public ArrayList<Delegue> getDelegues() throws SQLException {
		System.out.println("ModelGsb::getDelegues()") ;
		
		ArrayList<Delegue> listeDelegue = new ArrayList<Delegue>() ;
		try {
			
			this.connexion = ConnexionBDGsb.getConnexion() ;
			
			stmt = this.connexion.createStatement() ;
			
			String request = "SELECT VISITEUR.VIS_MATRICULE, VIS_NOM, VIS_PRENOM, VIS_LOGIN, VIS_MDP, REG_CODE "
					+ "FROM VISITEUR INNER JOIN TRAVAILLER "
					+ "ON VISITEUR.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE "
					+ "WHERE JJMMAA = ( SELECT MAX(JJMMAA)"
						+ "FROM TRAVAILLER as T "
						+ "WHERE T.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE) "
					+ "AND TRA_ROLE = 'Delegue' " ;
			
			resultat = stmt.executeQuery(request) ;
			
			while(resultat.next()){
				String matricule, nom, prenom, login, mdp, regionCode ;
				matricule = this.resultat.getString("VIS_MATRICULE") ;
				nom = this.resultat.getString("VIS_NOM") ;
				prenom = this.resultat.getString("VIS_PRENOM") ;
				login = this.resultat.getString("VIS_LOGIN");
				mdp = this.resultat.getString("VIS_MDP") ;
				regionCode = this.resultat.getString("REG_CODE") ;
				listeDelegue.add(new Delegue(matricule, nom, prenom, login, mdp, regionCode)) ;
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage()) ;
			
		} finally {
			if(this.resultat != null) {
				this.resultat.close() ;
				if(this.stmt != null) {
					this.stmt.close() ;
				}
			}
		}
		
		return  listeDelegue ;
	}
	
	public Delegue getUnDelegue(String login, String mdp) throws SQLException {
		System.out.println("ModelGsb::getUnDelegue(login,mdp)") ;
		ArrayList<Delegue> lesDelegues = this.getDelegues() ;
		Delegue delegue = null ;
		int l = 0 ;
		while(delegue == null && l < lesDelegues.size()) {
			if(lesDelegues.get(l).getLogin().equals(login) && lesDelegues.get(l).getMdp().equals(mdp) ) {
				delegue = lesDelegues.get(l) ;
			}
			else {
				l += 1 ;
			}
		}
		
		
		return delegue ;
		
	}
	
	public List<Praticien> getListeDesPraticiensHesitantOrderByCoeffConfiance() {
		System.out.println("ModelGsb::getListeDesPraticienshesitants()") ;
		List<Praticien> lesPraticiens = new ArrayList<Praticien>() ;
		
		try {
			
			this.connexion = ConnexionBDGsb.getConnexion() ;
			
			stmt = this.connexion.createStatement() ;
			
			String request = "SELECT PRATICIEN.PRA_NUM, PRA_NOM,PRA_PRENOM, PRA_ADRESSE, PRA_CP, PRA_VILLE, PRA_COEFNOTORIETE, TYP_CODE, RAP_DATE_VISITE, COEF_CODE "
					+ "FROM PRATICIEN INNER JOIN RAPPORT_VISITE "
					+ "ON PRATICIEN.PRA_NUM = RAPPORT_VISITE.PRA_NUM "
					+ "WHERE COEF_CODE <= 5 "
					+ "ORDER BY COEF_CODE;";
					
			resultat = stmt.executeQuery(request) ;
			
			while(resultat.next()){
				
				Praticien unPraticien = new Praticien(
						resultat.getInt("PRA_NUM"),
						resultat.getString("PRA_NOM"),
						resultat.getString("PRA_PRENOM"),
						resultat.getString("PRA_ADRESSE"),
						resultat.getString("PRA_CP"),
						resultat.getString("PRA_VILLE"),
						resultat.getFloat("PRA_COEFNOTORIETE"),
						resultat.getString("TYP_CODE"),
						resultat.getString("RAP_DATE_VISITE"),
						resultat.getInt("COEF_CODE")) ;
				lesPraticiens.add(unPraticien) ;
			}
			System.out.println(lesPraticiens) ;
			return lesPraticiens ;
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage()) ;
			
		} 
		
		return lesPraticiens ;
	}
	
	public List<Praticien> getListeDesPraticiensHesitantOrderByDepuisDerniereVisite() {
		System.out.println("ModelGsb::getListeDesPraticienshesitants()") ;
		List<Praticien> lesPraticiens = new ArrayList<Praticien>() ;
		
		try {
			
			this.connexion = ConnexionBDGsb.getConnexion() ;
			
			stmt = this.connexion.createStatement() ;
			
			String request = "SELECT PRATICIEN.PRA_NUM, PRA_NOM,PRA_PRENOM, PRA_ADRESSE, PRA_CP, PRA_VILLE, PRA_COEFNOTORIETE, TYP_CODE, RAP_DATE_VISITE, COEF_CODE "
					+ "FROM PRATICIEN INNER JOIN RAPPORT_VISITE "
					+ "ON PRATICIEN.PRA_NUM = RAPPORT_VISITE.PRA_NUM "
					+ "WHERE COEF_CODE <= 5 "
					+ "ORDER BY RAP_DATE_VISITE DESC;";
					
			resultat = stmt.executeQuery(request) ;
			
			while(resultat.next()){
				
				Praticien unPraticien = new Praticien(
						resultat.getInt("PRA_NUM"),
						resultat.getString("PRA_NOM"),
						resultat.getString("PRA_PRENOM"),
						resultat.getString("PRA_ADRESSE"),
						resultat.getString("PRA_CP"),
						resultat.getString("PRA_VILLE"),
						resultat.getFloat("PRA_COEFNOTORIETE"),
						resultat.getString("TYP_CODE"),
						resultat.getString("RAP_DATE_VISITE"),
						resultat.getInt("COEF_CODE")) ;
				lesPraticiens.add(unPraticien) ;
			}
			System.out.println(lesPraticiens) ;
			return lesPraticiens ;
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage()) ;
			
		} 
		
		return lesPraticiens ;
	}
	
	public List<Praticien> getListeDesPraticiensHesitantOrderByCoeffNotoriete() {
		System.out.println("ModelGsb::getListeDesPraticienshesitants()") ;
		List<Praticien> lesPraticiens = new ArrayList<Praticien>() ;
		
		try {
			
			this.connexion = ConnexionBDGsb.getConnexion() ;
			
			stmt = this.connexion.createStatement() ;
			
			String request = "SELECT PRATICIEN.PRA_NUM, PRA_NOM,PRA_PRENOM, PRA_ADRESSE, PRA_CP, PRA_VILLE, PRA_COEFNOTORIETE, TYP_CODE, RAP_DATE_VISITE, COEF_CODE "
					+ "FROM PRATICIEN INNER JOIN RAPPORT_VISITE "
					+ "ON PRATICIEN.PRA_NUM = RAPPORT_VISITE.PRA_NUM "
					+ "WHERE COEF_CODE <= 5 "
					+ "ORDER BY PRA_COEFNOTORIETE DESC;";
					
			resultat = stmt.executeQuery(request) ;
			
			while(resultat.next()){
				
				Praticien unPraticien = new Praticien(
						resultat.getInt("PRA_NUM"),
						resultat.getString("PRA_NOM"),
						resultat.getString("PRA_PRENOM"),
						resultat.getString("PRA_ADRESSE"),
						resultat.getString("PRA_CP"),
						resultat.getString("PRA_VILLE"),
						resultat.getFloat("PRA_COEFNOTORIETE"),
						resultat.getString("TYP_CODE"),
						resultat.getString("RAP_DATE_VISITE"),
						resultat.getInt("COEF_CODE")) ;
				lesPraticiens.add(unPraticien) ;
			}
			System.out.println(lesPraticiens) ;
			return lesPraticiens ;
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage()) ;
			
		} 
		
		return lesPraticiens ;
	}
	
	public List<CompteRendu> getComptesRendusVisiteurs(String visMatricule, String mois, String annee ) throws SQLException {
		System.out.println("ModeleGsb::getComptesRendusVisiteurs()") ;
		
		List<CompteRendu> lesComptesRendus = new ArrayList<CompteRendu>() ;
		
		try {
			stmt = this.connexion.createStatement() ;
			
			String requete = "SELECT VIS_MATRICULE, RAP_NUM, PRA_NUM, RAP_BILAN, RAP_DATE_REDACTION, "
					+ "RAP_DATE_VISITE, MOT_CODE, COEF_CODE, EST_CONSULTE "
					+ "FROM RAPPORT_VISITE "
					+ "WHERE VIS_MATRICULE = ? "
					+ "AND MONTH(RAP_DATE_VISITE) = ? "
					+ "AND YEAR(RAP_DATE_VISITE) = ? ;";
			
			pstmt = (PreparedStatement) this.connexion.prepareStatement(requete) ;
			pstmt.setString(1, visMatricule) ;
			pstmt.setString(2, mois);
			pstmt.setString(3, annee);
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
	
	public String getNomPraticien(int praNum) throws SQLException {
		System.out.println("ModeleGsb::getNomPraticien()") ;
		
		String nomPraticien = null ;
		
		try {
			stmt = this.connexion.createStatement() ;
			
			String requete = "SELECT PRA_NOM "
					+ "FROM PRATICIEN "
					+ "WHERE PRA_NUM = ? " ;
			
			pstmt = (PreparedStatement) this.connexion.prepareStatement(requete) ;
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
			stmt = this.connexion.createStatement() ;
			
			String requete = "SELECT PRA_VILLE "
					+ "FROM PRATICIEN "
					+ "WHERE PRA_NUM = ? " ;
			
			pstmt = (PreparedStatement) this.connexion.prepareStatement(requete) ;
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
	
	public List<Visiteur> getVisiteursRegion(String region) {
		System.out.println("ModeleGsb::getVisiteursRegion("+region+")") ;
		
		List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>() ;
		
		try {
			
			String requete = "SELECT VISITEUR.VIS_MATRICULE, VIS_NOM, VIS_PRENOM, VIS_ADRESSE, VIS_CP, VIS_VILLE, "
					+ "VIS_DATEEMBAUCHE, VIS_LOGIN, VIS_MDP, SEC_CODE, LAB_CODE, REG_CODE "
					+ "FROM VISITEUR INNER JOIN TRAVAILLER "
					+ "ON VISITEUR.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE "
					+ "WHERE JJMMAA = (SELECT MAX(JJMMAA) "
						+ "FROM TRAVAILLER AS t "
						+ "WHERE t.VIS_MATRICULE = TRAVAILLER.VIS_MATRICULE) "
					+ "AND TRA_ROLE = 'Visiteur' "
					+ "AND REG_CODE = ? " ;
			
			pstmt = (PreparedStatement) this.connexion.prepareStatement(requete) ;
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
				System.out.println(matricule + " - " + nom + " " + prenom + " " + adresse + " " + cp
						+ " " + ville + " " + dateEmbauche + " " + login + " " + mdp
						+ " " + secCode + " " + labCode + " " + regCode) ;
				
				lesVisiteurs.add(new Visiteur(matricule, nom, prenom, adresse, cp, ville, 
						dateEmbauche, login, mdp, secCode, labCode, regCode)) ;
				
			}
			
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage()) ;
			
			e.printStackTrace();
		}
		finally {
			
			try {
				resultat.close() ;
				stmt.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return lesVisiteurs ;
	}
	
	public String getNomLabo(String regCode) throws SQLException {
		System.out.println("ModeleGsb::getNomLabo()") ;
		
		String nomLabo = null ;
		
		try {
			stmt = this.connexion.createStatement() ;
			
			String requete = "SELECT LAB_NOM "
					+ "FROM LABORATOIRE "
					+ "WHERE LAB_CODE = ? " ;
			
			pstmt = (PreparedStatement) this.connexion.prepareStatement(requete) ;
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
	
}
