public class CountAllSubsetsWithGivenSum {
    public static int subsetSum(int[] itemList, int targetSum) {
        int noOfItems = itemList.length;
        int[][] memoizationMatrix = new int[noOfItems + 1][targetSum + 1];

        // INIT
        for (int k = 0; k <= noOfItems; k++)
        memoizationMatrix[k][0] = 1;
        
        for (int k = 1; k <= targetSum; k++)
        memoizationMatrix[0][k] = 0;

        // LOGIC
        for(int currentItemsIncluded = 1; currentItemsIncluded <= noOfItems; currentItemsIncluded++) {
            for(int currentTargetSum = 1; currentTargetSum <= targetSum; currentTargetSum++) {
                if(itemList[currentItemsIncluded - 1] > currentTargetSum)
                    memoizationMatrix[currentItemsIncluded][currentTargetSum] = memoizationMatrix[currentItemsIncluded - 1][currentTargetSum];
                else
                    memoizationMatrix[currentItemsIncluded][currentTargetSum] = memoizationMatrix[currentItemsIncluded - 1][currentTargetSum - itemList[currentItemsIncluded - 1]] + memoizationMatrix[currentItemsIncluded - 1][currentTargetSum];
            }
        }

        return memoizationMatrix[noOfItems][targetSum];
    }

    public static void main(String[] args) {
        int[] itemList = { 7, 2, 9, 3, 2 };
        int targetSum = 14;

        System.out.println(subsetSum(itemList, targetSum));
    }
}