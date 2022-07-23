import java.util.Iterator;

public class SortedList<E extends Comparable<? super E>> extends List<E> {

    // Insert method
    public void insert(E data) {
        Node<E> curr = head;
        head = insertHelper(data, curr);
    }

    // Insert helper method
    public Node<E> insertHelper(E data, Node<E> curr) {
        // Empty list
        if (curr == null) {
            Node<E> temp = new Node<E>(data);
            curr = temp;
            temp.next = null;
            return curr;
        }

        if (data.compareTo(curr.data) < 0) {
            Node<E> temp = new Node<E>(data);
            temp.next = curr;
            curr = temp;
            return curr;
        } else {
            curr.next = insertHelper(data, curr.next);
            return curr;
        }
    }

    // Remove method
    public void remove(E data) {
        Node<E> curr = head;
        head = removeHelper(data, curr);
    }

    // Remove helper method
    public Node<E> removeHelper(E data, Node<E> curr) {
        if (curr == null) {
            return null;
        }

        if (data.compareTo(curr.data) == 0) {
            curr = curr.next;
            return curr;
        } else {
            curr.next = removeHelper(data, curr.next);
            return curr;
        }
    }

    // Retrieve method
    public E retrieve(int index) {
        Node<E> curr = head;
        int count = 0;
        return retrieveHelper(index, curr, count);
    }

    // Retrieve helper method
    public E retrieveHelper(int index, Node<E> curr, int count) {
        if (curr == null) {
            return null;
        }

        if (index == count) {
            return curr.data;
        } else {
            return retrieveHelper(index, curr.next, count + 1);
        }
    }

    // Search method
    public boolean search(E data) {
        Node<E> curr = head;
        return searchHelper(data, curr);
    }

    // Search helper method
    public boolean searchHelper(E data, Node<E> curr) {
        if (curr == null) {
            return false;
        }

        if (data.compareTo(curr.data) == 0) {
            return true;
        } else {
            return searchHelper(data, curr.next);
        }
    }

    // Iterator method
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> curr = head;

            public boolean hasNext() {
                return curr != null;
            }

            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }

        };
    }

}
