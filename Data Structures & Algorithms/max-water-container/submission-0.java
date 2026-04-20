class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left=0, right=n-1;
        int maxArea = Integer.MIN_VALUE;
        while(left<right) {
            int area = 0;
            if(heights[left] <= heights[right]) {
                area = heights[left] * (right-left);
                left++;
            } else {
                area = heights[right] * (right-left);
                right--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
