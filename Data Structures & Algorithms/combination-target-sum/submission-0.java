class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> comb = new ArrayList<>();
        comb(nums, 0, target, comb, new ArrayList<>());
        return comb;
    }

    // 

    private void comb(int[] nums, int ind, int target, List<List<Integer>> combination, List<Integer> inner) {

        if(ind==nums.length) {
            if(target==0)
                combination.add(new ArrayList<>(inner));
            return;
        }
        if(nums[ind] <= target) { // 5
            inner.add(nums[ind]);
            comb(nums, ind, target-nums[ind], combination, inner);
            inner.remove(inner.size()-1);
        }
        comb(nums, ind+1, target, combination, inner);
    }
}
