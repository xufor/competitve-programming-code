import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubsetWithZeroSum {
    public static ArrayList<Integer> find(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        var subsets = new ArrayList<ArrayList<Integer>>();
        int currentCumSum = 0;

        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            currentCumSum += arr[i];
            if (map.containsKey(currentCumSum)) {
                var subset = new ArrayList<Integer>();
                for (int j = map.get(currentCumSum) + 1; j <= i; j++)
                    subset.add(arr[j]);
                subsets.add(subset);
            } else
                map.put(currentCumSum, i);
        }

        var resultSubset = new ArrayList<Integer>();
        for(var subset: subsets) {
            if(subset.size() > resultSubset.size()) {
                resultSubset = subset;
            }
        }

        System.out.println(subsets);

        return resultSubset;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[] { -6, 5, 9, -8, -6, 2, 4, -6 }));
        System.out.println(find(new int[] { -2, 1, 0, -9, -3, 6, 3, 3 }));
    }
}
