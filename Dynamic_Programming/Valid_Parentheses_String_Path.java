/*
 * LeetCode 2267. Check if There Is a Valid Parentheses String Path
 * Hard
 * 
 * A parentheses string is valid if it is empty, written as AB, or (A) where A and B are valid.
 * You are given an m x n matrix of parentheses grid. A valid parentheses string path in the 
 * grid is a path satisfying all of the following conditions:
 * - The path starts from the upper left cell (0, 0).
 * - The path ends at the bottom-right cell (m - 1, n - 1).
 * - The path only ever moves down or right.
 * - The resulting parentheses string formed by the path is valid.
 * 
 * Return true if there exists a valid parentheses string path in the grid. Otherwise, return false.
 * 
 * Example 1:
 * Input: grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
 * Output: true
 * Explanation: Two possible paths result in valid parentheses strings "()(())" and "((()))".
 * 
 * Example 2:
 * Input: grid = [[")",")"],["(","("]]
 * Output: false
 * Explanation: The two possible paths form "))(" and ")((". Neither are valid.
 * 
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] is either '(' or ')'.
 */

public class Valid_Parentheses_String_Path {
    public static void main(String[] args) {
        Solution solver = new Solution();

        char[][] grid1 = {
            {'(', '(', '('},
            {')', '(', ')'},
            {'(', '(', ')'},
            {'(', '(', ')'}
        };
        System.out.println("Test Case 1: " + solver.hasValidPath(grid1)); 
        // Expected: true

        char[][] grid2 = {
            {')', ')'},
            {'(', '('}
        };
        System.out.println("Test Case 2: " + solver.hasValidPath(grid2)); 
        // Expected: false
    }
}

class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        
        boolean[][][] visited = new boolean[m][n][m + n];
        
        return dfs(grid, 0, 0, 0, visited, m, n);
    }
    
    private boolean dfs(char[][] grid, int r, int c, int balance, boolean[][][] visited, int m, int n) {
        if (r >= m || c >= n) return false;
        
        balance += (grid[r][c] == '(' ? 1 : -1);
        if (balance < 0) return false;
        
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }
        
        if (visited[r][c][balance]) return false;
        visited[r][c][balance] = true; 
        
        if (dfs(grid, r + 1, c, balance, visited, m, n)) return true;
        if (dfs(grid, r, c + 1, balance, visited, m, n)) return true;
        
        return false;
    }
}