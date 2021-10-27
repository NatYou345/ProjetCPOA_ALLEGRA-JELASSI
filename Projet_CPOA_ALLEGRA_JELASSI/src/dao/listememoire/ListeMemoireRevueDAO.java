
package dao.listememoire;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import general_DAO.RevueDAO;
import objets_metier.Revue;

public class ListeMemoireRevueDAO implements RevueDAO {

	private static ListeMemoireRevueDAO instance;

	private List<Revue> donnees;


	public static ListeMemoireRevueDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireRevueDAO();
		}

		return instance;
	}

	private ListeMemoireRevueDAO() {

		this.donnees = new ArrayList<Revue>();

		this.donnees.add(new Revue(1, "Test", "Test", 2, "Test", 2));
		this.donnees.add(new Revue(2, "Test", "Test", 3, "Test", 4));
	}


	public boolean create(Revue objet) {

		objet.setId_revue(3);
		// Ne fonctionne que si l'objet mï¿½tier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_revue(objet.getId_revue() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	public boolean update(Revue objet) {
		
		// Ne fonctionne que si l'objet mï¿½tier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	public boolean delete(Revue objet) {

		Revue supprime;
		
		// Ne fonctionne que si l'objet mï¿½tier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	public Revue getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Revue(id, "test","test", 3 , "Test", 2));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possï¿½de cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	
	}

	@Override
	public ArrayList<Revue> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}