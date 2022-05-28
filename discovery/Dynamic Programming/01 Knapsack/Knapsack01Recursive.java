public class Knapsack01Recursive {
    private static int knapsack(int[] itemProfits, int[] itemWeights, int knapsackCapacity, int currentItemIndex) {
        if(currentItemIndex >= itemProfits.length || itemWeights[currentItemIndex] > knapsackCapacity)
            return 0;
        
        int resultWhenIncludingCurrentItem = itemProfits[currentItemIndex] + knapsack(itemProfits, itemWeights, knapsackCapacity-itemWeights[currentItemIndex], currentItemIndex+1);
        int resultWhenExcludingCurrentItem = knapsack(itemProfits, itemWeights, knapsackCapacity, currentItemIndex+1);
        int optimalResult = Math.max(resultWhenExcludingCurrentItem, resultWhenIncludingCurrentItem);

        return optimalResult;
    }

    public static void main(String[] args) {
        int[] itemWeights = new int[] { 7, 2, 3, 5, 6 };
        int[] itemProfits = new int[] { 5, 4, 7, 1, 3 };
        int knapsackCapacity = 10;

        System.out.println(knapsack(itemProfits, itemWeights, knapsackCapacity, 0));
    }
}