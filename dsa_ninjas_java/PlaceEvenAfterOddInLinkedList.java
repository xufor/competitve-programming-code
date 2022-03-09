import java.util.Arrays;

public class PlaceEvenAfterOddInLinkedList {
    public static void evenAfterOdd(LinkedList<Integer> linkedList) {
        Node<Integer> current = linkedList.head, swapCandidate = linkedList.head, currentPrevious = null,
                swapCandidatePrevious = null;
        while (current != null) {
            if (current.data % 2 != 0) {
                if (swapCandidate == linkedList.head)
                    linkedList.head = current;

                if (swapCandidatePrevious != null)
                    swapCandidatePrevious.next = current;
                if (currentPrevious != null)
                    currentPrevious.next = swapCandidate;

                Node<Integer> temp = swapCandidate.next;
                swapCandidate.next = current.next;
                current.next = temp;

                // tricky steps
                // swince swapCandidate and current got swapped, we'll have to get next swapCandidate
                // from current's next
                swapCandidatePrevious = current;
                swapCandidate = current.next;

                // similar tricky steps
                currentPrevious = swapCandidate;
                current = swapCandidate.next;
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
