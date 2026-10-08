/*
 * LeetCode 1021. Remove Outermost Parentheses
 * Easy
 * 
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, 
 * where A and B are valid parentheses strings.
 * 
 * A valid parentheses string s is primitive if it is nonempty, and there 
 * does not exist a way to split it into s = A + B, with A and B nonempty 
 * valid parentheses strings.
 * 
 * Given a valid parentheses string s, consider its primitive decomposition: 
 * s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
 * 
 * Return s after removing the outermost parentheses of every primitive string 
 * in the primitive decomposition of s.
 * 
 * Example 1:
 * Input: s = "(()())(())"
 * Output: "()()()"
 * 
 * Example 2:
 * Input: s = "(()())(())(()(()))"
 * Output: "()()()()(())"
 * 
 * Example 3:
 * Input: s = "()()"
 * Output: ""
 * 
 * Constraints:
 * 1 <= s.length <= 10^5
 * s[i] is either '(' or ')'.
 * s is a valid parentheses string.
 */

public class Remove_Outermost_Parentheses {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.removeOuterParentheses("(()())(())")); 
        // Expected: "()()()"

        System.out.println("Test Case 2: " + solver.removeOuterParentheses("(()())(())(()(()))")); 
        // Expected: "()()()()(())"

        System.out.println("Test Case 3: " + solver.removeOuterParentheses("()()")); 
        // Expected: ""
        
        System.out.println("Test Case 4: " + solver.removeOuterParentheses("((()))")); 
        // Expected: "(())"
    }
}

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                if (depth++ > 0) {
                    result.append(c);
                }
            } else {
                if (--depth > 0) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}