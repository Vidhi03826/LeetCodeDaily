class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first  = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<String>();
        for(int i=0;i<n;i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps  =q.peek().second;
            q.remove();
            if(word.equals(endWord)) return steps;
            for(int i=0;i<word.length();i++){
                for(char ch ='a'; ch<='z';ch++){
                   char replaced[] = word.toCharArray();
                    replaced[i] = ch;
                    String newstr = new String(replaced);
                    if(st.contains(newstr)==true){
                        st.remove(newstr);
                        q.add(new Pair(newstr, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}