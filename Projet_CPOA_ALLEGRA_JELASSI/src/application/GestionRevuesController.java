package application;

import java.io.IOException;
import java.net.URL;
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
import objets_metier.ClientAff;
import objets_metier.Periodicite;
import objets_metier.Revue;
import objets_metier.RevuePeriodicite;
import solutionPersistance.SolutionPersistance;



public class GestionRevuesController {

@FXML
private TableView <RevuePeriodicite> listeRevues;
@FXML
private TableView <AbonnementAff> listeAbos ;

@FXML
private TableColumn <AbonnementAff,String> listeAbos_nom;
@FXML
private TableColumn <AbonnementAff,String> listeAbos_prenom;
@FXML
private TableColumn <AbonnementAff,String> listeAbos_ville;
@FXML
private TableColumn <AbonnementAff,LocalDate> listeAbos_date_debut;
@FXML
private TableColumn <AbonnementAff,LocalDate> listeAbos_date_fin;

@FXML
private TableColumn <RevuePeriodicite,String> listeRevues_titre;
@FXML
private TableColumn <RevuePeriodicite,String> listeRevues_tarif;
@FXML
private TableColumn <RevuePeriodicite,String> listeRevues_periodicite;
@FXML
private Label lbl_revueTitre;
@FXML
private Label lbl_revueDescription;
@FXML
private Label lbl_revueTarif;
@FXML
private Label lbl_revuePeriodicite;
@FXML
private ObservableList<RevuePeriodicite> listeRevuesPeriodicite = FXCollections.observableArrayList();
@FXML
private ObservableList<AbonnementAff> listeAbonnementsAff = FXCollections.observableArrayList();
@FXML
private Button btn_ajouter;
@FXML
private Button btn_modifier;
@FXML
private Button btn_supprimer;

private RevuePeriodicite revueSelected;
private AbonnementAff abonnementSelected;

@FXML
private Button btn_ajouterAbo;
@FXML
private Button btn_modifierAbo;
@FXML
private Button btn_supprimerAbo;



public ObservableList<RevuePeriodicite> getListeRevues() 
{
	return listeRevuesPeriodicite;
}
public ObservableList<AbonnementAff> getListeAbonnements() 
{
	return listeAbonnementsAff;
}

	
	public GestionRevuesController() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize() throws SQLException, ParseException 
	{
		initListeRevues();
	   	afficherRevueDetails(null);
	   	listeRevues.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			try {
				afficherRevueDetails(newValue);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
	   	listeAbos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	   		this.abonnementSelected = newValue;
		});
	}
	public void initListeRevues() throws SQLException {
		listeRevues.getItems().clear();
		SolutionPersistance solPers = new SolutionPersistance();
		DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		listeRevues_titre.setCellValueFactory(cellData -> cellData.getValue().titreProperty());
		listeRevues_tarif.setCellValueFactory(cellData -> cellData.getValue().tarif_numeroProperty());
		listeRevues_periodicite.setCellValueFactory(cellData -> cellData.getValue().libelle_periodiciteProperty());
	   	ArrayList<RevuePeriodicite> listeRevuePeriodicite = daos.getRevueDAO().findAllLibelle();
	   	Iterator<RevuePeriodicite> itr = listeRevuePeriodicite.iterator();
	   	while (itr.hasNext())
	   	{
	   		RevuePeriodicite obj = itr.next();
	   		
	   		listeRevuesPeriodicite.add(obj);
	   	}
	   	listeRevues.setItems(getListeRevues());
	}

	public void initListeAbonnement(RevuePeriodicite revueP) throws SQLException, ParseException {
		listeAbos.getItems().clear();
		SolutionPersistance solPers = new SolutionPersistance();
		DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
		
		listeAbos_nom.setCellValueFactory(cellData -> cellData.getValue().getClientAff().nomProperty());
		listeAbos_prenom.setCellValueFactory(cellData -> cellData.getValue().getClientAff().prenomProperty());
		listeAbos_ville.setCellValueFactory(cellData -> cellData.getValue().getClientAff().villeProperty());
		listeAbos_date_debut.setCellValueFactory(cellData -> cellData.getValue().date_debutProperty());
		listeAbos_date_fin.setCellValueFactory(cellData -> cellData.getValue().date_finProperty());
		
	   	ArrayList<AbonnementAff> listeAbonnementAff = daos.getAbonnementDAO().findAllDetailsByRevue(revueP);
	   	//System.out.println("listeAbonnementAff : " + listeAbonnementAff);
	   	Iterator<AbonnementAff> itr = listeAbonnementAff.iterator();
	   	
	   	while (itr.hasNext())
	   	{
	   		AbonnementAff obj = itr.next();
	   		// Recherche detail client
	   		ClientAff clientA = daos.getClientDAO().getCAById(obj.id_clientProperty().getValue().intValue());
	   		obj.setClientAff(clientA);
	   		
	   		listeAbonnementsAff.add(obj);
	   	}
	   	listeAbos.setItems(getListeAbonnements());
	   	//System.out.println("listeAbos: " + getListeAbonnements());
	}

	
	private void afficherRevueDetails(RevuePeriodicite revue) throws SQLException, ParseException {
		this.revueSelected = revue;
		
	    if (revue != null) {
	        lbl_revueTitre.setText(revue.getTitre());
	        lbl_revueDescription.setText(revue.getDescription());
	        lbl_revueTarif.setText(revue.getTarif_numero());
	        lbl_revuePeriodicite.setText(revue.getlibelle_periodicite());
	        
	        this.initListeAbonnement(revue);

	    } else {
			lbl_revueTitre.setText("");
	        lbl_revueDescription.setText("");
	        lbl_revueTarif.setText("");
	        lbl_revuePeriodicite.setText("");
	    }
	}
	
	@FXML
	private void supprimerRevue() throws ParseException 
	{
		int SelectedIndex = listeRevues.getSelectionModel().getSelectedIndex();
		if (SelectedIndex >=0) 
		{
			SolutionPersistance solPers = new SolutionPersistance();
			DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
			Revue obj = new Revue(this.revueSelected.getId_revue());
			
			System.out.println("Abo existant : "+ this.revueSelected.getId_revue() + " " + daos.getAbonnementDAO().getByRevueId(this.revueSelected.getId_revue()));
			if(daos.getAbonnementDAO().getByRevueId(this.revueSelected.getId_revue()) == 0 ) {
			 	daos.getRevueDAO().delete(obj);
			 	listeRevues.getItems().remove(SelectedIndex);
			 }
			 else
			 {
				 Alert alert = new Alert(AlertType.WARNING);
			     alert.setTitle("Suppression impossible !");
			     alert.setHeaderText("Il y a des abonnements avec cette revue");
			     alert.setContentText("Sélectionnez une autre revue dans la liste.");
			     alert.showAndWait();
			 }
		}
		else 
		{
			Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Pas de revue sélectionnée !");
	        alert.setHeaderText("Pas de revue sélectionnée");
	        alert.setContentText("Sélectionnez une revue dans la liste.");

	        alert.showAndWait();
		}
	}
	
	public boolean RevueEditDialogue(RevuePeriodicite revueP) 
	{
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("ModifierRevue.fxml"));
	        VBox vbox = (VBox) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Modification d'une revue");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(vbox);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
	        ModifierRevueController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setRevueP(revueP);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }

	}
	public boolean RevueCreerDialogue(RevuePeriodicite revueP) 
	{
		try {
	        // Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("NouvelleRevue.fxml"));
	        VBox vbox = (VBox) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Création d'une revue");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(vbox);
	        dialogStage.setScene(scene);

	       NouvelleRevueController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setRevueP(revueP);

	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }

	}
	
	@FXML
	private void handleNouvelleRevue() throws SQLException 
	{
		RevuePeriodicite tempRP = new RevuePeriodicite();
		boolean okClicked = RevueCreerDialogue(tempRP);
		if (okClicked) 
		{
			initListeRevues();
		}
	}
	
	@FXML
	private void handleModifierRevue() throws SQLException, ParseException {
	    RevuePeriodicite selectedRevue = listeRevues.getSelectionModel().getSelectedItem();
	    if (selectedRevue != null) {
	    	
	        boolean okClicked = RevueEditDialogue(selectedRevue);
	        if (okClicked) {
	            afficherRevueDetails(selectedRevue);
	            initListeRevues();
	        }

	    } else {
	        
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Aucune revue sélectionnée");
	        alert.setHeaderText("Aucune revue sélectionnée");
	        alert.setContentText("Sélectionnez une revue dans la liste.");

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
	        System.out.println("ID client avant nouvel abo : "+revueSelected.getId_revue());
	        AbonnementAff aboAff = new AbonnementAff(revueSelected.getId_revue());
	        
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
	        
	        AbonnementAff aboAff = new AbonnementAff(revueSelected.getId_revue());
	        
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
			initListeAbonnement(revueSelected);
		}
	}
	
	@FXML
	private void handleModifierAbonnement() throws SQLException, ParseException {
	    AbonnementAff selectedAbonnement = listeAbos.getSelectionModel().getSelectedItem();
	    if (selectedAbonnement != null) {
	    	
	        boolean okClicked = AbonnementEditDialogue(abonnementSelected);
	        if (okClicked) {
	            //afficherClientDetails(selectedClient);
	        	initListeAbonnement(revueSelected);
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

