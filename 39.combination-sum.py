class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        self.result = []
        candidates = sorted(candidates)
        self.dfs(self.result, target, 0, [], candidates)
        return self.result

    def dfs(self, res, target, index, path, nums):
        if target < 0:
            return
        if target == 0:
            res.append(path[:])
            return
        if target > 0:
            for i in xrange(index, len(nums)):
                path.append(nums[i])
                self.dfs(res, target-nums[i], i, path, nums)
                path.pop() 
