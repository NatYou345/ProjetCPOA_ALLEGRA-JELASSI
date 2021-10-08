package general_DAO;

import objets_métier.Periodicite;

public class MySQLPeriodiciteDAO implements DAO<Periodicite>{
	

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
}