import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {
    public static List<Integer> findStockSpan(Integer[] input) {
        class StackData {
            Integer element;
            Integer index;

            StackData(Integer element, Integer index) {
                this.element = element;
                this.index = index;
            }
        }

        Stack<StackData> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        for (Integer currentIndex = 0; currentIndex < input.length; currentIndex++) {
            while (!stack.isEmpty() && stack.peek().element < input[currentIndex]) {
                stack.pop();
            }
            if (stack.isEmpty())
                result.add(currentIndex + 1);
            else
                result.add(currentIndex - stack.peek().index);
            stack.push(new StackData(input[currentIndex], currentIndex));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findStockSpan(new Integer[] { 60, 70, 80, 100, 90, 75, 80, 120 }));
        System.out.println(findStockSpan(new Integer[] { 10, 10, 10, 10 }));
    }
}
