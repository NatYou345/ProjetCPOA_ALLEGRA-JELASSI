/**
 * 
 */
package objets_metier;

import java.util.Objects;

public class Client {
	
	/**
	 * @param id_client
	 * @param nom
	 * @param prenom
	 * @param no_rue
	 * @param voie
	 * @param code_postal
	 * @param ville
	 * @param pays
	 */
	public Client(int id_client, String nom, String prenom, String no_rue, String voie, String code_postal,
			String ville, String pays) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.no_rue = no_rue;
		this.voie = voie;
		this.code_postal = code_postal;
		this.ville = ville;
		this.pays = pays;
	}

	private int id_client;
	private String nom;
	private String prenom;
	private String no_rue;
	private String voie;
	private String code_postal;
	private String ville;
	private String pays;
	
	
	
	
	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", nom=" + nom + ", prenom=" + prenom + ", no_rue=" + no_rue
				+ ", voie=" + voie + ", code_postal=" + code_postal + ", ville=" + ville+ ", pays=" + pays + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the no_rue
	 */
	public String getNo_rue() {
		return no_rue;
	}

	/**
	 * @param no_rue the no_rue to set
	 */
	public void setNo_rue(String no_rue) {
		this.no_rue = no_rue;
	}

	/**
	 * @return the voie
	 */
	public String getVoie() {
		return voie;
	}

	/**
	 * @param voie the voie to set
	 */
	public void setVoie(String voie) {
		this.voie = voie;
	}

	/**
	 * @return the code_postal
	 */
	public String getCode_postal() {
		return code_postal;
	}

	/**
	 * @param code_postal the code_postal to set
	 */
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param code_postal the code_postal to set
	 */
	public void setVille(String ville) {
		this.code_postal = ville;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code_postal, id_client, no_rue, nom, pays, prenom, ville, voie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(code_postal, other.code_postal) && id_client == other.id_client
				&& Objects.equals(no_rue, other.no_rue) && Objects.equals(nom, other.nom)
				&& Objects.equals(pays, other.pays) && Objects.equals(prenom, other.prenom)
				&& Objects.equals(ville, other.ville) && Objects.equals(voie, other.voie);
	}

}
