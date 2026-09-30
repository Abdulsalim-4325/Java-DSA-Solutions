/*
 * Ways to Reach Origin
 * Difficulty: Medium | Accuracy: 53.93% | Submissions: 61K+ | Points: 4
 * 
 * Geek is standing at a point (x, y) on a 2D grid and wants to reach the origin (0, 0).
 * From any point, Geek can move in only two directions: left, from (x, y) to (x - 1, y), 
 * or down, from (x, y) to (x, y - 1).
 * 
 * Find the total number of distinct paths for Geek to reach (0, 0) from (x, y). 
 * Since the answer can be very large, return it modulo 10^9+7.
 * 
 * Examples:
 * Input: x = 3, y = 0
 * Output: 1
 * Explanation: The only possible path is (3, 0) -> (2, 0) -> (1, 0) -> (0, 0).
 * 
 * Input: x = 3, y = 6
 * Output: 84
 * Explanation: There are a total of 84 distinct paths from (3, 6) to (0, 0).
 * 
 * Constraints:
 * 0 <= x, y <= 500
 */

public class Ways_to_Reach_Origin {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int x1 = 3;
        int y1 = 0;
        System.out.println("Test Case 1: " + solver.ways(x1, y1)); // Expected: 1

        int x2 = 3;
        int y2 = 6;
        System.out.println("Test Case 2: " + solver.ways(x2, y2)); // Expected: 84
        
        int x3 = 500;
        int y3 = 500;
        // Large constraint test case
        System.out.println("Test Case 3: " + solver.ways(x3, y3)); // Will print combination modulo 10^9+7
    }
}

class Solution {
    public int ways(int x, int y) {
        int MOD = 1000000007;
        
        int[] dp = new int[y + 1];
        
        for (int j = 0; j <= y; j++) {
            dp[j] = 1;
        }
        
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }
        
        return dp[y];
    }
}