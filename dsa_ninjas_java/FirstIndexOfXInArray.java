public class FirstIndexOfXInArray {
    public static int firstIndexOfXInArray(int[] arr, int target, int current) {
        if(current == arr.length)
            return -1;
        if(arr[current] == target)
            return current;
        return firstIndexOfXInArray(arr, target, current + 1);
    }

    public static int firstIndexOfXInArray(int[] arr, int target) {
        return firstIndexOfXInArray(arr, target, 0);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 7, 3, 4, 9, 7, 8, 9 };
        System.out.println(firstIndexOfXInArray(arr, 9));
    }
}
