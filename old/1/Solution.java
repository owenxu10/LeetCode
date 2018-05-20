import java.util.HashMap;
import java.util.Map;

/*
1. Two Sum

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 

Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9

Output: index1=1, index2=2

*/

public class Solution {
	
    public int[] twoSum(int[] nums, int target) {
//    	int[] result = new int[2];
//    	int p1 = 0;
//    	int p2; 
//    	while(p1<=nums.length-2){
//    		for(p2=p1+1;p2<=nums.length-1;p2++){
//    			if(nums[p1] + nums[p2] == target){
//    				result[0] = p1+1;
//    				result[1] = p2+1;
//    				break;
//    			}
//    		}
//    		p1++;
//    	}
//    	return result;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i + 1);
        }
        return result;
    }
    
    public static void main(String args[]){
    	Solution s1 = new Solution();
    	int[] nums = {3,2,4};
    	int[] result = s1.twoSum(nums, 6);
    	System.out.println(result[0]);
    	System.out.println(result[1]);
    	
    }

}
