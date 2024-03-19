// Fig. 14.21: Validate.java
// Input and validate data from user using the ValidateInput class.

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
        StringBuilder errors = new StringBuilder();
        if (!ValidateInput.validateFirstName(firstName)) {
            errors.append("Invalid first name.\n");
        }
        if (!ValidateInput.validateLastName(lastName)) {
            errors.append("Invalid last name.\n");
        }
        if (!ValidateInput.validateAddress(address)) {
            errors.append("Invalid address.\n");
        }
        if (!ValidateInput.validateCity(city)) {
            errors.append("Invalid city.\n");
        }
        if (!ValidateInput.validateState(state)) {
            errors.append("Invalid state.\n");
        }
        if (!ValidateInput.validateZip(zip)) {
            errors.append("Invalid zip code.\n");
        }
        if (!ValidateInput.validatePhone(phone)) {
            errors.append("Invalid phone number.\n");
        }

        // Display error messages or Thank you message
        if (errors.length() > 0) {
            System.out.println("\nValidation Errors:\n" + errors.toString());
        } else {
            System.out.println("Valid input. Thank you.");
        }
        scanner.close();
    }
}