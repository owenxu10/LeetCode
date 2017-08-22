class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        step = 0
        v_max = 0
        reached = 0

        for i in xrange(len(nums)):
            if v_max >= len(nums)-1:
                return step

            if i <= v_max:
                reached = max(i+nums[i], reached)

            if i == v_max:
                step+=1
                v_max = reached
        return step
