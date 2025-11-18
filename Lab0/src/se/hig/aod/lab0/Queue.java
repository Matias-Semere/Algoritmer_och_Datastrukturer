package se.hig.aod.lab0;

/**
 * An interface for the generic Abstract Data Type <code>Queue</code>.
 * 
 * @author Anders Jackson
 * @param <E> Elements that are stored in Queue.
 */

public interface Queue<E> {
        /**
         * Removes all elements from this queue and writes
         * a message on {@link System}.out).
         */
        public void clear();

        /**
         * Checks if this queue is empty.
         * 
         * @return true if queue is empty, false otherwise.
         */
        public boolean isEmpty();

        /**
         * Checks if this queue is empty.
         * 
         * @return true if queue is full, false otherwise.
         */
        public boolean isFull();

        /**
         * Add an element at the last position in this queue.
         * 
         * @param element added to this queue.
         */
        public void enqueue(E element);

        /**
         * Removes the first element from this queue. Will throw
         * {@link QueueEmptyException} if this queue is empty.
         * 
         * @throws QueueEmptyException when queue is empty.
         * @return the first element.
         */
        public E dequeue();

        /**
         * Returns the first element in this queue, without removing it. Will throw
         * {@link QueueEmptyException} if this queue is empty.
         * 
         * @throws QueueEmptyException when queue is empty.
         * @return the first element.
         */
        public E getFront();

}
