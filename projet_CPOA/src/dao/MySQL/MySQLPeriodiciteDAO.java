package dao.MySQL;

import java.sql.SQLException;
import java.util.ArrayList;

import general_DAO.DAO;
import general_DAO.PeriodiciteDAO;
import objets_métier.Periodicite;

public class MySQLPeriodiciteDAO implements DAO<Periodicite>, PeriodiciteDAO{
	

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
	// TODO Auto-generated method stub
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