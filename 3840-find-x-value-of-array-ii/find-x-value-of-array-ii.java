class Solution {

    static class Node {
        int product;
        int[] cnt;

        Node(int k) {
            product = 1 % k;
            cnt = new int[k];
        }
    }

    int k;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;

        int n = nums.length;
        tree = new Node[4 * n];

        build(nums, 1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update nums[index]
            update(1, 0, n - 1, index, value);

            // Query [start, n-1]
            Node res = query(1, 0, n - 1, start, n - 1);

            ans[i] = res.cnt[x];
        }

        return ans;
    }

    private void build(int[] nums, int node, int l, int r) {

        tree[node] = new Node(k);

        if (l == r) {
            int val = nums[l] % k;

            tree[node].product = val;
            tree[node].cnt[val] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        build(nums, node * 2, l, mid);
        build(nums, node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(
        int node,
        int l,
        int r,
        int index,
        int value
    ) {

        if (l == r) {
            value %= k;

            tree[node].product = value;

            tree[node].cnt = new int[k];
            tree[node].cnt[value] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node query(
        int node,
        int l,
        int r,
        int ql,
        int qr
    ) {

        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    private Node merge(Node left, Node right) {

        Node res = new Node(k);

        // Product of entire segment
        res.product = (int) (
            (long) left.product * right.product % k
        );

        // Subarrays/suffixes coming from left
        for (int i = 0; i < k; i++) {
            res.cnt[i] = left.cnt[i];
        }

        // Suffixes that start in right:
        // left.product * rightProduct % k
        for (int i = 0; i < k; i++) {

            int newRem = (int) (
                (long) left.product * i % k
            );

            res.cnt[newRem] += right.cnt[i];
        }

        return res;
    }
}