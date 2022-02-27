import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QuickSort {
    public static int partition(ArrayList<Integer> arr, int start, int end) {
        int pivot = arr.get(end), i= 0, j = 0;
        while(i < end) {
            if(arr.get(i) > pivot) {
                Collections.swap(arr, i, j);
                j++;
            }
            i++;
        }
        Collections.swap(arr, j, end);
        return j;
    }

    public static void sort(ArrayList<Integer> arr, int start, int end) {
        if (start < end) {
            // (start == end) means that its single element
            // (start > end) is completely invalid case
            int partitionIndex = partition(arr, start, end);
            sort(arr, start, partitionIndex - 1);
            sort(arr, partitionIndex + 1, end);
        }
    }

    public static void sort(ArrayList<Integer> arr) {
        sort(arr, 0, arr.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] { 9, 5, 7, 8, 4, 6, 2, 1, 3, 0 }));
        sort(arr);
        System.out.println(arr);
    }
}
