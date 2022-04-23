import java.util.ArrayList;
import java.util.PriorityQueue;

class Data {
    int element;
    int parentArray;
    int indexOfDataInArray;

    public Data(int element, int parentArray, int indexOfDataInArray) {
        this.element = element;
        this.parentArray = parentArray;
        this.indexOfDataInArray = indexOfDataInArray;
    }
}

public class MergeKSortedArrays {
    public static ArrayList<Integer> merge(int[][] arrays) {
        var result = new ArrayList<Integer>();
        var heap = new PriorityQueue<Data>((a, b) -> a.element - b.element);
        
        // add the first element of all arrays into the heap
        for(int i = 0; i < arrays.length; i++) {
            heap.add(new Data(arrays[i][0], i, 0));
        }

        // since keeping track of wich array has been explored to which extend
        // we will keep track of the array information in the heap itself
        // once we have removed an element from heap,
        // we will explore the parent array of the removed element

        while(!heap.isEmpty()) {
            var data = heap.remove();
            result.add(data.element);
            // checking if there are more elements in the array from where the most recent data came
            if(data.indexOfDataInArray < arrays[data.parentArray].length - 1) {
                heap.add(new Data(arrays[data.parentArray][data.indexOfDataInArray + 1], data.parentArray, data.indexOfDataInArray + 1));
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] arrays = new int[][] { { 1, 3, 5, 6 }, { 2, 4, 7 }, { 8, 10 }, { 9 } };
        System.out.println(merge(arrays));
    }
}
