/*
 * Longest Increasing Path in Matrix
 * Difficulty: Hard | Accuracy: 44.5% | Submissions: 20K+ | Points: 8
 * 
 * Given a matrix with n rows and m columns. Find the length of the longest path 
 * with the following constraints:
 * - The values in path must be strictly increasing.
 * - No cell should be revisited in the path.
 * - From each cell, you can move left, right, up, or down.
 * - You are not allowed to move diagonally or move outside the boundary.
 * 
 * Example 1:
 * Input: n = 3, m = 3, matrix[][] = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
 * Output: 5
 * Explanation: One such path is 1 -> 2 -> 3 -> 6 -> 9.
 * 
 * Example 2:
 * Input: n = 3, m = 3, matrix[][] = [[3, 4, 5], [6, 2, 6], [2, 2, 1]]
 * Output: 4
 * Explanation: 3 -> 4 -> 5 -> 6.
 * 
 * Constraints:
 * 1 <= n, m <= 1000
 * 0 <= matrix[i][j] <= 2^30
 */

public class Longest_Increasing_Path_in_Matrix {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int n1 = 3, m1 = 3;
        int[][] matrix1 = {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}
        };
        System.out.println("Test Case 1: " + solver.longIncPath(matrix1, n1, m1)); 
        // Expected: 5

        int n2 = 3, m2 = 3;
        int[][] matrix2 = {
            {3, 4, 5}, 
            {6, 2, 6}, 
            {2, 2, 1}
        };
        System.out.println("Test Case 2: " + solver.longIncPath(matrix2, n2, m2)); 
        // Expected: 4
    }
}

class Solution {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longIncPath(int[][] matrix, int n, int m) {
        if (matrix == null || n == 0 || m == 0) return 0;
        
        int[][] memo = new int[n][m];
        int maxPath = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, n, m, memo));
            }
        }
        
        return maxPath;
    }
    
    private int dfs(int[][] matrix, int r, int c, int n, int m, int[][] memo) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        
        int max = 1; 
        
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] > matrix[r][c]) {
                max = Math.max(max, 1 + dfs(matrix, nr, nc, n, m, memo));
            }
        }
        
        memo[r][c] = max;
        return max;
    }
}