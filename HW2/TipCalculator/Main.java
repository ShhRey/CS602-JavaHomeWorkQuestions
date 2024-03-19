//Fig. 12.19: TipCalculator.java
// Main app class that loads and displays the Tip Calculator's GUI

// Importing all the necessary libraries
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Main class that extends the Application overriding the Start Method
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
        	// Loading the FXML File that contains the UI Layout
            Parent root = FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));
            
            // Creating a new Scene with the Loaded Layout
            Scene scene = new Scene(root);
            // Adding title to the Window
            stage.setTitle("Tip Calculator");
            stage.setScene(scene);
            stage.show();
        } 
        // Catching Any Exceptions that might occur during the Process
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    // Main Method / Entry point of the Application
    public static void main(String[] args) {
        // Command to Launch the JavaFX Application
    	launch(args);
    }
}