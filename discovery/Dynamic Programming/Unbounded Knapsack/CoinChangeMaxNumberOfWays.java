public class CoinChangeMaxNumberOfWays {
    public static int coinChangeAllPermutations(int[] coinProfits, int targetSum) {
        // this algo uses 1D memoization array
        // this algo will give an anwer of 13
        // this is because it creates all permutations 
        // all the permutations are -> 11111, 1112, 1121, 1211, 2111, 311, 131, 113, 221, 212, 122, 23, 32

        int noOfItems = coinProfits.length;
        int[] memoizationArray = new int[targetSum + 1];
        
        memoizationArray[0] = 1;

        for(int currentTargetSum = 1; currentTargetSum <= targetSum; currentTargetSum++) {
            for(int currentItemIndex = 0; currentItemIndex < noOfItems; currentItemIndex++) {
                if(currentTargetSum >= coinProfits[currentItemIndex]) {
                    memoizationArray[currentTargetSum] += memoizationArray[currentTargetSum - coinProfits[currentItemIndex]];
                }
            }
        }

        return memoizationArray[targetSum];
    }

    public static int coinChangeAllCombinations(int[] coinProfits, int targetSum) {
        // this algo uses 1D memoization array
        // this algo will give an anwer of 5 
        // this is because it creates all combinations
        // all the permutations are -> 11111, 1112, 113, 122, 23
        // if we use 2D memoization table then automatically combinations will be created

        int noOfItems = coinProfits.length;
        int[] memoizationArray = new int[targetSum + 1];
        
        memoizationArray[0] = 1;

        for(int currentItemIndex = 0; currentItemIndex < noOfItems; currentItemIndex++) {
            for(int currentTargetSum = 1; currentTargetSum <= targetSum; currentTargetSum++) {
                if(currentTargetSum >= coinProfits[currentItemIndex]) {
                    memoizationArray[currentTargetSum] += memoizationArray[currentTargetSum - coinProfits[currentItemIndex]];
                }
            }
        }

        return memoizationArray[targetSum];
    }

    public static int coinChangeAllCombinations2D(int[] coinProfits, int targetSum) {
        // this algo uses 2D memoization matrix
        // this algo will give an anwer of 5 
        // this is because it creates all combinations
        // all the permutations are -> 11111, 1112, 113, 122, 23
        // if we observe closely then this is similar of above 1D approach but uses more space

        int noOfItems = coinProfits.length;
        int[][] tabulationMatrix = new int[noOfItems + 1][targetSum + 1];
        
        for(int i = 0; i <= noOfItems; i++) {
            tabulationMatrix[i][0] = 1;
        }

        for(int currentItem = 1; currentItem <= noOfItems; currentItem++) {
            for(int currentTargetSum = 1; currentTargetSum <= targetSum; currentTargetSum++) {
                if(currentTargetSum >= coinProfits[currentItem - 1])
                    tabulationMatrix[currentItem][currentTargetSum] += tabulationMatrix[currentItem-1][currentTargetSum] + tabulationMatrix[currentItem][currentTargetSum - coinProfits[currentItem - 1]];
                else
                    tabulationMatrix[currentItem][currentTargetSum] = tabulationMatrix[currentItem-1][currentTargetSum];
            }
        }

        return tabulationMatrix[noOfItems][targetSum];
    }

    public static void main(String[] args) {
        int[] coinProfits = new int[] { 1, 2, 3 };
        int targetSum = 5;

        System.out.println(coinChangeAllPermutations(coinProfits, targetSum));
        System.out.println(coinChangeAllCombinations(coinProfits, targetSum));
        System.out.println(coinChangeAllCombinations2D(coinProfits, targetSum));
    }
}
