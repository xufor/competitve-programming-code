public class MergeSort {
    public static void mergesort(int arr[], int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergesort(arr, low, mid);
            mergesort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int leftLength = mid - low + 1;
        int rightLength = high - (mid + 1) + 1; // can also write high - mid 😅
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];
        int i, j, k;
        // copying left and right side elements from original array
        for(i = low, j = 0; i <= mid; i++)
            leftArray[j++] = arr[i];
        for(i = mid + 1, j = 0; i <= high; i++)
            rightArray[j++] = arr[i];
        // comparing and copying the elements into the original array until one of the sides gets exhausted
        for(i = 0, j = 0, k = low; i < leftLength && j < rightLength; )
            if(leftArray[i] < rightArray[j])
                arr[k++] = leftArray[i++];
            else
                arr[k++] = rightArray[j++];
        // checking which side got exhausted and enssuring that other side also gets exhausted
        if(i == leftLength)
            while(j != rightLength)
                arr[k++] = rightArray[j++];
        else
            while(i != leftLength)
                arr[k++] = leftArray[i++];
    }

    public static void mergesort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }

    public static void main(String args[]) {
        int arr[] = { 9, 6, 2, 3,};
        mergesort(arr);
        for(int x : arr)
            System.out.print(x + " ");
    }
}