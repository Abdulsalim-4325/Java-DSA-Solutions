/*
 * Problem: 3963. Create Grid With Exactly One Path (LeetCode - Easy)
 * 
 * You are given two integers m and n, representing the number of rows and columns 
 * of a grid. Construct any m x n grid consisting only of the characters '.' and '#', 
 * where:
 * - '.' represents a free cell.
 * - '#' represents an obstacle cell.
 * 
 * A valid path is a sequence of free cells that:
 * - Starts at the top-left cell (0, 0).
 * - Ends at the bottom-right cell (m - 1, n - 1).
 * - Moves only Right or Down.
 * 
 * Return any grid such that there is exactly one valid path.
 * 
 * Approach:
 * Construct an L-shaped path. Fill the top row (row 0) and the rightmost column 
 * (col n-1) with '.' to form the path. Fill everything else with '#'. This strictly 
 * blocks any early downward movement, forcing exactly one route.
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N)
 */

import java.util.Arrays;

public class Create_Grid_With_Exactly_One_Path {

    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    sb.append('.');
                } else {
                    sb.append('#');
                }
            }
            grid[i] = sb.toString();
        }
        
        return grid;
    }

    public static void main(String[] args) {
        Create_Grid_With_Exactly_One_Path solution = new Create_Grid_With_Exactly_One_Path();

        // Example 1
        String[] grid1 = solution.createGrid(2, 3);
        System.out.println(Arrays.toString(grid1));
        // Expected equivalent output with exactly 1 path. (e.g., ["...", "##."])

        // Example 2
        String[] grid2 = solution.createGrid(3, 3);
        System.out.println(Arrays.toString(grid2));
        // Expected equivalent output with exactly 1 path. (e.g., ["...", "##.", "##."])
    }
}