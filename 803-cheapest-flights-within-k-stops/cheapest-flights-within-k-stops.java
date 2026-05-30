class Solution {
    class Pair{
    int first, second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class tuple{
    int first, second,third;
    tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
     int m = flights.length;
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i]  = (int)(1e9);
        }
        dist[src] = 0;

        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0, src, 0));

        while(!q.isEmpty()){
            int stops = q.peek().first;
            int node = q.peek().second;
            int cost = q.peek().third;
            q.remove();

            for(Pair it : adj.get(node)){
                int adjnode = it.first;   /// isko smajhna haii why first
                int edgD= it.second;

                if(edgD + cost < dist[adjnode] && stops<=k){
                    dist[adjnode] = edgD + cost;
                    q.add(new tuple(stops +1, adjnode, edgD + cost));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst] ;
    }
}