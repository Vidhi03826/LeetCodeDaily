class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        Arrays.sort(points , Comparator.comparingInt(row -> row[0]));
      int result =0 ;
      for(int i=1;i<n;i++){
        int width = points[i][0]  - points[i-1][0];
        result = Math.max(result , width);

      }
      return result;


    }
}