public class MySQLClientDAO implements DAO<Client>{
	

private static MySQLClientDAO instance;
private MySQLClientDAO() {}

public static MySQLClientDAO getInstance() {
	
    if (instance==null) {
     instance = new MySQLClientDAO();
     }
    return instance;
    }
}
