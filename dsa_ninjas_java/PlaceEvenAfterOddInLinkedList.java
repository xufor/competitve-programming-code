public class PlaceEvenAfterOddInLinkedList {
    public static void evenAfterOdd(LinkedList<Integer> linkedList) {
        Node<Integer> i = linkedList.head, j = linkedList.head;
        while (i != null) {
            if (i.data % 2 != 0) {
                Integer temp = i.data;
                i.data = j.data;
                j.data = temp;
                j = j.next;
            }
            i = i.next;
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
