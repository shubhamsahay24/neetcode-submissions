class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        int left=0, right=s.length()-1;

        while(left<=right) {
            char ch1 = s.charAt(left);
            char ch2 = s.charAt(right);

            if(!Character.isLetterOrDigit(ch1)) {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(ch2)) {
                right--;
                continue;
            }
            if(left==right)
                break; 
            if(ch1==ch2) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
