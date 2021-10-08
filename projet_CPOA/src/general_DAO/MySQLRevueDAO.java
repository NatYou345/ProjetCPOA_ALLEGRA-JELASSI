
public class MySQLRevueDAO implements DAO<Revue>{
	

private static MySQLRevueDAO instance;
private MySQLRevueDAO() {}

public static MySQLRevueDAO getInstance() {
	
    if (instance==null) {
     instance = new MySQLRevueDAO();
     }
    return instance;
    }
}
