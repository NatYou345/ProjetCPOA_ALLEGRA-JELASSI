/**
 * 
 */
/**
 * @author natha
 *
 */
module projet_CPOA_ALLEGRA_JELASSI {
	requires java.sql;
	requires org.junit.jupiter.api;
	requires javafx.graphics;
	requires org.junit.platform.engine;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}