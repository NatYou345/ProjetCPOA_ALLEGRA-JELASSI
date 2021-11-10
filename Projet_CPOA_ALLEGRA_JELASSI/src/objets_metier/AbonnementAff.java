/**Classe Abonnement 
 * 
 */
package objets_metier;

import java.time.LocalDate;
import java.util.Objects;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class AbonnementAff {
	
	private IntegerProperty id_abonnement;
	private ObjectProperty<LocalDate> date_debut;
	private ObjectProperty<LocalDate> date_fin;
	private IntegerProperty id_client;
	private IntegerProperty id_revue;
	private RevuePeriodicite revuePeriodicite;
	private ClientAff clientAff;
	
	
	
	public AbonnementAff(int id, LocalDate date_deb, LocalDate date_fin, int id_client, int id_revue) {
		this.id_abonnement = new SimpleIntegerProperty(id);
		this.date_debut = new SimpleObjectProperty<LocalDate> (date_deb);
		this.date_fin = new SimpleObjectProperty<LocalDate> (date_fin);
		this.id_client = new SimpleIntegerProperty(id_client);
		this.id_revue = new SimpleIntegerProperty(id_revue);
	}
	public AbonnementAff(int id) {
		this.id_client = new SimpleIntegerProperty(id);
	
	}
	
	public AbonnementAff() {
		super();
	}
	
	public void setId_abonnement(int id_abonnement) {
		this.id_abonnement.set(id_abonnement);
	}
	
	public int getId_abonnementProperty() 
	{
		return id_abonnement.get();
	}
	
		
	public IntegerProperty id_abonnementProperty() 
	{
		return id_abonnement;
	}
	
	public void setDate_debut(LocalDate date_debut) {
		this.date_debut.set(date_debut);
	}
	
	public ObjectProperty<LocalDate> date_debutProperty() 
	{
		return date_debut;
	}
	public void setDate_fin(LocalDate date_fin) {
		this.date_fin.set(date_fin);
	}
	
	public ObjectProperty<LocalDate> date_finProperty() 
	{
		return date_fin;
	}
	
	public void setId_revue(int id_revue) {
		this.id_revue = new SimpleIntegerProperty(id_revue);
	}

	public IntegerProperty id_revueProperty() 
	{
		return id_revue;
	}
	
	public void setId_client(int id_client) {
		this.id_client.set(id_client);
	}
	
	public IntegerProperty id_clientProperty() 
	{
		return id_client;
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
		AbonnementAff other = (AbonnementAff) obj;
		return Objects.equals(date_debut, other.date_debut) && Objects.equals(date_fin, other.date_fin)
				&& id_abonnement == other.id_abonnement && id_client == other.id_client && id_revue == other.id_revue;
	}
	public RevuePeriodicite getRevuePeriodicite() {
		return revuePeriodicite;
	}
	public void setRevuePeriodicite(RevuePeriodicite revuePeriodicite) {
		this.revuePeriodicite = revuePeriodicite;
	}
	public ClientAff getClientAff() {
		return clientAff;
	}
	public void setClientAff(ClientAff clientAff) {
		this.clientAff = clientAff;
	}
}
