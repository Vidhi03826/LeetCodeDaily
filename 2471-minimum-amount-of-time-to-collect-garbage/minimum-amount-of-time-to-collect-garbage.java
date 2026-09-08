class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int time= 0;
        int M_idx = 0;
        int P_idx = 0;
        int G_idx = 0;
        for(int i=0;i<n;i++){
          for(int j=0;j<garbage[i].length();j++){
            char ch = garbage[i].charAt(j);
                if(ch=='M'){
                    M_idx = i;
                }
                else if(ch=='P'){
                    P_idx = i;
                }
                else{
                    G_idx = i;
                }
                time++;
            }
    }
    //traverse and add travelling time
    for(int i=0;i<travel.length;i++){
        if(i<M_idx){
            time+=travel[i];
        }
        if(i<P_idx){
            time+=travel[i];
        }
        if(i<G_idx){
            time+=travel[i];
        }
    }
    return time;

    }
}