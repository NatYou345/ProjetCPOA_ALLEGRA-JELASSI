package dao.MySQL;

import java.sql.SQLException;
import java.util.ArrayList;

import general_DAO.ClientDAO;
import general_DAO.DAO;
import objets_m�tier.Client;

public class MySQLClientDAO implements DAO<Client>, ClientDAO{
	

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
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean create(Client object) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean update(Client object) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean delete(Client object) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public ArrayList<Client> findAll() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}