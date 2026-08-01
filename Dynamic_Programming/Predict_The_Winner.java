
/*
486. Predict the Winner

Two players take turns selecting a number from either the
left end or the right end of an integer array.

Player 1 starts first.

Both players play optimally.

Return true if Player 1 can obtain a score greater than or
equal to Player 2's score.

Examples:

Input:
nums = [1, 5, 2]

Output:
false

Explanation:
Player 1 cannot obtain a score greater than or equal to
Player 2's score.


Input:
nums = [1, 5, 233, 7]

Output:
true

Explanation:
Player 1 can play optimally and obtain a score greater than
Player 2's score.
*/

public class Predict_The_Winner {

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;

       
        int[][] dp = new int[n][n];

    
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

       
        for (int length = 2; length <= n; length++) {

            for (int left = 0;
                 left + length <= n;
                 left++) {

                int right = left + length - 1;

              
                int takeLeft =
                        nums[left]
                        - dp[left + 1][right];

            
                int takeRight =
                        nums[right]
                        - dp[left][right - 1];

               
                dp[left][right] =
                        Math.max(
                                takeLeft,
                                takeRight
                        );
            }
        }

       
        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {

        Predict_The_Winner solver =
                new Predict_The_Winner();

        // Test Case 1
        int[] nums1 = {1, 5, 2};

        System.out.println(
                "Input: [1, 5, 2]"
        );

        System.out.println(
                "Can Player 1 win? "
                        + solver.predictTheWinner(nums1)
        );
        // Expected: false

        System.out.println();

        // Test Case 2
        int[] nums2 = {1, 5, 233, 7};

        System.out.println(
                "Input: [1, 5, 233, 7]"
        );

        System.out.println(
                "Can Player 1 win? "
                        + solver.predictTheWinner(nums2)
        );
        // Expected: true

        System.out.println();

        // Test Case 3
        int[] nums3 = {1, 1};

        System.out.println(
                "Input: [1, 1]"
        );

        System.out.println(
                "Can Player 1 win? "
                        + solver.predictTheWinner(nums3)
        );
        // Expected: true
    }
}

