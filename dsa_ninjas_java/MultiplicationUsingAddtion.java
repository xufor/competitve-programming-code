public class MultiplicationUsingAddtion {
    private static long multiply(long firstOperand, long secondOperand) {
        if (firstOperand == 0 || secondOperand == 0) {
            return 0;
        }
        return firstOperand + multiply(firstOperand, secondOperand - 1);
    }

    public static void main(String args[]) {
        System.out.println(multiply(10, 23));
        System.out.println(multiply(10, 0));
        System.out.println(multiply(0, 19));
        System.out.println(multiply(1, 19));
        System.out.println(multiply(19, 1));
    }
}