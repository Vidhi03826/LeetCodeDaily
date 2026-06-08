class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] leftsmall = new int[n];
        int[] rightsmall = new int[n];

        Stack<Integer> st = new Stack<>();

        // NSL
        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            leftsmall[i] = st.isEmpty() ? 0 : st.peek() + 1;

            st.push(i);
        }

        st.clear();

        // NSR
        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            rightsmall[i] = st.isEmpty() ? n - 1 : st.peek() - 1;

            st.push(i);
        }

        int maxArea = 0;

        for(int i = 0; i < n; i++) {

            int width = rightsmall[i] - leftsmall[i] + 1;

            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }
}