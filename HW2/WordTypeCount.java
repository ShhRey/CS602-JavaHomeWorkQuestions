// Fig 16.17 WordTypeCount.java
// Program count the number of occurrences of each word in a String.

package wordCount;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class WordTypeCount {
	public static void main(String[] args ) {
		// Create HashMap to store String keys and Integer Values
		Map<String, Integer> myMap = new HashMap<>();
		
		// Creating functions for Creating and Displaying Map
		createMap(myMap);
		displayMap(myMap);
	}
	
	// Function for creating map from User Input
	public static void createMap(Map<String, Integer> map) {
		Scanner scanner = new Scanner(System.in);
		// Prompting user for String Input
		System.out.println("Enter a String: ");
		String input = scanner.nextLine();
		// Tokenize the Input
		String[] tokens = input.split(" ");
		for (String token: tokens) {
			String word = token.toLowerCase();
			// Count occurrences and store in Map
			if (map.containsKey(word)) {
				int count = map.get(word);
				map.put(word, count+1);
			}
			else {
				map.put(word, 1);
			}
		}
	}
	
	// Function for displaying map content
	private static void displayMap(Map<String, Integer> map) {
        // get and sort keys acc to occurrence count
		Set<String> keys = map.keySet();
        TreeSet<String> sortedKeys = new TreeSet<>(keys);
        System.out.printf("%nMap contains:%nKey\t\tValue%n");
        // Print out every key and its count	
        for (String key : sortedKeys) {
            System.out.printf("%-10s%10s%n", key, map.get(key));
        }
        System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }
}
