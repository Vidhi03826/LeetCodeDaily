class Solution {
    private int timer =1;
    public void dfs(int node, int parent, int[] vis, int[] low,int[] tin,List<List<Integer>> bridges,ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        low[node] = tin[node] = timer;
        timer++;
        for(Integer it: adj.get(node)){
            if(it==parent) continue;
            if(vis[it]==0){
                dfs(it, node, vis, low, tin, bridges, adj);
                low[node] = Math.min(low[node], low[it]);

                if(low[it]>tin[node]){
                    bridges.add(Arrays.asList(it,node));
                }
            }
            else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(List<Integer> it: connections){
            int u = it.get(0); 
            int v= it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] vis = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0 , -1 , vis, low, tin, bridges, adj);
        return bridges;


    }
}