class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxLength = 1;
        Set<Character> set = new HashSet<>();
        int n = s.length();
        if(n<=1)
            return n;
        int left=0, right=1;
        set.add(s.charAt(0)); // a b c
        while(left<right && right<n) {
            char ch = s.charAt(right);  // a 
            if(set.contains(ch)) {
                while(set.contains(ch)) {
                    System.out.println(set);
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(ch);
            maxLength = Math.max(maxLength, (right-left)+1);
            right++; 
        }
        return maxLength;
    }
}
