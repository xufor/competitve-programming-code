// this problem can also be called minimum difference partition

public class MinimumSubsetSumDifference {
    public static int minimumSubsetSumDifference(int[] itemList) {
        int noOfItems = itemList.length, sumOfAllItems = 0;

        for(int item: itemList)
            sumOfAllItems += item;

        int targetSum = sumOfAllItems;
        boolean[][] tabulationMatrix = new boolean[noOfItems + 1][targetSum + 1];

        // memoization matrix initialization
        for (int k = 0; k <= noOfItems; k++)
        tabulationMatrix[k][0] = true;
        
        for (int k = 1; k <= targetSum; k++)
        tabulationMatrix[0][k] = false;

        // dynamic programming logic
        for(int currentItemsIncluded = 1; currentItemsIncluded <= noOfItems; currentItemsIncluded++) {
            for(int currentTargetSum = 1; currentTargetSum <= targetSum; currentTargetSum++) {
                if(itemList[currentItemsIncluded - 1] > currentTargetSum)
                    tabulationMatrix[currentItemsIncluded][currentTargetSum] = tabulationMatrix[currentItemsIncluded - 1][currentTargetSum];
                else
                    tabulationMatrix[currentItemsIncluded][currentTargetSum] = tabulationMatrix[currentItemsIncluded - 1][currentTargetSum - itemList[currentItemsIncluded - 1]] || tabulationMatrix[currentItemsIncluded - 1][currentTargetSum];
            }
        }

        int minimumDifference = Integer.MAX_VALUE;

        for(int k = 0; k <= targetSum / 2; k++) {
            if(tabulationMatrix[noOfItems][k] == true) {
                minimumDifference = Math.min(minimumDifference, Math.abs(sumOfAllItems - 2 * k));
            }
        }
        
        return minimumDifference;
    }

    public static void main(String[] args) {
        int[] itemList = { 0, 1, 2 };

        System.out.println(minimumSubsetSumDifference(itemList));
    }
}
