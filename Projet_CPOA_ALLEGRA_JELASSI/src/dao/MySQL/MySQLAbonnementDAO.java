package dao.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import general_DAO.AbonnementDAO;
import general_DAO.DAO;
import objets_metier.Abonnement;
import objets_metier.AbonnementAff;
import objets_metier.ClientAff;
import objets_metier.RevuePeriodicite;


public class MySQLAbonnementDAO implements DAO<Abonnement>, AbonnementDAO{
	private Connexion maConnexion;
	{
		this.maConnexion=new Connexion();
	}	

private static MySQLAbonnementDAO instance;
private MySQLAbonnementDAO() {}

public static MySQLAbonnementDAO getInstance() {
	
    if (instance==null) {
     instance = new MySQLAbonnementDAO();
     }
    return instance;
    }

@Override
public Abonnement getById(int id) {
	
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Abonnement where id_abonnement = ?"); 
		requete.setInt(1, id);
		ResultSet res  = requete.executeQuery();
		Abonnement a = null;
		if (res.next()) {
			
			a = new Abonnement(res.getInt(1),res.getDate(2),res.getDate(3), res.getInt(6), res.getInt(6));

		}
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return a;
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return null;
}

@Override
public int getByRevueId(int id) {
	
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Abonnement where id_revue = ?"); 
		requete.setInt(1, id);
		ResultSet res  = requete.executeQuery();
		
		int nb = 0;
		if (res.next()) {
			nb = 1;
		}
		else {
			nb = 0;
		}
		
		if (requete != null)
			requete.close();
		
		if (laConnexion != null)
			laConnexion.close();
		
		return nb;
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return -1;
}

@Override
public int getByClientId(int id) {
	
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Abonnement where id_client = ?"); 
		requete.setInt(1, id);
		ResultSet res  = requete.executeQuery();
		
		int nb = 0;
		if (res.next()) {
			nb = 1;
		}
		else {
			nb = 0;
		}
		
		if (requete != null)
			requete.close();
		
		if (laConnexion != null)
			laConnexion.close();
		
		return nb;
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return -1;
}
@Override
public boolean create(Abonnement object) {
	
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" insert into Abonnement ( date_debut, date_fin, id_client, id_revue) Values (?,?,?,?)"); 
		
		long timeInMilliSeconds = object.getDate_debut().getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
        requete.setDate(1, date1);
        long timeInMilliSeconds2 = object.getDate_fin().getTime();
        java.sql.Date date2 = new java.sql.Date(timeInMilliSeconds2);
		requete.setDate(2, date2);
		requete.setInt(3, object.getId_client());
		requete.setInt(4, object.getId_revue());
		
		int nbClient = requete.executeUpdate();
		
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return false;
}

@Override
public boolean update(Abonnement object) {

	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" update Abonnement SET date_debut =?, date_fin =?, id_client =?, id_revue =? where id_abonnement =?"); 
		
		java.sql.Date date1 = new java.sql.Date(object.getDate_debut().getTime());
		requete.setDate(1, date1);
		java.sql.Date date2 = new java.sql.Date(object.getDate_fin().getTime());
		requete.setDate(2, date2);
		requete.setInt(3, object.getId_client());
		requete.setInt(4, object.getId_revue());
		requete.setInt(5, object.getId_abonnement());
		
		int nbClient = requete.executeUpdate();
		
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return false;
}

@Override
public boolean delete(Abonnement object) {
	
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" delete from Abonnement where id_abonnement =?");
		
		requete.setInt(1, object.getId_abonnement()); 
		
		int nbClient = requete.executeUpdate();
		
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return false;
}

@Override
public ArrayList<Abonnement> findAll() throws SQLException {
	
	ArrayList<Abonnement> listeAbo = new ArrayList<Abonnement>();
	
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Abonnement"); 
		
		ResultSet res  = requete.executeQuery();
		Abonnement obj = null;
		
		while (res.next()) 
		{
			obj = new Abonnement(res.getInt(1),res.getDate(2),res.getDate(3), res.getInt(4), res.getInt(5));
			listeAbo.add(obj);
		}

		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return listeAbo;
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return null;
}

@Override
public ArrayList<AbonnementAff> findAllDetails() throws SQLException {
	
	ArrayList<AbonnementAff> listeAbo = new ArrayList<AbonnementAff>();
	
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Abonnement"); 
		
		ResultSet res  = requete.executeQuery();
		AbonnementAff obj = null;
		
		while (res.next()) 
		{
			obj = new AbonnementAff(res.getInt(1),res.getDate(2).toLocalDate(),res.getDate(3).toLocalDate(), res.getInt(4), res.getInt(5));
			listeAbo.add(obj);
		}

		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return listeAbo;
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return null;
}

@Override
public ArrayList<AbonnementAff> findAllDetailsByClient(ClientAff cli) throws SQLException {
	
	ArrayList<AbonnementAff> listeAbo = new ArrayList<AbonnementAff>();
	
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Abonnement where id_client = ?"); 
		requete.setInt(1, cli.getId_client());
		ResultSet res  = requete.executeQuery();
		AbonnementAff obj = null;
		
		while (res.next()) 
		{
			obj = new AbonnementAff(res.getInt(1),res.getDate(2).toLocalDate(),res.getDate(3).toLocalDate(), res.getInt(4), res.getInt(5));
			listeAbo.add(obj);
		}

		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return listeAbo;
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return null;
}
@Override
public ArrayList<AbonnementAff> findAllDetailsByRevue(RevuePeriodicite revue) throws SQLException {
	
	ArrayList<AbonnementAff> listeAbo = new ArrayList<AbonnementAff>();
	
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Abonnement where id_revue = ?"); 
		requete.setInt(1, revue.getId_revue());
		ResultSet res  = requete.executeQuery();
		AbonnementAff obj = null;
		
		while (res.next()) 
		{
			obj = new AbonnementAff(res.getInt(1),res.getDate(2).toLocalDate(),res.getDate(3).toLocalDate(), res.getInt(4), res.getInt(5));
			listeAbo.add(obj);
		}

		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return listeAbo;
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return null;
}

@Override
public RevuePeriodicite getRPById(int id) {
	// TODO Auto-generated method stub
	return null;
}


}