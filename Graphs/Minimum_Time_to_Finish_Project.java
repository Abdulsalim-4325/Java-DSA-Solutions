/*
 * Minimum Time to Finish Project
 * Difficulty: Medium | Accuracy: 63.98% | Submissions: 8K+ | Points: 4
 * 
 * An IT company is working on a large project consisting of n modules.
 * The given array duration[] stores the time required (in months) to complete the ith module.
 * The array dependencies[][], where dependencies[i] = [u, v], indicates that module v 
 * can be started only after module u is completed.
 * 
 * Multiple modules can be worked on simultaneously as long as all dependencies are completed.
 * Find the minimum time required to complete the entire project.
 * If the project cannot be completed due to a cyclic dependency, return -1.
 * 
 * Examples:
 * Input: duration[] = [10, 20, 30, 10, 30, 20]
 * dependencies[][] = [[5, 2], [5, 0], [4, 0], [4, 1], [2, 3], [3, 1]]
 * Output: 80
 * 
 * Input: duration[] = [5, 5, 5], dependencies[][] = [[0, 1], [1, 2], [2, 0]]
 * Output: -1
 * Explanation: There is a cycle in the dependency graph.
 * 
 * Constraints:
 * 1 <= duration.size() <= 10^5
 * 0 <= duration[i] <= 10^5
 * 0 <= m <= 2 * 10^5
 * 0 <= dependencies[i][j] < 10^5
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Minimum_Time_to_Finish_Project {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] duration1 = {10, 20, 30, 10, 30, 20};
        int[][] dependencies1 = {
            {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
        };
        System.out.println("Test Case 1: " + solver.minTime(duration1, dependencies1)); 
        // Expected: 80

        int[] duration2 = {5, 5, 5};
        int[][] dependencies2 = {
            {0, 1}, {1, 2}, {2, 0}
        };
        System.out.println("Test Case 2: " + solver.minTime(duration2, dependencies2)); 
        // Expected: -1
    }
}

class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        int[] inDegree = new int[n];
        for (int[] dep : dependencies) {
            int u = dep[0];
            int v = dep[1];
            adj[u].add(v);
            inDegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] completionTime = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                completionTime[i] = duration[i];
            }
        }
        
        int processedNodes = 0;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            processedNodes++;
            
            for (int v : adj[u]) {
                completionTime[v] = Math.max(completionTime[v], completionTime[u] + duration[v]);
                
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        if (processedNodes != n) {
            return -1;
        }
        
        int minTotalTime = 0;
        for (int i = 0; i < n; i++) {
            minTotalTime = Math.max(minTotalTime, completionTime[i]);
        }
        
        return minTotalTime;
    }
}