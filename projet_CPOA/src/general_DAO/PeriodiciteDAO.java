/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_m�tier.Periodicite;

public interface PeriodiciteDAO {
	
	
public ArrayList<Periodicite> findAll() throws SQLException;
		
}