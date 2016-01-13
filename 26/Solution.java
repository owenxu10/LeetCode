/*
26. Remove Duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        
        for(p1 = 0 ; p1<nums.length-1; p1++){
            if(nums[p1+1] == nums[p1]) 
                continue;
            else nums[p2++] = nums[p1+1];
        }
        return p2;
    }
}