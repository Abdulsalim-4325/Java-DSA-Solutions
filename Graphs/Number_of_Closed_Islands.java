/*
 * Problem: 1254. Number of Closed Islands (LeetCode - Medium)
 * 
 * Given a 2D grid consists of 0s (land) and 1s (water). An island is a maximal 
 * 4-directionally connected group of 0s and a closed island is an island totally 
 * (all left, top, right, bottom) surrounded by 1s.
 * Return the number of closed islands.
 * 
 * Example 1:
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation: Islands in gray are closed because they are completely surrounded by water.
 * 
 * Example 2:
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * 
 * Constraints:
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 * 
 * Approach:
 * Eliminate boundary-connected islands first using DFS. Then count remaining 
 * isolated islands in the interior of the grid using a second DFS pass.
 * 
 * Time Complexity: O(R * C)
 * Space Complexity: O(R * C) recursive stack space
 */

public class Number_of_Closed_Islands {

    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int closedIslands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r == 0 || c == 0 || r == rows - 1 || c == cols - 1) && grid[r][c] == 0) {
                    dfs(grid, r, c);
                }
            }
        }

        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r][c] == 0) {
                    dfs(grid, r, c);
                    closedIslands++;
                }
            }
        }

        return closedIslands;
    }

    private void dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 1) {
            return;
        }

        grid[r][c] = 1;

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        Number_of_Closed_Islands solution = new Number_of_Closed_Islands();

        int[][] grid1 = {
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(solution.closedIsland(grid1)); // Expected: 2

        int[][] grid2 = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0}
        };
        System.out.println(solution.closedIsland(grid2)); // Expected: 1
    }
}