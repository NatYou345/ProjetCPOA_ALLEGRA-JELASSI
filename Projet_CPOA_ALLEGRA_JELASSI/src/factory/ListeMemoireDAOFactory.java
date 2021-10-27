package factory;

import java.text.ParseException;

import dao.listememoire.ListeMemoireAbonnementDAO;
import dao.listememoire.ListeMemoireClientDAO;
import dao.listememoire.ListeMemoirePeriodiciteDAO;
import dao.listememoire.ListeMemoireRevueDAO;
import general_DAO.AbonnementDAO;
import general_DAO.ClientDAO;
import general_DAO.PeriodiciteDAO;
import general_DAO.RevueDAO;

public class ListeMemoireDAOFactory extends DAOFactory {

@Override
public ClientDAO getClientDAO() {
	return ListeMemoireClientDAO.getInstance();
}

@Override
public AbonnementDAO getAbonnementDAO() throws ParseException {
	return ListeMemoireAbonnementDAO.getInstance();
}

@Override
public PeriodiciteDAO getPeriodiciteDAO() {
	return ListeMemoirePeriodiciteDAO.getInstance();
}

@Override
public RevueDAO getRevueDAO() {
	return ListeMemoireRevueDAO.getInstance();
}

}