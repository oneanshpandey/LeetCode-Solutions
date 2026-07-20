class Solution(object):
    def intToRoman(self, num):
        # Map values to their Roman symbols in descending order
        roman_mapping = [
            (1000, "M"), (900, "CM"), (500, "D"),(400, "CD"),
            (100, "C"), (90, "XC"), (50, "L"), (40, "XL"),
            (10, "X"), (9, "IX"), (5, "V"), (4, "IV"), (1, "I")
        ]
        
        result = []

        # Loop through each value-symbol pair
        for value, symbol in roman_mapping:
            # If num is 0, we can stop early
            if num == 0:
                break

            # Determine how many times the current symbol fits into num
            count = num // value
            if count > 0:
                result.append(symbol * count)
                num %= value # Keep the remainder

        return "".join(result)
        
        