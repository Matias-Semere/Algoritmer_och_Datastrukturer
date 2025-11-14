package se.hig.aod.lab0;

public class LinkedList<T> implements PrintableList<T> {

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int numberOfElements() {
        return size;
    }

    public void insertFirst(T t) {
        Node newNode = new Node(t);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertLast(T t) {
        Node newNode = new Node(t);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
        }

        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
        }

        if (head.next == null) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
        }
        return head.data;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public String toStringRecursive() {
        if (isEmpty())
            return "";
        String svar = "[";
        for (int i = 0; i < size; i++) {
            if (head.data != null) {
                svar += head.data + ",";
                head = head.next;
            }
        }
        svar = svar.substring(0, svar.length() - 1);
        return svar + "]";
    }

    @Override
    public String toStringReverseRecursive() {
        if (isEmpty())
            return null;
        String svar = "[";
        String temp = toStringRecursive();
        temp = temp.substring(1, temp.length() - 1);
        String[] split = temp.split(",");

        for (int i = split.length - 1; i >= 0; i--) {
            svar += split[i] + ",";
        }
        svar = svar.substring(0, svar.length() - 1);
        return svar + "]";
    }
}
