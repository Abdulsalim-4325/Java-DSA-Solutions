/*
 * LeetCode 32. Longest Valid Parentheses
 * Hard
 * 
 * Given a string containing just the characters '(' and ')', return the 
 * length of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * 
 * Example 2:
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * 
 * Example 3:
 * Input: s = ""
 * Output: 0
 * 
 * Constraints:
 * 0 <= s.length <= 3 * 10^4
 * s[i] is '(', or ')'.
 */

public class Longest_Valid_Parentheses {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.longestValidParentheses("(()"));     
        // Expected: 2

        System.out.println("Test Case 2: " + solver.longestValidParentheses(")()())"));  
        // Expected: 4

        System.out.println("Test Case 3: " + solver.longestValidParentheses(""));        
        // Expected: 0
        
        System.out.println("Test Case 4: " + solver.longestValidParentheses("()(()"));  
        // Expected: 2
        
        System.out.println("Test Case 5: " + solver.longestValidParentheses("(()())"));  
        // Expected: 6
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        
        left = 0;
        right = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        
        return maxLength;
    }
}