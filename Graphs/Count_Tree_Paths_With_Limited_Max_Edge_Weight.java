/*
 * Problem: Count Tree Paths With Limited Max Edge Weight (GeeksforGeeks - Hard)
 * 
 * Given a weighted tree with n nodes and an array queries[], where each queries[i] 
 * represents a maximum allowed edge weight. For each query x, find the number of 
 * distinct paths in the tree such that the maximum edge weight along the path is <= x.
 * 
 * Examples:
 * Input: n = 3, edges[][] = [[1, 2, 1], [2, 3, 4]], queries[] = [3]
 * Output: [1]
 * Explanation: Only 1 -> 2 has a max edge weight <= 3.
 * 
 * Constraints:
 * 2 <= n <= 10^4
 * 1 <= queries.size() <= 10^4
 * 0 <= queries[i], edges[i][2] <= 10^5
 * 
 * Approach:
 * Offline Queries + Disjoint Set Union (DSU). Sort both edges and queries in 
 * ascending order. Iteratively union connected components as edge weight limits 
 * increase. When joining components of sizes S1 and S2, exactly (S1 * S2) new 
 * distinct paths are validated.
 * 
 * Time Complexity: O(N log N + Q log Q)
 * Space Complexity: O(N + Q)
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Count_Tree_Paths_With_Limited_Max_Edge_Weight {

    private int[] parent;
    private int[] size;

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int q = queries.length;
        int[][] sortedQueries = new int[q][2];
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i; 
        }
        
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] result = new int[q];
        int edgeIdx = 0;
        int totalPaths = 0; 

        for (int i = 0; i < q; i++) {
            int limit = sortedQueries[i][0];
            int originalIdx = sortedQueries[i][1];

            while (edgeIdx < edges.length && edges[edgeIdx][2] <= limit) {
                int u = edges[edgeIdx][0];
                int v = edges[edgeIdx][1];
                
                int rootU = find(u);
                int rootV = find(v);

                if (rootU != rootV) {
                    totalPaths += size[rootU] * size[rootV];
                    parent[rootU] = rootV;
                    size[rootV] += size[rootU];
                }
                edgeIdx++;
            }
            result[originalIdx] = totalPaths;
        }

        ArrayList<Integer> ans = new ArrayList<>(q);
        for (int res : result) {
            ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args) {
        Count_Tree_Paths_With_Limited_Max_Edge_Weight solution = 
                new Count_Tree_Paths_With_Limited_Max_Edge_Weight();

        // Example 1
        int n1 = 3;
        int[][] edges1 = {{1, 2, 1}, {2, 3, 4}};
        int[] queries1 = {3};
        System.out.println(solution.maximumWeight(n1, edges1, queries1)); 
        // Expected: [1]

        // Example 2
        int n2 = 7;
        int[][] edges2 = {{1, 2, 3}, {2, 3, 1}, {2, 4, 9}, {3, 6, 7}, {3, 5, 8}, {5, 7, 4}};
        int[] queries2 = {1, 3, 5};
        System.out.println(solution.maximumWeight(n2, edges2, queries2)); 
        // Expected: [1, 3, 4]
    }
}