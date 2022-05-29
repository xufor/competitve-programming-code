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

    public static void main(String[] args) {
        int[] coinProfits = new int[] { 1, 2, 3 };
        int targetSum = 5;

        System.out.println(coinChangeAllPermutations(coinProfits, targetSum));
        System.out.println(coinChangeAllCombinations(coinProfits, targetSum));
    }
}
