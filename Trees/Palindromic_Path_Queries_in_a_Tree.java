/*
 * Problem: 3841. Palindromic Path Queries in a Tree (LeetCode - Hard)
 * 
 * You are given an undirected tree with n nodes labeled 0 to n - 1. 
 * A string s assigns a lowercase character to each node.
 * 
 * Queries:
 * - "update ui c": Change character at node ui to c.
 * - "query ui vi": Determine whether characters on path from ui to vi 
 *   can be rearranged into a palindrome.
 * 
 * Approach:
 * Combine Euler Tour Subtree Flattening, Binary Lifting for Lowest Common Ancestor (LCA), 
 * and a Binary Indexed Tree (BIT/Fenwick Tree) for O(log N) dynamic subtree updates.
 * Validate palindromic capabilities using 26-bit bitwise XOR frequency mappings.
 * 
 * Time Complexity: O(N log N + Q log N)
 * Space Complexity: O(N log N)
 */

import java.util.ArrayList;
import java.util.List;

public class Palindromic_Path_Queries_in_a_Tree {
    private int[] in, out, depth;
    private int[][] up;
    private int[] val, root_xor;
    private int[] bit;
    private int timer;
    private int n;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        in = new int[n];
        out = new int[n];
        depth = new int[n];
        up = new int[n][16];
        val = new int[n];
        root_xor = new int[n];
        bit = new int[n + 2];
        timer = 0;

        for (int i = 0; i < n; i++) {
            val[i] = 1 << (s.charAt(i) - 'a');
        }

        dfs(0, 0, 0, 0, adj);

        int[] initialXor = new int[n + 1];
        for (int i = 0; i < n; i++) {
            initialXor[in[i]] = root_xor[i];
        }
        for (int i = 1; i <= n; i++) {
            updateBIT(i, initialXor[i] ^ initialXor[i - 1]);
        }

        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                int newVal = 1 << (parts[2].charAt(0) - 'a');
                int diff = val[u] ^ newVal;
                val[u] = newVal;
                updateBIT(in[u], diff);
                updateBIT(out[u] + 1, diff);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int lca = getLCA(u, v);
                int pathMask = queryBIT(in[u]) ^ queryBIT(in[v]) ^ val[lca];
                ans.add(Integer.bitCount(pathMask) <= 1);
            }
        }
        return ans;
    }

    private void dfs(int u, int p, int d, int cur_xor, List<Integer>[] adj) {
        in[u] = ++timer;
        up[u][0] = p;
        for (int i = 1; i < 16; i++) {
            up[u][i] = up[up[u][i - 1]][i - 1];
        }
        depth[u] = d;
        root_xor[u] = cur_xor ^ val[u];

        for (int v : adj[u]) {
            if (v != p) {
                dfs(v, u, d + 1, root_xor[u], adj);
            }
        }
        out[u] = timer;
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }
        int diff = depth[u] - depth[v];
        for (int i = 0; i < 16; i++) {
            if (((diff >> i) & 1) == 1) {
                u = up[u][i];
            }
        }
        if (u == v) return u;
        for (int i = 15; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        return up[u][0];
    }

    private void updateBIT(int idx, int delta) {
        for (; idx <= n; idx += idx & -idx) {
            bit[idx] ^= delta;
        }
    }

    private int queryBIT(int idx) {
        int res = 0;
        for (; idx > 0; idx -= idx & -idx) {
            res ^= bit[idx];
        }
        return res;
    }

    public static void main(String[] args) {
        Palindromic_Path_Queries_in_a_Tree solution = new Palindromic_Path_Queries_in_a_Tree();
        
        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}};
        String s1 = "aac";
        String[] queries1 = {"query 0 2", "update 1 b", "query 0 2"};
        System.out.println(solution.palindromePath(n1, edges1, s1, queries1)); 
        // Expected: [true, false]
        
        int n2 = 4;
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}};
        String s2 = "abca";
        String[] queries2 = {"query 1 2", "update 0 b", "query 2 3", "update 3 a", "query 1 3"};
        System.out.println(solution.palindromePath(n2, edges2, s2, queries2)); 
        // Expected: [false, false, true]
    }
}