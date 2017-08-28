class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        res = {}
        for str in strs:
            key = ''.join(sorted(str))
            if key in res:
                res[key].append(str)
            else:
                res[key] = [str]
        return res.values()
