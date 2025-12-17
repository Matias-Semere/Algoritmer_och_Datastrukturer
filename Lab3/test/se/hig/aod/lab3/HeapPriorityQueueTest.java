package se.hig.aod.lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for HeapPriorityQueue
 * 
 * @author Matias Semere
 */
class HeapPriorityQueueTest {

	static final Integer[] INT_FIXTURE = { 9, 8, 7, 6, 4 }; // TODO fill with random integers

	HeapPriorityQueue<Integer> nonEmptyQueue;
	HeapPriorityQueue<Integer> emptyQueue;

	@BeforeEach
	void setUp() throws Exception {
		nonEmptyQueue = new HeapPriorityQueue<Integer>(INT_FIXTURE.length);
		emptyQueue = new HeapPriorityQueue<Integer>(INT_FIXTURE.length);

		for (int testData : INT_FIXTURE) {
			nonEmptyQueue.enqueue(testData);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		nonEmptyQueue = null;
		emptyQueue = null;
	}

	@Test
	void testClearNonEmptyQueue() {
		nonEmptyQueue.clear();
		assertTrue(nonEmptyQueue.isEmpty(), "intQueue borde vara tom efter en clear");
	}

	@Test
	void testClearEmptyQueue() {
		emptyQueue.clear();
		assertTrue(emptyQueue.isEmpty(), "emptyQueue should be empty after clear");
	}

	@Test
	void testIsEmptyNonEmptyQueue() {
		assertFalse(nonEmptyQueue.isEmpty(), "nonEmptyQueue should not be empty");
	}

	@Test
	void testIsEmptyEmptyQueue() {
		assertTrue(emptyQueue.isEmpty(), "emptyQueue borde vara tom från början");
	}

	@Test
	void testEnqueueEmptyQueue() {
		emptyQueue.enqueue(1);
		assertFalse(emptyQueue.isEmpty(), "EmptyQueue border inte vara tom");
	}

	@Test
	void testEnqueueNonEmptyQueue() {
		try {
			nonEmptyQueue.enqueue(10);
			throw new AssertionError("Expected PriorityQueueFullException but no exception was thrown");
		} catch (PriorityQueueFullException e) {
			return;
		} catch (Exception e) {
			throw new AssertionError(
					"Expected PriorityQueueEmptyException but got " + e.getClass().getName());
		}
	}


	@Test
	void testDequeueEmptyQueue() {
		try {
			emptyQueue.dequeue();
			throw new AssertionError("Expected PriorityQueueEmptyException but no exception was thrown");
		} catch (PriorityQueueEmptyException e) {
			return;
		} catch (Exception e) {
			throw new AssertionError(
					"Expected PriorityQueueEmptyException but got " + e.getClass().getName());
		}
	}

	@Test
	void testDequeueNonEmptyQueue() {
		assertEquals(9, nonEmptyQueue.dequeue(), "nonEmptyQueue should return the first element");
		assertEquals(8, nonEmptyQueue.dequeue(), "nonEmptyQueue should return the second element");
	}

	@Test
	void testSizeNonEmptyQueue() {
		assertEquals(INT_FIXTURE.length, nonEmptyQueue.size(), "nonEmptyQueue should have the same size as the fixture");
	}

	@Test
	void testSizeEmptyQueue() {
		assertEquals(0, emptyQueue.size(), "emptyQueue should have size 0");
	}

	@Test
	void testGetFrontEmptyQueue() {
		try {
			emptyQueue.getFront();
			throw new AssertionError("Expected PriorityQueueEmptyException but no exception was thrown");
		} catch (PriorityQueueEmptyException e) {
			return;
		} catch (Exception e) {
			throw new AssertionError(
					"Expected PriorityQueueEmptyException but got " + e.getClass().getName());
		}
	}

	@Test
	void testGetFrontNonEmptyQueue() {
		assertEquals(9, nonEmptyQueue.getFront(), "nonEmptyQueue should return the first element and not remove it");
		assertEquals(9, nonEmptyQueue.getFront(), "nonEmptyQueue should return the first element again");
	}

}
