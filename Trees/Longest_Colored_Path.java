/*
 * Longest Colored Path
 * Difficulty: Hard | Accuracy: 32.64% | Submissions: 7K+ | Points: 8
 * 
 * Given an undirected acyclic graph (tree) with n nodes numbered from 1 to n. 
 * Each node is colored either Red (R) or Blue (B).
 * 
 * A path is called valid if, once you visit a Blue node, you cannot visit any 
 * Red node after it on the same path.
 * A path containing a pattern like Blue -> Red is invalid.
 * Find the maximum number of nodes in a valid path.
 * 
 * Constraints:
 * s.size() <= 10^5
 * 1 <= edges[i][j] <= s.size()
 * edges.size() == s.size() - 1
 */

import java.util.Arrays;

public class Longest_Colored_Path {
    public static void main(String[] args) {
        Solution solver = new Solution();

        String s1 = "RBB";
        int[][] edges1 = {{1, 2}, {1, 3}};
        System.out.println("Test Case 1: " + solver.longestPath(s1, edges1)); 
        // Expected: 2
        
        String s2 = "BB";
        int[][] edges2 = {{1, 2}};
        System.out.println("Test Case 2: " + solver.longestPath(s2, edges2)); 
        // Expected: 2
        
        String s3 = "RBRB";
        int[][] edges3 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("Test Case 3: " + solver.longestPath(s3, edges3)); 
        // Expected: 2
    }
}

class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        char[] color = s.toCharArray();
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] to = new int[2 * n];
        int[] next = new int[2 * n];
        int edgeCount = 0;
        
        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            to[edgeCount] = v;
            next[edgeCount] = head[u];
            head[u] = edgeCount++;
            to[edgeCount] = u;
            next[edgeCount] = head[v];
            head[v] = edgeCount++;
        }
        
        int[] order = new int[n];
        int[] parent = new int[n];
        int[] down1 = new int[n];
        int[] down2 = new int[n];
        int[] c1 = new int[n];
        int[] up = new int[n];
        int[] max_len_edges = new int[n];
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int orderStart = 0;
                int orderEnd = 0;
                order[orderEnd++] = i;
                visited[i] = true;
                parent[i] = -1;
                
                while (orderStart < orderEnd) {
                    int u = order[orderStart++];
                    for (int e = head[u]; e != -1; e = next[e]) {
                        int v = to[e];
                        if (!visited[v] && color[u] == color[v]) {
                            visited[v] = true;
                            parent[v] = u;
                            order[orderEnd++] = v;
                        }
                    }
                }
                
                for (int j = orderEnd - 1; j >= 0; j--) {
                    int u = order[j];
                    down1[u] = 0; down2[u] = 0; c1[u] = -1;
                    for (int e = head[u]; e != -1; e = next[e]) {
                        int v = to[e];
                        if (v == parent[u] || color[u] != color[v]) continue;
                        int len = down1[v] + 1;
                        if (len > down1[u]) {
                            down2[u] = down1[u];
                            down1[u] = len;
                            c1[u] = v;
                        } else if (len > down2[u]) {
                            down2[u] = len;
                        }
                    }
                }
                
                up[i] = 0;
                for (int j = 0; j < orderEnd; j++) {
                    int u = order[j];
                    max_len_edges[u] = Math.max(down1[u], up[u]);
                    for (int e = head[u]; e != -1; e = next[e]) {
                        int v = to[e];
                        if (v == parent[u] || color[u] != color[v]) continue;
                        if (v == c1[u]) {
                            up[v] = Math.max(up[u], down2[u]) + 1;
                        } else {
                            up[v] = Math.max(up[u], down1[u]) + 1;
                        }
                    }
                }
            }
        }
        
        int maxPathNodes = 0;
        for (int i = 0; i < n; i++) {
            maxPathNodes = Math.max(maxPathNodes, max_len_edges[i] + 1);
        }
        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            if (color[u] != color[v]) {
                maxPathNodes = Math.max(maxPathNodes, (max_len_edges[u] + 1) + (max_len_edges[v] + 1));
            }
        }
        return maxPathNodes;
    }
}