public class UnboundedKnapsackTabulation {
    
    public static int knapsack2DMinified(int[] P, int[] W, int C) {
        int N = P.length;
        int[][] T = new int[N + 1][C + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                if (j >= W[i - 1]) {
                    T[i][j] = Math.max(P[i - 1] + T[i][j - W[i - 1]], T[i - 1][j]);
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }

        return T[N][C];
    }

    public static int knapsack2D(int[] itemProfits, int[] itemWeights, int knapsackCapacity) {
        int noOfItems = itemProfits.length;
        int[][] tabulationMatrix = new int[noOfItems + 1][knapsackCapacity + 1];

        for(int currentItemsIncluded = 1; currentItemsIncluded <= noOfItems; currentItemsIncluded++) {
            for(int currentKnapsackCapacity = 1; currentKnapsackCapacity <= knapsackCapacity; currentKnapsackCapacity++) {
                if(currentKnapsackCapacity >= itemWeights[currentItemsIncluded-1]) {
                    tabulationMatrix[currentItemsIncluded][currentKnapsackCapacity] = Math.max(itemProfits[currentItemsIncluded - 1] + tabulationMatrix[currentItemsIncluded][currentKnapsackCapacity - itemWeights[currentItemsIncluded - 1]], tabulationMatrix[currentItemsIncluded-1][currentKnapsackCapacity]); 
                } else {
                    tabulationMatrix[currentItemsIncluded][currentKnapsackCapacity] = tabulationMatrix[currentItemsIncluded-1][currentKnapsackCapacity]; 
                }
            }
        }

        return tabulationMatrix[noOfItems][knapsackCapacity];
    }

    // permutations and combinations does not matter in this question as we have to find max profit and not number of ways
    public static int knapsack(int[] itemProfits, int[] itemWeights, int knapsackCapacity) {
        int noOfItems = itemProfits.length;
        int[] memoizationArray = new int[knapsackCapacity + 1];

        for(int currentItemsIncluded = 1; currentItemsIncluded <= noOfItems; currentItemsIncluded++) {
            for(int currentKnapsackCapacity = 1; currentKnapsackCapacity <= knapsackCapacity; currentKnapsackCapacity++) {
                if(currentKnapsackCapacity >= itemWeights[currentItemsIncluded-1]) {
                    memoizationArray[currentKnapsackCapacity] = Math.max(itemProfits[currentItemsIncluded - 1] + memoizationArray[currentKnapsackCapacity - itemWeights[currentItemsIncluded - 1]], memoizationArray[currentKnapsackCapacity]); 
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
        System.out.println(knapsack2D(itemProfits, itemWeights, knapsackCapacity));
        System.out.println(knapsack2DMinified(itemProfits, itemWeights, knapsackCapacity));
    }
} 