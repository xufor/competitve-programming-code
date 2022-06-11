import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var indexOfComplement = map.get(target - nums[i]);
            if (indexOfComplement == null)
                map.put(nums[i], i);
            else
                return new int[] { i, indexOfComplement };
        }
        return null;
    }
}