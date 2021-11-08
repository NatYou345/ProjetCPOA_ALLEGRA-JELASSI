/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_metier.Revue;
import objets_metier.RevuePeriodicite;

public interface RevueDAO extends DAO <Revue>{
	public ArrayList<Revue> findAll() throws SQLException;
	public ArrayList<RevuePeriodicite> findAllLibelle() throws SQLException;
	public RevuePeriodicite getRPById(int id);
}
