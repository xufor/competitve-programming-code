// BOTTOM UP APPROACH

public class Knapsack01Tabulation {
    private static int knapsack(int[] itemProfits, int[] itemWeights, int knapsackCapacity) {
        int noOfItems = itemProfits.length;

        int[][] tabulationMatrix = new int[noOfItems+1][knapsackCapacity+1];
        
        for(int currentItemsIncluded = 1; currentItemsIncluded <= noOfItems; currentItemsIncluded++) {
            for(int currentKnapsackCapacity = 1; currentKnapsackCapacity <= knapsackCapacity; currentKnapsackCapacity++) {
                if(itemWeights[currentItemsIncluded - 1] > currentKnapsackCapacity)
                    tabulationMatrix[currentItemsIncluded][currentKnapsackCapacity] = tabulationMatrix[currentItemsIncluded-1][currentKnapsackCapacity];
                else
                    tabulationMatrix[currentItemsIncluded][currentKnapsackCapacity] = Math.max(itemProfits[currentItemsIncluded - 1] + tabulationMatrix[currentItemsIncluded - 1][currentKnapsackCapacity - itemWeights[currentItemsIncluded - 1]], tabulationMatrix[currentItemsIncluded - 1][currentKnapsackCapacity]);
            }
        }

        return tabulationMatrix[noOfItems][knapsackCapacity];
    }

    public static void main(String[] args) {
        int[] itemWeights = new int[] { 7, 2, 3, 5, 6 };
        int[] itemProfits = new int[] { 5, 4, 7, 1, 3 };
        int knapsackCapacity = 10;

        System.out.println(knapsack(itemProfits, itemWeights, knapsackCapacity));
    }
}