class Solution {
    class Pair{
     long first; int second;
     Pair(long first, int second){
        this.first = first;
        this.second = second;
     }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int m = roads.length;
     int  mod = 1_000_000_007;
        for(int i=0;i<m;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> Long.compare(a.first,b.first));
        pq.add(new Pair(0,0));
        int [] ways = new int[n]; 
        long[] dist = new long[n];
       Arrays.fill(dist, Long.MAX_VALUE);  
        for(int i=0;i<n;i++){
           
            ways[i] = 0;
        }
        ways[0] = 1;
        dist[0] = 0;

        while(pq.size()!=0){
          
            long dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for(Pair it : adj.get(node)){
             int adjnode = (int) it.first;
            long edgewt = it.second;
                
                if(dis > dist[node]) continue;
                if(dis + edgewt < dist[adjnode]){
                    dist[adjnode] = dis + edgewt;
                    ways[adjnode] = ways[node];
                    pq.add(new Pair(dis + edgewt , adjnode));
                }

                else if(dis + edgewt == dist[adjnode]){
                    ways[adjnode] = (ways[adjnode] + ways[node]) % mod;
                }
            }
        }
         return ways[n-1] %mod;
        }
}