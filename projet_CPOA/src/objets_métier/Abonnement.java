/**Classe Abonnement 
 * 
 */
package objets_métier;

import java.util.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Abonnement {
	
	private int id_abonnement;
	private Date date_debut;
	private Date date_fin;
	private int id_client;
	private int id_revue;
	
	
	
	public Abonnement(int id, int i, Object object, Object object2, Object object3) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the id_abonnement
	 */
	public int getId_abonnement() {
		return id_abonnement;
	}

	/**
	 * @param id_abonnement the id_abonnement to set
	 */
	public void setId_abonnement(int id_abonnement) {
		this.id_abonnement = id_abonnement;
	}

	/**
	 * @return the date_debut
	 */
	public Date getDate_debut() {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date_debut.toLocalDate();
		return date_debut;
	}

	/**
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(Date date_debut) {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date_debut.toLocalDate();
		this.date_debut = date_debut;
	}

	/**
	 * @return the date_fin
	 */
	public Date getDate_fin() {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date_debut.toLocalDate();
		return date_fin;
	}

	/**
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(Date date_fin) {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date_debut.toLocalDate();
		this.date_fin = date_fin;
	}

	/**
	 * @return the id_client
	 */
	public int getId_client() {
		return id_client;
	}

	/**
	 * @param id_client the id_client to set
	 */
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	/**
	 * @return the id_revue
	 */
	public int getId_revue() {
		return id_revue;
	}

	/**
	 * @param id_revue the id_revue to set
	 */
	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
	}

	@Override
	public String toString() {
		return "Abonnement [id_abonnement=" + id_abonnement + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", id_client=" + id_client + ", id_revue=" + id_revue + "]";
	}

}
