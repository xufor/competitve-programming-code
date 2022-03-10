import java.util.Arrays;

public class BubbleSortLinkedList {
    public static void sort(LinkedList<Integer> linkedList) {
        long length = linkedList.length();
        for (long i = 0; i < length - 1; i++) {
            Node<Integer> current = linkedList.head, previous = null;
            for (long j = 0; j < length - i - 1; j++) {
                Node<Integer> forward = current.next;
                if (current.data > forward.data) {
                    if (previous == null)
                        linkedList.head = forward;
                    else
                        previous.next = forward;

                    current.next = forward.next;
                    forward.next = current;

                    previous = forward;
                    continue;
                }
                previous = current;
                current = forward;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Arrays.stream(new Integer[] { 5, 4, 1, 2 }).forEach(i -> linkedList.addLast(i));
        sort(linkedList);
        System.out.println(linkedList);
    }
}
