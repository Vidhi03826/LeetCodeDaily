
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];
        Arrays.fill(last, -1);

        // DFS traversal
        int[] prev = new int[n];
        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 0;

        while (top > 0) {
            int node = stack[--top];

            if (node < 0) {
                node = ~node;
                last[s.charAt(node) - 'a'] = prev[node];
                continue;
            }

            int c = s.charAt(node) - 'a';
            prev[node] = last[c];

            if (last[c] != -1) {
                newParent[node] = last[c];
            }

            last[c] = node;
            stack[top++] = ~node;

            for (int child : tree[node]) {
                stack[top++] = child;
            }
        }

        // Build modified tree
        List<Integer>[] newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        // Calculate subtree sizes
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int[] order = new int[n];
        top = 0;
        int count = 0;
        order[top++] = 0;

        while (count < top) {
            int node = order[count++];

            for (int child : newTree[node]) {
                order[top++] = child;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            int node = order[i];
            ans[newParent[node]] += ans[node];
        }

        return ans;
    }
}
