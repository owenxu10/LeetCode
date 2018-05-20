class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates = sorted(candidates)
        result = []
        self.dfs(candidates,target,result,-1,[])
        return result

    def dfs(self,nums,target,res,index,path):
        if target < 0:
            return
        if target == 0:
            if path not in res:
                 res.append(path[:])
            return
        if target > 0:
            for i in xrange(index+1,len(nums)):

                if i>index+1 and nums[i] == nums[i-1]:
                    continue

                if nums[i] > target:
                    return
                
                path.append(nums[i])
                self.dfs(nums,target-nums[i],res,i,path)
                path.pop() 
            
