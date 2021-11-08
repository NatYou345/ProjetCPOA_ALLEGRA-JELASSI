/**
 * 
 */
package application;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import objets_metier.Abonnement;
import objets_metier.AbonnementAff;
import objets_metier.Client;
import objets_metier.ClientAff;
import solutionPersistance.SolutionPersistance;

/**
 * @author natha
 *
 */
public class ModifierAbonnementController {



@FXML
private Label id_abo;
@FXML
private Label id_client;
@FXML
private TextField id_revue;
@FXML
private TextField date_debut;
@FXML
private TextField date_fin;
@FXML
private Button btn_modifier;

private Stage dialogStage;
private boolean okClicked = false;
private Abonnement abonnement;
private AbonnementAff abonnementA;
private boolean idRevueSaisi = false;
private boolean dateDebutSaisie = false;
private boolean dateFinSaisie = false;


	public ModifierAbonnementController() 
	{
		
	}
	
	public void initialize() throws SQLException 
	{
		btn_modifier.setDisable(true);

	   	id_revue.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.idRevueSaisi = (NewValue != "");
	   	if (idRevueSaisi && dateDebutSaisie && dateFinSaisie) {
	   		btn_modifier.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_modifier.setDisable(true);
	   		}
	   			
	   		});
	   	date_debut.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.dateDebutSaisie = (NewValue != "");
	   	if (idRevueSaisi && dateDebutSaisie && dateFinSaisie) {
	   		btn_modifier.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_modifier.setDisable(true);
	   		}
	   		});
	   	date_fin.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.dateFinSaisie = (NewValue != "");
	   	if (idRevueSaisi && dateDebutSaisie && dateFinSaisie) {
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
        DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date_debut.setText(localDate1.format(dateFormatter1));
        
        LocalDate localDate2 = abonnement.date_finProperty().getValue();
        DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date_fin.setText(localDate2.format(dateFormatter2));

	}
	
	@FXML
	private void handleModifier() throws ParseException 
	{
		SolutionPersistance solPers = new SolutionPersistance();
		DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		
		Date date_deb1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_debut.getText());
		Date date_fin1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_fin.getText());
		
		abonnement = new Abonnement(Integer.parseInt(id_abo.getText()),date_deb1,date_fin1,Integer.parseInt(id_client.getText()),Integer.parseInt(id_revue.getText()));
		System.out.println("Abo à modifier: "+ abonnement.toString());

	   	daos.getAbonnementDAO().update(abonnement);
	   	okClicked = true;
	}

}
