import java.util.HashMap;

public class AllPairsWithDifferenceK {
    public static void find(int[] arr, int k) {
        var map = new HashMap<Integer, Boolean>();

        for (int element : arr) {
            if (map.containsKey(element + k))
                System.out.println(element + " " + (element + k));
            if (map.containsKey(element - k))
                System.out.println((element - k) + " " + element);
            map.put(element, true);
        }
    }

    public static void main(String[] args) {
        find(new int[] { 13, 5, 10, 8, 7, 16, 15 }, 3);
        System.out.println("----");
        find(new int[] { 13, 5, 10, 8, 7, 16, 15 }, 5);
    }
}
