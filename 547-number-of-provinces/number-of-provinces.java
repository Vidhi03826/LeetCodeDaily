class Solution {
    public void bfs(int i, boolean [] vis, int[][] isConnected ){
        vis[i] = true;
        Queue<Integer> q  = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[front][j] == 1 && vis[j] == false){
                    vis[j] = true;
                    q.add(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
       int n = isConnected.length;
        int count =0;
        boolean [] vis = new boolean[n];
        for(int i=0; i <n;i++){
            if(!vis[i]) {
                bfs(i, vis, isConnected);
                count++;
            }
        }
    return count;
    }
}