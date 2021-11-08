package dao.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import general_DAO.PeriodiciteDAO;
import objets_metier.Periodicite;
import objets_metier.RevuePeriodicite;

public class MySQLPeriodiciteDAO implements PeriodiciteDAO {
	private Connexion maConnexion;
{
	this.maConnexion=new Connexion();
}

private static MySQLPeriodiciteDAO instance;
private MySQLPeriodiciteDAO() {}

public static MySQLPeriodiciteDAO getInstance() {
	
    if (instance==null) {
     instance = new MySQLPeriodiciteDAO();
     }
    return instance;
    }

@Override
public Periodicite getById(int id) {
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Periodicite where id_periodicite = ?"); 
		requete.setInt(1, id);
		ResultSet res  = requete.executeQuery();
		Periodicite p = null;
		if (res.next()) {
			
		p = new Periodicite(res.getInt(1),res.getString(2));

		}
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return p;
		
	}catch (SQLException sqle) {
		System.out.println("Problï¿½me dans la requï¿½te ! " + sqle.getMessage());
	}
	return null;
}

@Override
public boolean create(Periodicite object) {
	System.out.println("Crï¿½ation de la pï¿½riodicitï¿½ avec MYSQL Factory");
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" insert into Periodicite (libelle) values (?)"); 
		requete.setString(1, object.getLibelle());
		
		int nbPeriodicite = requete.executeUpdate();
		
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
	}catch (SQLException sqle) {
		System.out.println("Problï¿½me dans la requï¿½te ! " + sqle.getMessage());
	}
	return false;
}

@Override
public boolean update(Periodicite object) {
	System.out.println("Update de la pï¿½riodicitï¿½ avec MYSQL Factory");
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" update Periodicite SET libelle =? where id_periodicite=?"); 
		
		requete.setInt(2, object.getId_periodicite()); 
		requete.setString(1, object.getLibelle());
		
		int nbPeriodicite = requete.executeUpdate();
		
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
	}catch (SQLException sqle) {
		System.out.println("Problï¿½me dans la requï¿½te ! " + sqle.getMessage());
	}
	return false;
}

@Override
public boolean delete(Periodicite object) {
	System.out.println("Delete de la pï¿½riodicitï¿½ avec MYSQL Factory");
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" delete from Periodicite where id_periodicite =?");
		
		requete.setInt(1, object.getId_periodicite()); 
		
		int nbPeriodicite = requete.executeUpdate();
		
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
	}catch (SQLException sqle) {
		System.out.println("Problï¿½me dans la requï¿½te ! " + sqle.getMessage());
	}
	
	return false;
}

@Override
public ArrayList<Periodicite> findAll() throws SQLException {
	ArrayList<Periodicite> ListePeriodicite = new ArrayList<Periodicite>();
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Periodicite"); 
		ResultSet res  = requete.executeQuery();
		Periodicite p = null;
		while (res.next()) 
		{
			p = new Periodicite(res.getInt(1),res.getString(2));
			ListePeriodicite.add(p);
		}
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		
		return ListePeriodicite;
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return null;

}

@Override
public int getByLibelle(String libelle) {
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Periodicite where libelle = ?"); 
		requete.setString(1, libelle);
		ResultSet res = requete.executeQuery();
		int p = 0;
		if (res.next()) {
			
		p = res.getInt(1);

		}
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return p;
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return -1;
}

@Override
public RevuePeriodicite getRPById(int id) {
	// TODO Auto-generated method stub
	return null;
}
}