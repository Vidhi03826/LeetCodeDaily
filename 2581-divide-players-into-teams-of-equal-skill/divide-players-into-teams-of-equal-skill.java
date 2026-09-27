class Solution {
    public long dividePlayers(int[] skill) {
       int n = skill.length;
       Arrays.sort(skill);
        int low = 0;
        int high = n-1;
        long s = 0;
        s  = skill[low] + skill[high];
        long chemistry=0;
       
        while(low<high){
            if(skill[low]+ skill[high]!=s){
                return -1;
            }
            chemistry+= skill[low] * skill[high];
         low++;
         high--;

        }
        return chemistry;
    }
}