/*
 * Largest Subsquare Surrounded by X
 * Difficulty: Medium | Accuracy: 50.31% | Submissions: 41K+ | Points: 4
 * 
 * Given a square matrix mat[][] of size n x n, where each cell contains either 'X' or 'O'. 
 * Find the size of the largest square submatrix whose boundary is completely surrounded by 'X'. 
 * The cells inside the submatrix can contain either 'X' or 'O'. Only the four sides of the 
 * submatrix must contain 'X'.
 * Return side length of the largest such square submatrix.
 * 
 * Note: A square of size 1 is valid if its only cell is 'X'. 
 * If no such square submatrix exists, return 0.
 * 
 * Examples:
 * Input: mat[][] = [
 *   ['X','X','X','O'],
 *   ['X','O','X','X'],
 *   ['X','X','X','O'],
 *   ['X','O','X','X']
 * ]
 * Output: 3
 * 
 * Input: mat[][] = [
 *   ['X','X'],
 *   ['X','X']
 * ]
 * Output: 2
 * 
 * Constraints:
 * 1 <= n, mat.size(), mat[i].size() <= 1000
 */

public class Largest_Subsquare_Surrounded_by_X {
    public static void main(String[] args) {
        Solution solver = new Solution();

        char[][] mat1 = {
            {'X', 'X', 'X', 'O'},
            {'X', 'O', 'X', 'X'},
            {'X', 'X', 'X', 'O'},
            {'X', 'O', 'X', 'X'}
        };
        System.out.println("Test Case 1: " + solver.largestSubsquare(mat1)); // Expected: 3

        char[][] mat2 = {
            {'X', 'X'},
            {'X', 'X'}
        };
        System.out.println("Test Case 2: " + solver.largestSubsquare(mat2)); // Expected: 2

        char[][] mat3 = {
            {'O', 'O', 'O'},
            {'O', 'O', 'O'},
            {'O', 'O', 'O'}
        };
        System.out.println("Test Case 3: " + solver.largestSubsquare(mat3)); // Expected: 0
    }
}

class Solution {
    public int largestSubsquare(char mat[][]) {
        int n = mat.length;
        if (n == 0) return 0;
        
        int[][] top = new int[n][n];
        int[][] left = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'X') {
                    top[i][j] = (i == 0) ? 1 : top[i - 1][j] + 1;
                    left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
                }
            }
        }

        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int len = Math.min(top[i][j], left[i][j]);

                while (len > maxSize) {
                    if (top[i][j - len + 1] >= len && left[i - len + 1][j] >= len) {
                        maxSize = len;
                        break; 
                    }
                    len--;
                }
            }
        }

        return maxSize;
    }
}