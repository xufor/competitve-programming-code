public class UnboundedKnapsackMemoized {
    public static int knapsack(int[] itemProfits, int[] itemWeights, int knapsackCapacity, int itemsIncluded, int[][] memoizationMatrix) {
        if (itemsIncluded < 1 || itemWeights[itemsIncluded-1] > knapsackCapacity)
            return 0;
        
        if(memoizationMatrix[itemsIncluded-1][knapsackCapacity] != 0)
            return memoizationMatrix[itemsIncluded-1][knapsackCapacity];
        
        int resultWhenIncludingCurrentItem = itemProfits[itemsIncluded-1] + knapsack(itemProfits, itemWeights, knapsackCapacity - itemWeights[itemsIncluded-1], itemsIncluded, memoizationMatrix);
        int resultWhenExcludingCurrentItem = knapsack(itemProfits, itemWeights, knapsackCapacity, itemsIncluded-1, memoizationMatrix);
        int optimalResult = Math.max(resultWhenExcludingCurrentItem, resultWhenIncludingCurrentItem);

        memoizationMatrix[itemsIncluded-1][knapsackCapacity] = optimalResult;
        
        return optimalResult;
    }

    public static void main(String[] args) {
        int[] itemWeights = new int[] { 7, 2, 3, 5, 6 };
        int[] itemProfits = new int[] { 5, 4, 7, 1, 3 };
        int knapsackCapacity = 10;
        int noOfItems = itemWeights.length;
        int[][] memoizationMatrix = new int[noOfItems+1][knapsackCapacity + 1];

        System.out.println(knapsack(itemProfits, itemWeights, knapsackCapacity, noOfItems, memoizationMatrix));
    }
} 