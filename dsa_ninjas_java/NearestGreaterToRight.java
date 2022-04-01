import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NearestGreaterToRight {
    public static ArrayList<Integer> nearestGreaterToRight(Integer[] input) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer currrentIndex = input.length - 1; currrentIndex > 0; currrentIndex--) {
            while (!stack.empty() && stack.peek() <= input[currrentIndex]) {
                stack.pop();
            }
            if (stack.size() == 0)
                result.add(-1);
            else
                result.add(stack.peek());
            stack.push(input[currrentIndex]);
        }
        System.out.println(stack);
        return result;
    }

    public static void main(String args[]) {
        Integer[][] testArrays = new Integer[][] { { 5, 4, 11, 9, 2, 20, 4, 7, 8, 5 },
                { 4, 3, 1, 7, 8, 9, 10, 25, 4, 7, 8, 9 } };
        for (Integer[] testArray : testArrays) {
            ArrayList<Integer> result =  nearestGreaterToRight(testArray);
            Collections.reverse(result);
            System.out.println(result);
        }
    }
}