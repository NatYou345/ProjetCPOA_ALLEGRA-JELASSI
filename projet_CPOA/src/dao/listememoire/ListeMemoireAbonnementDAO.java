
package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import general_DAO.AbonnementDAO;
import objets_métier.Abonnement;

public class ListeMemoireAbonnementDAO implements AbonnementDAO {

	private static ListeMemoireAbonnementDAO instance;

	private List<Abonnement> donnees;


	public static ListeMemoireAbonnementDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireAbonnementDAO();
		}

		return instance;
	}

	private ListeMemoireAbonnementDAO() {

		this.donnees = new ArrayList<Abonnement>();

		this.donnees.add(new Abonnement(0, 0, null, null, null));
		this.donnees.add(new Abonnement(0, 0, null, null, null));
	}


	public boolean create(Abonnement objet) {

		objet.setId_abonnement(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_abonnement(objet.getId_abonnement() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	public boolean update(Abonnement objet) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	public boolean delete(Abonnement objet) {

		Abonnement supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	public Abonnement getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new Abonnement(id, 0, null, null, null));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	public ArrayList<Abonnement> findAll() {
		return (ArrayList<Abonnement>) this.donnees;
	}

	@Override
	public boolean create(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
}