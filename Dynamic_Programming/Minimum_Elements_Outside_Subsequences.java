/*
 * Minimum Elements Outside Subsequences
 * Difficulty: Hard | Accuracy: 66.65% | Submissions: 6K+ | Points: 8
 * 
 * Given an array arr[] of size n, partition its elements into a strictly increasing 
 * subsequence and a strictly decreasing subsequence.
 * Each element can belong to at most one of these subsequences, and some elements may remain unused.
 * Determine the minimum number of elements that cannot be included in either subsequence.
 * 
 * Examples:
 * 
 * Input: arr[] = [7, 8, 1, 2, 4, 6, 3, 5, 2, 1, 8, 7]
 * Output: 2
 * Explanation: One possible increasing subsequence is: [1, 2, 4, 5, 8]. 
 * One possible decreasing subsequence is: [7, 6, 3, 2, 1]. 
 * The remaining elements are 8 and 7, so the minimum number of unselected elements is 2.
 * 
 * Input: arr[] = [1, 4, 2, 3, 3, 2, 4]
 * Output: 0
 * Explanation: One possible increasing subsequence is: [1, 2, 3, 4]. 
 * One possible decreasing subsequence is: [4, 3, 2]. 
 * All elements are included in one of the two subsequences.
 * 
 * Constraints:
 * 1 <= n <= 100
 * 1 <= arr[i] <= 100
 */

public class Minimum_Elements_Outside_Subsequences {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] arr1 = {7, 8, 1, 2, 4, 6, 3, 5, 2, 1, 8, 7};
        System.out.println("Test Case 1: " + solver.minCount(arr1)); // Expected: 2

        int[] arr2 = {1, 4, 2, 3, 3, 2, 4};
        System.out.println("Test Case 2: " + solver.minCount(arr2)); // Expected: 0
    }
}

class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n][101][102];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 100; j++) {
                for (int k = 0; k <= 101; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        int maxUsed = solve(arr, 0, 0, 101, dp);
        return n - maxUsed;
    }
    
    private int solve(int[] arr, int i, int lastInc, int lastDec, int[][][] dp) {
        if (i == arr.length) {
            return 0;
        }
        
        if (dp[i][lastInc][lastDec] != -1) {
            return dp[i][lastInc][lastDec];
        }
        
        int maxUsed = solve(arr, i + 1, lastInc, lastDec, dp);
        
        if (arr[i] > lastInc) {
            maxUsed = Math.max(maxUsed, 1 + solve(arr, i + 1, arr[i], lastDec, dp));
        }
        
        if (arr[i] < lastDec) {
            maxUsed = Math.max(maxUsed, 1 + solve(arr, i + 1, lastInc, arr[i], dp));
        }
        
        return dp[i][lastInc][lastDec] = maxUsed;
    }
}