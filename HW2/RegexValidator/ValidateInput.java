// Fig. 14.20: ValidateInput.java
// Validating user information using regular expressions.

public class ValidateInput {
    // Start with an uppercase letter followed by lowercase letters
    public static boolean validateFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]*");
    }

    // Allows uppercase and lowercase letters and may include an apostrophe or hyphen
    public static boolean validateLastName(String lastName) {
        return lastName.matches("[a-zA-Z]+(['-][a-zA-Z]+)*");
    }

    // Numbers followed by a space and street name (which may include spaces)
    public static boolean validateAddress(String address) {
        return address.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    // Allows cities names with spaces
    public static boolean validateCity(String city) {
        return city.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    // Allows state names with spaces
    public static boolean validateState(String state) {
        return state.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    // Accepts exactly 5 digits
    public static boolean validateZip(String zip) {
        return zip.matches("\\d{5}");
    }

    // Must follow the following pattern XXX-XXX-XXXX
    public static boolean validatePhone(String phone) {
        return phone.matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}");
    }
}