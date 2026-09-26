class Solution {
    public int findMinDifference(List<String> timePoints) {
       int minutes[] = new int[timePoints.size()];
        
        for(int i=0;i<timePoints.size();i++){
            String hourstring = timePoints.get(i).substring(0,2);
            String minstring = timePoints.get(i).substring(3);

            int hour = Integer.parseInt(hourstring);
            int min = Integer.parseInt(minstring);
     
         minutes[i] =  hour*60 + min;

        
        }
        Arrays.sort(minutes);
        int mindiff = Integer.MAX_VALUE;
        int n = minutes.length;
        for(int i = 1; i<minutes.length;i++){
            mindiff = Math.min(mindiff , minutes[i] - minutes[i-1]);

        }
        return mindiff = Math.min(mindiff , (24*60 - minutes[n-1]) + minutes[0]);
    }
}