/*
 * Party in Town
 * Difficulty: Medium | Accuracy: 54.0% | Submissions: 10K+ | Points: 4
 * 
 * Geek Town has n houses numbered from 1 to n, choose a house to host a party such that 
 * its distance from its farthest house is as small as possible. Return this minimum possible distance.
 * 
 * The houses are connected by n - 1 bidirectional roads, forming a tree. 
 * The connections are given as an adjacency list adj, where adj[i] contains all houses 
 * directly connected to house i + 1. 
 * 
 * Examples:
 * 
 * Input: adj[][] = [[2], [1, 4, 3], [2], [2]] 
 * Output: 1
 * 
 * Input: adj[][] = [[2], [1, 3], [4, 2], [3]]
 * Output: 2
 * 
 * Constraints:
 * 1 <= n <= 10^5
 * 1 <= adj[i][j] <= n
 * adj.size() = n
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Party_in_Town {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // Construct Test Case 1: [[2], [1, 4, 3], [2], [2]]
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        adj1.add(new ArrayList<>(Arrays.asList(2)));
        adj1.add(new ArrayList<>(Arrays.asList(1, 4, 3)));
        adj1.add(new ArrayList<>(Arrays.asList(2)));
        adj1.add(new ArrayList<>(Arrays.asList(2)));
        System.out.println("Test Case 1: " + solver.partyHouse(adj1)); // Expected: 1

        // Construct Test Case 2: [[2], [1, 3], [4, 2], [3]]
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        adj2.add(new ArrayList<>(Arrays.asList(2)));
        adj2.add(new ArrayList<>(Arrays.asList(1, 3)));
        adj2.add(new ArrayList<>(Arrays.asList(4, 2)));
        adj2.add(new ArrayList<>(Arrays.asList(3)));
        System.out.println("Test Case 2: " + solver.partyHouse(adj2)); // Expected: 2
    }
}

class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        if (n <= 1) return 0;

        int[] first = bfs(adj, 1);
        int farthestNode = first[0];

        int[] second = bfs(adj, farthestNode);
        int diameter = second[1];

        return (diameter + 1) / 2;
    }

    private int[] bfs(ArrayList<ArrayList<Integer>> adj, int start) {
        int n = adj.size();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        int farthestNode = start;
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : adj.get(current - 1)) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;

                    queue.offer(next);

                    if (distance[next] > maxDistance) {
                        maxDistance = distance[next];
                        farthestNode = next;
                    }
                }
            }
        }

        return new int[]{farthestNode, maxDistance};
    }
}