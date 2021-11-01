package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import objets_metier.Periodicite;
import objets_metier.Revue;
import objets_metier.RevuePeriodicite;
import solutionPersistance.SolutionPersistance;



public class GestionRevuesController {

@FXML
private TableView <RevuePeriodicite> listeRevues;
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
private Button btn_ajouter;
@FXML
private Button btn_modifier;
@FXML
private Button btn_supprimer;

private RevuePeriodicite revueSelected;

public ObservableList<RevuePeriodicite> getListeRevues() 
{
	return listeRevuesPeriodicite;
}

	
	public GestionRevuesController() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize() throws SQLException 
	{
		initListeRevues();
	   	afficherRevueDetails(null);
	   	listeRevues.getSelectionModel().selectedItemProperty().addListener((observable, oldValue,newValue) -> afficherRevueDetails(newValue));
	   	
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
	
	private void afficherRevueDetails(RevuePeriodicite revue) {
		this.revueSelected = revue;
	    if (revue != null) {

	        lbl_revueTitre.setText(revue.getTitre());
	        lbl_revueDescription.setText(revue.getDescription());
	        lbl_revueTarif.setText(revue.getTarif_numero());
	        lbl_revuePeriodicite.setText(revue.getlibelle_periodicite());

	    } else {

	    	lbl_revueTitre.setText("");
	        lbl_revueDescription.setText("");
	        lbl_revueTarif.setText("");
	        lbl_revuePeriodicite.setText("");
	    }
	}
	
	@FXML
	private void supprimerRevue() 
	{
		int SelectedIndex = listeRevues.getSelectionModel().getSelectedIndex();
		if (SelectedIndex >=0) 
		{
			listeRevues.getItems().remove(SelectedIndex);
			SolutionPersistance solPers = new SolutionPersistance();
			DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());
			Revue obj = new Revue(this.revueSelected.getId_revue());
			daos.getRevueDAO().delete(obj);
			
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
	        loader.setLocation(MainApp.class.getResource("NouvelleRevue.fxml"));
	        VBox vbox = (VBox) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Modification d'une revue");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(vbox);
	        dialogStage.setScene(scene);

	        // Set the person into the controller.
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
		boolean okClicked = RevueEditDialogue(tempRP);
		if (okClicked) 
		{
			//listeRevuesPeriodicite.add(tempRP);
			initListeRevues();
		}
	}
	
	@FXML
	private void handleModifierRevue() {
	    RevuePeriodicite selectedRevue = listeRevues.getSelectionModel().getSelectedItem();
	    if (selectedRevue != null) {
	        boolean okClicked = RevueEditDialogue(selectedRevue);
	        if (okClicked) {
	            afficherRevueDetails(selectedRevue);
	        }

	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Aucune revue sélectionnée");
	        alert.setHeaderText("Aucune revue sélectionnée");
	        alert.setContentText("Sélectionnez une revue dans la liste.");

	        alert.showAndWait();
	    }
	}
}

