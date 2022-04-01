public class WaysToClimbStaircase {
    public static int ways(int noOfStairs) {
        if (noOfStairs == 0)
            return 1;
        if (noOfStairs < 0)
            return 0;
        return ways(noOfStairs - 1) + ways(noOfStairs - 2) + ways(noOfStairs - 3);
    }

    public static void main(String[] args) {
        System.out.println(ways(4));
    }
}