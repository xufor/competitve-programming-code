public class NthFibonacciNumber {
    public static int fibo(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int firstSmallAns = fibo(n-1);
        int secondSmallAns = fibo(n-2);
        return firstSmallAns + secondSmallAns;
    }

    public static int nthfibo(int n) {
       return fibo(n-1);
    }

    public static void main(String[] args) {
        System.out.println(nthfibo(5));
    }
}
