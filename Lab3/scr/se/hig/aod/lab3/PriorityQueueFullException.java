package se.hig.aod.lab3;

/**
 * Exception class that signals if the heap is full or if an operation that is not allowed has been
 * done on an full heap.
 * 
 * @author Matias Semere
 */
public class PriorityQueueFullException extends RuntimeException {
	/**
	 * A constructor that takes a message about which error has been generated.
	 * This can be written to the user when the exception is caught.
	 */
	public PriorityQueueFullException(String message) {
		super(message);
	}
}