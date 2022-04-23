public class HeapSort {
    public static void downHeapify(int[] heap, int parentIndex, int heapSize) {
        int leftChildIndex = (parentIndex * 2) + 1;
        int rightChildIndex = (parentIndex * 2) + 2;
        int largestElementIndex = parentIndex;

        if (leftChildIndex < heapSize && heap[leftChildIndex] > heap[largestElementIndex])
            largestElementIndex = leftChildIndex;

        if (rightChildIndex < heapSize && heap[rightChildIndex] > heap[largestElementIndex])
            largestElementIndex = rightChildIndex;

        if (parentIndex != largestElementIndex) {
            ArrayUtils.swap(heap, parentIndex, largestElementIndex);
            downHeapify(heap, largestElementIndex, heapSize);
        }
    }

    public static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            downHeapify(arr, i, arr.length);

        for (int i = arr.length - 1; i > 0; i--) {
            ArrayUtils.swap(arr, i, 0);
            downHeapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        var arr = new int[] { 9, 7, 1, 4, 6, 5, 8, 2, 3, 10 };
        sort(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
