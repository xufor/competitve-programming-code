public class UnboundedKnapsackMemoized {
    public static int knapsack(int[] itemProfits, int[] itemWeights, int knapsackCapacity, int currentItemIndex, int[] memoizationArray) {
        if (currentItemIndex >= itemProfits.length || itemWeights[currentItemIndex] > knapsackCapacity)
            return 0;
        
        int resultWhenIncludingCurrentItem = itemProfits[currentItemIndex] + knapsack(itemProfits, itemWeights, knapsackCapacity - itemWeights[currentItemIndex], currentItemIndex, memoizationArray);
        int resultWhenExcludingCurrentItem = knapsack(itemProfits, itemWeights, knapsackCapacity, currentItemIndex+1, memoizationArray);
        int optimalResult = Math.max(resultWhenExcludingCurrentItem, resultWhenIncludingCurrentItem);
        
        return optimalResult;
    }

    public static void main(String[] args) {
        int[] itemWeights = new int[] { 3, 2, 1 };
        int[] itemProfits = new int[] { 1, 2, 3 };
        int knapsackCapacity = 5;
        int[] memoizationArray = new int[knapsackCapacity + 1];


        System.out.println(knapsack(itemProfits, itemWeights, knapsackCapacity, 0, memoizationArray));
    }
} 