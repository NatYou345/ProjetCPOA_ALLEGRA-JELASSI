/**
 * 
 */
package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import general_DAO.ClientDAO;
import objets_metier.Client;

public class ListeMemoireClientDAO implements ClientDAO {

	private static ListeMemoireClientDAO instance;

	private List<Client> donnees;


	public static ListeMemoireClientDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}

		return instance;
	}

	private ListeMemoireClientDAO() {

		this.donnees = new ArrayList<Client>();

		this.donnees.add(new Client(1, "Jelassi", "Nour", "1", "Rue gaston zeller", "57000", "Metz", "France"));
		this.donnees.add(new Client(2, "Allegra", "Nathan", "3", "Passage du sablon", "57000", "Metz", "France"));
	}


	public boolean create(Client objet) {

		objet.setId_client(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_client(objet.getId_client() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	public boolean update(Client objet) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	public boolean delete(Client objet) {

		Client supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	public Client getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Client(id, "test", "test", "test", "test", "test", "test", "test"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Client> findAll() {
		return (ArrayList<Client>) this.donnees;
	}
}