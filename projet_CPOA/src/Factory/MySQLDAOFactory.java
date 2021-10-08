package Factory;

import general_DAO.*;

public class MySQLDAOFactory extends DAOFactory {
public ClientDAO getEtudiantDAO() {
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
@Override
public ClientDAO getClientDAO() {
	// TODO Auto-generated method stub
	return null;
}

}