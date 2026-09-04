class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int n = candies.length;
        int maxc =candies[0];
        for(int i =1;i<n;i++){
         if(candies[i]> maxc){
            maxc = candies[i];
         }
        }

        for(int i=0;i<n;i++){
            if(candies[i] +extraCandies >= maxc){
                res.add(true);
            }
            else{
            res.add(false);
            }
        }
        return res;

    }
}