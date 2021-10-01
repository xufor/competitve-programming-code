public class FindFactorial {
    public static int fact(int x) {
        if(x == 1)
            return 1; // 1! is 1
        int smallAns = fact(x-1);
        return x * smallAns;
    }
    
    public static void main(String args[]) {
        int n = 3;
        System.out.println(fact(n));
    }
}