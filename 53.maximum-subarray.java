class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curmax = 0;

        for(int num:nums){
            curmax = Math.max(num,num+curmax);
            max = Math.max(curmax,max);
        }
        return max;
    }
}
