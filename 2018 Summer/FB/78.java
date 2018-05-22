// 78. Subsets

// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        helper(new ArrayList<Integer>(), nums, 0, list);
        return list;
    }
    
    public void helper(List<Integer> li, int[] nums, int start, List<List<Integer>> list) {
        list.add(li);
        if (nums.length == 0) return;
        for (int i = start; i < nums.length; i++) {
            List<Integer> l = new ArrayList(li);
            l.add(nums[i]);
            helper(l, nums, i+1, list);
        }
    }
}