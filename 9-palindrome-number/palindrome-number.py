class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        # Negative numbers are not palindromes
        # Numbers ending in 0 (except 0 itself) are not palindromes
        if x < 0 or (x % 10 == 0 and x != 0):
            return False

        reversed_num = 0
        original_num = x

        # Reverse the integer mathematically
        while x > 0:
            digit = x % 10
            reversed_num = (reversed_num * 10) + digit
            x //= 10
        # Check if the reversed number matches the original
        return original_num == reversed_num

        