class Solution {
    public int calPoints(String[] op) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < op.length; i++) {

            if (op[i].equals("+")) {

                int first = st.pop();
                int second = st.peek();

                int sum = first + second;

                st.push(first);
                st.push(sum);

            }

            else if (op[i].equals("D")) {

                int num = st.peek();
                st.push(num * 2);

            }

            else if (op[i].equals("C")) {

                st.pop();

            }

            else {

                st.push(Integer.parseInt(op[i]));

            }
        }

        int ans = 0;

        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}