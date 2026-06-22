class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==1) {
            return nums[0];
        }
        Arrays.fill(dp, -1);
        int first = rob(Arrays.copyOfRange(nums, 0, nums.length-1), 0, dp);

        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1, -1);
        int second = rob(Arrays.copyOfRange(nums, 1, nums.length), 0, dp1);

        return Math.max(first, second);
    }

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
