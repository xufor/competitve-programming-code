public class ReverseLinkedList {
    public static Node<Integer> reverse(Node<Integer> previous, Node<Integer> current) {
        if (current != null) {
            Node<Integer> lastNode = reverse(current, current.next);
            current.next = previous;
            return lastNode;
        }
        return previous;
    }

    public static Node<Integer> reverse(Node<Integer> head) {
        return reverse(null, head);
    }

    public static LinkedList<Integer> reverse(LinkedList<Integer> linkedList) {
        Node<Integer> previous = null, current = linkedList.head, next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        linkedList.head = previous;
        return linkedList;
    }

    public static void main(String[] args) {
        Integer[][] testAtrrays = { { 1, 2, 3, 4, 5 }, { 1, 2 }, { 1 }, {} };
        for (Integer[] testArray : testAtrrays) {
            System.out.println(reverse(LinkedList.contruct(testArray)));
            LinkedList.print(reverse(LinkedList.contruct(testArray).head));
        }
    }
}
