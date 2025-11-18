package se.hig.aod.lab0;

public class ArrayStack<T> implements Stack<T> {

        int top;
        T[] array;

        public ArrayStack(int capacity) {
                array = (T[]) new Object[capacity];
                top = -1;
        }

        @Override
        public void clear() {
                array = (T[]) new Object[array.length];
                top = -1;
        }

        @Override
        public boolean isEmpty() {
                return top == -1;
        }

        @Override
        public boolean isFull() {
                return top == array.length - 1;
        }

        @Override
        public void push(T element) {
                if (isFull()) {
                        throw new StackFullException("Stack is full");
                }
                array[++top] = element;
        }

        @Override
        public T pop() {
                if (isEmpty()) {
                        throw new StackEmptyException("Stack is empty");
                }
                T data = array[top];
                array[top--] = null;
                return data;
        }

        @Override
        public T peek() {
                if (isEmpty()) {
                        throw new StackEmptyException("Stack is empty");
                }
                return array[top];
        }

}
