package Factory;

import general_DAO.AbonnementDAO;
import general_DAO.ClientDAO;
import general_DAO.PeriodiciteDAO;
import general_DAO.RevueDAO;

public abstract class DAOFactory {
	
public static DAOFactory getDAOFactory(Persistance cible) {
DAOFactory daoF = null;
switch (cible) {
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
public abstract AbonnementDAO getAbonnementDAO();
public abstract PeriodiciteDAO getPeriodiciteDAO();
public abstract RevueDAO getRevueDAO();
}