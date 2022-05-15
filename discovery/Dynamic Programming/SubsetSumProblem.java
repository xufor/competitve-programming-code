public class SubsetSumProblem {
    private static boolean subsetSum(int[] itemList, int targetSum) {
        int noOfItems = itemList.length;
        boolean[][] memoizationMatrix = new boolean[noOfItems + 1][targetSum + 1];

        // INIT
        for (int k = 0; k <= noOfItems; k++)
        memoizationMatrix[k][0] = true;
        
        for (int k = 1; k <= targetSum; k++)
        memoizationMatrix[0][k] = false;

        // LOGIC
        for(int currentItemsIncluded = 1; currentItemsIncluded <= noOfItems; currentItemsIncluded++) {
            for(int currentTargetSum = 1; currentTargetSum <= targetSum; currentTargetSum++) {
                if(itemList[currentItemsIncluded - 1] > currentTargetSum)
                    memoizationMatrix[currentItemsIncluded][currentTargetSum] = memoizationMatrix[currentItemsIncluded - 1][currentTargetSum];
                else
                    memoizationMatrix[currentItemsIncluded][currentTargetSum] = memoizationMatrix[currentItemsIncluded - 1][currentTargetSum - itemList[currentItemsIncluded - 1]] || memoizationMatrix[currentItemsIncluded - 1][currentTargetSum];
            }
        }

        return memoizationMatrix[noOfItems][targetSum];
    }

    public static void main(String[] args) {
        int[] itemList = { 7, 2, 9, 3, 7 };
        int targetSum = 14;

        System.out.println(subsetSum(itemList, targetSum));
    }
}