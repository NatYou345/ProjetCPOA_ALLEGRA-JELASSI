package general_DAO;

import objets_métier.Client;

public class MySQLClientDAO implements DAO<Client>{
	

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
}
