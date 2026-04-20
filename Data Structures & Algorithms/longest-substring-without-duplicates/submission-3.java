class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int left=0, right=0, maxLength = 0;
        while(right < s.length()) {
            char ch = s.charAt(right);  
            while(set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxLength = Math.max(maxLength, (right-left)+1);
            right++; 
        }
        return maxLength;
    }
}
