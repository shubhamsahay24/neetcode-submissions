class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, 0, dp);
    }


//  1 1 3 3
    private int rob(int[] nums, int ind, int[] dp) {
        if(ind>=nums.length) {
            return 0;
        }
        if(dp[ind]!=-1)
            return dp[ind];

        int take = nums[ind] + rob(nums, ind+2, dp);
        int nonTake = rob(nums, ind+1, dp);

        return dp[ind] = Math.max(take, nonTake);
    }
}
