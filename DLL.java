public class DLL<T> {

    // Node structure
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the size of the list
    public int size() {
        return size;
    }

    // Add node to the front (beginning)
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add node to the end (tail)
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Remove node from the front
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T removedData = head.data;
        if (head == tail) { // Only one element
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return removedData;
    }

    // Remove node from the end
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T removedData = tail.data;
        if (head == tail) { // Only one element
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removedData;
    }

    // Delete first occurrence of a specific value
    public boolean remove(T data) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(data)) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Check if the list contains a value
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Traverse forward from head to tail
    public void printForward() {
        Node<T> current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Traverse backward from tail to head
    public void printBackward() {
        Node<T> current = tail;
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Example usage
    public static void main(String[] args) {
        DLL<Integer> dll = new DLL<>();

        dll.addLast(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.addFirst(5);

        // Output: Forward: 5 <-> 10 <-> 20 <-> 30 <-> null
        dll.printForward();

        // Output: Backward: 30 <-> 20 <-> 10 <-> 5 <-> null
        dll.printBackward();

        dll.remove(20); // Remove middle element
        dll.removeFirst(); // Remove head

        // Output: Forward: 10 <-> 30 <-> null
        dll.printForward();
        
        System.out.println("Size: " + dll.size()); // Output: 2
    }
}