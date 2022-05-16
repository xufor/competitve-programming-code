// This problem can also be called minimum difference partition

public class MinimumSubsetSumDifference {
    public static int minimumSubsetSumDifference(int[] itemList) {
        int noOfItems = itemList.length, sumOfAllItems = 0;

        for(int item: itemList)
            sumOfAllItems += item;

        int targetSum = sumOfAllItems;
        boolean[][] memoizationMatrix = new boolean[noOfItems + 1][targetSum + 1];

        // memoization matrix initialization
        for (int k = 0; k <= noOfItems; k++)
        memoizationMatrix[k][0] = true;
        
        for (int k = 1; k <= targetSum; k++)
        memoizationMatrix[0][k] = false;

        // dynamic programming logic
        for(int currentItemsIncluded = 1; currentItemsIncluded <= noOfItems; currentItemsIncluded++) {
            for(int currentTargetSum = 1; currentTargetSum <= targetSum; currentTargetSum++) {
                if(itemList[currentItemsIncluded - 1] > currentTargetSum)
                    memoizationMatrix[currentItemsIncluded][currentTargetSum] = memoizationMatrix[currentItemsIncluded - 1][currentTargetSum];
                else
                    memoizationMatrix[currentItemsIncluded][currentTargetSum] = memoizationMatrix[currentItemsIncluded - 1][currentTargetSum - itemList[currentItemsIncluded - 1]] || memoizationMatrix[currentItemsIncluded - 1][currentTargetSum];
            }
        }

        int minimumDifference = Integer.MAX_VALUE;

        for(int k = 0; k <= targetSum / 2; k++) {
            if(memoizationMatrix[noOfItems][k] == true) {
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
