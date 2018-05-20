package old;

class Solution {
    public boolean canJump(int[] nums) {
        int reached = 0;
        for (int i = 0;i<=nums.length-1;i++){
            if (i > reached) return false;
            reached = Math.max(reached, nums[i]+i);
        }
        return true;
    }
}


