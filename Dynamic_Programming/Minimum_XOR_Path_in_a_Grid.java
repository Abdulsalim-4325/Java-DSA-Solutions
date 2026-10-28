/*
 * Problem: 3882. Minimum XOR Path in a Grid (LeetCode - Medium)
 * 
 * You are given a 2D integer array grid of size m * n.
 * You start at the top-left cell (0, 0) and want to reach the bottom-right cell (m - 1, n - 1).
 * At each step, you may move either right or down.
 * The cost of a path is defined as the bitwise XOR of all the values in the cells 
 * along that path, including the start and end cells.
 * 
 * Return the minimum possible XOR value among all valid paths from (0, 0) to (m - 1, n - 1).
 * 
 * Constraints:
 * - 1 <= m == grid.length <= 1000
 * - 1 <= n == grid[i].length <= 1000
 * - m * n <= 1000
 * - 0 <= grid[i][j] <= 1023
 * 
 * Approach:
 * Using a 3D boolean DP array to track all achievable XOR states for every cell. 
 * Since maximum possible XOR is 1023, the 3rd dimension is bounded at 1024.
 * 
 * Time Complexity: O(m * n * 1024)
 * Space Complexity: O(m * n * 1024)
 */

public class Minimum_XOR_Path_in_a_Grid {

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] dp = new boolean[m][n][1024];
        dp[0]0[0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int val = grid[i][j];

                if (i > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (dp[i - 1][j][x]) {
                            dp[i][j][x ^ val] = true;
                        }
                    }
                }

                if (j > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (dp[i][j - 1][x]) {
                            dp[i][j][x ^ val] = true;
                        }
                    }
                }
            }
        }

        for (int x = 0; x < 1024; x++) {
            if (dp[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Minimum_XOR_Path_in_a_Grid solution = new Minimum_XOR_Path_in_a_Grid();

        int[][] grid1 = {
            {1, 2},
            {3, 4}
        };
        System.out.println(solution.minCost(grid1)); // Expected: 6

        int[][] grid2 = {
            {6, 7},
            {5, 8}
        };
        System.out.println(solution.minCost(grid2)); // Expected: 9

        int[][] grid3 = {
            {2, 7, 5}
        };
        System.out.println(solution.minCost(grid3)); // Expected: 0
    }
}