public class UnboundedKnapsackRecursive {
    public static int knapsack(int[] itemProfits, int[] itemWeights, int knapsackCapacity, int currentItemIndex) {
        int noOfItems = itemProfits.length;
        if(knapsackCapacity < itemWeights[currentItemIndex])
            return 0;
        else {
            int currentMaxProfit = 0;
            for(int i = 0; i < noOfItems; i++)
                currentMaxProfit = itemProfits[i] + knapsack(itemProfits, itemWeights, knapsackCapacity - itemWeights[i], i);
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