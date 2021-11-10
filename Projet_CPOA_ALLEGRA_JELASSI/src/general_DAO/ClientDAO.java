/**
 * 
 */
package general_DAO;

import java.util.ArrayList;
import objets_metier.Client;
import objets_metier.ClientAff;

public interface ClientDAO extends DAO<Client>{
	
	public ArrayList<Client> findAll();
	public ArrayList<ClientAff> findAllAff();
	public ClientAff getCAById(int id);


}
