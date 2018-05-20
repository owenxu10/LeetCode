"""
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.
"""


class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        nums = sorted(nums)
        for i in range(1, len(nums) - 1):
            el_first = nums[i]
            s_left = nums[:i]
            s_right = nums[i + 1:]
            i_left = len(s_left) - 1
            i_right = 0
            while (i_left >= 0 or i_right <= len(s_right) - 1):
                value_left = s_left[i_left]
                value_right = s_right[i_right]
                if value_left + el_first + value_right > 0:
                    if i_left > 0:
                        i_left -= 1
                elif value_left + el_first + value_right < 0:
                    if i_right < len(s_right) - 1:
                        i_right += 1
                else:
                    cur_result = [s_left[i_left], el_first, s_right[i_right]]
                    if cur_result not in result:
                        result.append([s_left[i_left], el_first, s_right[i_right]])
                    if i_left > 0:
                        i_left -= 1
                    if i_right < len(s_right) - 1:
                        i_right += 1
                if i_left == 0 or i_right == len(s_right) - 1:
                    break
        return result


s = Solution()
print(s.threeSum([0,0,0]))
