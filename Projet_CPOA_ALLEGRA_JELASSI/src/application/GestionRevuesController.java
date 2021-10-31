package application;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
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

public ObservableList<RevuePeriodicite> GetListeRevues() 
{
	return listeRevuesPeriodicite;
}

	
	public GestionRevuesController() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize() throws SQLException 
	{
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
	   	listeRevues.setItems(GetListeRevues());
	}
	
}

