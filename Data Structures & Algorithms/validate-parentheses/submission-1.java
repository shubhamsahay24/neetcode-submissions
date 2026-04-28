class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add(')');
        set.add('}');
        set.add(']');
        st.push(s.charAt(0));
        if(set.contains(st.peek()))
            return false;
        for(int i=1; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(!st.isEmpty()) {
                if(ch==')' && st.peek()=='(')
                    st.pop();   // 
                else if(ch=='}' && st.peek()=='{')
                    st.pop();
                else if(ch==']' && st.peek()=='[')
                    st.pop();
                else
                    st.push(ch);
            } else {
                st.push(ch);
            }
           // System.out.println(st);
        }
        if(st.isEmpty())
            return true;
        
        return false;
    }
}
