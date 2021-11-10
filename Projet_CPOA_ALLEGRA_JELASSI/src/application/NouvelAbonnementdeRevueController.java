/**
 * 
 */
package application;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import dateConv.DateConv;
import factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import objets_metier.Abonnement;
import objets_metier.AbonnementAff;
import objets_metier.Client;

/**
 * @author natha
 *
 */
public class NouvelAbonnementdeRevueController {




@FXML
private Label id_revue;
@FXML
private TextField id_client;
@FXML
private DatePicker date_debut;
@FXML
private DatePicker date_fin;
@FXML
private Button btn_creer;

private Stage dialogStage;
private boolean okClicked = false;
private Abonnement abonnement;
private AbonnementAff abonnementA;
private boolean idClientSaisi = false;
private boolean dateDebutSaisie = false;
private boolean dateFinSaisie = false;


	public NouvelAbonnementdeRevueController() 
	{
		
	}
	
	public void initialize() throws SQLException 
	{
		btn_creer.setDisable(true);

	   	id_client.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.idClientSaisi = (NewValue != "");
	   	if (idClientSaisi && dateDebutSaisie && dateFinSaisie) {
	   		btn_creer.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_creer.setDisable(true);
	   		}
	   			
	   		});
	   	date_debut.valueProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.dateDebutSaisie = (NewValue != null);
	   	if (idClientSaisi && dateDebutSaisie && dateFinSaisie) {
	   		btn_creer.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_creer.setDisable(true);
	   		}
	   		});
	   	date_fin.valueProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.dateFinSaisie = (NewValue != null);
	   	if (idClientSaisi && dateDebutSaisie && dateFinSaisie) {
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
		id_revue.setText(String.valueOf(abonnement.id_revueProperty().getValue().intValue()));
	
		
	
	}
	
	@FXML
	private void handleCreer() throws ParseException 
	{
		//SolutionPersistance solPers = new SolutionPersistance();
		//DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		DAOFactory daos = DAOFactory.getDAOFactory(application.MainApp.getSolPers());		
		//Date date_deb1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_debut.getValue());
		//Date date_fin1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_fin.getValue());
		Date date_deb1 = DateConv.asDate(date_debut.getValue());
		Date date_fin1 = DateConv.asDate(date_fin.getValue());
		
		Client client = daos.getClientDAO().getById(Integer.parseInt(id_client.getText()));
		if (client != null) {
			abonnement = new Abonnement(date_deb1,date_fin1,Integer.parseInt(id_client.getText()),Integer.parseInt(id_revue.getText()));
			daos.getAbonnementDAO().create(abonnement);
			okClicked = true;
			this.dialogStage.close();
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Client inexistant !");
	        alert.setHeaderText("Ce client n'existe pas");
	        alert.setContentText("Indiquuez un autre client");
	        alert.showAndWait();
		}
	}

}
