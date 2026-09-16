/*
 * LeetCode 1621. Number of Sets of K Non-Overlapping Line Segments
 * Medium
 * 
 * Given n points on a 1-D plane, where the ith point (from 0 to n-1) is at x = i, 
 * find the number of ways we can draw exactly k non-overlapping line segments such 
 * that each segment covers two or more points. The endpoints of each segment must 
 * have integral coordinates. The k line segments do not have to cover all n points, 
 * and they are allowed to share endpoints.
 * 
 * Return the number of ways we can draw k non-overlapping line segments. 
 * Since this number can be huge, return it modulo 10^9 + 7.
 * 
 * Example 1:
 * Input: n = 4, k = 2
 * Output: 5
 * 
 * Example 2:
 * Input: n = 3, k = 1
 * Output: 3
 * 
 * Example 3:
 * Input: n = 30, k = 7
 * Output: 796297179
 * 
 * Constraints:
 * 2 <= n <= 1000
 * 1 <= k <= n-1
 */

public class Number_of_Sets_of_K_Segments {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.numberOfSets(4, 2)); // Expected: 5
        System.out.println("Test Case 2: " + solver.numberOfSets(3, 1)); // Expected: 3
        System.out.println("Test Case 3: " + solver.numberOfSets(30, 7)); // Expected: 796297179
    }
}

class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int totalPoints = n + k - 1;
        int pointsToChoose = 2 * k;

        if (pointsToChoose > totalPoints) {
            return 0;
        }

        long result = 1;
        
        for (int i = 1; i <= pointsToChoose; i++) {
            result = (result * (totalPoints - i + 1)) % MOD;
            result = (result * modInverse(i, MOD)) % MOD;
        }

        return (int) result;
    }

    private long modInverse(long n, int mod) {
        return power(n, mod - 2, mod);
    }

    private long power(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}