/*
 * Min Edge Reversals for Path
 * Difficulty: Medium | Accuracy: 37.35% | Submissions: 6K+ | Points: 4
 * 
 * Given a directed graph with n vertices numbered from 1 to n. 
 * The graph is represented using a 2D array edges[][] of size m, where each 
 * entry edges[i] = [u, v] denotes a directed edge from vertex u to vertex v. 
 * You are also given a source vertex src and a destination vertex dst.
 * 
 * Find the minimum number of edges that need to be reversed so that there exists 
 * at least one path from src to dst. If it is not possible to create a path 
 * from src to dst, return -1.
 * 
 * Examples:
 * Input: n = 3, edges[][] = [[1, 2], [3, 2]], src = 1, dst = 3
 * Output: 1
 * Explanation: Reverse the edge 3 -> 2.
 * 
 * Input: n = 4, edges[][] = [[1, 2], [2, 3], [3, 4]], src = 1, dst = 4
 * Output: 0
 * Explanation: One path already exists between 1 to 4 i.e. 1 -> 2 -> 3 -> 4.
 * 
 * Constraints:
 * 1 <= n, m <= 10^5
 * 1 <= edges[i][0], edges[i][1] <= n
 * 1 <= src, dst <= n
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Min_Edge_Reversals_for_Path {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[][] edges1 = {{1, 2}, {3, 2}};
        System.out.println("Test Case 1: " + solver.minimumEdgeReversal(edges1, 3, 1, 3)); // Expected: 1

        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("Test Case 2: " + solver.minimumEdgeReversal(edges2, 4, 1, 4)); // Expected: 0
    }
}

class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new int[]{v, 0});
            adj.get(v).add(new int[]{u, 1});
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(src);
        
        while (!deque.isEmpty()) {
            int curr = deque.pollFirst();
            
            if (curr == dst) {
                return dist[curr];
            }
            
            for (int[] next : adj.get(curr)) {
                int nextNode = next[0];
                int weight = next[1];
                
                if (dist[curr] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[curr] + weight;
                    
                    if (weight == 0) {
                        deque.addFirst(nextNode);
                    } else {
                        deque.addLast(nextNode);
                    }
                }
            }
        }
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}