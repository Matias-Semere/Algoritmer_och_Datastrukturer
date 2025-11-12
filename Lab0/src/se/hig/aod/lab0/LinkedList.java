package se.hig.aod.lab0;

public class LinkedList<T> implements List<T> {

    Node<T> head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int numberOfElements() {
        return size;
    }

    public void insertFirst(T t) {
        Node<T> newNode = new Node<>();
        newNode.data = t;
        newNode.next = this.head;

        this.head = newNode;
        this.size++;
    }

    public void insertLast(T t) {
        Node<T> newNode = new Node<>();
        newNode.data = t;
        newNode.next = null;

        if (this.head == null) {
            this.head = newNode;
            this.size++;
            return;
        }
        Node<T> current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public T removeFirst() {
        if (head == null)
            throw new ListEmptyException("Den är ju tom ");
        else if (size == 1) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }
        Node<T> current = head;
        head = head.next;
        size--;
        return current.data;
    }

    public T removeLast() {
        return null;
    }

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    class Node<T> {
        T data;
        Node<T> next;
    }

}
