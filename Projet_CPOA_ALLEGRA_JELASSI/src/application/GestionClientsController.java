package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import factory.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import normalisations.NormalisationCodePostal;
import normalisations.NormalisationPays;
import normalisations.NormalisationVilles;
import normalisations.NormalisationVoie;
import objets_metier.Abonnement;
import objets_metier.AbonnementAff;
import objets_metier.Client;
import objets_metier.ClientAff;
import objets_metier.RevuePeriodicite;



public class GestionClientsController {

@FXML
private TableView <ClientAff> tv_listeClients;
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
private Button btn_import;
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


public ObservableList<ClientAff> gettv_listeClients() 
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
		inittv_listeClients();
	   	afficherClientDetails(null);
	   	tv_listeClients.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
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
	public void inittv_listeClients() throws SQLException {
		tv_listeClients.getItems().clear();
		//SolutionPersistance solPers = new SolutionPersistance();
		//DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		DAOFactory daos = DAOFactory.getDAOFactory(application.MainApp.getSolPers());
		listeClients_nom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		listeClients_prenom.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
		listeClients_ville.setCellValueFactory(cellData -> cellData.getValue().villeProperty());
		
	   	ArrayList<ClientAff> listeClientAff = daos.getClientDAO().findAllAff();
	   	Iterator<ClientAff> itr = listeClientAff.iterator();
	   	while (itr.hasNext())
	   	{
	   		ClientAff obj = itr.next();
	   		listeClientsAff.add(obj);
	   	}
	   	tv_listeClients.setItems(gettv_listeClients());
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
		//SolutionPersistance solPers = new SolutionPersistance();
		//DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		DAOFactory daos = DAOFactory.getDAOFactory(application.MainApp.getSolPers());
		
		listeAbos_titre.setCellValueFactory(cellData -> cellData.getValue().getRevuePeriodicite().titreProperty());
		listeAbos_periodicite.setCellValueFactory(cellData -> cellData.getValue().getRevuePeriodicite().libelle_periodiciteProperty());

		//listeAbos_id_abo.setCellValueFactory(cellData -> String.valueOf(cellData.getValue().getId_abonnementProperty()));

		listeAbos_date_debut.setCellValueFactory(cellData -> cellData.getValue().date_debutProperty());
		listeAbos_date_fin.setCellValueFactory(cellData -> cellData.getValue().date_finProperty());
		
	   	ArrayList<AbonnementAff> listeAbonnementAff = daos.getAbonnementDAO().findAllDetailsByClient(clientAff);
	   	Iterator<AbonnementAff> itr = listeAbonnementAff.iterator();
	   	
	   	while (itr.hasNext())
	   	{
	   		AbonnementAff obj = itr.next();
	   		// Recherche detail revue
	   		RevuePeriodicite revueP = daos.getRevueDAO().getRPById(obj.id_revueProperty().getValue().intValue());
	   		obj.setRevuePeriodicite(revueP);
	   		
	   		listeAbonnementsAff.add(obj);
	   	}
	   	listeAbos.setItems(getListeAbonnements());

	}
	
	
	@FXML
	private void supprimerClient() throws ParseException 
	{
		int SelectedIndex = tv_listeClients.getSelectionModel().getSelectedIndex();
		if (SelectedIndex >=0) 
		{
			//SolutionPersistance solPers = new SolutionPersistance();
			//DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
			DAOFactory daos = DAOFactory.getDAOFactory(application.MainApp.getSolPers());
			Client obj = new Client(this.clientSelected.getId_client());

			if(daos.getAbonnementDAO().getByClientId(this.clientSelected.getId_client()) == 0 ) {
			 	daos.getClientDAO().delete(obj);
			 	tv_listeClients.getItems().remove(SelectedIndex);
			}
			else {
				Alert alert = new Alert(AlertType.WARNING);
			    alert.setTitle("Suppression impossible !");
			    alert.setHeaderText("Il y a des abonnements avec ce client");
			    alert.setContentText("Sélectionnez un autre client dans la liste.");
			    alert.showAndWait();
			}
			
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
	        dialogStage.initModality(Modality.APPLICATION_MODAL);
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
	        dialogStage.initModality(Modality.APPLICATION_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(vbox);
	        dialogStage.setScene(scene);

	        NouveauClientController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	       

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
			inittv_listeClients();
		}
	}
	
	@FXML
	private void handleModifierClient() throws SQLException, ParseException {
	    ClientAff selectedClient = tv_listeClients.getSelectionModel().getSelectedItem();
	    if (selectedClient != null) {
	    	
	        boolean okClicked = ClientEditDialogue(selectedClient);
	        if (okClicked) {
	            afficherClientDetails(selectedClient);
	            inittv_listeClients();
	        }

	    } else {
	        
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Aucun client sélectionné");
	        alert.setHeaderText("Aucun client sélectionné");
	        alert.setContentText("Sélectionnez un client dans la liste.");

	        alert.showAndWait();
	    }
	}
	
	public boolean AbonnementCreerDialogue() 
	{
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("NouvelAbonnement.fxml"));
	        VBox vbox = (VBox) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Création d'un abonnement pour un client");
	        dialogStage.initModality(Modality.APPLICATION_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(vbox);
	        dialogStage.setScene(scene);

	        NouvelAbonnementController controller = loader.getController();

	        controller.setDialogStage(dialogStage);

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
	        dialogStage.setTitle("Modification d'un abonnement pour un client");
	        dialogStage.initModality(Modality.APPLICATION_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(vbox);
	        dialogStage.setScene(scene);

	        ModifierAbonnementController controller = loader.getController();

	        controller.setDialogStage(dialogStage);
	        
	        //AbonnementAff aboAff = new AbonnementAff(clientSelected.getId_client());
	        
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
		ClientAff selectedClient = tv_listeClients.getSelectionModel().getSelectedItem();
		if (selectedClient != null) {
		boolean okClicked = AbonnementCreerDialogue();
		if (okClicked) 
		{
			initListeAbonnement(clientSelected);
		}
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Aucun client sélectionné");
	        alert.setHeaderText("Aucun client sélectionné");
	        alert.setContentText("Sélectionnez un client dans la liste.");

	        alert.showAndWait();
		}
	}
	
	@FXML
	private void handleModifierAbonnement() throws SQLException, ParseException {
	    AbonnementAff selectedAbonnement = listeAbos.getSelectionModel().getSelectedItem();
	    if (selectedAbonnement != null) {
	    	
	        boolean okClicked = AbonnementEditDialogue(abonnementSelected);
	        if (okClicked) {
	            //afficherClientDetails(selectedClient);
	        	initListeAbonnement(clientSelected);
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
			//SolutionPersistance solPers = new SolutionPersistance();
			//DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
			DAOFactory daos = DAOFactory.getDAOFactory(application.MainApp.getSolPers());
			Abonnement obj = new Abonnement(this.abonnementSelected.id_abonnementProperty().getValue().intValue());

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
	
	
	@FXML		
	   private void importerFichier() throws Exception { 
		
		final FileChooser fileChooser = new FileChooser();
	      fileChooser.setTitle("Selectionnez le fichier clients");

	      // Set Initial Directory
	      fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));

	      // Add Extension Filters
	      fileChooser.getExtensionFilters().addAll(
	              new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
	              //new FileChooser.ExtensionFilter("csv"));

	      TextArea textArea = new TextArea();
	      textArea.setMinHeight(70);

	      Stage primaryStage = new Stage();
	      String filePath = "";
	      File file = fileChooser.showOpenDialog(primaryStage);
	      if (file != null) {
	          filePath = file.getPath();
	      }
	          else
	        	  return;
	      
	      
		 String line = "";
	     final String delimiter = ";";
	     try
	        {
	           
	            FileReader fileReader = new FileReader(filePath);
	            BufferedReader reader = new BufferedReader(fileReader);
	            while ((line = reader.readLine()) != null)   
	            { 
	               String[] mot = line.split(delimiter);
	               
	               Client client = new Client(mot[0] , mot[1], mot[2], NormalisationVoie.AdaptationVoie(mot[3]), NormalisationCodePostal.NormPostal(mot[4]), NormalisationVilles.AdaptationVilles(mot[5]), NormalisationPays.franciserPays(mot[6]));
	               
	               DAOFactory daos = DAOFactory.getDAOFactory(application.MainApp.getSolPers());
	               daos.getClientDAO().create(client);
	            }
	            inittv_listeClients();
	            reader.close();
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	     
	    }
	
}

