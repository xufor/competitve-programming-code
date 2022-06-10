class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i, num in enumerate(nums):
            complement_index = map.get(target - num)
            if complement_index == None:
                map[num] = i
            else:
                return sorted([i, complement_index])