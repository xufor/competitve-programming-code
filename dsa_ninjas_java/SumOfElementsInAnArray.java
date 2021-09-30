public class SumOfElementsInAnArray {
    public static int sumOfElementsInAnArray(int[] arr, int current) {
        if(current == arr.length) {
            return 0;
        }
        return arr[current] + sumOfElementsInAnArray(arr, current + 1);
    }

    public static int sumOfElementsInAnArray(int[] arr) {
        return sumOfElementsInAnArray(arr, 0);
    }

    public static void main(String[] args) {
        int[] a = { 1,4,9,16,25 };
        System.out.println(sumOfElementsInAnArray(a));
    }   
}