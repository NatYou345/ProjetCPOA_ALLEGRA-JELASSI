/**
 * 
 */
package application;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import objets_metier.Abonnement;
import objets_metier.AbonnementAff;
import solutionPersistance.SolutionPersistance;

/**
 * @author natha
 *
 */
public class NouvelAbonnementController {




@FXML
private Label id_client;
@FXML
private TextField id_revue;
@FXML
private TextField date_debut;
@FXML
private TextField date_fin;
@FXML
private Button btn_creer;

private Stage dialogStage;
private boolean okClicked = false;
private Abonnement abonnement;
private AbonnementAff abonnementA;
private boolean idRevueSaisi = false;
private boolean dateDebutSaisie = false;
private boolean dateFinSaisie = false;


	public NouvelAbonnementController() 
	{
		
	}
	
	public void initialize() throws SQLException 
	{
		btn_creer.setDisable(true);

	   	id_revue.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.idRevueSaisi = (NewValue != "");
	   	if (idRevueSaisi && dateDebutSaisie && dateFinSaisie) {
	   		btn_creer.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_creer.setDisable(true);
	   		}
	   			
	   		});
	   	date_debut.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.dateDebutSaisie = (NewValue != "");
	   	if (idRevueSaisi && dateDebutSaisie && dateFinSaisie) {
	   		btn_creer.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_creer.setDisable(true);
	   		}
	   		});
	   	date_fin.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.dateFinSaisie = (NewValue != "");
	   	if (idRevueSaisi && dateDebutSaisie && dateFinSaisie) {
	   		btn_creer.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_creer.setDisable(true);
	   		}
	   		});
	}
	

	
	public void setDialogStage (Stage dialogStage) 
	{
		this.dialogStage = dialogStage;
	}
	
	public boolean isOkClicked() 
	{
		return okClicked;
	}
	
	public void setAbonnement(AbonnementAff abonnement) 
	{
		this.abonnementA = abonnement;
		id_client.setText(String.valueOf(abonnement.id_clientProperty().getValue().intValue()));
	
		
	
	}
	
	@FXML
	private void handleCreer() throws ParseException 
	{
		SolutionPersistance solPers = new SolutionPersistance();
		DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		
		Date date_deb1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_debut.getText());
		Date date_fin1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_fin.getText());
		
		abonnement = new Abonnement(date_deb1,date_fin1,Integer.parseInt(id_client.getText()),Integer.parseInt(id_revue.getText()));
		System.out.println("Abo à créer: "+ abonnement.toString());

	   	daos.getAbonnementDAO().create(abonnement);
	   	okClicked = true;
	}

}
