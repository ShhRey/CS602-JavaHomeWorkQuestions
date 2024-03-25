// Fig. 14.21: Validate.java
// Input and validate data from user using the ValidateInput class.

import java.util.Scanner;

public class Validate {
    public static void main(String[] args) {
    	// Create scanner to obtain input from command window 
        Scanner scanner = new Scanner(System.in);
        
        // Create Custom Input Placeholders for users
        System.out.print("Please enter first name (Start with Uppercase): ");
        String firstName = scanner.nextLine();
        System.out.print("Please enter last name (May include apostrophesor hyphens): ");
        String lastName = scanner.nextLine();
        System.out.print("Please enter address (eg. 123, Main St): ");
        String address = scanner.nextLine();
        System.out.print("Please enter city (eg. Newark): ");
        String city = scanner.nextLine();
        System.out.print("Please enter state (eg. New Jersey): ");
        String state = scanner.nextLine();
        System.out.print("Please enter zip (5 digits): ");
        String zip = scanner.nextLine();
        System.out.print("Please enter phone (XXX-XXX-XXXX): ");
        String phone = scanner.nextLine();

        // Validate user inputs
        System.out.println("Validate Result: ");
        
        // Display Error Messages
        if (!ValidateInput.validateFirstName(firstName)) {
        	System.out.println("Invalid First Name");
        }
        else if (!ValidateInput.validateLastName(lastName)) {
        	System.out.println("Invalid Last Name");
        }
        else if (!ValidateInput.validateAddress(address)) {
        	System.out.println("Invalid Address");
        }
        else if (!ValidateInput.validateCity(city)) {
        	System.out.println("Invalid City Name");
        }
        else if (!ValidateInput.validateState(state)) {
        	System.out.println("Invalid State Name");
        }
        else if (!ValidateInput.validateZip(zip)) {
        	System.out.println("Invalid ZipCode");
        }
        else if (!ValidateInput.validatePhone(phone)) {
        	System.out.println("Invalid Phone Number");
        }
        else {
        	System.out.println("Valid Input. Thank you !");
        }
        // Closing Scanner
        scanner.close();
    }
}