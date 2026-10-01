/*
 * LeetCode 20. Valid Parentheses
 * Easy
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * 
 * Example 4:
 * Input: s = "([])"
 * Output: true
 * 
 * Example 5:
 * Input: s = "([)]"
 * Output: false
 * 
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 */

public class Valid_Parentheses {
    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("Test Case 1: " + solver.isValid("()"));      // Expected: true
        System.out.println("Test Case 2: " + solver.isValid("()[]{}"));  // Expected: true
        System.out.println("Test Case 3: " + solver.isValid("(]"));      // Expected: false
        System.out.println("Test Case 4: " + solver.isValid("([])"));    // Expected: true
        System.out.println("Test Case 5: " + solver.isValid("([)]"));    // Expected: false
        System.out.println("Test Case 6: " + solver.isValid("]"));       // Expected: false
    }
}

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        
        char[] stack = new char[s.length()];
        int top = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[top++] = ')';
            } else if (c == '{') {
                stack[top++] = '}';
            } else if (c == '[') {
                stack[top++] = ']';
            } else {
                if (top == 0 || stack[--top] != c) {
                    return false;
                }
            }
        }
        
        return top == 0;
    }
}