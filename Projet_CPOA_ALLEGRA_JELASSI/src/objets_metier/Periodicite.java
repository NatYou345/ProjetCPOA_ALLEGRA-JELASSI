package objets_metier;

import java.util.Objects;

public class Periodicite {

	private int id_periodicite;
	private String libelle;

	public Periodicite(int id_periodicite, String libelle) {
		this.id_periodicite = id_periodicite;
		this.libelle = libelle;
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

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Periodicite [id_periodicite=" + id_periodicite + ", libelle=" + libelle + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_periodicite, libelle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periodicite other = (Periodicite) obj;
		return id_periodicite == other.id_periodicite && Objects.equals(libelle, other.libelle);
	}

}
