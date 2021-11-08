/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_metier.Abonnement;
import objets_metier.AbonnementAff;
import objets_metier.ClientAff;

public interface AbonnementDAO extends DAO<Abonnement> {

	public ArrayList<Abonnement> findAll() throws SQLException;

	public ArrayList<AbonnementAff> findAllDetails() throws SQLException;

	public ArrayList<AbonnementAff> findAllDetailsByClient(ClientAff cli) throws SQLException;
}
