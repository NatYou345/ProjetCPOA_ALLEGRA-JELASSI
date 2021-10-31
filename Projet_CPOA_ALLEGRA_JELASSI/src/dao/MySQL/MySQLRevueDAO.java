package dao.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import general_DAO.DAO;
import general_DAO.RevueDAO;
import objets_metier.Periodicite;
import objets_metier.Revue;
import objets_metier.RevuePeriodicite;

public class MySQLRevueDAO implements DAO<Revue>, RevueDAO{
	private Connexion maConnexion;
	{
		this.maConnexion=new Connexion();
	}	

private static MySQLRevueDAO instance;
private MySQLRevueDAO() {}

public static MySQLRevueDAO getInstance() {
	
    if (instance==null) {
     instance = new MySQLRevueDAO();
     }
    return instance;
    }

@Override
public Revue getById(int id) {
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Revue where id_revue = ?"); 
		requete.setInt(1, id);
		ResultSet res  = requete.executeQuery();
		Revue r = null;
		if (res.next()) {
			
		r = new Revue(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4), res.getString(5),res.getInt(6));

		}
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return r;
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return null;
}

@Override
public boolean create(Revue object) {
	System.out.println("Création de revue avec MYSQL Factory");
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" insert into Revue (titre,description,tarif_numero,visuel,id_periodicite) values (?,?,?,?,?)"); 
		requete.setString(1, object.getTitre());
		requete.setString(2, object.getDescription());
		requete.setFloat(3, object.getTarif_numero());
		requete.setString(4, object.getVisuel());
		requete.setInt(5,object.getId_periodicite() );
		
		int nbRevue = requete.executeUpdate();
		
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
public boolean update(Revue object) {
	System.out.println("Update de revue avec MYSQL Factory");
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" update Revue SET titre =?,description=?,tarif_numero=?,visuel=?,id_periodicite=? where id_revue=?"); 
		requete.setString(1, object.getTitre());
		requete.setString(2, object.getDescription());
		requete.setFloat(3, object.getTarif_numero());
		requete.setString(4, object.getVisuel());
		requete.setInt(5,object.getId_periodicite() );
		
		int nbRevue = requete.executeUpdate();
		
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
public boolean delete(Revue object) {
	System.out.println("Delete de la revue avec MYSQL Factory");
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" delete from Revue where id_revue =?");
		
		requete.setInt(1, object.getId_revue()); 
		
		int nbClient = requete.executeUpdate();
		
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
public ArrayList<RevuePeriodicite> findAllLibelle() throws SQLException {
	ArrayList<RevuePeriodicite> ListeRevue = new ArrayList<RevuePeriodicite>();
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select id_revue, titre, description, tarif_numero, "+
																		"Revue.id_periodicite, libelle from Revue,"+
																		"Periodicite "+
																		"where Revue.id_periodicite = Periodicite.id_periodicite");
		ResultSet res  = requete.executeQuery();
		RevuePeriodicite obj = null;
		while (res.next()) 
		{
			obj = new RevuePeriodicite(res.getInt(1),res.getString(2),res.getString(3),String.valueOf(res.getFloat(4)),res.getInt(5),res.getString(6));
			ListeRevue.add(obj);
		}
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		
		return ListeRevue;
		
	}catch (SQLException sqle) {
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return null;

}

@Override
public ArrayList<Revue> findAll() throws SQLException {
	return null;

}
}
