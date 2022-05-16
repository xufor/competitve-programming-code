public class SubsetSum {
    public static boolean subsetSum(int[] itemList, int targetSum) {
        int noOfItems = itemList.length;
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

        return tabulationMatrix[noOfItems][targetSum];
    }

    public static void main(String[] args) {
        int[] itemList = { 7, 2, 9, 3, 7 };
        int targetSum = 14;

        System.out.println(subsetSum(itemList, targetSum));
    }
}