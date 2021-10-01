public class AllIndexesOfXInArray {
    public static int allIndexesOfXInArray(int[] arr, int target, int current, int[] ans, int filled) {
        if(current == arr.length)
            return filled;
        if(arr[current] == target)
            ans[filled++] = current;
        return allIndexesOfXInArray(arr, target, current + 1, ans, filled);
    }

    public static int allIndexesOfXInArray(int[] arr, int target, int[] ans) {
        return allIndexesOfXInArray(arr, target, 0, ans, 0);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 9, 7, 3, 4, 9, 7, 8, 9, 0};
        int[] ans = new int[10];
        int filled = allIndexesOfXInArray(arr, 9, ans);
        for(int i = 0; i < filled; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
