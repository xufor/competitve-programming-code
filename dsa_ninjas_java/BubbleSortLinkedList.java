// import java.util.Arrays;

// public class BubbleSortLinkedList {
//     public static void sort(LinkedList<Integer> linkedList) {
//         Node<Integer> pointerA = linkedList.head, pointerAPrevious = null;
//         Node<Integer> pointerB = pointerA, pointerBPrevious = pointerAPrevious;
//         while(pointerA.next != null) {
//             while(pointerB.next != null) {
//             if (pointerB.data > pointerB.next.data) {
//                 if (pointerB == linkedList.head)
//                     linkedList.head = pointerB.next;

//                 if (pointerAPrevious != null)
//                     pointerAPrevious.next = current;
//                 if (pointerBPrevious != null)
//                     pointerBPrevious.next = swapCandidate;

//                 Node<Integer> temp = swapCandidate.next;
//                 swapCandidate.next = current.next;
//                 current.next = temp;


//                 pointerBPrevious = pointerB;
//                 pointerB = pointerB.next;
//             }
//             pointerAPrevious = pointerA;
//             pointerA = pointerA.next;
//         }
//     }

//     public static void main(String[] args) {
//         LinkedList<Integer> linkedList = new LinkedList<>();
//         Arrays.stream(new Integer[] { 5, 4, 1, 6, 3, 9, 8, 7, 2, 0 }).forEach(i -> linkedList.addLast(i));
//         System.out.println(linkedList);
//     }
// }
