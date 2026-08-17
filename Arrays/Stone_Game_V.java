/*
1563. Stone Game V

There are several stones arranged in a row, and each stone has an associated
value which is an integer given in the array stoneValue.

In each round of the game, Alice divides the row into two non-empty rows
(i.e. left row and right row), then Bob calculates the value of each row
which is the sum of the values of all the stones in this row.

Bob throws away the row which has the maximum value, and Alice's score
increases by the value of the remaining row.

If the value of the two rows are equal, Bob lets Alice decide which row
will be thrown away.

The next round starts with the remaining row.

The game ends when there is only one stone remaining.

Alice's score is initially zero.

Return the maximum score that Alice can obtain.

Example 1:

Input:
stoneValue = [6,2,3,4,5,5]

Output:
18

Explanation:
Alice divides the row into [6,2,3] and [4,5,5].
The left row has value 11 and the right row has value 14.
Bob throws away the right row and Alice gains 11.

Alice then divides [6,2,3] into [6] and [2,3].
Bob throws away [6] and Alice gains 5.

Finally, Alice divides [2,3] into [2] and [3].
Bob throws away [3] and Alice gains 2.

Total score = 11 + 5 + 2 = 18.

Example 2:

Input:
stoneValue = [7,7,7,7,7,7,7]

Output:
28

Example 3:

Input:
stoneValue = [4]

Output:
0

Constraints:

1 <= stoneValue.length <= 500
1 <= stoneValue[i] <= 10^6
*/

import java.util.*;

public class Stone_Game_V {

    public static int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int left = 0; left + len <= n; left++) {
                int right = left + len - 1;

                for (int mid = left; mid < right; mid++) {
                    int leftSum = prefix[mid + 1] - prefix[left];
                    int rightSum = prefix[right + 1] - prefix[mid + 1];

                    if (leftSum < rightSum) {
                        dp[left][right] = Math.max(
                            dp[left][right],
                            leftSum + dp[left][mid]
                        );
                    } else if (leftSum > rightSum) {
                        dp[left][right] = Math.max(
                            dp[left][right],
                            rightSum + dp[mid + 1][right]
                        );
                    } else {
                        dp[left][right] = Math.max(
                            dp[left][right],
                            leftSum + Math.max(
                                dp[left][mid],
                                dp[mid + 1][right]
                            )
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] stoneValue = new int[n];

        for (int i = 0; i < n; i++) {
            stoneValue[i] = sc.nextInt();
        }

        System.out.println(stoneGameV(stoneValue));

        sc.close();
    }
}