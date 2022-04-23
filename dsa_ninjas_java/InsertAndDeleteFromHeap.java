import java.util.Arrays;

class ArrayUtils {
    public static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}

class MaxHeap {
    private int heap[] = new int[500];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int data) {
        heap[size] = data;
        upHeapify(size);
        size += 1;
    }

    public void upHeapify(int childIndex) {
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            if (heap[parentIndex] < heap[childIndex]) {
                ArrayUtils.swap(heap, parentIndex, childIndex);
                childIndex = parentIndex;
            } else {
                return;
            }
        }
    }

    public int delete() {
        int deletedElement = heap[0];
        heap[0] = heap[size - 1];
        size -= 1;
        downHeapify(0);
        return deletedElement;
    }

    public void downHeapify(int parentIndex) {
        int leftChildIndex = (parentIndex * 2) + 1;
        int rightChildIndex = (parentIndex * 2) + 2;
        int largestElementIndex = parentIndex;

        if (leftChildIndex < size && heap[leftChildIndex] > heap[largestElementIndex])
            largestElementIndex = leftChildIndex;

        if (rightChildIndex < size && heap[rightChildIndex] > heap[largestElementIndex])
            largestElementIndex = rightChildIndex;

        if (parentIndex != largestElementIndex) {
            ArrayUtils.swap(heap, parentIndex, largestElementIndex);
            downHeapify(largestElementIndex);
        }
    }
}

public class InsertAndDeleteFromHeap {
    public static void main(String[] args) {
        var maxHeap = new MaxHeap();
        Arrays.stream(new int[] { 6, 7, 74, 4, 9, 5, 79, 1 }).forEach(e -> maxHeap.insert(e));
        while (!maxHeap.isEmpty())
            System.out.print(maxHeap.delete() + " ");
    }
}
