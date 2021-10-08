package general_DAO;

import objets_métier.Abonnement;

public class MySQLAbonnementDAO implements DAO<Abonnement>{
	

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
}