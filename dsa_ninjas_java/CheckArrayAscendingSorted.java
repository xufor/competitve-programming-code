public class CheckArrayAscendingSorted {
    private static boolean check(int arr[], int currentIndex) {
        if (currentIndex >= arr.length - 1 || arr[currentIndex] > arr[currentIndex + 1]) {
            return false;
        }
        return check(arr, currentIndex + 1);
    }

    public static void main(String args[]) {
        int arr1[] = { 7, 8, 2, 3, 1, 4, 6, 9, 10, 5 };
        int arr2[] = { 1, 2, 3, 4, 5 };
        int arr3[] = { 1 };
        int arr4[] = {};
        System.out.println(check(arr1, 0));
        System.out.println(check(arr2, 0));
        System.out.println(check(arr3, 0));
        System.out.println(check(arr4, 0));
    }
}