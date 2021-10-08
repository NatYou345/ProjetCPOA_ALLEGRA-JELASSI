package objets_métier;

public class Periodicite {
	
	public Periodicite(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Periodicite [id_periodicite=" + id_periodicite + ", libelle=" + libelle + "]";
	}

	private int id_periodicite;
	private String libelle;

	public Périodicité() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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



}
