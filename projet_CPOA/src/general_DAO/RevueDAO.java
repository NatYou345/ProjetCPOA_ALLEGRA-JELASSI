/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_m�tier.Revue;

public interface RevueDAO extends DAO <Revue>{
	public ArrayList<Revue> findAll() throws SQLException;
}
