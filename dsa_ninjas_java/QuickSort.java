import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QuickSort {
    public static int partition(ArrayList<Integer> arr, int start, int end) {
        int pivot = arr.get(end), i = start, j = start;
        while (i < end) {
            if (arr.get(i) < pivot) {
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

    public static ArrayList<Integer> sort(ArrayList<Integer> arr) {
        sort(arr, 0, arr.size() - 1);
        return arr;
    }

    public static void main(String[] args) {
        Integer[][] testArrays = { { 9, 5, 7, 8, 4, 6, 2, 1, 3, 0 }, { 1, 3, 5, 2, 4 }, {}, { 5 },
                { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }, { 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1 },
                { -1, -5, 7, -1, -5, 8, 9, 8, 8, 7, 2, 6, 7 } };
        Arrays.stream(testArrays).forEach(arr -> System.out.println(sort(new ArrayList<>(Arrays.asList(arr)))));
    }
}
