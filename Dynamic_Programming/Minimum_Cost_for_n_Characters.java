/*
Problem: Minimum Cost for n Characters

Given an empty screen, find the minimum cost to obtain exactly n characters.

Operations:
1. Insert one character: cost i
2. Delete the last character: cost d
3. Copy the entire current string and paste it immediately: cost c
   This doubles the current string length.

Approach:
Dynamic Programming:
dp[len] = minimum cost to obtain exactly len characters.

Transitions:
- Insert one character:
  dp[len] = dp[len - 1] + insertCost

- For even length:
  Copy-paste from len / 2 characters:
  dp[len] = min(dp[len], dp[len / 2] + copyCost)

- For odd length:
  Copy-paste from (len + 1) / 2 characters to get len + 1,
  then delete one character:
  dp[len] = min(dp[len], dp[(len + 1) / 2] + copyCost + deleteCost)

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class Minimum_Cost_for_n_Characters {

    public static int minCost(int n, int insertCost, int deleteCost, int copyCost) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = insertCost;

        for (int len = 2; len <= n; len++) {
            dp[len] = dp[len - 1] + insertCost;

            if (len % 2 == 0) {
                dp[len] = Math.min(dp[len], dp[len / 2] + copyCost);
            } else {
                dp[len] = Math.min(
                    dp[len],
                    dp[(len + 1) / 2] + copyCost + deleteCost
                );
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n1 = 9, insertCost1 = 1, deleteCost1 = 2, copyCost1 = 1;
        System.out.println("Minimum cost for n = 9: "
                + minCost(n1, insertCost1, deleteCost1, copyCost1));
        // Expected Output: 5

        int n2 = 9, insertCost2 = 10, deleteCost2 = 1, copyCost2 = 1;
        System.out.println("Minimum cost for n = 9: "
                + minCost(n2, insertCost2, deleteCost2, copyCost2));
        // Expected Output: 17
    }
}