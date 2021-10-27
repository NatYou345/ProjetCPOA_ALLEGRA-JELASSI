/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_metier.Revue;

public interface RevueDAO extends DAO <Revue>{
	public ArrayList<Revue> findAll() throws SQLException;
}
