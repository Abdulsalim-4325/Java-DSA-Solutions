/*Given a binary matrix mat[][] of size n*m and an integer k, process a list of queries queries[][]. Each query contains coordinates [i, j] of the center of a square.

For every query, find the side length of the largest odd-sized square centered at cell (i, j) such that the square contains at most k ones.
 A square centered at (i, j) expands outward symmetrically in all four directions by the same number of cells, so its side length is always odd.
Note: If no odd-sized square centered at the given cell satisfies the condition of containing at most k ones, return -1 for that query.

Examples:

Input: mat[][] = [[1, 0, 1, 0, 0], [1, 0, 1, 1, 1], [1, 1, 1, 1, 1], [1, 0, 0, 1, 0]], queries[][] = [[1, 2]], k = 9
Output: [3]
Explanation: The largest odd-sized square centered at (1, 2) is the 3 × 3 square spanning rows 0 to 2 and columns 1 to 3. 
It contains 6 ones, which is at most k = 9. Hence, the answer is 3.
Input: mat[][] = [[1, 1, 1], [1, 1, 1], [1, 1, 1]], queries[][] = [[1, 1], [2, 2]], K = 9
Output: [3, 1]
Explanation: For query (1, 1), the largest valid square is the entire 3 × 3 matrix, which contains 9 ones. Hence, the answer is 3.
For query (2, 2), no expansion is possible without going outside the matrix, so only the 1 × 1 square centered at (2, 2) is valid. Hence, the answer is 1.
Constraints:
1 ≤ mat.size(), mat[0].size() ≤ 500
1 ≤ queries.size() ≤ 104
0 ≤ queries[q][0] < mat.size()
0 ≤ queries[q][1] < mat[0].size()
0 ≤ k ≤ mat.size() * mat[0].size()*/


import java.util.ArrayList;
import java.util.Arrays;

public class Largest_Odd_Squares_with_Limited_1s {

    

    static class Solution {

        ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
            int n = mat.length;
            int m = mat[0].length;

            int[][] prefix = new int[n + 1][m + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    prefix[i + 1][j + 1] =
                        mat[i][j]
                        + prefix[i][j + 1]
                        + prefix[i + 1][j]
                        - prefix[i][j];
                }
            }

            ArrayList<Integer> ans = new ArrayList<>();

            for (int[] query : queries) {
                int row = query[0];
                int col = query[1];

                int maxRadius = Math.min(
                    Math.min(row, n - 1 - row),
                    Math.min(col, m - 1 - col)
                );

                int low = 0;
                int high = maxRadius;
                int best = -1;

                while (low <= high) {
                    int mid = low + (high - low) / 2;

                    int top = row - mid;
                    int bottom = row + mid;
                    int left = col - mid;
                    int right = col + mid;

                    int ones = prefix[bottom + 1][right + 1]
                             - prefix[top][right + 1]
                             - prefix[bottom + 1][left]
                             + prefix[top][left];

                    if (ones <= k) {
                        best = 2 * mid + 1;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                ans.add(best);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] mat = {
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
        };

        int[][] queries = {
            {1, 2}
        };

        int k = 9;

        System.out.println(solution.largestSquare(mat, queries, k));
    }
}