public class MergeSortLinkedList {
    public static Node<Integer> sort(Node<Integer> head) {
        if (head != null && head.next != null) {
            Node<Integer> middle = MiddlePointOfLinkedList.middle(head), headOfSecondPart = middle.next;
            middle.next = null;
            Node<Integer> headOfSortedFirstPart = sort(head);
            Node<Integer> headOfSortedSecondPart = sort(headOfSecondPart);
            return MergeTwoSortedLinkedLists.merge(headOfSortedFirstPart, headOfSortedSecondPart);
        }
        return head;
    }

    public static Node<Integer> sort(LinkedList<Integer> linkedList) {
        return sort(linkedList.head);
    }

    public static void main(String[] args) {
        LinkedList.print(sort(LinkedList.contruct(new Integer[] { 9, 5, 7, 8, 4, 6, 2, 1, 3, 0 })));
        LinkedList.print(sort(LinkedList.contruct(new Integer[] { 9, 5, 7, 8, -4, -10, -8, -6, 4 })));
        LinkedList.print(sort(LinkedList.contruct(new Integer[] { 0, -1 })));
        LinkedList.print(sort(LinkedList.contruct(new Integer[] { -1 })));
        LinkedList.print(sort(LinkedList.contruct(new Integer[] {})));
    }
}
