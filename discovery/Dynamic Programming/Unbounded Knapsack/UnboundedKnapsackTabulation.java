public class UnboundedKnapsackTabulation {
    public static int knapsack(int[] itemProfits, int[] itemWeights, int knapsackCapacity) {
        int noOfItems = itemProfits.length;
        int[] memoizationArray = new int[knapsackCapacity + 1];

        for(int currentKnapsackCapacity = 1; currentKnapsackCapacity <= knapsackCapacity; currentKnapsackCapacity++) {
            for(int currentItemIndex = 0; currentItemIndex < noOfItems; currentItemIndex++) {
                if(currentKnapsackCapacity >= itemWeights[currentItemIndex]) {
                    memoizationArray[currentKnapsackCapacity] = Math.max(itemProfits[currentItemIndex] + memoizationArray[currentKnapsackCapacity - itemWeights[currentItemIndex]], memoizationArray[currentKnapsackCapacity]); 
                }
            }
        }

        return memoizationArray[knapsackCapacity];
    }

    public static void main(String[] args) {
        int[] itemWeights = new int[] { 3, 2, 1 };
        int[] itemProfits = new int[] { 1, 2, 3 };
        int knapsackCapacity = 5;


        System.out.println(knapsack(itemProfits, itemWeights, knapsackCapacity));
    }
} 