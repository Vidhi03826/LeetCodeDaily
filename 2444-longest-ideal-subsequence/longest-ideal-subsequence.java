class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int freq[] = new int[26];

        int result = 0 ; 
        for(int i= 0; i<n ; i++){
            int idx = s.charAt(i) - 'a';
            int left = Math.max( 0 , idx - k);
            int right = Math.min(25 , idx + k);
            int longest= 0;
            for(int j = left ; j<=right;j++){
                 longest = Math.max(longest , freq[j]);
                
            }
            freq[idx] = Math.max( freq[idx],longest +1 );
            result = Math.max(result , freq[idx]);
            }
            return result;
    }
}