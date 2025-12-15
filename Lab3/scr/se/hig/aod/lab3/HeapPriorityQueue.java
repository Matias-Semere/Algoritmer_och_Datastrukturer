package se.hig.aod.lab3;

import java.util.stream.IntStream;

/**
 * A static heap implementation of a priority queue for elements of type T.
 * 
 * @author Matias Semere
 * 
 * @param <T> Data type of elements stored in the queue.
 */
public class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T> {

	private T[] heap;
	private int size;
	private int maxSize;

	public HeapPriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		heap = (T[]) (new Comparable[maxSize]);
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Method that is specific for a static implementation of the heap, checks if
	 * the underlying array is full.
	 * 
	 * @return true if the underlying array is full
	 */
	public boolean isFull() {
		return size == maxSize;
	}

	@Override
	public int size() {
		return size;
	}

	private int parent(int currentIndex) {
		return (currentIndex - 1) / 2;
	}

	private int leftChild(int currentIndex) {
		return 2 * currentIndex + 1;
	}

	private int rightChild(int currentIndex) {
		return 2 * currentIndex + 2;
	}

	private void reHeapUp(int currentIndex) {
		int parent = parent(currentIndex);
		if (heap[currentIndex].compareTo(heap[parent]) < 0) {
			T tmp = heap[currentIndex];
			heap[currentIndex] = heap[parent];
			heap[parent] = tmp;
			reHeapUp(parent);
		}
	}

	private void reHeapDown(int currentIndex) {
		int left = leftChild(currentIndex);
		int right = rightChild(currentIndex);

		if (left >= size) {
			return;
		}

		int largestChild = left;

		if (right < size && heap[right].compareTo(heap[left]) > 0) {
			largestChild = right;
		}

		if (heap[currentIndex].compareTo(heap[largestChild]) < 0) {
			T temp = heap[currentIndex];
			heap[currentIndex] = heap[largestChild];
			heap[largestChild] = temp;

			reHeapDown(largestChild);
		}
	}

	@Override
	public void enqueue(T newElement) {
		if (isFull()) {
			throw new PriorityQueueFullException("Heap is full!");
		}
		size++;
		heap[size - 1] = newElement;
		reHeapUp(size - 1);
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new PriorityQueueEmptyException("Cannot dequeue empty Queue!");
		} else {
			T dequeuedElement = heap[0];// the root element of the heap

			// TODO Code that moves the last element in the heap to the root of the heap
			size--;
			// TODO reHeapDown for the new root of the heap

			return dequeuedElement;
		}
	}

	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new PriorityQueueEmptyException("Cannot get front of empty Queue!");
		} else {
			return heap[0];
		}
	}

	@Override
	public String toString() {
		String stringRepresentation = "";
		for (int i = 0; i < size; i++) {
			stringRepresentation += heap[i] + " ";
		}
		return stringRepresentation;
	}

}
