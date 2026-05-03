class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2)
            return false;
        for(int i=0; i<n1; i++) {
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        int left=0, right=n1;
        if(Arrays.equals(freq1, freq2)) 
            return true;

        while(right<n2) {
            char ch1 = s2.charAt(left);
            freq2[ch1-'a']--;
            left++;
            char ch2 = s2.charAt(right);
            freq2[ch2-'a']++;
            right++;
            if(Arrays.equals(freq1, freq2)) 
                return true;
        }
        return false;
    }
}
