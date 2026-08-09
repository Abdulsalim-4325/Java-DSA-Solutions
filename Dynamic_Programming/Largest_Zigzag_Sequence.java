
/*
Largest Zigzag Sequence

Given a square matrix mat[][] of size n x n. A zigzag sequence starts
from the top and ends at the bottom. Two consecutive elements of the
sequence cannot belong to the same column.

Return the maximum sum of such a zigzag sequence.

Examples:

Input:
mat[][] = [[3, 1, 2],
           [4, 8, 5],
           [6, 9, 7]]

Output:
18

Explanation:
One optimal zigzag sequence is:
3 -> 8 -> 7

The sum is:
3 + 8 + 7 = 18.

Example 2:

Input:
mat[][] = [[1, 2, 4],
           [3, 9, 6],
           [11, 3, 15]]

Output:
28

Explanation:
One optimal zigzag sequence is:
4 -> 9 -> 15

The sum is:
4 + 9 + 15 = 28.

Constraints:

1 <= n <= 100
1 <= mat[i][j] <= 1000
*/

public class Largest_Zigzag_Sequence {

    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            int max1 = -1;
            int max2 = -1;
            int index = -1;

            for (int j = 0; j < n; j++) {
                if (dp[j] > max1) {
                    max2 = max1;
                    max1 = dp[j];
                    index = j;
                } else if (dp[j] > max2) {
                    max2 = dp[j];
                }
            }

            int[] next = new int[n];

            for (int j = 0; j < n; j++) {
                int bestPrevious = (j == index) ? max2 : max1;
                next[j] = mat[i][j] + bestPrevious;
            }

            dp = next;
        }

        int answer = 0;

        for (int value : dp) {
            answer = Math.max(answer, value);
        }

        return answer;
    }

    public static void main(String[] args) {
        Largest_Zigzag_Sequence solver =
                new Largest_Zigzag_Sequence();

        int[][] mat1 = {
            {3, 1, 2},
            {4, 8, 5},
            {6, 9, 7}
        };

        System.out.println("Test Case 1:");
        System.out.println("Output: " + solver.zigzagSequence(mat1));
        System.out.println("Expected: 18");
        System.out.println();

        int[][] mat2 = {
            {1, 2, 4},
            {3, 9, 6},
            {11, 3, 15}
        };

        System.out.println("Test Case 2:");
        System.out.println("Output: " + solver.zigzagSequence(mat2));
        System.out.println("Expected: 28");
    }
}
