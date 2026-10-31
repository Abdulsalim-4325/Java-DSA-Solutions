/*
 * Problem: 3665. Twisted Mirror Path Count (LeetCode - Medium)
 * 
 * Given an m x n binary grid where 0 represents an empty cell and 1 represents a mirror.
 * A robot starts at (0, 0) and wants to reach (m - 1, n - 1), moving only right or down.
 * If the robot attempts to move into a mirror cell, it is reflected before entering:
 * - Moving right into a mirror turns it down.
 * - Moving down into a mirror turns it right.
 * If a reflection causes it to move out of bounds, it is invalid.
 * 
 * Return the number of unique valid paths modulo 10^9 + 7.
 * 
 * Approach:
 * Deconstruct mirror paths leveraging topological Dynamic Programming maps. Maintain 
 * states segregating horizontal momentum (rightPaths) from vertical momentum (downPaths). 
 * Traverse row-major, mapping standard branching bounds natively at empty cells and 
 * forcefully pushing deflecting momentum diagonally at mirrors.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N)
 */

public class Twisted_Mirror_Path_Count {

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1000000007;

        int[][] rightPaths = new int[m][n];
        int[][] downPaths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ways = 0;
                
                if (i == 0 && j == 0) {
                    ways = 1;
                } else if (grid[i][j] == 0) {
                    ways = (rightPaths[i][j] + downPaths[i][j]) % MOD;
                }

                if (i == m - 1 && j == n - 1) {
                    return ways;
                }

                if (grid[i][j] == 0) {
                    if (j + 1 < n) {
                        rightPaths[i][j + 1] = (rightPaths[i][j + 1] + ways) % MOD;
                    }
                    if (i + 1 < m) {
                        downPaths[i + 1][j] = (downPaths[i + 1][j] + ways) % MOD;
                    }
                } else {
                    if (i + 1 < m) {
                        downPaths[i + 1][j] = (downPaths[i + 1][j] + rightPaths[i][j]) % MOD;
                    }
                    if (j + 1 < n) {
                        rightPaths[i][j + 1] = (rightPaths[i][j + 1] + downPaths[i][j]) % MOD;
                    }
                }
            }
        }
        
        return 0;
    }

    public static void main(String[] args) {
        Twisted_Mirror_Path_Count solution = new Twisted_Mirror_Path_Count();

        int[][] grid1 = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 0, 0}
        };
        System.out.println(solution.uniquePaths(grid1)); // Expected: 5

        int[][] grid2 = {
            {0, 0},
            {0, 0}
        };
        System.out.println(solution.uniquePaths(grid2)); // Expected: 2

        int[][] grid3 = {
            {0, 1, 1},
            {1, 1, 0}
        };
        System.out.println(solution.uniquePaths(grid3)); // Expected: 1
    }
}