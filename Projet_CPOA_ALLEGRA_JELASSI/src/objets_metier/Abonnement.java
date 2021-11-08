/**Classe Abonnement 
 * 
 */
package objets_metier;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Abonnement {
	
	private int id_abonnement;
	private Date date_debut;
	private Date date_fin;
	private int id_client;
	private int id_revue;
	
	
	
	public Abonnement(int id, Date date_deb, Date date_fin, int id_client, int id_revue) {
		this.id_abonnement = id;
		this.date_debut = date_deb;
		this.date_fin = date_fin;
		this.id_client = id_client;
		this.id_revue = id_revue;
	}
	
	public Abonnement(Date date_deb, Date date_fin, int id_client, int id_revue) {
		
		this.date_debut = date_deb;
		this.date_fin = date_fin;
		this.id_client = id_client;
		this.id_revue = id_revue;
	}
	public Abonnement(int id) {
		this.id_abonnement = id;
	
	}

	public Abonnement() {
		// TODO Auto-generated constructor stub
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
		return date_debut;
	}

	/**
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	/**
	 * @return the date_fin
	 */
	public Date getDate_fin() {
		return date_fin;
	}

	/**
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(Date date_fin) {
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
	@Override
	public int hashCode() {
		return Objects.hash(date_debut, date_fin, id_abonnement, id_client, id_revue);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abonnement other = (Abonnement) obj;
		return Objects.equals(date_debut, other.date_debut) && Objects.equals(date_fin, other.date_fin)
				&& id_abonnement == other.id_abonnement && id_client == other.id_client && id_revue == other.id_revue;
	}

}
