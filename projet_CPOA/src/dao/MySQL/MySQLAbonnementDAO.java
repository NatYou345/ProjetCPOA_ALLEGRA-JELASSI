package dao.MySQL;

import java.sql.SQLException;
import java.util.ArrayList;

import general_DAO.AbonnementDAO;
import general_DAO.DAO;
import objets_métier.Abonnement;

public class MySQLAbonnementDAO implements DAO<Abonnement>, AbonnementDAO{
	

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
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean create(Abonnement object) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean update(Abonnement object) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean delete(Abonnement object) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public ArrayList<Abonnement> findAll() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}