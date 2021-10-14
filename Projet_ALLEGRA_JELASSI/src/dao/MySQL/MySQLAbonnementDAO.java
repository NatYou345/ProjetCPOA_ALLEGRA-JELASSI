package dao.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import Connexion_BDD.Connexion;
import general_DAO.AbonnementDAO;
import general_DAO.DAO;
import objets_metier.Abonnement;


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
			
			a = new Abonnement(res.getInt(1),res.getDate(2),res.getDate(3),res.getInt(4), res.getInt(5));

		}
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return a;
		
	}catch (SQLException sqle) {
		System.out.println("Probl�me dans la requ�te ! " + sqle.getMessage());
	}
	return null;
}

@Override
public boolean create(Abonnement object) {
	System.out.println("Creation d'abonnement avec MYSQL Factory");
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" insert into Abonnement ( date_debut, date_fin, id_client, id_revue) Values (?,?,?,?)"); 
		
		long timeInMilliSeconds = object.getDate_debut().getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
        requete.setDate(1, date1);
        long timeInMilliSeconds2 = object.getDate_debut().getTime();
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
		System.out.println("Probl�me dans la requ�te ! " + sqle.getMessage());
	}
	return false;
}

@Override
public boolean update(Abonnement object) {
	System.out.println("Update d'abonnement avec MYSQL Factory");
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" update Abonnement SET date_debut =?, date_fin =?, id_client =?, id_revue =? where id_abonnement =?"); 
		
		java.sql.Date date1 = new java.sql.Date(object.getDate_debut().getTime());
		requete.setDate(1, date1);
		java.sql.Date date2 = new java.sql.Date(object.getDate_debut().getTime());
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
		System.out.println("Probl�me dans la requ�te ! " + sqle.getMessage());
	}
	return false;
}

@Override
public boolean delete(Abonnement object) {
	System.out.println("Delete d'un abonnement avec MYSQL Factory");
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
		System.out.println("Probl�me dans la requ�te ! " + sqle.getMessage());
	}
	return false;
}

@Override
public ArrayList<Abonnement> findAll() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}