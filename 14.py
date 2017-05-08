"""
Write a function to find the longest common prefix string amongst an array of strings.
"""


class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        prefix = ""
        if len(strs)>0:
            strs = sorted(strs)
            first_el = strs[0]
            last_el = strs[-1]
            lens = len(first_el) if len(first_el)<len(last_el) else len(last_el)
            if(len(first_el)>0):
                for i in range(0, lens):
                    if (first_el[i] == last_el[i]):
                        prefix = prefix + first_el[i]
                    else:
                        return prefix
        return prefix



s = Solution()
print(s.longestCommonPrefix([["",""]]))
