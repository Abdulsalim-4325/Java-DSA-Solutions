/*
Min Edge Movements to Connect a Graph

Given a graph with n vertices (0 to n-1) and m edges.
You can remove one edge from anywhere and add that edge between
any two vertices in one operation.

Find the minimum number of operations required to connect the graph.
If it is not possible to connect the graph, return -1.

Examples:

Input: n = 4, edges[][] = [[0, 1], [0, 2], [1, 2]]

Output: 1

Explanation:
Remove the edge between vertices 1 and 2 and add it between
vertices 1 and 3.

Input: n = 6, edges[][] = [[0,1], [0,2], [0,3], [1,2], [1,3]]

Output: 2

Explanation:
Remove edges (1,2) and (0,3), and add edges (1,4) and (3,5).

Constraints:

1 <= n <= 10^5
1 <= m <= 10^5
edges[i].length = 2
edges[i][j] < n
There are no multi-edges in the graph.
*/

public class Min_Edge_Movements_To_Connect_A_Graph {

    public int minEdgesReq(int n, int[][] edges) {
        if (edges.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] edge : edges) {
            int u = find(parent, edge[0]);
            int v = find(parent, edge[1]);

            if (u != v) {
                parent[u] = v;
                components--;
            }
        }

        return components - 1;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    public static void main(String[] args) {
        Min_Edge_Movements_To_Connect_A_Graph solver =
                new Min_Edge_Movements_To_Connect_A_Graph();

        int n1 = 4;
        int[][] edges1 = {
            {0, 1},
            {0, 2},
            {1, 2}
        };

        System.out.println("Input: n = " + n1);
        System.out.println("Output: " +
                solver.minEdgesReq(n1, edges1));
        System.out.println();

        int n2 = 6;
        int[][] edges2 = {
            {0, 1},
            {0, 2},
            {0, 3},
            {1, 2},
            {1, 3}
        };

        System.out.println("Input: n = " + n2);
        System.out.println("Output: " +
                solver.minEdgesReq(n2, edges2));
    }
}