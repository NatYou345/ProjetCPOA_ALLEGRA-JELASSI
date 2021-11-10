/**
 * 
 */
package application;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import dateConv.DateConv;
import factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import objets_metier.Abonnement;
import objets_metier.AbonnementAff;

/**
 * @author natha
 *
 */
public class ModifierAbonnementdeRevueController {



@FXML
private Label id_abo;
@FXML
private Label id_revue;
@FXML
private Label id_client;
@FXML
private DatePicker date_debut;
@FXML
private DatePicker date_fin;
@FXML
private Button btn_modifier;

private Stage dialogStage;
private boolean okClicked = false;
private Abonnement abonnement;
private AbonnementAff abonnementA;
private boolean idRevueSaisi = false;
private boolean dateDebutSaisie = false;
private boolean dateFinSaisie = false;


	public ModifierAbonnementdeRevueController() 
	{
		
	}
	
	public void initialize() throws SQLException 
	{
		btn_modifier.setDisable(true);

	   	
	   	date_debut.valueProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.dateDebutSaisie = (NewValue != null);
	   	if (dateDebutSaisie && dateFinSaisie) {
	   		btn_modifier.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_modifier.setDisable(true);
	   		}
	   		});
	   	date_fin.valueProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.dateFinSaisie = (NewValue != null);
	   	if (dateDebutSaisie && dateFinSaisie) {
	   		btn_modifier.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_modifier.setDisable(true);
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
		id_abo.setText(String.valueOf(abonnement.id_abonnementProperty().getValue().intValue()));
		
		id_client.setText(String.valueOf(abonnement.id_clientProperty().getValue().intValue()));
		id_revue.setText(String.valueOf(abonnement.id_revueProperty().getValue().intValue()));


		LocalDate localDate1 = abonnement.date_debutProperty().getValue();
        //DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date_debut.setValue(localDate1); //.format(dateFormatter1));
        
        LocalDate localDate2 = abonnement.date_finProperty().getValue();
        //DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date_fin.setValue(localDate2); //.format(dateFormatter2));

	}
	
	@FXML
	private void handleModifier() throws ParseException 
	{
		//SolutionPersistance solPers = new SolutionPersistance();
		//DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		DAOFactory daos = DAOFactory.getDAOFactory(application.MainApp.getSolPers());		
		//Date date_deb1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_debut.getValue());
		//Date date_fin1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_fin.getValue());
		Date date_deb1 = DateConv.asDate(date_debut.getValue());
		Date date_fin1 = DateConv.asDate(date_fin.getValue());
		
		abonnement = new Abonnement(Integer.parseInt(id_abo.getText()),date_deb1,date_fin1,Integer.parseInt(id_client.getText()),Integer.parseInt(id_revue.getText()));
	   	daos.getAbonnementDAO().update(abonnement);
	   	okClicked = true;
	   	this.dialogStage.close();
	}

}
