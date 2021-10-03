public class QuickSort {
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high], i = low, j = low;
        // the pointer j always moves
        // the pointer i only moves when swapping occurs
        // i keeps track of which next big value you take to the right 🤯
        // j keeps moving and as soon as it encounters a small value
        // it contacts i for the next big value that can be sent to the right 😏
        // when the loop ends, i will be pointing at the correct location
        // where the pivot should be kept 😉
        for(; j < high; j++) {
            if(arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    public static void quicksort(int[] arr, int low, int high) {
        if(low < high) {
            int partitionIndex = partition(arr, low, high);
            quicksort(arr, low, partitionIndex - 1);
            quicksort(arr, partitionIndex + 1, high);
        }
    }
    
    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 9, 6, 2, 3, 1, 0, 5, 4, 7, 8 };
        quicksort(arr);
        for(int x : arr)
            System.out.print(x + " ");
    }
}
