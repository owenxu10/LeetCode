class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        for i in xrange(len(nums)):
            if len(res) == 0:
                res.append([nums[i]])
            else:
                #nums[i]
                new_res = []
                for li in res:
                    for lens in xrange(len(li)+1):
                        curList = li[:]
                        curList.insert(lens,nums[i])
                        new_res.append(curList)
                    res = new_res
        return res
