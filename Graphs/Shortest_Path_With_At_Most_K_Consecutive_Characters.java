/*
 * Problem: 3970. Shortest Path With At Most K Consecutive Identical Characters
 * 
 * You are given an integer n representing the number of nodes in a directed weighted graph, 
 * numbered from 0 to n - 1. This is represented by a 2D integer array edges, where 
 * edges[i] = [ui, vi, wi] represents a directed edge from node ui to node vi with weight wi.
 * 
 * You are also given a string labels of length n, where labels[i] is the character 
 * assigned to node i, and an integer k.
 * Return the minimum total edge weight of a path from node 0 to node n - 1 such that 
 * the concatenation of the labels of the nodes along the path contains at most k 
 * consecutive identical characters. If no valid path exists, return -1.
 * 
 * Constraints:
 * - 1 <= n == labels.length <= 5 * 10^4
 * - 0 <= edges.length <= 5 * 10^4
 * - edges[i] == [ui, vi, wi]
 * - 0 <= ui, vi <= n - 1
 * - 1 <= wi <= 10^4
 * - labels consists of lowercase English letters
 * - 1 <= k <= 50
 * 
 * Approach:
 * Expanded State-Space Dijkstra Algorithm resolving combinations dynamically across
 * node tracking alongside mapped limits. 
 * 
 * Time Complexity: O(E * K log (N * K))
 * Space Complexity: O(N * K + E)
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Shortest_Path_With_At_Most_K_Consecutive_Characters {

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (n == 1) return 0;
        
        int numEdges = edges.length;
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] to = new int[numEdges];
        int[] weight = new int[numEdges];
        int[] next = new int[numEdges];
        
        for (int i = 0; i < numEdges; i++) {
            int u = edges[i][0];
            to[i] = edges[i][1];
            weight[i] = edges[i][2];
            next[i] = head[u];
            head[u] = i;
        }
        
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 1});
        dist[0][1] = 0;
        
        char[] labelChars = labels.toCharArray();
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            int count = curr[2];
            
            if (d > dist[u][count]) continue;
            
            if (u == n - 1) return d;
            
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                int w = weight[e];
                
                int newCount = (labelChars[u] == labelChars[v]) ? count + 1 : 1;
                
                if (newCount <= k) {
                    if (d + w < dist[v][newCount]) {
                        dist[v][newCount] = d + w;
                        pq.offer(new int[]{d + w, v, newCount});
                    }
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Shortest_Path_With_At_Most_K_Consecutive_Characters solution = 
                new Shortest_Path_With_At_Most_K_Consecutive_Characters();

        // Example 1
        int n1 = 3;
        int[][] edges1 = {{0,1,1},{1,2,1},{0,2,3}};
        String labels1 = "aab";
        int k1 = 1;
        System.out.println(solution.shortestPath(n1, edges1, labels1, k1)); 
        // Expected: 3
        
        // Example 2
        int n2 = 3;
        int[][] edges2 = {{0,1,1},{1,2,1},{0,2,3}};
        String labels2 = "aab";
        int k2 = 2;
        System.out.println(solution.shortestPath(n2, edges2, labels2, k2)); 
        // Expected: 2
    }
}