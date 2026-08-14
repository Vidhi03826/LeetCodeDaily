class Solution {
    public int maximumLengthSubstring(String s) {
        int left= 0 ; 
        int maxlen = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int right = 0;right<s.length();right++){
        mp.put(s.charAt(right) ,  mp.getOrDefault(s.charAt(right) , 0) +1);

        while(mp.get(s.charAt(right))>2){
           mp.put(s.charAt(left) , mp.get(s.charAt(left)) - 1);
            left++;
        }
        maxlen = Math.max(maxlen , right  - left+1);
        }
        return maxlen ; 
    }
}