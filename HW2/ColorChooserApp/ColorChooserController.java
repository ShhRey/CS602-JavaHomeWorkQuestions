// Import necessary JavaFX classes for building GUI applications.
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

// Define a controller class named ColorChooserController.
public class ColorChooserController {
    // Injecting FXML elements from the FXML file into instance variables.
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;
    
    // Instance variables for managing color values.
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;
    
    // The initialize method is automatically called when the FXML file is loaded.
    public void initialize() {
        // Bind text field values to corresponding slider values.
        redTextField.textProperty().bind(redSlider.valueProperty().asString("%.0f"));
        greenTextField.textProperty().bind(greenSlider.valueProperty().asString("%.0f"));
        blueTextField.textProperty().bind(blueSlider.valueProperty().asString("%.0f"));
        alphaTextField.textProperty().bind(alphaSlider.valueProperty().asString("%.2f"));
        
        // Listeners that update the color rectangle's fill based on slider changes.
        redSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                    red = newValue.intValue();
                    colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                }
            }
        );
        
        greenSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> ov,
                    Number oldValue, Number newValue) {
                    green = newValue.intValue();
                    colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                }
            }
        );
        
        blueSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> ov,
                    Number oldValue, Number newValue) {
                    blue = newValue.intValue();
                    colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                }
            }
        );
                
        
        alphaSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> ov,
                    Number oldValue, Number newValue) {
                    alpha = newValue.doubleValue();
                    colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                }
            }
        );
    }
}