/**
 * 
 */
package objets_metier;

import java.util.Objects;


public class Revue {

	private int id_revue;
	private String titre;
	private String description;
	private float tarif_numero;
	private String visuel;
	private int id_periodicite;
	
	public Revue() {
		
	}
	
	public Revue (int i) 
	{
		this.id_revue = i;
	}
	public Revue(int i, String titre, String description, float tarif_numero2, String visuel, int periodicite) {
		this.id_revue = i;
		this.titre = titre;
		this.description = description;
		this.tarif_numero = tarif_numero2;
		this.visuel = visuel;
		this.id_periodicite = periodicite;
	}


	public Revue(int id_revue, String titre) {
		this.id_revue = id_revue;
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Revue [id_revue=" + id_revue + ", titre=" + titre + ", description=" + description + ", tarif_numero="
				+ tarif_numero + ", visuel=" + visuel + ", id_periodicite=" + id_periodicite + "]";
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

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the tarif_numero
	 */
	public float getTarif_numero() {
		return tarif_numero;
	}

	/**
	 * @param tarif_numero the tarif_numero to set
	 */
	public void setTarif_numero(float tarif_numero) {
		this.tarif_numero = tarif_numero;
	}

	/**
	 * @return the visuel
	 */
	public String getVisuel() {
		return visuel;
	}

	/**
	 * @param visuel the visuel to set
	 */
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}

	/**
	 * @return the id_periodicite
	 */
	public int getId_periodicite() {
		return id_periodicite;
	}

	/**
	 * @param id_periodicite the id_periodicite to set
	 */
	public void setId_periodicite(int id_periodicite) {
		this.id_periodicite = id_periodicite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id_periodicite, id_revue, tarif_numero, titre, visuel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revue other = (Revue) obj;
		return Objects.equals(description, other.description) && id_periodicite == other.id_periodicite
				&& id_revue == other.id_revue
				&& Float.floatToIntBits(tarif_numero) == Float.floatToIntBits(other.tarif_numero)
				&& Objects.equals(titre, other.titre) && Objects.equals(visuel, other.visuel);
	}

}
