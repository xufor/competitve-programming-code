import java.util.HashMap;
import java.util.stream.IntStream;

public class SubarraysWithZeroSum {
    public static void find(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        int currentCumSum = 0;

        map.put(0, -1);


        for (int i = 0; i < arr.length; i++) {
            currentCumSum += arr[i];
            if (map.containsKey(currentCumSum)) {
                IntStream.range(map.get(currentCumSum) + 1, i+1).forEach(j -> System.out.print(arr[j] + " "));
                System.out.println();
            }
            else 
                map.put(currentCumSum, i);
        }

    }

    public static void main(String[] args) {
        find(new int[] { -6, 5, 9, -8, -6, 2, 4 });
    }
}
