import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class MaxHeap {
    private ArrayList<Integer> heap = new ArrayList<>();

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void insert(int data) {
        heap.add(data);
        upHeapify(heap.size() - 1);
    }

    public void upHeapify(int childIndex) {
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            if (heap.get(parentIndex) < heap.get(childIndex)) {
                Collections.swap(heap, parentIndex, childIndex);
                childIndex = parentIndex;
            } else {
                return;
            }
        }
    }

    public int delete() {
        int deletedElement = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        downHeapify(0);
        return deletedElement;
    }

    public void downHeapify(int parentIndex) {
        int leftChildIndex = (parentIndex * 2) + 1;
        int rightChildIndex = (parentIndex * 2) + 2;
        int largestElementIndex = parentIndex;

        if(leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(largestElementIndex))
            largestElementIndex = leftChildIndex;

        if(rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(largestElementIndex))
            largestElementIndex = rightChildIndex;
        
        if(parentIndex != largestElementIndex) {
            Collections.swap(heap, parentIndex, largestElementIndex);
            downHeapify(largestElementIndex);
        }
    }
}

public class InsertAndDeleteFromHeap {
    public static void main(String[] args) {
        var maxHeap = new MaxHeap();
        Arrays.stream(new int[] { 6, 7, 74, 4, 9, 5, 79, 1 }).forEach(e -> maxHeap.insert(e));
        while(!maxHeap.isEmpty())
            System.out.print(maxHeap.delete() + " ");
    }
}
