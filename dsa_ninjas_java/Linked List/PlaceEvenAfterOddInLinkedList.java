import java.util.Arrays;

public class PlaceEvenAfterOddInLinkedList {
    public static void evenAfterOdd(LinkedList<Integer> linkedList) {
        Node<Integer> current = linkedList.head, unfit = linkedList.head, currentPrevious = null,
                unfitPrevious = null;
        while (current != null) {
            if (current.data % 2 != 0) {
                if (unfitPrevious != null)
                    unfitPrevious.next = current;
                else
                    linkedList.head = current;

                if (currentPrevious != null)
                    currentPrevious.next = unfit;

                Node<Integer> temp = unfit.next;
                unfit.next = current.next;
                current.next = temp;

                // tricky steps
                // swince unfit and current got swapped, we'll have to get next unfit
                // from current's next
                unfitPrevious = current;
                unfit = current.next;

                // similar tricky steps
                currentPrevious = unfit;
                current = unfit.next;
                continue;
            }
            currentPrevious = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Arrays.stream(new Integer[] { 5, 4, 1, 6, 3, 9, 8, 7, 2, 0 }).forEach(i -> linkedList.addLast(i));
        evenAfterOdd(linkedList);
        System.out.println(linkedList);
    }
}
