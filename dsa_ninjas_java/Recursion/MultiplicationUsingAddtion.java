import java.util.Arrays;

public class MultiplicationUsingAddtion {
    private static long multiply(long firstOperand, long secondOperand) {
        if (firstOperand == 0 || secondOperand == 0) {
            return 0;
        }
        return firstOperand + multiply(firstOperand, secondOperand - 1);
    }

    public static void main(String args[]) {
        int[][] testValues = { { 10, 23 }, { 10, 0 }, { 0, 19 }, { 1, 19 }, { 19, 1 } };
        Arrays.stream(testValues).forEach(v -> System.out.println(multiply(v[0], v[1])));
    }
}