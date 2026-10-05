/*
 * LeetCode 856. Score of Parentheses
 * Medium
 * 
 * Given a balanced parentheses string s, return the score of the string.
 * The score of a balanced parentheses string is based on the following rule:
 * - "()" has score 1.
 * - AB has score A + B, where A and B are balanced parentheses strings.
 * - (A) has score 2 * A, where A is a balanced parentheses string.
 * 
 * Example 1:
 * Input: s = "()"
 * Output: 1
 * 
 * Example 2:
 * Input: s = "(())"
 * Output: 2
 * 
 * Example 3:
 * Input: s = "()()"
 * Output: 2
 * 
 * Constraints:
 * 2 <= s.length <= 50
 * s consists of only '(' and ')'.
 * s is a balanced parentheses string.
 */

public class Score_of_Parentheses {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.scoreOfParentheses("()"));       
        // Expected: 1

        System.out.println("Test Case 2: " + solver.scoreOfParentheses("(())"));     
        // Expected: 2

        System.out.println("Test Case 3: " + solver.scoreOfParentheses("()()"));     
        // Expected: 2
        
        System.out.println("Test Case 4: " + solver.scoreOfParentheses("(()(()))")); 
        // Expected: 6
    }
}

class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int depth = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                
                if (s.charAt(i - 1) == '(') {
                    score += (1 << depth);
                }
            }
        }
        
        return score;
    }
}