import java.util.Scanner;

public class BMI_Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user to select the unit for weight
        System.out.print("Select the unit for weight (1 for kilograms, 2 for pounds): ");
        int weightChoice = input.nextInt();
        double weight = 0.0;

        // Ask for weight input based on the chosen unit
        if (weightChoice == 1) {
            System.out.print("Enter your weight in kilograms: ");
            weight = input.nextDouble() * 2.20462; // Convert kilograms to pounds
        } else if (weightChoice == 2) {
            System.out.print("Enter your weight in pounds: ");
            weight = input.nextDouble();
        } else {
            System.out.println("Invalid choice. Defaulting to pounds.");
            System.out.print("Enter your weight in pounds: ");
            weight = input.nextDouble();
        }

        // Ask the user to select the unit for height
        System.out.print("Select the unit for height (1 for centimeters, 2 for inches): ");
        int heightChoice = input.nextInt();
        double height = 0.0;

        // Ask for height input based on the chosen unit
        if (heightChoice == 1) {
            System.out.print("Enter your height in centimeters: ");
            height = input.nextDouble() * 0.393701; // Convert centimeters to inches
        } else if (heightChoice == 2) {
            System.out.print("Enter your height in inches: ");
            height = input.nextDouble();
        } else {
            System.out.println("Invalid choice. Defaulting to inches.");
            System.out.print("Enter your height in inches: ");
            height = input.nextDouble();
        }

        // Calculate the BMI using the standard formula
        double bmi = calculateBMI(weight, height);

        // Output the BMI value to the user
        System.out.println("Your BMI is: " + bmi);

        // Determine the BMI category based on the calculated BMI
        String category = determineBMICategory(bmi);

        // Print out the BMI categories and their corresponding values
        System.out.println("BMI Category 	| 	Values");
        System.out.println("Underweight  	| 	< 18.5");
        System.out.println("Normal weight	| 	18.5-24.9");
        System.out.println("Overweight   	| 	25-29.9");
        System.out.println("Obesity      	| 	>= 30");

        // Inform the user of their BMI category
        System.out.println("Your BMI category is: " + category);

        // Close the scanner
        input.close();
    }

    // Method to calculate BMI given weight in pounds and height in inches
    public static double calculateBMI(double weightPounds, double heightInches) {
        return (weightPounds * 703) / (heightInches * heightInches);
    }

    // Method to determine the BMI category based on the BMI value
    public static String determineBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal weight";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}
