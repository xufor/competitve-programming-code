public class MergeTwoSortedLinkedLists {
    public static Node<Integer> merge(Node<Integer> pointer1, Node<Integer> pointer2) {
        if (pointer1 == null) {
            return pointer2;
        } else if (pointer2 == null) {
            return pointer1;
        } else {
            Node<Integer> finalHead = null, finalTail = null;
            while (pointer1 != null && pointer2 != null) {
                if (pointer1.data < pointer2.data) {
                    if (finalHead == null && finalTail == null) {
                        finalHead = finalTail = pointer1;
                    } else {
                        finalTail.next = pointer1;
                        finalTail = pointer1;
                    }
                    pointer1 = pointer1.next;
                } else {
                    if (finalHead == null && finalTail == null) {
                        finalHead = finalTail = pointer2;
                    } else {
                        finalTail.next = pointer2;
                        finalTail = pointer2;
                    }
                    pointer2 = pointer2.next;
                }
                if (pointer1 != null) {
                    finalTail.next = pointer1;
                }
                if (pointer2 != null) {
                    finalTail.next = pointer2;
                }
            }
            return finalHead;
        }
    }

    public static void main(String[] args) {
        LinkedList.print(merge(LinkedList.contruct(new Integer[] { 1, 3, 5, 8, 10 }).head,
                LinkedList.contruct(new Integer[] { 4, 6, 9, 10 }).head));

        LinkedList.print(merge(LinkedList.contruct(new Integer[] { 1 }).head,
                LinkedList.contruct(new Integer[] { 0, 2 }).head));

        LinkedList.print(merge(LinkedList.contruct(new Integer[] { }).head,
                LinkedList.contruct(new Integer[] { 4 }).head));
    }
}
