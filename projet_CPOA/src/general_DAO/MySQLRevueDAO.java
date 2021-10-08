package general_DAO;

import objets_métier.Revue;

public class MySQLRevueDAO implements DAO<Revue>{
	

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
}
