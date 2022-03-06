class Node<T> {
    public T data;
    public Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    private Node<T> head;

    LinkedList() {
        this.head = null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<T>(data), temp = head;
        if (head == null) {
            head = newNode;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
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
            Node<T> temp1 = null, temp2 = head;
            while (temp2.next != null) {
                temp1 = temp2;
                temp2 = temp2.next;
            }
            T data = temp2.data;
            if(temp1 == null) // only one element
                head = null;
            else
                temp1.next = null;
            return data;
        }
        return null;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "EMPTY";
        }
        Node<T> temp = head;
        String linkedListString = "";
        while (temp != null) {
            linkedListString += temp.data + " ";
            temp = temp.next;
        }
        return linkedListString;
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

        for (String str : new String[] { "A", "G", "E", "Z", "T" }) {
            ll.addLast(str);
        }
    }
}
