// TipCalculatorController.java
// Controller that handles calculateButton and tipPercentageSlider events

// Importing all the necessary libraries
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;

public class TipCalculatorController {
	// Number Formats for currency and percentage
	private static final NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    
    // Default tip percentage
    private BigDecimal tipPercentage = new BigDecimal(0.10);
    
    // Reference to the VBox
    @FXML
    private VBox container;
    
    @FXML
    private TextField amountTextField;
    
    @FXML
    private Label tipPercentageLabel;
    
    @FXML
    private Slider tipPercentageSlider;
    
    @FXML
    private TextField tipTextField;
    
    @FXML
    private TextField totalTextField;
    
    // Initialization method called after FXML fields are injected
    public void initialize() {
    	// Setting rounding mode for currency format
        currency.setRoundingMode(RoundingMode.HALF_UP);
        
        // Setting padding programmatically
        container.setPadding(new Insets(10, 10, 10, 10));
        
        // Creating listener for changes in tip percentage slider
        tipPercentageSlider.valueProperty().addListener(
            (observable, oldValue, newValue) -> {
                tipPercentage = BigDecimal.valueOf(newValue.doubleValue() / 100.0);
                tipPercentageLabel.setText(percent.format(tipPercentage));
            }
        );
    }
    
    // Event handler for calculating tip and displaying output
    @FXML
    private void calculateButtonPressed(ActionEvent event) {
        try {
        	// Get amount from text field
            BigDecimal amount = new BigDecimal(amountTextField.getText());
            // Check if Input Amount is greater than 0 or not
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            	amountTextField.setText("Only Positive Numbers are accepted !");
            	tipTextField.setText("N/A");
            	totalTextField.setText("N/A");
            }
            else {
            	// Calculate Tip and Total Amount
            	BigDecimal tip = amount.multiply(tipPercentage);
                BigDecimal total = amount.add(tip);
                // Display them in their respective fields
                tipTextField.setText(currency.format(tip));
                totalTextField.setText(currency.format(total));
            }
        } 
        catch (NumberFormatException ex) {
        	// Handling Invalid / Blank Inputs
            amountTextField.setText("Enter a Valid Amount.");
            amountTextField.selectAll();
            amountTextField.requestFocus();
        }
    }
}