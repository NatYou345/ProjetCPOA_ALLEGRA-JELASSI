package application;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccueilController {

@FXML
private Button btnGestionClients;
@FXML
private Button btnGestionRevues;
@FXML
private Button btnGestionPeriodicites;
@FXML
private Button btnGestionAbonnements;

	
	public AccueilController() {
		// TODO Auto-generated constructor stub
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

	
}	


