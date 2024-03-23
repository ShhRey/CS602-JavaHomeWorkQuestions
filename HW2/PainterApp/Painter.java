// Fig. 13.5: Painter.java
// Main application class that loads and displays the Painter's GUI.

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML document for the GUI
        Parent root = FXMLLoader.load(getClass().getResource("Painter.fxml"));
        
        // Create and set the scene
        Scene scene = new Scene(root);
        // Set the stage title
        stage.setTitle("Painter");
        stage.setScene(scene);
        // Display the stage
        stage.show();
    }
    
    public static void main(String[] args) {
        // Launch the application
        launch(args);
    }
}