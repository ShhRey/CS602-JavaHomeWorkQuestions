// Fig. 21.11: Queue.java
// Queue uses class List.

package com.deitel.datastructures;

import java.util.NoSuchElementException;

public class Queue<E> {
	private List<E> queueList;
	
	// constructor that initializes the internal list
	public Queue() {
		queueList = new List<E>("queue");
	}
	
	// adds object to the rear of queue
	public void enqueue(E object) {
		queueList.insertAtBack(object);
	}
	
	// removes and returns object from front of the queue
	public E dequeue() throws NoSuchElementException {
		return queueList.removeFromFront();
	}
	
	// checks if queue is empty
	public boolean isEmpty() {
		return queueList.isEmpty();
	}
	
	// output queue contents
	public void print() {
		queueList.print();
	}
}