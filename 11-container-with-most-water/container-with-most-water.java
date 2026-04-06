class Solution {
    public int maxArea(int[] height) {
       int n= height.length;
        int leftptr = 0;
        int rightptr = n-1;
        int currArea = 0;
        
        while(leftptr<rightptr){
            int w = rightptr - leftptr;
            int h = Math.min(height[leftptr], height[rightptr]);

             currArea = Math.max(currArea, h * w);

            if(height[leftptr]<height[rightptr]) leftptr ++;
            else rightptr--;
        }
        return currArea;

    }
}