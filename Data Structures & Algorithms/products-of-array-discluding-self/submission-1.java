class Solution {
    public int[] productExceptSelf(int[] nums) {

        //return withDivision(nums);
        return prefixSuffix(nums);
        
    }
    private int[] withDivision(int[] nums) {
        int[] prod = new int[nums.length];
        int zeroCount = 0;
        int product = 1;

        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                zeroCount++;
            } else {
                product *= nums[i];
            }
        }
        System.out.println(zeroCount);
        if(zeroCount>1) {
            return prod;
        }
        for(int i=0; i<nums.length; i++) {
            
            if(nums[i]!=0) {
                if(zeroCount==1) 
                    prod[i] = 0;
                else prod[i] = product/nums[i];
            } else {
                prod[i] = product;
            }
        }
        
        return prod;
    }

    private int[] prefixSuffix(int[] nums) {
        // without division operator
        // Maintaining prefix product array from left to right
        // suffix product array from right to left
        int n =nums.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        int[] prod = new int[n];
        pref[0]=1;
        suff[n-1]=1;
        for(int i=1; i<n; i++) {
            pref[i] = pref[i-1] * nums[i-1];
        }
        for(int i=n-2; i>=0; i--) {
            suff[i] = suff[i+1] * nums[i+1];
        }
        for(int i=0; i<n; i++) {
            prod[i] = pref[i] * suff[i];
        }
        return prod;
    }
}  
