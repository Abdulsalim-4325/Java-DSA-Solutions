/*
 * LeetCode 2472. Maximum Number of Non-overlapping Palindrome Substrings
 * Hard
 * 
 * You are given a string s and a positive integer k.
 * Select a set of non-overlapping substrings from the string s that satisfy the following conditions:
 * - The length of each substring is at least k.
 * - Each substring is a palindrome.
 * 
 * Return the maximum number of substrings in an optimal selection.
 * A substring is a contiguous sequence of characters within a string.
 * 
 * Example 1:
 * Input: s = "abaccdbbd", k = 3
 * Output: 2
 * Explanation: We can select the substrings "aba" and "dbbd".
 * Both are palindromes and have a length of at least k = 3.
 * 
 * Example 2:
 * Input: s = "adbcda", k = 2
 * Output: 0
 * Explanation: There is no palindrome substring of length at least 2 in the string.
 * 
 * Constraints:
 * 1 <= k <= s.length <= 2000
 * s consists of lowercase English letters.
 */

public class Maximum_Non_overlapping_Palindromes {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.maxPalindromes("abaccdbbd", 3)); // Expected: 2
        System.out.println("Test Case 2: " + solver.maxPalindromes("adbcda", 2));    // Expected: 0
        System.out.println("Test Case 3: " + solver.maxPalindromes("aaaa", 2));      // Expected: 2
    }
}

class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int lastEnd = -1; 

        for (int i = 0; i < n; i++) {
            if (i - lastEnd >= k && isPalindrome(s, i - k + 1, i)) {
                count++;
                lastEnd = i;
            }
            else if (i - lastEnd >= k + 1 && isPalindrome(s, i - k, i)) {
                count++;
                lastEnd = i;
            }
        }
        
        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}