// 90. Subsets II

// Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: [1,2,2]
// Output:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(new ArrayList<Integer>(), nums, 0);
        return result;
    }
    
    public void dfs(List<Integer> list, int[] nums, int pos) {
        if (!result.contains(list))
            result.add(list);
        
        for (int i = pos; i < nums.length; i++) {
        	/********************
				Avoid the dup
        	********************/
            if (i > pos && nums[i-1] == nums[i]) continue;
            
            List<Integer> temp = new ArrayList<Integer>(list);
            temp.add(nums[i]);
            dfs(temp, nums, i+1);
        }
    } 
}