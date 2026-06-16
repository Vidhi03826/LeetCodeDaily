import java.util.*;

class Solution {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.dist - b.dist);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int dis = curr.dist;

            for (Pair it : adj.get(node)) {

                int adjNode = it.node;
                int wt = it.dist;

                if (dis + wt < dist[adjNode]) {

                    dist[adjNode] = dis + wt;

                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}