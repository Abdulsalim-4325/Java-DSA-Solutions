/*
 * Count Subsequences Divisible by n
 * Difficulty: Medium | Accuracy: 49.98% | Submissions: 11K+ | Points: 4
 * 
 * Given a numeric string s containing only digits and an integer n, count the number of 
 * non-empty subsequences of s whose numeric value is divisible by n. 
 * Return the answer modulo 1e9 + 7.
 * 
 * Examples:
 * 
 * Input: s = "1234", n = 4
 * Output: 4
 * Explanation: The subsequences 4, 12, 24 and 124 are divisible by 4.
 * 
 * Input: s = "330", n = 6
 * Output: 4
 * Explanation: The subsequences 30, 30, 330 and 0 are divisible by 6.
 * 
 * Constraints:
 * 1 <= |s| * n <= 10^6
 */

public class Count_Subsequences_Divisible_by_n {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.countSubsequences("1234", 4)); // Expected: 4
        System.out.println("Test Case 2: " + solver.countSubsequences("330", 6));  // Expected: 4
    }
}

class Solution {
    public int countSubsequences(String s, int n) {
        int MOD = 1_000_000_007;
        int[] dp = new int[n];
        
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            int[] nextDp = new int[n];
            
            for (int j = 0; j < n; j++) {
                nextDp[j] = dp[j];
            }
            
            nextDp[digit % n] = (nextDp[digit % n] + 1) % MOD;
            
            for (int j = 0; j < n; j++) {
                if (dp[j] > 0) {
                    int newRem = (j * 10 + digit) % n;
                    nextDp[newRem] = (nextDp[newRem] + dp[j]) % MOD;
                }
            }
            
            dp = nextDp;
        }
        
        return dp[0];
    }
}