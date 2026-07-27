class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max1 = 0
        max2 = 0

        for num in nums:
            if num > max1:
                max2 = max1 # The old largest becomes second largest
                max1 = num # Update the new largest
            elif num > max2:
                max2 = num # Update second largest if it's smaller than max1 but larger than max2

        return (max1 - 1) * (max2 - 1)
        