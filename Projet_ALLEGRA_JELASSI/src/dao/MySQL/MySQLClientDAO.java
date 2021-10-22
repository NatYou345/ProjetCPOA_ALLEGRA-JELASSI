package dao.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import general_DAO.ClientDAO;
import general_DAO.DAO;
import objets_metier.Client;

public class MySQLClientDAO implements DAO<Client>, ClientDAO{
private Connexion maConnexion;
	{
		this.maConnexion=new Connexion();
	}

private static MySQLClientDAO instance;
private MySQLClientDAO() {}

public static MySQLClientDAO getInstance() {
	
    if (instance==null) {
     instance = new MySQLClientDAO();
     }
    return instance;
    }

@Override
public Client getById(int id) {
	
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" select * from Client where id_client = ?"); 
		requete.setInt(1, id);
		ResultSet res  = requete.executeQuery();
		Client c = null;
		if (res.next()) {
			System.out.println("Trouv�");
			c = new Client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),	res.getString(5),res.getString(6),res.getString(7),	res.getString(8));

		}
		if (requete != null)
			requete.close();
		if (laConnexion != null)
			laConnexion.close();
		
		return c;
		
	}catch (SQLException sqle) {
		System.out.println("Probl�me dans la requ�te ! " + sqle.getMessage());
	}
	return null;
}

@Override
public boolean create(Client object) {
	System.out.println("Creation de client avec MYSQL Factory");
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" insert into Client (nom, prenom, no_rue, voie, code_postal, ville, pays) values (?,?,?,?,?,?,?)"); 
		
		requete.setString(1, object.getNom());
		requete.setString(2, object.getPrenom());
		requete.setString(3, object.getNo_rue());
		requete.setString(4, object.getVoie());
		requete.setString(5, object.getCode_postal());
		requete.setString(6, object.getVille());
		requete.setString(7, object.getPays());
		
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
public boolean update(Client object) {
	System.out.println("Update du client avec MYSQL Factory");
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" update Client SET nom =?, prenom =?, no_rue =?, voie =?, code_postal =?, ville =?, pays =? where id_client=?"); 
		requete.setInt(8, object.getId_client());
		requete.setString(1, object.getNom());
		requete.setString(2, object.getPrenom());
		requete.setString(3, object.getNo_rue());
		requete.setString(4, object.getVoie());
		requete.setString(5, object.getCode_postal());
		requete.setString(6, object.getVille());
		requete.setString(7, object.getPays());
		
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
public boolean delete(Client object) {
	System.out.println("Delete du client avec MYSQL Factory");
	try {
		Connection laConnexion = maConnexion.creeConnexion();
		PreparedStatement requete = laConnexion.prepareStatement(" delete from Client where id_client =?");
		
		requete.setInt(1, object.getId_client()); 
		
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
public ArrayList<Client> findAll() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}
