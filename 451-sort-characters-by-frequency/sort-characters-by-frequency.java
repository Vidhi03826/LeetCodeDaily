import java.util.*;

class Solution {
    public String frequencySort(String s) {
        
        // Count frequency using HashMap
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        // Convert map to list
        List<Character> list = new ArrayList<>(map.keySet());
        
        // Sort characters based on frequency (descending)
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        
        // Build result string
        StringBuilder sb = new StringBuilder();
        for(char ch : list) {
            int freq = map.get(ch);
            while(freq-- > 0) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
