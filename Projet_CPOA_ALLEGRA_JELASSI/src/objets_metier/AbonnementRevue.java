package objets_metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AbonnementRevue {
	
	private IntegerProperty idAbonnement;
	private StringProperty date_debut;
	private StringProperty date_fin;
	private StringProperty nom;
	private StringProperty prenom;
	private IntegerProperty id_revue;

	public AbonnementRevue(int idAbonnement, String date_debut, String date_fin, String nom, int prenom, int id_revue) {
		this.idAbonnement = new SimpleIntegerProperty(idAbonnement);
		this.date_debut = new SimpleStringProperty(date_debut);
		this.date_fin = new SimpleStringProperty(date_fin);
		this.nom = new SimpleStringProperty(nom);
		this.id_revue = new SimpleIntegerProperty(id_revue);
	}


	/**
	 * @return the idAbonnement
	 */
	public IntegerProperty getIdAbonnement() {
		return idAbonnement;
	}

	/**
	 * @param idAbonnement the idAbonnement to set
	 */
	public void setIdAbonnement(IntegerProperty idAbonnement) {
		this.idAbonnement = idAbonnement;
	}

	/**
	 * @return the date_debut
	 */
	public StringProperty getDate_debut() {
		return date_debut;
	}

	/**
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(StringProperty date_debut) {
		this.date_debut = date_debut;
	}

	/**
	 * @return the date_fin
	 */
	public StringProperty getDate_fin() {
		return date_fin;
	}

	/**
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(StringProperty date_fin) {
		this.date_fin = date_fin;
	}

	/**
	 * @return the nom
	 */
	public StringProperty getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(StringProperty nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public StringProperty getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(StringProperty prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the id_revue
	 */
	public IntegerProperty getId_revue() {
		return id_revue;
	}

	/**
	 * @param id_revue the id_revue to set
	 */
	public void setId_revue(IntegerProperty id_revue) {
		this.id_revue = id_revue;
	}
	
	public IntegerProperty idAbonnementProperty() 
	{
		return idAbonnement;
	}
	
	public StringProperty date_debProperty() 
	{
		return date_debut;
	}
	
	public StringProperty date_finProperty() 
	{
		return date_fin;
	}
	
	public StringProperty nomProperty() 
	{
		return nom;
	}
	
	public StringProperty prenomProperty() 
	{
		return prenom;
	}
	
	public IntegerProperty id_revueProperty() 
	{
		return id_revue;
	}

	@Override
	public String toString() {
		return "AbonnementRevue [idAbonnement=" + idAbonnement + ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", nom=" + nom + ", prenom=" + prenom + ", id_revue=" + id_revue + "]";
	}

}
