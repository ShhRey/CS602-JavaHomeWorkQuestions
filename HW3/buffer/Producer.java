// Fig. 23.10: Producer.java
// Producer with a run method that inserts the value 1 to 10 in buffer.

package buffer;

import java.security.SecureRandom;

public class Producer implements Runnable {
	private static final SecureRandom generator = new SecureRandom();
	private final Buffer sharedLocation; // reference to shared object
	
	// constructor
	public Producer(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	
	// store values from 1 to 10 in sharedLocation
	@Override
	public void run() {
		int sum = 0;
		
		for (int count = 1; count <= 10; count++) {
			try  { // sleep 0 to 3 seconds, then place the value in Buffer
				Thread.sleep(generator.nextInt(3000)); // random sleep
				sharedLocation.blockingPut(count); // set the value of buffer
				sum += count; // increment the sum for values
				System.out.printf("\t%2d%n", sum);
			}
			catch (InterruptedException exception) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
