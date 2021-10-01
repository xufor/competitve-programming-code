public class NumberOfDigitsInANumber {
    public static int numberOfDigitsInANumber(int n) {
        if(n == 0)
            return 0; // the number of digits in 0 are 0
        return 1 + numberOfDigitsInANumber(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(numberOfDigitsInANumber(12345));
    }
}
