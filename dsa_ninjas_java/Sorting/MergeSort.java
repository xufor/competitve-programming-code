import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class MergeSort {
    public static void merge(ArrayList<Integer> arr, int start, int middle, int end) {
        ArrayList<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        for (int i = start; i <= middle; i++)
            left.add(arr.get(i));
        for (int i = middle + 1; i <= end; i++)
            right.add(arr.get(i));
        
        ListIterator<Integer> leftIterator = left.listIterator(), rightIterator = right.listIterator(), arrIterator = arr.listIterator(start);
        while(leftIterator.hasNext() && rightIterator.hasNext()) {
            arrIterator.next(); // this step is important as set() method replaces the value of last next/previous call
            int leftIteratorValue = leftIterator.next(), rightIteratorValue = rightIterator.next();
            if(leftIteratorValue < rightIteratorValue) {
                arrIterator.set(leftIteratorValue);
                rightIterator.previous();
            }
            else {
                arrIterator.set(rightIteratorValue);
                leftIterator.previous();
            }
        }

        while(leftIterator.hasNext()) {
            arrIterator.next(); // this step is important as set() method replaces the value of last next/previous call
            arrIterator.set(leftIterator.next());
        }

        while(rightIterator.hasNext()) {
            arrIterator.next(); // this step is important as set() method replaces the value of last next/previous call
            arrIterator.set(rightIterator.next());
        }
    }

    public static void sort(ArrayList<Integer> arr, int start, int end) {
        if (start < end) {
            // (start == end) means that its single element
            // (start > end) is completely invalid case
            int middle = (start + end) / 2;
            sort(arr, start, middle);
            sort(arr, middle + 1, end);
            merge(arr, start, middle, end);
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
