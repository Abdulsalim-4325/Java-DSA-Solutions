/*
 * Shortest Safe Route in Grid
 * Difficulty: Medium | Accuracy: 50.58% | Submissions: 48K+ | Points: 4
 * 
 * Given a 2D matrix mat[][] of size n x m, where each cell is either 0 (landmine) or 1 (safe), 
 * find the minimum number of steps required to travel from any cell in the leftmost column 
 * to any cell in the rightmost column.
 * You can move only in four directions: up, down, left, and right.
 * A cell is unsafe if it contains a landmine or is directly adjacent to a landmine, 
 * and such cells must be avoided. Return -1 if no safe path exists.
 * 
 * Examples:
 * Input: mat[][] = [
 *   [1, 0, 1, 1, 1], 
 *   [1, 1, 1, 1, 1], 
 *   [1, 1, 1, 1, 1], 
 *   [1, 1, 1, 0, 1], 
 *   [1, 1, 1, 1, 0]
 * ]
 * Output: 6
 * 
 * Input: mat[][] = [
 *   [1, 1, 1, 1, 1], 
 *   [1, 1, 0, 1, 1], 
 *   [1, 1, 1, 1, 1]
 * ]
 * Output: -1
 * 
 * Constraints:
 * 1 <= n, m <= 10^3
 * 0 <= mat[i][j] <= 1
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Shortest_Safe_Route_in_Grid {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[][] mat1 = {
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {1, 1, 1, 1, 0}
        };
        System.out.println("Test Case 1: " + solver.shortestPath(mat1)); // Expected: 6

        int[][] mat2 = {
            {1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1}
        };
        System.out.println("Test Case 2: " + solver.shortestPath(mat2)); // Expected: -1
    }
}

class Solution {
    public int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        if (n == 0 || m == 0) return -1;
        
        boolean[][] visited = new boolean[n][m];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dr[k];
                        int nj = j + dc[k];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            visited[ni][nj] = true;
                        }
                    }
                }
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i][0]) {
                queue.offer(new int[]{i, 0, 1}); 
                visited[i][0] = true;
            }
        }
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            
            if (c == m - 1) {
                return dist;
            }
            
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }
        
        return -1;
    }
}