import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InsertionSort {
    /*
     * [5,1,4,3,2] -> BEGIN
     * [5|1,4,3,2] -> target = 1 | 5 is shifted to the right, 1 is placed at index 0 i.e. before 5
     * [1,5|4,3,2] -> target = 4 | 5 is shifted to the right, 4 is placed at index 1 i.e. before 5
     * [1,4,5|3,2] -> target = 3 | 4 and 5 are shifted to the right, 3 is placed at index 2 i.e. before 4
     * [1,3,4,5|2] -> target = 2 | 3, 4 and 5 are shifted to the right, 2 is placed at index 1 i.e. before 3
     * [1,2,3,4,5] -> END
     */

    public static ArrayList<Integer> sort(ArrayList<Integer> arr) {
        // i goes first to second element to last element
        for (int i = 1; i < arr.size(); i++) {
            int j = i - 1, target = arr.get(i);
            while (j >= 0 && target < arr.get(j)) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, target);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(sort(new ArrayList<>(Arrays.asList(new Integer[] { 4, 1, 3 }))));
        System.out.println(sort(new ArrayList<>(Arrays.asList(new Integer[] { 4 }))));
        System.out.println(sort(new ArrayList<>(Arrays.asList(new Integer[] { 4, 1 }))));
        System.out.println(sort(new ArrayList<>(Arrays.asList(new Integer[] {}))));
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
