/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_m�tier.Client;

public interface ClientDAO {
	
	
	public ArrayList<Client> findAll() throws SQLException;

}
