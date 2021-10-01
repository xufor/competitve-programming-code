public class SumOfDigitsOfANumber {
    public static int sumOfDigitsOfANumber(int n) {
        if(n == 0)
            return 0;
        return (n % 10) + sumOfDigitsOfANumber(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigitsOfANumber(123));
    }
}
