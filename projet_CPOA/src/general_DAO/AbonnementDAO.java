/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_m�tier.Abonnement;

public interface AbonnementDAO extends DAO<Abonnement> {

	public ArrayList<Abonnement> findAll() throws SQLException;
}
