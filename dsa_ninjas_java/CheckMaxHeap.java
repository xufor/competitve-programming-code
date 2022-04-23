public class CheckMaxHeap {
    public static boolean check(int heap[]) {
        // we will go from last parent with any child to the root of heap
        // last child's index is (heap.length - 1)
        // formula for parent is (childIndex - 1) / 2
        // thus the last parent's index will be ((heap.length - 1) - 1) / 2
        // i.e. (heap.length - 2) / 2
        for (int i = 0; i <= (heap.length - 2) / 2; i++) {
            int leftChildIndex = i * 2 + 1;
            int rightChildIndex = i * 2 + 2;

            if(leftChildIndex < heap.length && heap[leftChildIndex] > heap[i])
                return false;

            if(rightChildIndex < heap.length && heap[rightChildIndex] > heap[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] testCases = { { 79, 9, 74, 4, 6, 5, 7, 1 }, { 79, 9, 74, 0, 6, 5, 7, 1 } };
        for(var testCase: testCases) {
            System.out.println(check(testCase));
        }
    }
}