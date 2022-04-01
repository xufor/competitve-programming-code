import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NearestGreaterToRight {
    public static ArrayList<Integer> nearestGreaterToRight(Integer[] input) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer currentIndex = input.length - 1; currentIndex > 0; currentIndex--) {
            while (!stack.empty() && stack.peek() <= input[currentIndex]) {
                stack.pop();
            }
            if (stack.size() == 0)
                result.add(-1);
            else
                result.add(stack.peek());
            stack.push(input[currentIndex]);
        }
        return result;
    }

    public static void main(String args[]) {
        Integer[][] testArrays = new Integer[][] { { 5, 4, 11, 9, 2, 20, 4, 7, 8, 5 },
                { 4, 3, 1, 7, 8, 9, 10, 25, 4, 7, 8, 9 } };
        for (Integer[] testArray : testArrays) {
            ArrayList<Integer> result = nearestGreaterToRight(testArray);
            Collections.reverse(result);
            System.out.println(result);
        }
    }
}