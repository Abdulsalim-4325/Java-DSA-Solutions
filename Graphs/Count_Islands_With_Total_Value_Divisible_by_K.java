/*
 * Problem: 3619. Count Islands With Total Value Divisible by K (LeetCode - Medium)
 * 
 * You are given an m x n matrix grid and a positive integer k. An island is a 
 * group of positive integers (representing land) that are 4-directionally 
 * connected (horizontally or vertically).
 * 
 * The total value of an island is the sum of the values of all cells in the island.
 * Return the number of islands with a total value divisible by k.
 * 
 * Example 1:
 * Input: grid = [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], k = 5
 * Output: 2
 * Explanation: Islands adding up to multiples of 5 are highlighted in the solution.
 * 
 * Example 2:
 * Input: grid = [[3,0,3,0], [0,3,0,3], [3,0,3,0]], k = 3
 * Output: 6
 * 
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 10^5
 * 0 <= grid[i][j] <= 10^6
 * 1 <= k <= 10^6
 * 
 * Approach:
 * Iterate over the grid. When positive land is detected, run BFS to traverse 
 * the entire island. Mark visited cells as 0 natively inside the grid to save memory. 
 * Use a 'long' sum tracker to prevent overflow, then modulo evaluate against k.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N) BFS queue constraint
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Count_Islands_With_Total_Value_Divisible_by_K {

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = 0;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j});
                    
                    sum += grid[i][j];
                    grid[i][j] = 0;
                    
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int r = curr[0];
                        int c = curr[1];
                        
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0) {
                                sum += grid[nr][nc];
                                grid[nr][nc] = 0; 
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Count_Islands_With_Total_Value_Divisible_by_K solution = 
                new Count_Islands_With_Total_Value_Divisible_by_K();

        int[][] grid1 = {
            {0, 2, 1, 0, 0},
            {0, 5, 0, 0, 5},
            {0, 0, 1, 0, 0},
            {0, 1, 4, 7, 0},
            {0, 2, 0, 0, 8}
        };
        System.out.println(solution.countIslands(grid1, 5)); // Expected: 2

        int[][] grid2 = {
            {3, 0, 3, 0},
            {0, 3, 0, 3},
            {3, 0, 3, 0}
        };
        System.out.println(solution.countIslands(grid2, 3)); // Expected: 6
    }
}