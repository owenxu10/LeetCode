// 209. Minimum Size Subarray Sum

// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. 
// If there isn't one, return 0 instead.

// Example: 

// Input: [2,3,1,2,4,3], s = 7
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem constraint.
// Follow up:
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 

// Brute force (bad)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	int min = nums.length+1;
        for (int i = 0; i < nums.length; i++) {
        	int sum = 0;
        	for (int j = i; j < nums.length; j++) {
        		sum += nums[j];
        		if (sum >= s) {
        			if ((j + 1 - i) < min) {
        				min = j + 1 - i;
        			}
                    break;
        		} 
        	}
        }
        if (min == nums.length+1)
            return 0;
        return min;
    }
}

// O(n)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
        while (start < nums.length) {
            sum += nums[start];
            start++;
            while (sum >= s) {
                min = Math.min(min, start-end);
                sum -= nums[end];
                end++;    
            }
            
            
        }
        
        if (min == Integer.MAX_VALUE) 
            return 0;
        return min;
    }
}

//O(nlogn) ***
class Solution {
   public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        if (nums.length == 0) return 0;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (sums[i] >= s) {
                int position = binarysearch(sums, 0, i, sums[i], s);
                min = Math.min(i - position + 1, min);
            }
        }

        return min == Integer.MAX_VALUE? 0:min;
    }

    public int binarysearch(int[] sums, int start, int end, int target, int s) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target - sums[mid] >=  s) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}