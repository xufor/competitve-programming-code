public class PrintFirstNIntegers {
    public static void printFirstNIntegers(int current, int n) {
        if(current > n)
            return;
        System.out.print(current + " ");
        printFirstNIntegers(current + 1, n);
    }

    public static void printFirstNIntegers(int n) {
        printFirstNIntegers(1, n);
    }

    public static void main(String[] args) {
        printFirstNIntegers(10);
    }
}
