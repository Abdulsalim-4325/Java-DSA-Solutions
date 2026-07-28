/*
Shortest Path in 1-2 Graph

Given a weighted undirected graph where every edge weight is either
1 or 2, find the shortest distance between src and dest.

Examples:

Input:
V = 4
edges = [[0,1,1],[0,2,2],[2,3,1],[1,2,1],[1,3,2]]
src = 0
dest = 3

Output:
3

Input:
V = 5
edges = [[0,1,1],[0,2,2],[1,2,1],[3,4,2]]
src = 1
dest = 3

Output:
-1
*/

import java.util.*;

public class Shortest_Path_In_1_2_Graph {

    public int shortestPath(int V, int src, int dest, int[][] edges) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])
        );

        dist[src] = 0;
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int distance = current[1];

            if (distance > dist[node]) {
                continue;
            }

            if (node == dest) {
                return distance;
            }

            for (int[] neighbour : graph.get(node)) {

                int next = neighbour[0];
                int weight = neighbour[1];

                if (dist[next] > distance + weight) {

                    dist[next] = distance + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Shortest_Path_In_1_2_Graph solver =
                new Shortest_Path_In_1_2_Graph();

        // Test Case 1
        int[][] edges1 = {
                {0, 1, 1},
                {0, 2, 2},
                {2, 3, 1},
                {1, 2, 1},
                {1, 3, 2}
        };

        System.out.println(
                solver.shortestPath(4, 0, 3, edges1)
        ); // Expected: 3

        // Test Case 2
        int[][] edges2 = {
                {0, 1, 1},
                {0, 2, 2},
                {1, 2, 1},
                {3, 4, 2}
        };

        System.out.println(
                solver.shortestPath(5, 1, 3, edges2)
        ); // Expected: -1

        // Test Case 3
        int[][] edges3 = {
                {1, 0, 1},
                {0, 3, 2},
                {1, 3, 1},
                {1, 2, 2},
                {2, 3, 2},
                {3, 4, 1},
                {2, 4, 1}
        };

        System.out.println(
                solver.shortestPath(5, 1, 4, edges3)
        ); // Expected: 2
    }
}