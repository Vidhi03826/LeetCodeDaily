class Solution {
    public int lengthOfLongestSubstring(String s) {
       int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int l =0;
        int r=0;
        int maxlen = 0;
       
        while(r<s.length()){
             char ch = s.charAt(r);
            // already exists in the map 
            if(hash[ch] !=-1) {
           if(hash[ch]>=l){
             l = hash[ch] +1;

           }
          
            }
             maxlen = Math.max(maxlen, r-l+1);
             hash[ch] = r;
        r++; 
        }
       
        return maxlen;
    }
}