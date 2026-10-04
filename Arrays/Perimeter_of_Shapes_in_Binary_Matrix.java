/*
 * Perimeter of Shapes in Binary Matrix
 * Difficulty: Easy | Accuracy: 74.94% | Submissions: 5K+ | Points: 2
 * 
 * Given a binary matrix mat[][] of size n x m, where each cell contains 
 * either 0 or 1, find the total perimeter of all figures formed by cells 
 * containing 1s. Two cells are considered adjacent if they share a common side.
 * 
 * A single cell containing 1 has a perimeter of 4, whereas two adjacent cells 
 * containing 1 together have a perimeter of 6.
 * 
 * Example 1:
 * Input: mat[][] = [[0,1,0,0,0], [1,1,1,0,0], [1,0,0,0,0]]
 * Output: 12
 * 
 * Example 2:
 * Input: mat[][] = [[1,0], [1,1]]
 * Output: 8
 * 
 * Constraints:
 * 1 <= n, m <= 1000
 */

public class Perimeter_of_Shapes_in_Binary_Matrix {
    public static void main(String[] args) {
        int[][] mat1 = {
            {0, 1, 0, 0, 0}, 
            {1, 1, 1, 0, 0}, 
            {1, 0, 0, 0, 0}
        };
        System.out.println("Test Case 1: " + Solution.findPerimeter(mat1)); 
        // Expected: 12

        int[][] mat2 = {
            {1, 0}, 
            {1, 1}
        };
        System.out.println("Test Case 2: " + Solution.findPerimeter(mat2)); 
        // Expected: 8
    }
}

class Solution {
    static int findPerimeter(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int perimeter = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    perimeter += 4;
                    
                    if (i > 0 && mat[i - 1][j] == 1) {
                        perimeter -= 2;
                    }
                    
                    if (j > 0 && mat[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        
        return perimeter;
    }
}