/*
Maximum Sum of K x K Sub-Grid

Given an n × n grid containing positive and negative integers,
find the maximum sum among all possible k × k sub-grids.

Examples:

Input:
k = 3
mat = [
    [1, 2, -1, 4],
    [-8, -3, 4, 2],
    [3, 8, 10, -8],
    [-4, -1, 1, 7]
]

Output:
20

Input:
k = 1
mat = [[4]]

Output:
4
*/

public class Maximum_Sum_Of_K_X_K_Sub_Grid {

    public int maximumSum(int[][] mat, int k) {

        int n = mat.length;

        // Prefix Sum Matrix
        int[][] prefix = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;

        // Compute every k × k sub-grid sum
        for (int i = k; i <= n; i++) {

            for (int j = k; j <= n; j++) {

                int currentSum = prefix[i][j]
                        - prefix[i - k][j]
                        - prefix[i][j - k]
                        + prefix[i - k][j - k];

                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Maximum_Sum_Of_K_X_K_Sub_Grid solver =
                new Maximum_Sum_Of_K_X_K_Sub_Grid();

        // Test Case 1
        int[][] mat1 = {
                {1, 2, -1, 4},
                {-8, -3, 4, 2},
                {3, 8, 10, -8},
                {-4, -1, 1, 7}
        };

        System.out.println("Test Case 1:");
        System.out.println(solver.maximumSum(mat1, 3)); // Expected: 20
        System.out.println();

        // Test Case 2
        int[][] mat2 = {
                {4}
        };

        System.out.println("Test Case 2:");
        System.out.println(solver.maximumSum(mat2, 1)); // Expected: 4
        System.out.println();

        // Test Case 3
        int[][] mat3 = {
                {1, 2},
                {3, 4}
        };

        System.out.println("Test Case 3:");
        System.out.println(solver.maximumSum(mat3, 2)); // Expected: 10
    }
}