package se.hig.aod.lab0;

public class ArrayQueue<T> implements Queue<T> {

        private T[] array;
        private int front;
        private int rear;
        private int size;

        public ArrayQueue(int capacity) {
                array = (T[]) new Object[capacity];
                front = 0;
                rear = 0;
                size = 0;
        }

        @Override
        public void clear() {
                front = 0;
                rear = 0;
                size = 0;
                array = (T[]) new Object[array.length];
        }

        @Override
        public boolean isEmpty() {
                return size == 0;
        }

        @Override
        public boolean isFull() {
                return size == array.length;
        }

        @Override
        public void enqueue(T element) {
                if (isFull()) {
                        throw new QueueFullException("Queue is full");
                }
                array[rear] = element;
                rear = (rear + 1) % array.length;
                size++;
        }

        @Override
        public T dequeue() {
                if (isEmpty()) {
                        throw new QueueEmptyException("Queue is empty");
                }
                T data = array[front];
                array[front] = null;
                front = (front + 1) % array.length;
                size--;
                return data;
        }

        @Override
        public T getFront() {
                if (isEmpty()) {
                        throw new QueueEmptyException("Queue is empty");
                }
                return array[front];
        }
}