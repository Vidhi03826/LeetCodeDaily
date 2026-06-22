class Solution {
    public int largestArea(int[] hist){
        int n= hist.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || hist[st.peek()] >=hist[i])){
                int height = hist[st.pop()];
               int nse = i;
               int pse = st.isEmpty() ? -1 : st.peek();
               int width = nse - pse -1;
               maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];
        int maxArea = 0;

        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                }
                else{
                    height[j] = 0;
                }

               
            }
             maxArea = Math.max(maxArea , largestArea(height));
        }
        return maxArea;
    }
}