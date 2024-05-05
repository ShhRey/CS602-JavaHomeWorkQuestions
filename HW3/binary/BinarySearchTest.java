// Fig. 19.3: BinarySearchTest.java
// Use binary search to locate an item in an array

package binary;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest {

    // Perform a binary search on the data
    public static int binarySearch(int[] data, int key) {
        int low = 0; // low end of the search area
        int high = data.length - 1; // high end of the search area
        int middle = (low + high + 1) / 2; // middle element
        int location = -1; // return value; -1 if not found

        do {
            // Print remaining elements of array
            System.out.print(remainingElements(data, low, high));
            // Output spaces for alignment
            for (int i = 0; i < middle; i++) {
                System.out.print("   ");
            }
            System.out.println(" * "); // Indicate current middle
            // If the element is found at the middle
            if (key == data[middle]) {
                location = middle; // location is the current middle
            } 
            else if (key < data[middle]) { // middle element is too high
                high = middle - 1; // eliminate the higher half
            } 
            else { // middle element is too low
                low = middle + 1; // eliminate the lower half
            }
            // Re-calculate the middle
            middle = (low + high + 1) / 2;
        } 
        while ((low <= high) && (location == -1));
        // Location of search key
        return location;
    }

    // Method to output certain values in array
    private static String remainingElements(int[] data, int low, int high) {
        StringBuilder temporary = new StringBuilder();
        // Append spaces for alignment
        for (int i = 0; i < low; i++) {
            temporary.append("   ");
        }
        // Append elements left in array
        for (int i = low; i <= high; i++) {
            temporary.append(data[i]).append(" ");
        }
        return String.format("%s%n", temporary);
    }

    // The main method to execute the binary search test
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();
        // Create array of 15 random integers in sorted order
        int[] data = generator.ints(15, 10, 91).sorted().toArray();
        System.out.printf("%s%n", Arrays.toString(data)); // Display array

        // Get input from user
        System.out.print("Please enter an integer value (-1 to quit): ");
        int searchInt = input.nextInt();

        // Repeatedly input an integer; -1 terminates the program
        while (searchInt != -1) {
            // Perform search
            int location = binarySearch(data, searchInt);
            if (location == -1) { // Not found
                System.out.printf("%d was not found%n", searchInt);
            } 
            else { // Found
                System.out.printf("%d was found in position %d%n", searchInt, location);
            }

            // Get next input from user
            System.out.print("Please enter an integer value (-1 to quit): ");
            searchInt = input.nextInt();
        }
        // Closing the scanner once code is complete.
        input.close();
    }
}