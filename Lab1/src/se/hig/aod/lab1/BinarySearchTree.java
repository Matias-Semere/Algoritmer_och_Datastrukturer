package se.hig.aod.lab1;

/**
 * A binary search tree implementation that maintains elements in sorted order.
 * 
 * @param <T> the type of elements stored in the tree, must implement Comparable
 * @author Matias Semere
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements SearchableDataStructure<T> {

    /** The number of elements currently stored in the tree */
    private int size;
    
    /** The root node of the binary search tree */
    private Treenode root;

        /**
         * Returns the number of elements in the tree.
         * 
         * @return the number of elements
         */
        @Override
        public int size() {
                return size;
        }

        /**
         * Adds a new element to the tree while maintaining BST property.
         * 
         * @param newElement the element to add, must not be null
         * @throws IllegalArgumentException if the element is null
         */
        @Override
        public void addElement(T newElement) {
                if (newElement == null) {
                        System.err.println("Element cannot be null");
                }
                root = recursiveAdd(root, newElement);
        }

        /**
         * Recursively adds a new element to the appropriate position.
         * 
         * @param current the current node being examined, may be null
         * @param newElement the element to add to the tree
         * @return the node that should be at this position after insertion
         */
        private Treenode recursiveAdd(Treenode current, T newElement) {
                if (current == null) {
                        size++;
                        return new Treenode(newElement);
                }
                int comparison = newElement.compareTo(current.data);
                if (comparison < 0) {
                        current.left = recursiveAdd(current.left, newElement);
                } else if (comparison > 0) {
                        current.right = recursiveAdd(current.right, newElement);
                }
                return current;
        }

        /**
         * Searches for an element in the tree using binary search.
         * 
         * @param elementToFind the element to search for, may be null
         * @return the found element if it exists, null otherwise
         */
        @Override
        public T searchElement(T elementToFind) {
                if (elementToFind == null) {
                        return null;
                }
                Treenode result = recursiveSearch(root, elementToFind);
                return result != null ? result.data : null;
        }

        /**
         * Returns a string representation of the tree in sorted order.
         * 
         * @return a string representation of all elements
         */
        @Override
        public String toString() {
                return recursiveToString(root);
        }

        /**
         * Performs an in-order traversal and returns the elements as a string.
         * 
         * @param current the current node being visited, may be null
         */
        private String recursiveToString(Treenode current) {
                if (current == null) return "";
                return recursiveToString(current.left) + current.data + recursiveToString(current.right);
        }

        /**
         * Recursively searches for an element in the subtree.
         * 
         * @param current the current node being examined, may be null
         * @param elementToFind the element to search for
         * @return the Treenode containing the element if found, null otherwise
         */
        private Treenode recursiveSearch(Treenode current, T elementToFind) {
                if (current == null) {
                        return null;
                }

                int comparison = elementToFind.compareTo(current.data);
                if (comparison == 0) {
                        return current;
                } else if (comparison < 0) {
                        return recursiveSearch(current.left, elementToFind);
                } else {
                        return recursiveSearch(current.right, elementToFind);
                }
        }

        /**
         * A private inner class representing a node in the binary search tree.
         */
        class Treenode {

                private T data;             
                private Treenode left;
                private Treenode right;

                /**
                 * Constructs a new tree node with the specified data.
                 * 
                 * @param data the data to store
                 */
                public Treenode(T data) {
                        this.data = data;
                }
        }

}
