// Fig. 21.12: QueueTest.java
// Class QueueTest.
package com.deitel.datastructures;

import com.deitel.datastructures.Queue;
import java.util.NoSuchElementException;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		
		// Demonstrating the enqueue operations
		queue.enqueue(-1);
		queue.print();
		queue.enqueue(0);
		queue.print();
		queue.enqueue(1);
		queue.print();
		queue.enqueue(5);
		queue.print();
		
		// Demonstrating dequeue operations (removing elements)
		boolean continueLoop = true;
		
		while(continueLoop) {
			try {
				int removedItem = queue.dequeue(); // remove head element
				System.out.printf("%n%d dequeued%n", removedItem);
				queue.print();
			}
			catch (NoSuchElementException noSuchElementException) {
				continueLoop = false;
				noSuchElementException.printStackTrace();
			}
		}
	}
}