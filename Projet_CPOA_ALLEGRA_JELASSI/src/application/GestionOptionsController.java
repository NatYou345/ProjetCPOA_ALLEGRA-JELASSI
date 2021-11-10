/**
 * 
 */
package application;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import solutionPersistance.Persistance;

/**
 * @author natha
 *
 */
public class GestionOptionsController {


@FXML
private ComboBox<String> id_solution;

@FXML
private Button btn_modifier;

private Stage dialogStage;

private boolean okClicked = false;

@FXML
private ObservableList<Persistance> listePersistance = FXCollections.observableArrayList();

	public GestionOptionsController() 
	{
		
	}
	
	public void initialize() throws SQLException 
	{
   		id_solution.getItems().addAll("MySQL","ListeMémoire");
   		if (application.MainApp.getSolPers() == Persistance.MYSQL) 
   		id_solution.setValue("MySQL");
   		else
   			id_solution.setValue("ListeMémoire");
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
	private void handleModifier() 
	{
		
		//SolutionPersistance solPers = new SolutionPersistance();
		//DAOFactory daos = DAOFactory.getDAOFactory(solPers.getPers());

		if (id_solution.getValue() == "MySQL") {
			application.MainApp.setSolPers(Persistance.MYSQL);
		}
		else {
			application.MainApp.setSolPers(Persistance.ListeMemoire);

		}
		this.dialogStage.close();
	}

}
