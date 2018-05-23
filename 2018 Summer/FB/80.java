// 80. Remove Duplicates from Sorted Array II

// Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (i < 2 || nums[j-2] < nums[i]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}