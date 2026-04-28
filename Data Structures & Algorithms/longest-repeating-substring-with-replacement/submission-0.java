class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character, Integer> map = new HashMap<>();
        int[] count = new int[26];
        int left=0, right=0;
        int maxfreq = 0;
        int maxLength = 0;
        while(right<s.length()) {
            char ch = s.charAt(right);
            count[ch-'A']++;
            //map.put(ch, (map.getOrDefault(ch), 0)+1);
            maxfreq = Math.max(maxfreq, count[ch-'A']);
            // window length - maxf <=k
            while((right-left+1) - maxfreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, (right-left)+1);
            right++;
        }
        
        return maxLength;
    }
}
// A A A B A B B
//left=   1
//right=  5
// A -> 3
// B -> 2
