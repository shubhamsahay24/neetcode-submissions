class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        int left=0, right=0, maxLength = 0;
        while(right < s.length()) {
            char ch = s.charAt(right);  
            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch)+1); 
            }
            map.put(ch, right);
            maxLength = Math.max(maxLength, (right-left)+1);
            right++;
        }
        return maxLength;
    }
}
