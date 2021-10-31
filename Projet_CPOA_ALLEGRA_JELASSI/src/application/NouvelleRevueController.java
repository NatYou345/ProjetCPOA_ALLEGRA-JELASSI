/**
 * 
 */
package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
@FXML
private Label lbl_saisie;
@FXML
private Button btn_creer;

private Revue revue;
private boolean titreSaisi = false;
private boolean tarifSaisi = false;
private boolean periodiciteSaisie = false;

	public NouvelleRevueController() 
	{
		
	}
	
	public void initialize() throws SQLException 
	{
		btn_creer.setDisable(true);
		SolutionPersistance solPers = new SolutionPersistance();
		DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
	   	ArrayList<Periodicite> listePeriodicite = daos.getPeriodiciteDAO().findAll();
	   	Iterator<Periodicite> itr = listePeriodicite.iterator();
	   	while (itr.hasNext()) 
	   	{
	   		Periodicite p = itr.next();
	   		id_periodicite.getItems().add(p.getLibelle());
	   		
	   	}
	   	titre.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.titreSaisi = (NewValue != "");
	   	if (titreSaisi && tarifSaisi && periodiciteSaisie) {
	   		btn_creer.setDisable(false);
	   		lbl_saisie.setText(titre.getText()+" ("+ tarif_numero.getText().trim() + " �)");
	   	}
	   	else 
	   		{
	   			lbl_saisie.setText("");
	   			btn_creer.setDisable(true);
	   		}
	   			
	   	
	   		});
	   	tarif_numero.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.tarifSaisi = (NewValue != "");
	   	if (titreSaisi && tarifSaisi && periodiciteSaisie) {
	   		btn_creer.setDisable(false);
	   		lbl_saisie.setText(titre.getText()+" ("+ tarif_numero.getText().trim() + " �)");
	   	}
	   	else 
	   		{
	   			lbl_saisie.setText("");
	   			btn_creer.setDisable(true);
	   		}
	   		});
	   	id_periodicite.valueProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.periodiciteSaisie = (NewValue != "");
	   	if (titreSaisi && tarifSaisi && periodiciteSaisie) {
	   		btn_creer.setDisable(false);
	   		lbl_saisie.setText(titre.getText()+" ("+ tarif_numero.getText().trim() + " �)");
	   	}
	   	else 
	   		{
	   			lbl_saisie.setText("");
	   			btn_creer.setDisable(true);
	   		}
	   		});
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
