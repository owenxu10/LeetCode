class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        nums = sorted(nums)
        count = 0
        start = 0
        isFound = False
        if val not in nums:
            result = nums
        else:
            for i in range(0, len(nums)):
                if nums[i] != val:
                    if isFound == False:
                        isFound = True
                        start = i
                        count = 1
                    else:
                        count += 1
        nums = nums[start:start + count]

        return nums, count

s = Solution()

nums, count = s.removeElement([3,3,2,2],2)

print(nums,count)