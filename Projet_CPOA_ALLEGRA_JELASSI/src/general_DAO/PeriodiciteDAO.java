/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_metier.Periodicite;

public interface PeriodiciteDAO extends DAO<Periodicite>{
	
	
public ArrayList<Periodicite> findAll() throws SQLException;

int getByLibelle(String libelle);
		
}