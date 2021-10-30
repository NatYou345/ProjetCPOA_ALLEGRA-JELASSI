/**
 * 
 */
package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import objets_metier.Periodicite;
import objets_metier.Revue;
import solutionPersistance.SolutionPersistance;

/**
 * @author natha
 *
 */
public class NouvelleRevueController {



@FXML
private TextField titre;
@FXML
private TextField description;
@FXML
private TextField tarif_numero;
@FXML
private TextField visuel;
@FXML
private ComboBox<String> id_periodicite;

private Revue revue;


	public NouvelleRevueController() 
	{
		
	}
	
	public void initialize() throws SQLException 
	{
		SolutionPersistance solPers = new SolutionPersistance();
		DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
	   	ArrayList<Periodicite> listePeriodicite = daos.getPeriodiciteDAO().findAll();
	   	Iterator<Periodicite> itr = listePeriodicite.iterator();
	   	while (itr.hasNext()) 
	   	{
	   		Periodicite p = itr.next();
	   		id_periodicite.getItems().add(p.getLibelle());
	   		
	   	}
	}

	public void setRevue(Revue revue) 
	{
		this.revue = revue;
		
		titre.setText(revue.getTitre());
		titre.setText(revue.getDescription());

		
		
	}
	
	@FXML
	private void handleCreer() 
	{
		SolutionPersistance solPers = new SolutionPersistance();
		DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		revue = new Revue();
		revue.setTitre(titre.getText());
		revue.setDescription(description.getText());
		revue.setTarif_numero(Float.parseFloat(tarif_numero.getText()));
		int resIDPeriodicite = daos.getPeriodiciteDAO().getByLibelle(id_periodicite.getValue());
		revue.setId_periodicite(resIDPeriodicite);	
	   	daos.getRevueDAO().create(revue);
	}

}
