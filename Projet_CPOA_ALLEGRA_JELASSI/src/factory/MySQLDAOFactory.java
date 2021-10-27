package factory;

import dao.MySQL.MySQLAbonnementDAO;
import dao.MySQL.MySQLClientDAO;
import dao.MySQL.MySQLPeriodiciteDAO;
import dao.MySQL.MySQLRevueDAO;
import general_DAO.AbonnementDAO;
import general_DAO.ClientDAO;
import general_DAO.PeriodiciteDAO;
import general_DAO.RevueDAO;

public class MySQLDAOFactory extends DAOFactory {

@Override
public ClientDAO getClientDAO() {
	return MySQLClientDAO.getInstance();
}

@Override
public AbonnementDAO getAbonnementDAO() {
	return MySQLAbonnementDAO.getInstance();
}

@Override
public PeriodiciteDAO getPeriodiciteDAO() {
	return MySQLPeriodiciteDAO.getInstance();
}

@Override
public RevueDAO getRevueDAO() {
	return MySQLRevueDAO.getInstance();
}

}