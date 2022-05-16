// TOP DOWN APPROACH

public class ZeroOneKnapsackRecursionMemoized {
    private static int knapsack(int[] itemProfits, int[] itemWeights, int knapsackCapacity, int currentItemIndex, int[][] memoizationMatrix) {
        if(currentItemIndex >= itemProfits.length || itemWeights[currentItemIndex] > knapsackCapacity)
            return 0;

        if(memoizationMatrix[currentItemIndex+1][knapsackCapacity] != 0)
            return memoizationMatrix[currentItemIndex+1][knapsackCapacity];
        
        int resultWhenIncludingCurrentItem = itemProfits[currentItemIndex] + knapsack(itemProfits, itemWeights, knapsackCapacity-itemWeights[currentItemIndex], currentItemIndex+1, memoizationMatrix);
        int resultWhenExcludingCurrentItem = knapsack(itemProfits, itemWeights, knapsackCapacity, currentItemIndex+1, memoizationMatrix);
        int optimalResult = Math.max(resultWhenExcludingCurrentItem, resultWhenIncludingCurrentItem);

        memoizationMatrix[currentItemIndex+1][knapsackCapacity] = optimalResult;

        return optimalResult;
    }

    public static void main(String[] args) {
        int[] itemWeights = new int[] { 7, 2, 3, 5, 6 };
        int[] itemProfits = new int[] { 5, 4, 7, 1, 3 };
        int knapsackCapacity = 10;
        int noOfItems = itemProfits.length;

        int[][] memoizationMatrix = new int[noOfItems+1][knapsackCapacity+1];

        System.out.println(knapsack(itemProfits, itemWeights, knapsackCapacity, 0, memoizationMatrix));
    }
}