package factory;

import java.text.ParseException;

import general_DAO.AbonnementDAO;
import general_DAO.ClientDAO;
import general_DAO.PeriodiciteDAO;
import general_DAO.RevueDAO;
import solutionPersistance.Persistance; 

public abstract class DAOFactory {
	
public static DAOFactory getDAOFactory(Persistance solution) {
	DAOFactory daoF = null;
	switch (solution) {
		case MYSQL:
		daoF = new MySQLDAOFactory();
		break;
		
		case ListeMemoire:
			daoF = new ListeMemoireDAOFactory();
		break;
	}
	return daoF;
	}

public abstract ClientDAO getClientDAO();
public abstract AbonnementDAO getAbonnementDAO() throws ParseException;
public abstract PeriodiciteDAO getPeriodiciteDAO();
public abstract RevueDAO getRevueDAO();

}