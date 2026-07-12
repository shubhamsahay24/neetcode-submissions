class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int m = intervals.length;
        int n = intervals[0].length;
        int[][] merge = new int[m][n];
        merge[0][0] = intervals[0][0];
        merge[0][1] = intervals[0][1];
        int ind1=0, ind2=0;
        for(int i=1; i<m; i++) {
            if(intervals[i][0] <= merge[ind1][1]) {
                merge[ind1][1] = Math.max(intervals[i][1], merge[ind1][1]); 
               // System.out.println(merge[ind1][1]);              
            } else {
                merge[++ind1][0] = intervals[i][0];
                merge[ind1][1] = intervals[i][1];
               // System.out.println(merge[ind1][1]); 
            }
        }

        return Arrays.copyOfRange(merge, 0, ind1+1);
    }
}
