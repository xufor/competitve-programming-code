import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BubbleSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> arr) {
        // i goes first to second last element
        for (int i = 0; i < arr.size() - 1; i++) {
            // j goes first to second last element of the unsorted portion of the array
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    Collections.swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] { 4, 1, 3, 8, 9, 5, 3, 1, 8, 7 }));
        System.out.println(sort(arr));
        arr.clear();
        Collections.addAll(arr, new Integer[] { 4, 1, 3, 8, 9, 5, 3, 1, 8, 7 });
        System.out.println(sort(arr));
        arr.clear();
        Collections.addAll(arr, 4, 1, 3, 8, 9, 5, 3, 1, 8, 7);
        System.out.println(sort(arr));
    }
}
