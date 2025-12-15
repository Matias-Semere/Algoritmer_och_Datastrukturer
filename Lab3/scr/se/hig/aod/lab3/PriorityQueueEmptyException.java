package se.hig.aod.lab3;

/**
 * Exception class that signals if the heap is empty or if an operation that is not allowed has been
 * done on an empty heap.
 * 
 * @author Matias Semere
 */
public class PriorityQueueEmptyException extends RuntimeException {
	/**
	 * A constructor that takes a message about which error has been generated.
	 * This can be written to the user when the exception is caught.
	 */
	public PriorityQueueEmptyException(String message) {
		super(message);
	}
}
