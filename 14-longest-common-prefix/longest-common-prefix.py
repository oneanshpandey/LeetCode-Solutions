class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if not strs:
            return ""
        
        # Sort strings alphabetically
        strs.sort()
        
        first = strs[0]
        last = strs[-1]
        ans = []
        
        # Compare characters of the first and last string
        for i in range(min(len(first), len(last))):
            if first[i] != last[i]:
                break
            ans.append(first[i])
            
        return "".join(ans)