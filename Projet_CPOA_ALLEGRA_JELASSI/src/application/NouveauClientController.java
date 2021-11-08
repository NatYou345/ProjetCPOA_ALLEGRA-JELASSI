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
import javafx.stage.Stage;
import objets_metier.Client;
import objets_metier.ClientAff;
import solutionPersistance.SolutionPersistance;

/**
 * @author natha
 *
 */
public class NouveauClientController {




@FXML
private Label id;
@FXML
private TextField nom;
@FXML
private TextField prenom;
@FXML
private TextField num;
@FXML
private TextField voie;
@FXML
private TextField cp;
@FXML
private TextField ville;
@FXML
private TextField pays;


@FXML
private Button btn_creer;

private Stage dialogStage;
private boolean okClicked = false;
private Client client;
private ClientAff clientA;
private boolean nomSaisi = false;
private boolean prenomSaisi = false;
private boolean villeSaisie = false;


	public NouveauClientController() 
	{
		
	}
	
	public void initialize() throws SQLException 
	{
		btn_creer.setDisable(true);

	   	nom.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.nomSaisi = (NewValue != "");
	   	if (nomSaisi && prenomSaisi && villeSaisie) {
	   		btn_creer.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_creer.setDisable(true);
	   		}
	   			
	   		});
	   	prenom.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.prenomSaisi = (NewValue != "");
	   	if (nomSaisi && prenomSaisi && villeSaisie) {
	   		btn_creer.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_creer.setDisable(true);
	   		}
	   		});
	   	ville.textProperty().addListener((Observable,OldValue,NewValue)->
	   	{this.villeSaisie = (NewValue != "");
	   	if (nomSaisi && prenomSaisi && villeSaisie) {
	   		btn_creer.setDisable(false);
	   	}
	   	else 
	   		{
	   		btn_creer.setDisable(true);
	   		}
	   		});
	}
	
	public void setClientAff(ClientAff clientA) 
	{
		this.clientA = clientA;
		id.setText(String.valueOf(clientA.getId_client()));
		nom.setText(clientA.getNom());
		prenom.setText(clientA.getPrenom());
		num.setText(String.valueOf(clientA.getNum()));
		ville.setText(clientA.getVille());
	
	}
	
	public void setDialogStage (Stage dialogStage) 
	{
		this.dialogStage = dialogStage;
	}
	
	public boolean isOkClicked() 
	{
		return okClicked;
	}
	
	@FXML
	private void handleCreer() 
	{
		SolutionPersistance solPers = new SolutionPersistance();
		DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		client = new Client(nom.getText(),prenom.getText(),num.getText(),voie.getText(),cp.getText(),ville.getText(),pays.getText());
		System.out.println("Client � cr�er: "+ client.toString());

	   	daos.getClientDAO().create(client);
	   	okClicked = true;
	}

}
