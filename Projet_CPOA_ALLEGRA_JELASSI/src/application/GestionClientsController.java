package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import factory.DAOFactory;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import objets_metier.Abonnement;
import objets_metier.AbonnementAff;
import objets_metier.Client;
import objets_metier.ClientAff;
import objets_metier.Revue;
import objets_metier.RevuePeriodicite;
import solutionPersistance.SolutionPersistance;



public class GestionClientsController {

@FXML
private TableView <ClientAff> listeClients;
@FXML
private TableColumn <ClientAff,String> listeClients_nom;
@FXML
private TableColumn <ClientAff,String> listeClients_prenom;
@FXML
private TableColumn <ClientAff,String> listeClients_ville;
@FXML
private Label lbl_clientNom;
@FXML
private Label lbl_clientPrenom;
@FXML
private Label lbl_clientNum;
@FXML
private Label lbl_clientVoie;
@FXML
private Label lbl_clientCP;
@FXML
private Label lbl_clientVille;
@FXML
private Label lbl_clientPays;
@FXML
private ObservableList<ClientAff> listeClientsAff = FXCollections.observableArrayList();
@FXML
private ObservableList<AbonnementAff> listeAbonnementsAff = FXCollections.observableArrayList();
@FXML
private Button btn_ajouter;
@FXML
private Button btn_modifier;
@FXML
private Button btn_supprimer;
@FXML
private TableView <AbonnementAff> listeAbos ;
@FXML
private TableColumn <AbonnementAff,String> listeAbos_titre;
@FXML
private TableColumn <AbonnementAff,String> listeAbos_periodicite;
@FXML
private TableColumn <AbonnementAff,LocalDate> listeAbos_date_debut;
@FXML
private TableColumn <AbonnementAff,LocalDate> listeAbos_date_fin;
@FXML
private TableColumn <AbonnementAff,String> listeAbos_id_abo;
@FXML
private Button btn_ajouterAbo;
@FXML
private Button btn_modifierAbo;
@FXML
private Button btn_supprimerAbo;



private ClientAff clientSelected;
private AbonnementAff abonnementSelected;


public ObservableList<ClientAff> getListeClients() 
{
	return listeClientsAff;
}
public ObservableList<AbonnementAff> getListeAbonnements() 
{
	return listeAbonnementsAff;
}

	
	public GestionClientsController() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize() throws SQLException, ParseException 
	{
		initListeClients();
	   	afficherClientDetails(null);
	   	listeClients.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			try {
				afficherClientDetails(newValue);
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	   	listeAbos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	   		this.abonnementSelected = newValue;
		});
	   	
	}
	public void initListeClients() throws SQLException {
		listeClients.getItems().clear();
		SolutionPersistance solPers = new SolutionPersistance();
		DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		listeClients_nom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		listeClients_prenom.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
		listeClients_ville.setCellValueFactory(cellData -> cellData.getValue().villeProperty());
		
	   	ArrayList<ClientAff> listeClientAff = daos.getClientDAO().findAllAff();
	   	Iterator<ClientAff> itr = listeClientAff.iterator();
	   	while (itr.hasNext())
	   	{
	   		ClientAff obj = itr.next();
	   		//System.out.println("Client : " + obj.getCP() + " "+ obj.getVille() + " " + obj.getPays());
	   		listeClientsAff.add(obj);
	   	}
	   	listeClients.setItems(getListeClients());
	}
	
	private void afficherClientDetails(ClientAff client) throws SQLException, ParseException {
		this.clientSelected = client;
		
	    if (client != null) {
	        lbl_clientNom.setText(client.getNom());
	        lbl_clientPrenom.setText(client.getPrenom());
	        lbl_clientNum.setText(client.getNum());
	        lbl_clientVoie.setText(client.getVoie());
	        lbl_clientCP.setText(client.getCP());
	        lbl_clientVille.setText(client.getVille());
	        lbl_clientPays.setText(client.getPays());
	        
	        this.initListeAbonnement(client);

	    } else {
	    	lbl_clientNom.setText("");
	    	lbl_clientPrenom.setText("");
	    	lbl_clientNum.setText("");
	    	lbl_clientVoie.setText("");
	    	lbl_clientCP.setText("");
	        lbl_clientVille.setText("");
	        lbl_clientPays.setText("");

	    }
	}

	public void initListeAbonnement(ClientAff clientAff) throws SQLException, ParseException {
		listeAbos.getItems().clear();
		SolutionPersistance solPers = new SolutionPersistance();
		DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		
		listeAbos_titre.setCellValueFactory(cellData -> cellData.getValue().getRevuePeriodicite().titreProperty());
		listeAbos_periodicite.setCellValueFactory(cellData -> cellData.getValue().getRevuePeriodicite().libelle_periodiciteProperty());

		
		//listeAbos_id_abo.setCellValueFactory(cellData -> String.valueOf(cellData.getValue().getId_abonnementProperty()));

		listeAbos_date_debut.setCellValueFactory(cellData -> cellData.getValue().date_debutProperty());
		listeAbos_date_fin.setCellValueFactory(cellData -> cellData.getValue().date_finProperty());
		
	   	ArrayList<AbonnementAff> listeAbonnementAff = daos.getAbonnementDAO().findAllDetailsByClient(clientAff);
	   	System.out.println("Abos : " + listeAbonnementAff);
	   	Iterator<AbonnementAff> itr = listeAbonnementAff.iterator();
	   	
	   	while (itr.hasNext())
	   	{
	   		AbonnementAff obj = itr.next();
	   		System.out.println("Abos : " + obj);
	   		// Recherche detail revue
	   		
	   		RevuePeriodicite revueP = daos.getRevueDAO().getRPById(obj.id_revueProperty().getValue().intValue());
	   		
	   		obj.setRevuePeriodicite(revueP);
	   		listeAbonnementsAff.add(obj);
	   	}
	   	listeAbos.setItems(getListeAbonnements());
	}
	
	
	@FXML
	private void supprimerClient() 
	{
		int SelectedIndex = listeClients.getSelectionModel().getSelectedIndex();
		if (SelectedIndex >=0) 
		{
			SolutionPersistance solPers = new SolutionPersistance();
			DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
			Client obj = new Client(this.clientSelected.getId_client());
			daos.getClientDAO().delete(obj);
			listeClients.getItems().remove(SelectedIndex);
			
		}
		else 
		{
			Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Pas de client sélectionné !");
	        alert.setHeaderText("Pas de client sélectionné");
	        alert.setContentText("Sélectionnez un client dans la liste.");

	        alert.showAndWait();
		}
	}
	
	public boolean ClientEditDialogue(ClientAff clientA) 
	{
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("ModifierClient.fxml"));
	        VBox vbox = (VBox) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Modification d'un client");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(vbox);
	        dialogStage.setScene(scene);

	        ModifierClientController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setClientAff(clientA);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }

	}

	public boolean ClientCreerDialogue(ClientAff clientA) 
	{
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("NouveauClient.fxml"));
	        VBox vbox = (VBox) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Création d'un client");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(vbox);
	        dialogStage.setScene(scene);

	        NouveauClientController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        //controller.setClientAff(clientA);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@FXML
	private void handleNouveauClient() throws SQLException 
	{
		ClientAff tempCA = new ClientAff();
		boolean okClicked = ClientCreerDialogue(tempCA);
		if (okClicked) 
		{
			initListeClients();
		}
	}
	
	@FXML
	private void handleModifierClient() throws SQLException, ParseException {
	    ClientAff selectedClient = listeClients.getSelectionModel().getSelectedItem();
	    if (selectedClient != null) {
	    	
	        boolean okClicked = ClientEditDialogue(selectedClient);
	        if (okClicked) {
	            afficherClientDetails(selectedClient);
	            initListeClients();
	        }

	    } else {
	        
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Aucun client sélectionné");
	        alert.setHeaderText("Aucun client sélectionné");
	        alert.setContentText("Sélectionnez un client dans la liste.");

	        alert.showAndWait();
	    }
	}
	
	public boolean AbonnementCreerDialogue(Abonnement abonnement) 
	{
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("NouvelAbonnement.fxml"));
	        VBox vbox = (VBox) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Création d'un abonnement");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(vbox);
	        dialogStage.setScene(scene);

	        NouvelAbonnementController controller = loader.getController();

	        controller.setDialogStage(dialogStage);
	        System.out.println("ID client avant nouvel abo : "+clientSelected.getId_client());
	        AbonnementAff aboAff = new AbonnementAff(clientSelected.getId_client());
	        
	        controller.setAbonnement(aboAff);
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public boolean AbonnementEditDialogue(AbonnementAff abonnement) 
	{
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("ModifierAbonnement.fxml"));
	        VBox vbox = (VBox) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Modification d'un abonnement");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(vbox);
	        dialogStage.setScene(scene);

	        ModifierAbonnementController controller = loader.getController();

	        controller.setDialogStage(dialogStage);
	        
	        AbonnementAff aboAff = new AbonnementAff(clientSelected.getId_client());
	        
	        controller.setAbonnement(abonnementSelected);
	        
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@FXML
	private void handleNouvelAbonnement() throws SQLException, ParseException 
	{
		Abonnement tempA = new Abonnement();
		boolean okClicked = AbonnementCreerDialogue(tempA);
		if (okClicked) 
		{
			initListeAbonnement(clientSelected);
		}
	}
	
	@FXML
	private void handleModifierAbonnement() throws SQLException, ParseException {
	    ClientAff selectedClient = listeClients.getSelectionModel().getSelectedItem();
	    if (selectedClient != null) {
	    	
	        boolean okClicked = AbonnementEditDialogue(abonnementSelected);
	        if (okClicked) {
	            afficherClientDetails(selectedClient);
	            initListeClients();
	        }

	    } else {
	        
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Aucun abonnement sélectionné");
	        alert.setHeaderText("Aucun abonnement sélectionné");
	        alert.setContentText("Sélectionnez un abonnement dans la liste.");

	        alert.showAndWait();
	    }
	}
	
	@FXML
	private void supprimerAbonnement() throws ParseException 
	{
		int SelectedIndex = listeAbos.getSelectionModel().getSelectedIndex();
		if (SelectedIndex >=0) 
		{
			SolutionPersistance solPers = new SolutionPersistance();
			DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
			Abonnement obj = new Abonnement(this.abonnementSelected.id_abonnementProperty().getValue().intValue());
			System.out.println("Abo à supprimer : " + this.abonnementSelected.id_abonnementProperty());
			daos.getAbonnementDAO().delete(obj);
			listeAbos.getItems().remove(SelectedIndex);
			
		}
		else 
		{
			Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Pas d'abonnement sélectionné !");
	        alert.setHeaderText("Pas d'abonnement sélectionné");
	        alert.setContentText("Sélectionnez un abonnement dans la liste.");

	        alert.showAndWait();
		}
	}
	
}

