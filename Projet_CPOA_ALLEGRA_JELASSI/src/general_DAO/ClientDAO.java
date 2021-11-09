/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_metier.Client;
import objets_metier.ClientAff;
import objets_metier.Revue;

public interface ClientDAO extends DAO<Client>{
	
	public ArrayList<Client> findAll() throws SQLException;
	public ArrayList<ClientAff> findAllAff() throws SQLException;
	public ClientAff getCAById(int id);


}
