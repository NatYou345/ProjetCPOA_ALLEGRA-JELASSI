/**
 * 
 */
package application;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import dateConv.DateConv;
import factory.DAOFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import objets_metier.Abonnement;
import objets_metier.AbonnementAff;
import objets_metier.Revue;

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
private ComboBox<String> revue_titre;
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
private boolean idRevueSaisi = false;
private boolean dateDebutSaisie = false;
private boolean dateFinSaisie = false;


	public NouvelAbonnementController() 
	{
		
	}
	
	public void initialize() throws SQLException 
	{
		btn_creer.setDisable(true);

		//SolutionPersistance solPers = new SolutionPersistance();
		//DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		DAOFactory daos = DAOFactory.getDAOFactory(application.MainApp.getSolPers());	   	ArrayList<Revue> listeRevue = daos.getRevueDAO().findAll();
	   	Iterator<Revue> itr = listeRevue.iterator();
	   	while (itr.hasNext()) 
	   	{
	   		Revue r = itr.next();
	   		revue_titre.getItems().add(r.getTitre());
	   		
	   	}		

	   	revue_titre.valueProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.idRevueSaisi = (NewValue != "");
	   	if (idRevueSaisi && dateDebutSaisie && dateFinSaisie) {
	   		btn_creer.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_creer.setDisable(true);
	   		}
	   			
	   		});
	   	date_debut.valueProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.dateDebutSaisie = (NewValue != null);
	   	if (idRevueSaisi && dateDebutSaisie && dateFinSaisie) {
	   		btn_creer.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_creer.setDisable(true);
	   		}
	   		});
	   	date_fin.valueProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.dateFinSaisie = (NewValue != null);
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
		revue_titre.setValue("");

	}
	
	@FXML
	private void handleCreer() throws ParseException 
	{
		//SolutionPersistance solPers = new SolutionPersistance();
		//DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		DAOFactory daos = DAOFactory.getDAOFactory(application.MainApp.getSolPers());		
		Date date_deb1 = DateConv.asDate(date_debut.getValue());
		Date date_fin1 = DateConv.asDate(date_fin.getValue());
		//Date date_fin1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_fin.getText());
		
		int resIDRevue = daos.getRevueDAO().getByLibelle(revue_titre.getValue());
		
		abonnement = new Abonnement(date_deb1,date_fin1,Integer.parseInt(id_client.getText()),resIDRevue);

	   	daos.getAbonnementDAO().create(abonnement);
	   	okClicked = true;
	   	this.dialogStage.close();
	}

}
