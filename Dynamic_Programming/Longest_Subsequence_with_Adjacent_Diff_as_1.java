/*
 * Longest Subsequence with Adjacent Diff as 1
 * Difficulty: Medium | Accuracy: 29.43% | Submissions: 61K+ | Points: 4
 * 
 * Given an array arr[] with n elements. find the longest subsequence such that 
 * the absolute difference between adjacent elements is one.
 * 
 * Examples:
 * 
 * Input : arr[] = [10, 9, 4, 5, 4, 8, 6]
 * Output : 3
 * Explanation: Longest subsequences with difference 1 are [10, 9, 8], [4, 5, 4] and [4, 5, 6]. 
 * 
 * Input : arr[] = [1, 2, 3, 2, 3, 7, 2, 1]
 * Output : 7
 * Explanation:  Longest subsequences with difference 1 is [1, 2, 3, 2, 3, 2, 1]. 
 * 
 * Constraints:
 * 1 <= arr.size(), arr[i] <= 10^6
 */

public class Longest_Subsequence_with_Adjacent_Diff_as_1 {
    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] arr1 = {10, 9, 4, 5, 4, 8, 6};
        System.out.println("Test Case 1: " + solver.longestSubseq(arr1)); // Expected: 3

        int[] arr2 = {1, 2, 3, 2, 3, 7, 2, 1};
        System.out.println("Test Case 2: " + solver.longestSubseq(arr2)); // Expected: 7
    }
}

class Solution {
    public int longestSubseq(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        int maxVal = 0;
        for (int num : arr) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        int[] dp = new int[maxVal + 2];
        int maxLen = 0;
        
        for (int num : arr) {
            int lenMinus1 = (num - 1 >= 0) ? dp[num - 1] : 0;
            int lenPlus1 = (num + 1 <= maxVal) ? dp[num + 1] : 0;
            
            dp[num] = Math.max(lenMinus1, lenPlus1) + 1;
            
            if (dp[num] > maxLen) {
                maxLen = dp[num];
            }
        }
        
        return maxLen;
    }
}