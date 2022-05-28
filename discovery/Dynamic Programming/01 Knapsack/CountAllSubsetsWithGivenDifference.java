// this problem can also be called count of all partitions with given difference

public class CountAllSubsetsWithGivenDifference {
    public static int countAllSubsetsWithGivenDifference(int[] itemList, int difference) {
        int sumOfAllItems = 0;

        for(int item: itemList)
            sumOfAllItems += item;

        int targetSum = (sumOfAllItems - difference) / 2;

        return CountAllSubsetsWithGivenSum.countAllSubsetsWithGivenSum(itemList, targetSum);
    }

    public static void main(String[] args) {
        int[] itemList = { 1, 1, 2, 3 };
        int difference = 1;
        System.out.println(countAllSubsetsWithGivenDifference(itemList, difference));
    }
}
