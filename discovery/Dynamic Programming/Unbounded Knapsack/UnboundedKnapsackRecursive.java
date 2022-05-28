public class UnboundedKnapsackRecursive {
    public static int knapsack(int[] itemProfits, int[] itemWeights, int knapsackCapacity, int maxProfit) {
        int noOfItems = itemProfits.length;
        if(knapsackCapacity == 0)
            return maxProfit;
        else if(knapsackCapacity < 0)
            return -1;
        else {
            int currentMaxProfit = -1;
            for(int i = 0; i < noOfItems; i++)
                currentMaxProfit = Math.max(knapsack(itemProfits, itemWeights, knapsackCapacity - itemWeights[i], maxProfit + itemProfits[i]), currentMaxProfit);
            return currentMaxProfit;
        }
    }

    public static void main(String[] args) {
        int[] itemWeights = new int[] { 3, 2, 4 };
        int[] itemProfits = new int[] { 1, 2, 3 };
        int knapsackCapacity = 5;

        System.out.println(knapsack(itemProfits, itemWeights, knapsackCapacity, 0));
    }
} 