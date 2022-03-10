class Node<T> {
    public T data;
    public Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    public Node<T> head;

    LinkedList() {
        this.head = null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<T>(data), current = head;
        if (head == null) {
            head = newNode;
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public T deleteFirst() {
        if (head != null) {
            T data = head.data;
            head = head.next;
            return data;
        }
        return null;
    }

    public T deleteLast() {
        if (head != null) {
            Node<T> previous = null, current = head;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            T data = current.data;
            if (previous == null) // only one element
                head = null;
            else
                previous.next = null;
            return data;
        }
        return null;
    }

    public void insert(T data, long index) {
        if (index == 0) {
            addFirst(data);
        } else {
            Node<T> current = head, newNode = new Node<T>(data);
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("INVALID INDEX");
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    public T delete(long index) {
        if (index == 0) {
            if(head == null) {
                System.out.println("INVALID INDEX");
                return null;
            }
            return deleteFirst();
        } else {
            T data;
            Node<T> current = head;
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null || current.next == null) {
                System.out.println("INVALID INDEX");
                return null;
            } else {
                data = current.next.data;
                current.next = current.next.next;
                return data;
            }
        }
    }

    public long length(Node<T> head) {
        if(head == null) {
            return 0;
        }
        return 1 + length(head.next);
    }

    public long length() {
        return length(this.head);
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        Node<T> current = head;
        String linkedListString = "[";
        while (current != null) {
            linkedListString += current.data + (current.next != null ? ", " : "");
            current = current.next;
        }
        return linkedListString + "]";
    }
}

public class AddAndRemoveFromLinkedList {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        System.out.println(ll);
        for (String str : new String[] { "A", "C", "Z", "D", "R" }) {
            ll.addLast(str);
            System.out.println("ADDED: " + str);
        }
        for (String str : new String[] { "F", "G", "Y", "P", "E" }) {
            ll.addLast(str);
            System.out.println("ADDED: " + str);
        }
        System.out.println(ll);
        for (int i = 0; i < 5; i++) {
            System.out.println("DELETED: " + ll.deleteFirst());
        }
        System.out.println(ll);
        for (int i = 0; i < 5; i++) {
            System.out.println("DELETED: " + ll.deleteLast());
        }
        System.out.println(ll);
        ll.insert("X", 0);
        System.out.println(ll);
        ll.insert("Y", 1);
        System.out.println(ll);
        ll.insert("E", 3);
        System.out.println(ll);
        ll.insert("Z", 1);
        System.out.println(ll);
        ll.insert("W", 0);
        System.out.println(ll);
        ll.insert("R", 3);
        System.out.println(ll);

        System.out.println("DELETED: " + ll.delete(0));
        System.out.println(ll);

        System.out.println("DELETED: " + ll.delete(3));
        System.out.println(ll);

        System.out.println("DELETED: " + ll.delete(3));
        System.out.println(ll);

        System.out.println("DELETED: " + ll.delete(1));
        System.out.println(ll);

        System.out.println("DELETED: " + ll.delete(1));
        System.out.println(ll);

        System.out.println("DELETED: " + ll.delete(0));
        System.out.println(ll);
    }
}
