/**
 * 
 */
package general_DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import objets_metier.Abonnement;
import objets_metier.AbonnementAff;
import objets_metier.ClientAff;
import objets_metier.RevuePeriodicite;

public interface AbonnementDAO extends DAO<Abonnement> {

	public ArrayList<Abonnement> findAll() throws SQLException;

	public ArrayList<AbonnementAff> findAllDetails() throws SQLException;

	public ArrayList<AbonnementAff> findAllDetailsByClient(ClientAff cli) throws SQLException;

	public boolean getByRevueId(int id);

	public boolean getByClientId(int id);

	public ArrayList<AbonnementAff> findAllDetailsByRevue(RevuePeriodicite revue) throws SQLException;
}
