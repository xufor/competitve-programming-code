import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InsertionSort {
    /*
     * || ------- Philosophy of Insertion Sort ------- ||
     * => [sorted array of just one element i.e. the first element] , [unsorted array with elements except for the first element]
     * => [sorted array of just one element i.e. the first element] + [one element from unsorted portion i.e. the first one, placed at its appropriate position in the sorted portion], [unsorted array with one less element than it initially had]
     * => keep repeating the aboved step untill all elemets from unsorted portion are placed in the sorted portion
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
        System.out.println(sort(new ArrayList<>(Arrays.asList(new Integer[] { }))));
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
