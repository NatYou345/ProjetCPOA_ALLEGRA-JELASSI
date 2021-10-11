package dao.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Connexion_BDD.Connexion;
import general_DAO.PeriodiciteDAO;
import objets_métier.Periodicite;

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
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean create(Periodicite object) {
	System.out.println("Création de la périodicité avec MYSQL Factory");
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
		System.out.println("Problème dans la requête ! " + sqle.getMessage());
	}
	return false;
}

@Override
public boolean update(Periodicite object) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean delete(Periodicite object) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public ArrayList<Periodicite> findAll() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}