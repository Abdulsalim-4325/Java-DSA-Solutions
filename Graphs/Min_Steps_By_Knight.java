/*
 * Min Steps by Knight
 * Difficulty: Medium | Accuracy: 37.32% | Submissions: 142K+ | Points: 4
 * 
 * Given a square chessboard of size n x n, the initial position knightPos 
 * and target position targetPos of a Knight are given. Find the minimum 
 * number of moves required for the Knight to reach targetPos.
 * 
 * A Knight moves in an L-shape, covering 2 cells in one direction and 1 cell 
 * perpendicular to it. From (x, y), it can move to 8 possible coordinates.
 * Note: The positions are given using 1-based indexing.
 * 
 * Examples:
 * Input: n = 6, knightPos[] = [1, 3], targetPos[] = [5, 1]
 * Output: 2
 * Explanation: (1, 3) -> (3, 2) -> (5, 1)
 * 
 * Constraints:
 * n <= 1000
 * 2 <= knightPos.size(), targetPos.size() <= 2
 * 1 <= knightPos[i], targetPos[i] <= n
 */

import java.util.LinkedList;
import java.util.Queue;

public class Min_Steps_By_Knight {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int n1 = 3;
        int[] knightPos1 = {3, 3};
        int[] targetPos1 = {1, 2};
        System.out.println("Test Case 1: " + solver.minStepToReachTarget(knightPos1, targetPos1, n1)); 
        // Expected: 1

        int n2 = 6;
        int[] knightPos2 = {1, 3};
        int[] targetPos2 = {5, 1};
        System.out.println("Test Case 2: " + solver.minStepToReachTarget(knightPos2, targetPos2, n2)); 
        // Expected: 2
    }
}

class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        if (knightPos[0] == targetPos[0] && knightPos[1] == targetPos[1]) {
            return 0;
        }
        
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        
        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{knightPos[0], knightPos[1], 0});
        visited[knightPos[0]][knightPos[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];
            
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !visited[nx][ny]) {
                    if (nx == targetPos[0] && ny == targetPos[1]) {
                        return steps + 1;
                    }
                    
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, steps + 1});
                }
            }
        }
        
        return -1;
    }
}