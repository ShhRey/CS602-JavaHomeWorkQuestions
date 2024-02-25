// Fig. 3.10: Analysis.java
// Analysis of examination results using nested control statements.
import java.util.Scanner;

public class Analysis {
    public static void main(String[] args) {
        // Create Scanner to obtain input from command window
        Scanner input = new Scanner(System.in);

        // Initializing variables to track Passing/Failing Students
        int passes = 0;
        int failures = 0;
        int studentCounter = 1;

        // Process 10 students using Counter-Controlled Loop
        while (studentCounter <= 10) {
            // prompt user for input and obtain value from user
            System.out.print("Enter result (1 = pass, 2 = fail): ");
            int result = input.nextInt();

            // Using if...else statement to check result
            if (result == 1) {
                passes = passes + 1;
            } else {
                failures = failures + 1;
            }

            studentCounter = studentCounter + 1;
        }

        // Display the Final Status of students
        System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);

        // Check for Bonus for Instructor
        if (passes > 8) {
            System.out.println("Bonus to Instructor!");
        }
    }
}
