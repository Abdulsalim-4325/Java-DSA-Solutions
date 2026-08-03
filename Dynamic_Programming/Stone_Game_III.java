
/*
1406. Stone Game III

Alice and Bob take turns taking 1, 2, or 3 stones
from the beginning of the remaining array.

Each stone has an integer value, which may be positive,
negative, or zero.

Both players play optimally.

Return:

"Alice" if Alice wins
"Bob"   if Bob wins
"Tie"   if both players have the same score


Examples:

Input:
stoneValue = [1, 2, 3, 7]

Output:
"Bob"


Input:
stoneValue = [1, 2, 3, -9]

Output:
"Alice"


Input:
stoneValue = [1, 2, 3, 6]

Output:
"Tie"
*/

public class Stone_Game_III {

    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;

       
        int[] dp = new int[n + 1];

       

        
        for (int i = n - 1; i >= 0; i--) {

            int currentSum = 0;

            
            dp[i] = Integer.MIN_VALUE;

           
            for (int stonesTaken = 1;
                 stonesTaken <= 3
                 && i + stonesTaken <= n;
                 stonesTaken++) {

                
                currentSum +=
                        stoneValue[
                                i + stonesTaken - 1
                        ];

                
                int scoreDifference =
                        currentSum
                        - dp[i + stonesTaken];

                
                dp[i] = Math.max(
                        dp[i],
                        scoreDifference
                );
            }
        }

       
        if (dp[0] > 0) {
            return "Alice";
        }

        if (dp[0] < 0) {
            return "Bob";
        }

        return "Tie";
    }

    public static void main(String[] args) {

        Stone_Game_III solver =
                new Stone_Game_III();

        // Test Case 1
        int[] stones1 = {1, 2, 3, 7};

        System.out.println(
                "Input: [1, 2, 3, 7]"
        );

        System.out.println(
                "Winner: "
                        + solver.stoneGameIII(stones1)
        );
        // Expected: Bob

        System.out.println();

        // Test Case 2
        int[] stones2 = {1, 2, 3, -9};

        System.out.println(
                "Input: [1, 2, 3, -9]"
        );

        System.out.println(
                "Winner: "
                        + solver.stoneGameIII(stones2)
        );
        // Expected: Alice

        System.out.println();

        // Test Case 3
        int[] stones3 = {1, 2, 3, 6};

        System.out.println(
                "Input: [1, 2, 3, 6]"
        );

        System.out.println(
                "Winner: "
                        + solver.stoneGameIII(stones3)
        );
        // Expected: Tie
    }
}

