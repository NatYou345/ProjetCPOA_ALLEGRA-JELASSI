
package objets_metier;

import java.util.Objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ClientAff {

	private IntegerProperty id_client;
	private StringProperty nom;
	private StringProperty prenom;
	private StringProperty num;
	private StringProperty voie;
	private StringProperty cp;
	private StringProperty ville;
	private StringProperty pays;
	
	public ClientAff() {
		this.id_client = new SimpleIntegerProperty(-1);
		this.nom = new SimpleStringProperty("");
		this.prenom = new SimpleStringProperty("");
		this.num = new SimpleStringProperty("");
		this.voie = new SimpleStringProperty("");;
		this.cp = new SimpleStringProperty();
		this.ville = new SimpleStringProperty("");
		this.pays = new SimpleStringProperty("");
	}
	
	
	public ClientAff(int i, String nom, String prenom, String num, String voie, String cp, String ville, String pays) {
		this.id_client = new SimpleIntegerProperty(i);
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.num = new SimpleStringProperty(num);
		this.voie = new SimpleStringProperty(voie);
		this.cp = new SimpleStringProperty(cp);
		this.ville = new SimpleStringProperty(ville);
		this.pays = new SimpleStringProperty(pays);
	}


	@Override
	public String toString() {
		return "ClientAff [id_client=" + id_client + ", nom=" + nom + ", prenom=" + prenom + ", num=" + num + ", voie="
				+ voie + ", cp=" + cp + ", ville=" + ville + ", pays=" + pays + "]";
	}

	/**
	 * @return the id_revue
	 */
	public int getId_client() {
		return id_client.get();
	}

	/**
	 * @param id_client the id_client to set
	 */
	public void setId_client(int id_client) {
		this.id_client.set(id_client);
	}
	
	public IntegerProperty id_clientProperty() 
	{
		return id_client;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom.get();
	}

	/**
	 * @param titre the nom to set
	 */
	public void setNom(String nom) {
		this.nom.set(nom);
	}
	
	public StringProperty nomProperty() 
	{
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom.get();
	}

	/**
	 * @param description the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}
	
	public StringProperty prenomProperty() 
	{
		return prenom;
	}

	/**
	 * @return the num
	 */
	public String getNum() {
		return num.get();
	}

	/**
	 * @param num the num to set
	 */
	public void setnum(String num) {
		this.num.set(num);
	}
	
	public StringProperty numProperty() 
	{
		return num;
	}

	/**
	 * @return the voie
	 */
	public String getVoie() {
		return voie.get();
	}

	/**
	 * @param voie the voie to set
	 */
	public void setVoie(String voie) {
		this.voie.set(voie);
	}
	
	public StringProperty voieProperty() 
	{
		return voie;
	}

	/**
	 * @return the cp
	 */
	public String getCP() {
		return cp.get();
	}

	/**
	 * @param CP the CP to set
	 */
	public void setCP(String cp) {
		this.cp.set(cp);
	}
	
	public StringProperty CPProperty() 
	{
		return cp;
	}
	
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville.get();
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville.set(ville);
	}
	
	public StringProperty villeProperty() 
	{
		return ville;
	}
	
	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays.get();
	}
	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays.set(pays);
	}
	
	public StringProperty paysProperty() 
	{
		return pays;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cp, id_client, nom, num, prenom, ville, voie);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientAff other = (ClientAff) obj;
		return Objects.equals(cp, other.cp) && Objects.equals(id_client, other.id_client)
				&& Objects.equals(nom, other.nom) && Objects.equals(num, other.num)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(ville, other.ville)
				&& Objects.equals(voie, other.voie);
	}



	


	

}
