import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static ArrayList<Integer> find(int[] arr) {
        var map = new HashMap<Integer, Boolean>();
        
        for(int element: arr)
            map.put(element, true);

        var sequences = new ArrayList<ArrayList<Integer>>();

        for (int element : arr) {
            // if an element not the first element of a possible sequence
            // then no need to explore
            if (!map.containsKey(element - 1)) {
                var sequence = new ArrayList<Integer>();
                while(map.containsKey(element)) {
                    sequence.add(element);
                    element++;
                }
                sequences.add(sequence);
            }
        }

        var resultSequence = new ArrayList<Integer>();

        for(var sequence: sequences) {
            if(sequence.size() > resultSequence.size()) {
                resultSequence = sequence;
            }
        }

        return resultSequence;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 9, 3, 10, 4, 20, 2 };
        System.out.println(find(arr));
    }
}