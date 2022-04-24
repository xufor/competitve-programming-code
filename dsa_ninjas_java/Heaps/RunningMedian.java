import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    public static void main(String[] args) {
        // 6
        // 6 2 1 3 7 5
        // 12
        // 5 15 1 3 2 8 7 9 10 6 11 4
        // 4
        // 7 3 5 2
        Scanner scnr = new Scanner(System.in);
        int numberOfElements = scnr.nextInt();

        var leftMaxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        var rightMinHeap = new PriorityQueue<Integer>();

        while (numberOfElements-- > 0) {
            int element = scnr.nextInt();

            if(leftMaxHeap.size() == 0 || rightMinHeap.size() == 0) {
                leftMaxHeap.add(element);
            } else if(element > leftMaxHeap.size() && element < rightMinHeap.peek()) {
                leftMaxHeap.add(element);
            } else if(element > rightMinHeap.peek()) {
                leftMaxHeap.add(rightMinHeap.remove());
                rightMinHeap.add(element);
            } else {
                leftMaxHeap.add(element);
            }

            if(leftMaxHeap.size() - rightMinHeap.size() == 2) {
                rightMinHeap.add(leftMaxHeap.remove());
            }


            if ((leftMaxHeap.size() + rightMinHeap.size()) % 2 == 0) {
                System.out.println(((double)leftMaxHeap.peek() + rightMinHeap.peek()) / 2);
            } else {
                System.out.println(leftMaxHeap.peek());
            }
        }

        scnr.close();
    }
}
