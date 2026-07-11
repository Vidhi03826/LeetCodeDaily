class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }

        int[] freq = new int[128];

        int left = 0;
        int required = t.length();
        for(char ch : t.toCharArray()){
            freq[ch]++;
        }
        int minlen =Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right<s.length(); right++){
          char ch = s.charAt(right);
          if(freq[ch]>0){
            required--;
          }

          freq[ch]--;

          while(required==0){
            if(right - left+1<minlen){
                minlen = right - left+1;
                start = left;

            }
            char lchar = s.charAt(left);
            freq[lchar]++;
            
            if(freq[lchar]>0){
                required++;
            }
            left++;
          }
        }
        return minlen ==Integer.MAX_VALUE ?"" : s.substring(start , start +minlen);
    }
}