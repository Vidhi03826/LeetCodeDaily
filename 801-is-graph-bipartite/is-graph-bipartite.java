class Solution {
    private boolean check(int V, int[][] graph, int[] color, int start){
        color[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int it: graph[node]){
                if(color[it]==-1){
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                else if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int [V];
        for(int i=0;i<V;i++){
            color[i]=-1;
        }

        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(check(V, graph, color, i)==false){
                    return false;
                }
            }
        }
        return true;
    }
}