/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_métier.Periodicite;

public interface PeriodiciteDAO extends DAO<Periodicite>{
	
	
public ArrayList<Periodicite> findAll() throws SQLException;
		
}