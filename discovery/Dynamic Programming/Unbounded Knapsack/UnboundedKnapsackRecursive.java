public class UnboundedKnapsackRecursive {
    public static int knapsackV1(int[] itemProfits, int[] itemWeights, int knapsackCapacity, int currentItemIndex) {
        int noOfItems = itemProfits.length;
        if(knapsackCapacity < itemWeights[currentItemIndex])
            return 0;
        else {
            int currentMaxProfit = 0;
            for(int i = 0; i < noOfItems; i++)
                currentMaxProfit = itemProfits[i] + knapsackV1(itemProfits, itemWeights, knapsackCapacity - itemWeights[i], i);
            return currentMaxProfit;
        }
    }

    
    public static int knapsackV2(int[] itemProfits, int[] itemWeights, int knapsackCapacity, int maxProfit) {
        int noOfItems = itemProfits.length;
        if(knapsackCapacity == 0)
            return maxProfit;
        else if(knapsackCapacity < 0)
            return -1;
        else {
            int currentMaxProfit = -1;
            for(int i = 0; i < noOfItems; i++)
                currentMaxProfit = Math.max(knapsackV2(itemProfits, itemWeights, knapsackCapacity - itemWeights[i], maxProfit + itemProfits[i]), currentMaxProfit);
            return currentMaxProfit;
        }
    }

    public static void main(String[] args) {
        int[] itemWeights = new int[] { 3, 2, 4 };
        int[] itemProfits = new int[] { 1, 2, 3 };
        int knapsackCapacity = 5;

        System.out.println(knapsackV1(itemProfits, itemWeights, knapsackCapacity, 0));
        System.out.println(knapsackV2(itemProfits, itemWeights, knapsackCapacity, 0));
    }
} 