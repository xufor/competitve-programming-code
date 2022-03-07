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

                // important steps
                // the next swap candidate must be the next element to the resolved portion of the list
                swapCandidatePrevious = current;
                swapCandidate = current.next;
            }
            currentPrevious = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (Integer i : new Integer[] { 5, 4, 1, 6, 3, 9, 8, 7, 2, 0 }) {
            ll.addLast(i);
        }
        evenAfterOdd(ll);
        System.out.println(ll);
    }
}
