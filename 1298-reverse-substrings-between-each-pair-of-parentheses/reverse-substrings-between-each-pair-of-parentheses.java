import java.util.*;

class Solution {
    public String reverseParentheses(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ')') {

                StringBuilder temp = new StringBuilder();

                while (!st.isEmpty() && st.peek() != '(') {
                    temp.append(st.pop());
                }

                // Remove '('
                st.pop();

                // Push reversed part back
                for (int j = 0; j < temp.length(); j++) {
                    st.push(temp.charAt(j));
                }

            } else {
                st.push(s.charAt(i));
            }
        }

        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.reverse().toString();
    }
}