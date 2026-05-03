class Solution {
    public int search(int[] nums, int target) {
        
        int left=0, right=nums.length-1;
        if(nums.length==1) {
            if(target==nums[0])
                return 0;
            return -1;
        }
        while(left<right) {
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right])
                left = mid+1;
            else
                right=mid;
        }
        int pivot = left;
        if(target>=nums[pivot] && target<=nums[nums.length-1]) {
            return binarySearch(pivot, nums.length-1, target, nums);
        } else {
            return binarySearch(0, pivot, target, nums);
        }
    }

    private int binarySearch(int l, int r, int target, int[] nums) {

        while(l <= r) {
            int mid = l + (r-l)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }   
        return -1; 
    }
}
