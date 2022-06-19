public class UnboundedKnapsackMemoized {
    public static int knapsack(int[] itemProfits, int[] itemWeights, int knapsackCapacity, int itemsIncluded, int[] memoizationArray) {
        if (itemsIncluded < 1 || itemWeights[itemsIncluded-1] > knapsackCapacity)
            return 0;
        
        int resultWhenIncludingCurrentItem = itemProfits[itemsIncluded-1] + knapsack(itemProfits, itemWeights, knapsackCapacity - itemWeights[itemsIncluded-1], itemsIncluded, memoizationArray);
        int resultWhenExcludingCurrentItem = knapsack(itemProfits, itemWeights, knapsackCapacity, itemsIncluded-1, memoizationArray);
        int optimalResult = Math.max(resultWhenExcludingCurrentItem, resultWhenIncludingCurrentItem);
        
        return optimalResult;
    }

    public static void main(String[] args) {
        int[] itemWeights = new int[] { 7, 2, 3, 5, 6 };
        int[] itemProfits = new int[] { 5, 4, 7, 1, 3 };
        int knapsackCapacity = 10;
        int noOfItems = itemWeights.length;
        int[] memoizationArray = new int[knapsackCapacity + 1];


        System.out.println(knapsack(itemProfits, itemWeights, knapsackCapacity, noOfItems, memoizationArray));
    }
} 