/*
Longest Path in a Directed Acyclic Graph

Given a weighted Directed Acyclic Graph (DAG) with V vertices numbered
from 0 to V - 1, represented by edges[][], where:

edges[i] = [u, v, w]

denotes a directed edge from u to v with weight w.

You are also given a source vertex src.

Return the distance array, where the value at index i represents the
longest distance from src to vertex i.

If a vertex is unreachable from src, store Integer.MIN_VALUE for that
vertex. The driver code will automatically display Integer.MIN_VALUE
as INF.

Example 1:

Input:
V = 4
src = 0
edges = [[0, 1, 1],
         [0, 2, 1],
         [1, 2, 5],
         [3, 1, 2],
         [3, 2, -1]]

Output:
[0, 1, 6, INF]

Explanation:
The longest distance of vertex 1 from 0 is 1.
The longest distance of vertex 2 from 0 is 6.
Vertex 3 is unreachable from 0.

Example 2:

Input:
V = 5
src = 1
edges = [[0, 1, 1],
         [0, 2, 2],
         [1, 4, 4],
         [3, 2, -1],
         [4, 2, 3],
         [4, 3, 6]]

Output:
[INF, 0, 9, 10, 4]

Explanation:
Vertex 0 is unreachable from vertex 1.
The longest distance to vertex 2 is 9.
The longest distance to vertex 3 is 10.
The longest distance to vertex 4 is 4.

Constraints:
1 <= V <= 10^4
0 <= src <= V - 1
1 <= edges.size() <= V * (V - 1) / 2
0 <= edges[i][0], edges[i][1] < V
-100 <= edges[i][2] <= 100
*/

import java.util.*;

public class Longest_Path_In_A_Directed_Acyclic_Graph {

    public static int[] maxDistance(
            int V,
            int src,
            ArrayList<ArrayList<Integer>> edges) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            graph.get(u).add(new int[]{v, w});
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo.add(u);

            for (int[] edge : graph.get(u)) {
                int v = edge[0];

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);

        dist[src] = 0;

        for (int u : topo) {
            if (dist[u] == Integer.MIN_VALUE) {
                continue;
            }

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];

                dist[v] = Math.max(
                    dist[v],
                    dist[u] + w
                );
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int src = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            ArrayList<Integer> edge = new ArrayList<>();

            edge.add(sc.nextInt());
            edge.add(sc.nextInt());
            edge.add(sc.nextInt());

            edges.add(edge);
        }

        int[] result = maxDistance(V, src, edges);

        System.out.print("[");

        for (int i = 0; i < V; i++) {
            if (result[i] == Integer.MIN_VALUE) {
                System.out.print("INF");
            } else {
                System.out.print(result[i]);
            }

            if (i < V - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}