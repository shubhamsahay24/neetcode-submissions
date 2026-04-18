class Solution {
    public int[] productExceptSelf(int[] nums) {

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
}  
