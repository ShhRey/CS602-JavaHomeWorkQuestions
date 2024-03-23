// Fig. 13.6: PainterController.java
// Controller for the Painter app

// Importing all the required Libraries
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

// Controller for managing the GUI interactions of the Painter app
public class PainterController {	
	private enum PenSize {
		SMALL(2), MEDIUM(4), LARGE(6);
		private final int radius;
		PenSize(int radius) {
			this.radius = radius;
		}
		public int getRadius() {
			return radius;
		}
	}
    
    // RadioButtons for color selection
    @FXML private RadioButton blackRadioButton;
    @FXML private RadioButton redRadioButton;
    @FXML private RadioButton greenRadioButton;
    @FXML private RadioButton blueRadioButton;
    
    // RadioButtons for size selection
    @FXML private RadioButton smallRadioButton;
    @FXML private RadioButton mediumRadioButton;
    @FXML private RadioButton largeRadioButton;
    
    // The pane that serves as the drawing area
    @FXML private Pane drawingAreaPane;
    
    // ToggleGroups to manage color and size selection
    @FXML private ToggleGroup colorToggleGroup;
    @FXML private ToggleGroup sizeToggleGroup;
    
    // instance variables for managing Painting State
    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;
    
    // Initializes the controller and sets up default values and behavior.
    public void initialize() {
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        greenRadioButton.setUserData(Color.GREEN);
        blueRadioButton.setUserData(Color.BLUE);
        
        // Initialize the ToggleGroups with user data for sizes
        smallRadioButton.setUserData(PenSize.SMALL); // Small size
        mediumRadioButton.setUserData(PenSize.MEDIUM); // Medium size
        largeRadioButton.setUserData(PenSize.LARGE); // Large size
    }
    
    // Handles the drawing area's onMouseDragged MouseEvent to draw circles.
    @FXML
    private void drawingAreaMouseDragged(MouseEvent e) {
        // Draw a circle at the mouse position with the selected color and size
        Circle newCircle = new Circle(e.getX(), e.getY(), radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
    
    // Handles color RadioButton's ActionEvents to update the brush color.
    @FXML
    private void colorRadioButtonSelected(ActionEvent event) {
        // Update the brush color based on the selected RadioButton
        brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }
    
    // Handles size RadioButton's ActionEvents to update the brush size.
    @FXML
    private void sizeRadioButtonSelected(ActionEvent event) {
        // Update the brush size based on the selected RadioButton
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }
    
    // Handles the Undo Button's ActionEvents to remove the last shape drawn.
    @FXML
    private void undoButtonPressed(ActionEvent event) {
        int count = drawingAreaPane.getChildren().size();
        
        // If there are any shapes remove the last used shape
        if (count > 0) {
        	drawingAreaPane.getChildren().remove(count - 1);
        }
    }
    
    // Handles the Clear Button's ActionEvents to clear the drawing area.
    @FXML
    private void clearButtonPressed(ActionEvent event) {
        // Clear all shapes from the drawing area
        drawingAreaPane.getChildren().clear();
    }
}