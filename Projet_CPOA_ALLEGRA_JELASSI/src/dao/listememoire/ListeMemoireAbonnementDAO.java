package dao.listememoire;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import general_DAO.AbonnementDAO;
import objets_metier.Abonnement;
import objets_metier.AbonnementAff;
import objets_metier.ClientAff;
import objets_metier.RevuePeriodicite;

public class ListeMemoireAbonnementDAO implements AbonnementDAO {

	private static ListeMemoireAbonnementDAO instance;

	private List<Abonnement> donnees;


	public static ListeMemoireAbonnementDAO getInstance() throws ParseException {

		if (instance == null) {
			instance = new ListeMemoireAbonnementDAO();
		}

		return instance;
	}

	private ListeMemoireAbonnementDAO() throws ParseException {

		this.donnees = new ArrayList<Abonnement>();

		this.donnees.add(new Abonnement(1, new SimpleDateFormat("dd/MM/yyyy").parse("26/10/2021"), new SimpleDateFormat("dd/MM/yyyy").parse("26/11/2021"), 1, 1));
		this.donnees.add(new Abonnement(2, new SimpleDateFormat("dd/MM/yyyy").parse("26/10/2021"), new SimpleDateFormat("dd/MM/yyyy").parse("26/10/2022"), 1, 2));
	}

	public Abonnement getById(int id) throws ParseException {

		int idx = this.donnees.indexOf(new Abonnement(id, new SimpleDateFormat("dd/MM/yyyy").parse("26/10/2021"), new SimpleDateFormat("dd/MM/yyyy").parse("26/11/2021"), 1, 1));
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

	@Override
	public ArrayList<AbonnementAff> findAllDetails() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<AbonnementAff> findAllDetailsByClient(ClientAff client) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RevuePeriodicite getRPById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getByRevueId(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getByClientId(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<AbonnementAff> findAllDetailsByRevue(RevuePeriodicite revue) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}