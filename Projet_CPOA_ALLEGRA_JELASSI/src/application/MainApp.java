package application;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	

	@Override
	public void start(Stage primaryStage) {
	
				
		this.primaryStage = primaryStage;
		try {
			URL fxmlURL=getClass().getResource("Accueil.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("RevuesOnLine");
			primaryStage.show();
			} 
			catch (Exception e) {
				e.printStackTrace();
				}
		}

	public static void main(String[] args) {
		launch(args);
	}
	
}
