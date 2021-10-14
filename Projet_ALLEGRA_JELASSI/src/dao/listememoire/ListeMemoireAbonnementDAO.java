package dao.listememoire;

import java.util.ArrayList;
import java.util.List;

import general_DAO.AbonnementDAO;
import objets_metier.Abonnement;

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

	public Abonnement getById(int id) {

		int idx = this.donnees.indexOf(new Abonnement(id, 0, null, null, null));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	public boolean create(Abonnement objet) {

		objet.setId_abonnement(3);

		while (this.donnees.contains(objet)) {

			objet.setId_abonnement(objet.getId_abonnement() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	public boolean update(Abonnement objet) {
		
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
		
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}
	
	public ArrayList<Abonnement> findAll() {
		return (ArrayList<Abonnement>) this.donnees;
	}
}