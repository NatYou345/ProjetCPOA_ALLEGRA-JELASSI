
package objets_metier;

import java.util.Objects;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class RevuePeriodicite {

	private IntegerProperty id_revue;
	private StringProperty titre;
	private StringProperty description;
	private StringProperty tarif_numero;
	private StringProperty visuel;
	private IntegerProperty id_periodicite;
	private StringProperty libelle_periodicite;
	
	public RevuePeriodicite() {
		this.id_revue = new SimpleIntegerProperty(-1);
		this.titre = new SimpleStringProperty("");
		this.description = new SimpleStringProperty("");
		this.tarif_numero = new SimpleStringProperty("");
		//this.visuel = visuel;
		this.id_periodicite = new SimpleIntegerProperty(-1);
		this.libelle_periodicite = new SimpleStringProperty("");
		
	}
	
	
	public RevuePeriodicite(int i, String titre, String description, String tarif_numero, int periodicite, String libelle) {
		this.id_revue = new SimpleIntegerProperty(i);
		this.titre = new SimpleStringProperty(titre);
		this.description = new SimpleStringProperty(description);
		this.tarif_numero = new SimpleStringProperty(tarif_numero);
		//this.visuel = visuel;
		this.id_periodicite = new SimpleIntegerProperty(periodicite);
		this.libelle_periodicite = new SimpleStringProperty(libelle);
	}


	@Override
	public String toString() {
		return "Revue [id_revue=" + id_revue + ", titre=" + titre + ", description=" + description + ", tarif_numero="
				+ tarif_numero + ", visuel=" + visuel + ", id_periodicite=" + id_periodicite + ", lib_periodicite=" + libelle_periodicite + "]";
	}

	/**
	 * @return the id_revue
	 */
	public int getId_revue() {
		return id_revue.get();
	}

	/**
	 * @param id_revue the id_revue to set
	 */
	public void setId_revue(int id_revue) {
		this.id_revue.set(id_revue);
	}
	
	public IntegerProperty id_revueProperty() 
	{
		return id_revue;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre.get();
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre.set(titre);
	}
	
	public StringProperty titreProperty() 
	{
		return titre;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description.get();
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description.set(description);
	}
	
	public StringProperty descriptionProperty() 
	{
		return description;
	}

	/**
	 * @return the tarif_numero
	 */
	public String getTarif_numero() {
		return tarif_numero.get();
	}

	/**
	 * @param tarif_numero the tarif_numero to set
	 */
	public void setTarif_numero(String tarif_numero) {
		this.tarif_numero.set(tarif_numero);
	}
	
	public StringProperty tarif_numeroProperty() 
	{
		return tarif_numero;
	}

	/**
	 * @return the visuel
	 */
	public String getVisuel() {
		return visuel.get();
	}

	/**
	 * @param visuel the visuel to set
	 */
	public void setVisuel(String visuel) {
		this.visuel.set(visuel);;
	}
	
	public StringProperty visuelProperty() 
	{
		return visuel;
	}

	/**
	 * @return the id_periodicite
	 */
	public int getId_periodicite() {
		return id_periodicite.get();
	}

	/**
	 * @param Id_periodicite the Id_periodicite to set
	 */
	public void setId_periodicite(int id_periodicite) {
		this.id_periodicite.set(id_periodicite);
	}
	
	public IntegerProperty id_periodiciteProperty() 
	{
		return id_periodicite;
	}
	
	/**
	 * @return the libelle_periodicite
	 */
	public String getlibelle_periodicite() {
		return libelle_periodicite.get();
	}

	/**
	 * @param libelle_periodicite the libelle_periodicite to set
	 */
	public void setlibelle_periodicite(String libelle_periodicite) {
		this.libelle_periodicite.set(libelle_periodicite);
	}
	
	public StringProperty libelle_periodiciteProperty() 
	{
		return libelle_periodicite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id_periodicite, id_revue, libelle_periodicite, tarif_numero, titre, visuel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RevuePeriodicite other = (RevuePeriodicite) obj;
		return Objects.equals(description, other.description) && Objects.equals(id_periodicite, other.id_periodicite)
				&& Objects.equals(id_revue, other.id_revue)
				&& Objects.equals(libelle_periodicite, other.libelle_periodicite)
				&& Objects.equals(tarif_numero, other.tarif_numero) && Objects.equals(titre, other.titre)
				&& Objects.equals(visuel, other.visuel);
	}

	

}
