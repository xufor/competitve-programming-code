import java.util.LinkedList;

public class AllIndexesOfANumberInAnArray {
    public static void allIndexesOf(int target, int arr[], int currentIndex, LinkedList<Integer> foundIndexList) {
        if (currentIndex == arr.length) {
            return;
        } else if (arr[currentIndex] == target) {
            foundIndexList.add(currentIndex);
        }
        allIndexesOf(target, arr, currentIndex + 1, foundIndexList);
    }

    public static LinkedList<Integer> allIndexesOf(int target, int arr[]) {
        LinkedList<Integer> foundIndexList = new LinkedList<>();
        allIndexesOf(target, arr, 0, foundIndexList);
        return foundIndexList;
    }

    public static void main(String args[]) {
        int arr1[] = { 1, 5, 3, 4, 5, 6, 7, 8, 5, 10 };
        int arr2[] = { 1, 5 };
        int arr3[] = {};
        int arr4[] = { 6 };
        System.out.println(allIndexesOf(5, arr1));
        System.out.println(allIndexesOf(5, arr2));
        System.out.println(allIndexesOf(5, arr3));
        System.out.println(allIndexesOf(5, arr4));
    }
}
