

public class MySQLAbonnementDAO implements DAO<Abonnement>{
	

private static MySQLAbonnementDAO instance;
private MySQLAbonnementDAO() {}

public static MySQLAbonnementDAO getInstance() {
	
    if (instance==null) {
     instance = new MySQLAbonnementDAO();
     }
    return instance;
    }
}