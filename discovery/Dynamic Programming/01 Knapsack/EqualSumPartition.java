public class EqualSumPartition {
    private static boolean equalSumPartition(int[] itemList) {
    int sumOfAllItems = 0;

    for(int item: itemList)
        sumOfAllItems += item;

    if(sumOfAllItems % 2 != 0)
        return false;

    int targetSum = sumOfAllItems / 2;
    return SubsetSum.subsetSum(itemList, targetSum);
}

    public static void main(String[] args) {
        int[] itemList = { 0, 5, 6, 11 };
        // int[] itemList = { 1, 5, 6, 11 };
        
        System.out.println(equalSumPartition(itemList));
    }
}
