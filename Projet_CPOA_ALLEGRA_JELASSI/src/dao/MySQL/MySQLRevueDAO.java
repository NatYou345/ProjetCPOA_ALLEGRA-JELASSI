package dao.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import general_DAO.DAO;
import general_DAO.RevueDAO;
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
		System.out.println("Probl�me dans la requ�te ! " + sqle.getMessage());
	}
	return null;
}

@Override
public RevuePeriodicite getRPById(int id) {
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select id_revue, titre, description, tarif_numero, "+
				"Revue.id_periodicite, libelle " + 
				"from Revue, Periodicite " +
				"where Revue.id_periodicite = Periodicite.id_periodicite and id_revue = ?"); 
		requete.setInt(1, id);
		ResultSet res  = requete.executeQuery();
		RevuePeriodicite r = null;
		if (res.next()) {

			r = new RevuePeriodicite(res.getInt(1),res.getString(2),res.getString(3),res.getString(4), res.getInt(5), res.getString(6));
		}
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return r;
		
	}catch (SQLException sqle) {
		System.out.println("Probl�me dans la requ�te getRPByID ! " + sqle.getMessage());
	}
	return null;
}
@Override
public boolean create(Revue object) {
	
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
		System.out.println("Probeme dans la requete ! " + sqle.getMessage());
	}
	return false;
}

@Override
public boolean update(Revue object) {
	
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" update Revue SET titre =?,description=?,tarif_numero=?,visuel=?,id_periodicite=? where id_revue=?"); 
		requete.setString(1, object.getTitre());
		requete.setString(2, object.getDescription());
		requete.setFloat(3, object.getTarif_numero());
		requete.setString(4, object.getVisuel());
		requete.setInt(5,object.getId_periodicite() );
		requete.setInt(6,object.getId_revue() );
		
		int nbRevue = requete.executeUpdate();
		
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
	}catch (SQLException sqle) {
		System.out.println("Probleme dans la requete ! " + sqle.getMessage());
	}
	return false;
}

@Override
public boolean delete(Revue object) {
	
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
		System.out.println("Probleme dans la requete ! " + sqle.getMessage());
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
		System.out.println("Probl�me dans la requ�te ! " + sqle.getMessage());
	}
	return null;

}

@Override
public ArrayList<Revue> findAll() throws SQLException {
	ArrayList<Revue> ListeRevue = new ArrayList<Revue>();
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select id_revue, titre from Revue"); 
		ResultSet res  = requete.executeQuery();
		Revue obj = null;
		while (res.next()) 
		{
			obj = new Revue(res.getInt(1),res.getString(2));
			ListeRevue.add(obj);
		}
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		
		return ListeRevue;
		
	}catch (SQLException sqle) {
		System.out.println("Probl�me dans la requ�te ! " + sqle.getMessage());
	}
	return null;

}

@Override
public int getByLibelle(String libelle) {
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Revue where titre = ?"); 
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
		System.out.println("Probl�me dans la requ�te ! " + sqle.getMessage());
	}
	return -1;
}

@Override
public String getTitreByID(int id) {
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select titre from Revue where id_revue = ?"); 
		requete.setInt(1, id);
		ResultSet res = requete.executeQuery();
		String t = "";
		if (res.next()) {	
			t = res.getString(1);
		}
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return t;
		
	}catch (SQLException sqle) {
		System.out.println("Probl�me dans la requ�te ! " + sqle.getMessage());
	}
	return "";
}

}
