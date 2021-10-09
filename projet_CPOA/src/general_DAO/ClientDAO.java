/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_métier.Client;

public interface ClientDAO extends DAO<Client>{
	
	
	public ArrayList<Client> findAll() throws SQLException;

}
