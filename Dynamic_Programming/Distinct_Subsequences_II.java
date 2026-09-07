/*
 * LeetCode 940. Distinct Subsequences II
 * Hard
 * 
 * Given a string s, return the number of distinct non-empty subsequences of s. 
 * Since the answer may be very large, return it modulo 10^9 + 7.
 * 
 * A subsequence of a string is a new string that is formed from the original string 
 * by deleting some (can be none) of the characters without disturbing the relative 
 * positions of the remaining characters.
 * 
 * Example 1:
 * Input: s = "abc"
 * Output: 7
 * Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
 * 
 * Example 2:
 * Input: s = "aba"
 * Output: 6
 * Explanation: The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and "aba".
 * 
 * Example 3:
 * Input: s = "aaa"
 * Output: 3
 * Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 * 
 * Constraints:
 * 1 <= s.length <= 2000
 * s consists of lowercase English letters.
 */

public class Distinct_Subsequences_II {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.distinctSubseqII("abc")); // Expected: 7
        System.out.println("Test Case 2: " + solver.distinctSubseqII("aba")); // Expected: 6
        System.out.println("Test Case 3: " + solver.distinctSubseqII("aaa")); // Expected: 3
    }
}

class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        
        long[] endWith = new long[26];
        long total = 0;
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            
            long oldVal = endWith[idx];
            long newVal = (total + 1) % MOD;
            
            endWith[idx] = newVal;
            
            total = (total + newVal - oldVal + MOD) % MOD;
        }
        
        return (int) total;
    }
}