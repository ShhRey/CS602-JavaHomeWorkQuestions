// Fig. 13.8: ColorChooser.java
// Main application class that loads and displays the ColorChooser's GUI.

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Main class extending JavaFX Application
public class ColorChooser extends Application {
	
	// Start method to initialize the application
	@Override
	public void start(Stage stage) throws Exception {
		// Load the FXML file representing the GUI layout
		Parent root = FXMLLoader.load(getClass().getResource("ColorChooser.fxml"));
		
		// Create a scene using the loaded FXML file
		Scene scene = new Scene(root);
		
		// Set the title of the stage
		stage.setTitle("Color Chooser");
		
		// Set the scene to the stage
		stage.setScene(scene);
		
		// Display the stage
		stage.show();
	}
	
	// Main method to launch the application
	public static void main(String[] args) {
		// Launch the JavaFX application
		launch(args);
	}
}
