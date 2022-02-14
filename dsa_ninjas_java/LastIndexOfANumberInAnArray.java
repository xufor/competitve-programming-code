public class LastIndexOfANumberInAnArray {
    public static int lastIndexOf(int target, int arr[], int currentIndex, int maxIndexFound) {
        if (currentIndex == arr.length) {
            return maxIndexFound;
        } else if (arr[currentIndex] == target) {
            return lastIndexOf(target, arr, currentIndex + 1, currentIndex);
        } else {
            return lastIndexOf(target, arr, currentIndex + 1, maxIndexFound);
        }
    }

    public static int lastIndexOf(int target, int arr[]) {
        return lastIndexOf(target, arr, 0, -1);
    }

    public static void main(String args[]) {
        int arr1[] = { 1, 5, 3, 4, 5, 6, 7, 8, 5, 10 };
        int arr2[] = { 1, 5 };
        int arr3[] = {};
        int arr4[] = { 6 };
        System.out.println(lastIndexOf(5, arr1));
        System.out.println(lastIndexOf(5, arr2));
        System.out.println(lastIndexOf(5, arr3));
        System.out.println(lastIndexOf(5, arr4));
    }
}