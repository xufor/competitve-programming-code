public class XToThePowerOfN {
    public static int xToThePowerOfN(int x, int n) {
        if(n == 0)
            return 1;
        return x * xToThePowerOfN(x, n - 1);
    }
    // x ^ n = x * x ^ (n-1)
    // base case: x ^ 0 = 1

    public static void main(String[] args) {
        System.out.println(xToThePowerOfN(5, 2));
    }
}
