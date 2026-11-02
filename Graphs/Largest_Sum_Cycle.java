/*
 * Problem: Largest Sum Cycle (GeeksforGeeks - Hard)
 * 
 * Given an array edge[] of size n, there are n cells numbered from 0 to n - 1. 
 * Each cell has at most one outgoing edge.
 * edge[i] is the cell reached from i in one step. edge[i] = -1 means no outgoing edge.
 * A cycle is a sequence of cells where, by following the outgoing edges, we eventually 
 * return to the starting cell. 
 * 
 * Return the maximum cycle sum (sum of the indices of all cells in that cycle). 
 * If there is no cycle, return -1.
 * 
 * Constraints:
 * 2 <= edge.size() <= 10^5
 * -1 <= edge[i] < edge.size()
 * edge[i] != i
 * 
 * Approach:
 * Functional Graph Traversal with State Tracking. Use a 3-state visited array:
 * 0: Unvisited, 1: Currently Visiting, 2: Fully Processed. 
 * Resolves isolated cycles using purely iterative loops avoiding recursion depth faults.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

public class Largest_Sum_Cycle {

    public int largestSumCycle(int[] edge) {
        int n = edge.length;
        int[] visited = new int[n];
        long maxSum = -1; 

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                int curr = i;
                
                while (curr != -1 && visited[curr] == 0) {
                    visited[curr] = 1;
                    curr = edge[curr];
                }
                
                if (curr != -1 && visited[curr] == 1) {
                    long currentSum = 0;
                    int temp = curr;
                    
                    do {
                        currentSum += temp;
                        temp = edge[temp];
                    } while (temp != curr);
                    
                    maxSum = Math.max(maxSum, currentSum);
                }
                
                curr = i;
                while (curr != -1 && visited[curr] == 1) {
                    visited[curr] = 2;
                    curr = edge[curr];
                }
            }
        }
        
        return (int) maxSum; 
    }

    public static void main(String[] args) {
        Largest_Sum_Cycle solution = new Largest_Sum_Cycle();

        int[] edge1 = {1, 2, 0, -1};
        System.out.println(solution.largestSumCycle(edge1)); // Expected: 3

        int[] edge2 = {2, 0, -1, 2};
        System.out.println(solution.largestSumCycle(edge2)); // Expected: -1
    }
}