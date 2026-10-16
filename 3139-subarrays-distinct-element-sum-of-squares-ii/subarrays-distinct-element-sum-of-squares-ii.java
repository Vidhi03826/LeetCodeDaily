import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    long[] sum;
    long[] square;
    long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        sum = new long[4 * n];
        square = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> last = new HashMap<>();

        long ans = 0;

        for (int r = 0; r < n; r++) {
            int x = nums[r];

            int prev = last.getOrDefault(x, -1);

            update(1, 0, n - 1, prev + 1, r);

            ans = (ans + square[1]) % MOD;

            last.put(x, r);
        }

        return (int) ans;
    }

    private void update(int node, int l, int r, int ql, int qr) {

        if (ql <= l && r <= qr) {
            apply(node, l, r);
            return;
        }

        push(node, l, r);

        int mid = l + (r - l) / 2;

        if (ql <= mid) {
            update(node * 2, l, mid, ql, qr);
        }

        if (qr > mid) {
            update(node * 2 + 1, mid + 1, r, ql, qr);
        }

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        square[node] =
            (square[node * 2] + square[node * 2 + 1]) % MOD;
    }

    private void apply(int node, int l, int r) {

        long len = r - l + 1;

        square[node] =
            (square[node] + 2 * sum[node] + len) % MOD;

        sum[node] =
            (sum[node] + len) % MOD;

        lazy[node]++;
    }

    private void push(int node, int l, int r) {

        if (lazy[node] == 0 || l == r) {
            return;
        }

        int mid = l + (r - l) / 2;

        long add = lazy[node];

        applyMultiple(node * 2, l, mid, add);
        applyMultiple(node * 2 + 1, mid + 1, r, add);

        lazy[node] = 0;
    }

    private void applyMultiple(int node, int l, int r, long add) {

        long len = r - l + 1;

        square[node] = (
            square[node]
            + 2 * add % MOD * sum[node] % MOD
            + add % MOD * add % MOD * len % MOD
        ) % MOD;

        sum[node] =
            (sum[node] + add * len) % MOD;

        lazy[node] =
            (lazy[node] + add) % MOD;
    }
}