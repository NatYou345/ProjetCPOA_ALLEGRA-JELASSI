package objets_metier;

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

}