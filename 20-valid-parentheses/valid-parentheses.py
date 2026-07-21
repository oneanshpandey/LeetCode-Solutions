class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # Map each closing bracket to its corresponding opening bracket
        bracket_map = {")": "(", "}": "{", "]": "["}
        stack = []
        
        # Iterate through every character in the input string
        for char in s:
            # If the character is a closing bracket
            if char in bracket_map:
                # Pop the top element from the stack if it's not empty; else use a dummy value
                top_element = stack.pop() if stack else '#'
                
                # If the mapped opening bracket doesn't match the top of the stack, it's invalid
                if bracket_map[char] != top_element:
                    return False
            else:
                # If it's an opening bracket, push it onto the stack
                stack.append(char)
                
        # If the stack is empty, all brackets were correctly matched
        return len(stack) == 0