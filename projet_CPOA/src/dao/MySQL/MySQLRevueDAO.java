package dao.MySQL;

import java.sql.SQLException;
import java.util.ArrayList;

import general_DAO.DAO;
import general_DAO.RevueDAO;
import objets_métier.Revue;

public class MySQLRevueDAO implements DAO<Revue>, RevueDAO{
	

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
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean create(Revue object) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean update(Revue object) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean delete(Revue object) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public ArrayList<Revue> findAll() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}
