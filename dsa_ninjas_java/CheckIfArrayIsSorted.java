public class CheckIfArrayIsSorted {
    public static boolean check(int[] arr, int currentIndex) {
        if(currentIndex == arr.length) {
            return true;
        }
        if(arr[currentIndex] > arr[currentIndex-1]) {
            return check(arr, currentIndex + 1);
        }
        return false;
    }

    public static boolean check(int arr[]) {
        if(arr.length < 2) {
            return true;
        }
        return CheckIfArrayIsSorted.check(arr, 1);
    }

    public static void main(String[] args) {
        int[] a = {1,4,9,16,25};
        int[] b = {1,4,19,16,25};
        System.out.println(check(a));
        System.out.println(check(b));
    }
}
