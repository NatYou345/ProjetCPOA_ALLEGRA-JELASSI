
public class MySQLPeriodiciteDAO implements DAO<Periodicite>{
	

private static MySQLPeriodiciteDAO instance;
private MySQLPeriodiciteDAO() {}

public static MySQLPeriodiciteDAO getInstance() {
	
    if (instance==null) {
     instance = new MySQLPeriodiciteDAO();
     }
    return instance;
    }
}