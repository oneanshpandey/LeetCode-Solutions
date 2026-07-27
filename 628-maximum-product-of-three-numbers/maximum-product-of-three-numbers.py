class Solution(object):
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Sort the array in ascending order
        nums.sort()

        # Scenario 1: Product of the three largest numbers
        prod1 = nums[-1] * nums[-2] * nums[-3]

        # Scenario 2: Product of the two smallest (negative) numbers and the largest number
        prod2 = nums[0] * nums[1] * nums[-1]

        # Return the maximum of the two combinations
        return max(prod1, prod2) 
        