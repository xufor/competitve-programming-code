public class MiddlePointOfLinkedList<T> extends LinkedList<T> {
    public static <T> Node<T> middle(Node<T> slowPointer, Node<T> fastPointer) {
        while (fastPointer != null && fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    public static <T> Node<T> middle(Node<T> head) {
        return middle(head, head);
    }

    public static void main(String[] args) {
        System.out
                .println(MiddlePointOfLinkedList
                        .middle(LinkedList.contruct(new Integer[] { 1, 2, 3, 4, 5, 6 }).head).data);
        System.out
                .println(MiddlePointOfLinkedList
                        .middle(LinkedList.contruct(new Integer[] { 1, 2, 3, 4, 5 }).head).data);
        System.out
                .println(MiddlePointOfLinkedList
                        .middle(LinkedList.contruct(new Integer[] { 1 }).head).data);
        System.out
                .println(MiddlePointOfLinkedList
                        .middle(LinkedList.contruct(new Integer[] {}).head));
    }
}