package application;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import solutionPersistance.Persistance;

public class AccueilController {

@FXML
private Button btnGestionClients;
@FXML
private Button btnGestionRevues;
@FXML
private Button btnGestionPeriodicites;
@FXML
private Button btnGestionOptions;


	
	public AccueilController() {
		application.MainApp.setSolPers(Persistance.MYSQL);
	}
	
	@FXML
	public void GestionRevues() 
	{
		Stage secondStage = new Stage();
		try {
			URL fxmlURL=getClass().getResource("GestionRevues.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 1200, 700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondStage.setScene(scene);
			secondStage.setTitle("Gestion des revues");
			secondStage.show();
			} 
			catch (Exception e) {
				e.printStackTrace();
				}
		}

	@FXML
	public void GestionClients() 
	{
		Stage secondStage = new Stage();
		try {
			URL fxmlURL=getClass().getResource("GestionClients.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 1400, 700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondStage.setScene(scene);
			secondStage.setTitle("Gestion des clients");
			secondStage.show();
			} 
			catch (Exception e) {
				e.printStackTrace();
				}
		}

	@FXML
	
	public void GestionOptions() 
	{
		//Stage secondStage = new Stage();
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("GestionOptions.fxml"));
	        VBox vbox = (VBox) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Gestion des options");
	        dialogStage.initModality(Modality.APPLICATION_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(vbox);
	        dialogStage.setScene(scene);

	        GestionOptionsController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        
	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();
	        
			} 
			catch (Exception e) {
				e.printStackTrace();
				}
		}
	
}	


